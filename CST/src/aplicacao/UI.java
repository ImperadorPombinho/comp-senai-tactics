package aplicacao;


import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import CSTgame.CSTpeca;
import CSTgame.CSTposicao;
import CSTgame.exececaoCST;
import CSTgame.itemConsumivel;
import CSTgame.itemEquipavel;
import CSTgame.partidaCST;
import CSTgame.time;



public class UI {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void limparTelaConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static String[] lerNomes(Scanner scan){
        String[] nomes = new String[2];
        for (int i = 0; i < nomes.length; i++) {
            System.out.print("Digite o seu nome jogador #" + (i+1) + ":");
            nomes[i] = scan.next();
        }
        return nomes;
    }
    public static void printarVencedor(String nome){
        limparTelaConsole();
        System.out.println("==================================================================");
        System.out.println("\tO VENCENDOR EH: "+ nome+" PARABENS VERMAO");
        System.out.println("==================================================================");
        
    }
    public static int printarPartida(partidaCST partidaCST, String[] nomes, int numeroLinhas, Scanner scan){
        time testa;
        int selec = 0;
        testa = partidaCST.testaQuemGanhou();
        if(testa == time.ORACULO){
            printarVencedor(nomes[0]);
        }else if(testa == time.TROPA){
            printarVencedor(nomes[1]);
        }else{

        
              
        printarTabuleiro(partidaCST.getPecas(), numeroLinhas);
        System.out.println();
        System.out.println("Turno: " + partidaCST.getTurno());
        


        

        if(partidaCST.getJogador().getTimeAtual() == time.ORACULO){
            partidaCST.getJogador().setNome(nomes[0]);
            System.out.println("Esperando " + partidaCST.getJogador().getNome() + " jogar");
            System.out.println("Peça a ser jogada: " + partidaCST.getJogador().getPecaAtual().getNome() + " " +partidaCST.getJogador().getPecaAtual().toString());
        }else{
            partidaCST.getJogador().setNome(nomes[1]);
            System.out.println("Esperando " + partidaCST.getJogador().getNome() + " jogar");
            System.out.println("Peça a ser jogada: " + partidaCST.getJogador().getPecaAtual().getNome() + " " +partidaCST.getJogador().getPecaAtual().toString());
        }
        String status = printarStatus(partidaCST.getJogador().getPecaAtual(), numeroLinhas);
        System.out.println(status);
        System.out.println("Escolha a acao abaixo: ");
        System.out.println("1-Atacar");
        System.out.println("2-Movimentar");
        System.out.println("3-Habilidade");
        System.out.println("4-Usar Item");
        selec = scan.nextInt();
    }
    
        return selec;
    }
    private static void imprimirLIsta(List<itemConsumivel> qualquer){
        int cont = 1;
        if(qualquer.size() > 0){
            for (itemConsumivel itemConsumivel : qualquer) {
                System.out.print(cont + " - " + itemConsumivel.getNome());
                System.out.println();
                cont++;
            }
        }else{
            throw new exececaoCST("lista de itens vazia");
        }

    }
    private static void imprimirLista(List<itemEquipavel> qualquer){
        int cont = 1;
        if(qualquer.size() > 0){
            for (itemEquipavel itemEquipavel : qualquer) {
                System.out.print(cont + " - " + itemEquipavel.getNomeItem());
                System.out.println();
                cont++;
            }
        }else{
            throw new exececaoCST("lista de itens vazia");
        }
    }
    public static void menuItem(Scanner scan, partidaCST partidaCST){
        int resp, ID = 0;
        System.out.println("Item");
        System.out.println("Qual tipo?");
        System.out.println("1 - Consumivel");
        System.out.println("2 - Equipavel");
        resp = scan.nextInt();
        if(resp == 1){
            
            if(partidaCST.getJogador().getTimeAtual() == time.ORACULO){
                imprimirLIsta(partidaCST.getItensConsumivelsO());
                System.out.println("Escolha: ");
                ID = scan.nextInt();
                
            }else{
                imprimirLIsta(partidaCST.getItensConsumivelsT());
                System.out.println("Escolha: ");
                ID = scan.nextInt();
            }
            scan.nextLine();
            System.out.print("posicao destino: ");
            
            CSTposicao destino = UI.lerPosicao(scan, 20);
             partidaCST.perfomaceUsarItem(destino, ID);
            
        }else if(resp == 2){
           
            if(partidaCST.getJogador().getTimeAtual() == time.ORACULO){
                imprimirLista(partidaCST.getItensEquipavelsO());
                System.out.println("Escolha: ");
                ID = scan.nextInt();
            }else{
                imprimirLista(partidaCST.getItensEquipavelsT());
                System.out.println("Escolha: ");
                ID = scan.nextInt();
            }
            scan.nextLine();
            System.out.print("posicao destino: ");
            
            CSTposicao destino = UI.lerPosicao(scan, 20);
             partidaCST.perfomaceEquiparItem(destino, ID);
        }
        

    }
    public static CSTposicao lerPosicao(Scanner scan, int linhaMax){
        try{
           
        String string = scan.nextLine();
        char coluna = string.charAt(0);
        int linha;
        if(string.length() == 3){
             linha = Integer.parseInt(string.substring(1, 3));
        }else{
            linha = Integer.parseInt(string.substring(1));
        }
        
        return new CSTposicao(coluna, linha, linhaMax);
        }catch(RuntimeException e){
            throw new InputMismatchException("erro lendo posicao");
            
        }
        
    }

    public static void printarSorteioAtqPecas(partidaCST partidaCST){
        List<CSTpeca> auxOraculo = partidaCST.getPecasOraculo();
        List<CSTpeca> auxTropa = partidaCST.getPecasTropa();
        System.out.println();
        System.out.println("ordem de atq da tropa: ");
        for (CSTpeca csTpeca : auxTropa) {
            System.out.print("-> " +csTpeca.getNome());

        }
        System.out.println();
        System.out.println("ordem de atq da Oraculo: ");
        for (CSTpeca csTpeca : auxOraculo) {
            System.out.print("-> " +csTpeca.getNome());

        }
    }

    public static void printarTabuleiro(CSTpeca[][] pecas, int numeroLinhas){
        for (int i = 0; i < pecas.length; i++) {
            if(numeroLinhas - i <= 9){
            System.out.print("0"+(numeroLinhas-i) + " ");
            }else{
            System.out.print((numeroLinhas-i) + " ");
            }
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j], false);
            }
            
            System.out.println();
        }
        
        System.out.println("   A B C D E F G H I J K L M N O P Q R S T");
        
    }
    public static void printarTabuleiro(CSTpeca[][] pecas, int numeroLinhas, boolean[][] possiveisAtaques){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((numeroLinhas - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j], possiveisAtaques[i][j]);
            }
            System.out.println();
        }
        System.out.println("   A B C D E F G H I J K L M N O P Q R S T");
    }



    private static void printarPeca(CSTpeca peca, boolean telaDeFundo){
        if(telaDeFundo == true){
            System.out.print(ANSI_PURPLE_BACKGROUND);
        }
        if(peca == null){
            System.out.print("-" + ANSI_RESET);
        }else{
            if(peca.getTiminho() == time.ORACULO){
                System.out.print(ANSI_BLUE + peca + ANSI_RESET);
            }else{
                System.out.print(ANSI_RED + peca + ANSI_RESET);
            }
           
                
        }
        System.out.print(" ");
    }
    private static String printarStatus(CSTpeca peca, int linhas){
        StringBuilder Status = new StringBuilder();
        Status.append("\n==========STATUS==========");
        Status.append("\n");
        if(peca.getTiminho() == time.ORACULO){
            Status.append("\tNome: " +ANSI_BLUE+ peca.getNome()+ ANSI_RESET + "\n");
            Status.append("\tPeca: " + ANSI_BLUE + peca + ANSI_RESET + "\n");

        }else{
            Status.append("\tNome: " +ANSI_RED+ peca.getNome()+ ANSI_RESET+ "\n");
            Status.append("\tPeca: " + ANSI_RED + peca + ANSI_RESET + "\n"); 
        }
        Status.append("\tVida: " + peca.getVida());
        Status.append("\n");
        Status.append("\tAtaque: "+peca.getAtaque());
        Status.append("\n");
        Status.append("\tDefesa: "+peca.getDefesa());
        Status.append("\n");
        Status.append("\tRange geral: "+ peca.getRangeMovimento());
        Status.append("\n");
        if(peca.getInventario() == null){
            Status.append("\tInventario: "+ peca.getInventario());
        }else{
            Status.append("\tInventario: "+ peca.getInventario().getNomeItem());
        }
        
        Status.append("\n");
        Status.append("\n===========================");
        Status.append("\n");
        return Status.toString();
        
    }
}
