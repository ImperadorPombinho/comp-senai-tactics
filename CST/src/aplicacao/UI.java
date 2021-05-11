package aplicacao;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import CSTgame.CSTpeca;
import CSTgame.CSTposicao;
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

    public static int printarPartida(partidaCST partidaCST, String[] nomes, int numeroLinhas, Scanner scan){
        int selec;
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
        System.out.println("Escolha a acao abaixo: ");
        System.out.println("1-Atacar");
        System.out.println("2-Movimentar");
        selec = scan.nextInt();
        return selec;
    }
    public static CSTposicao lerPosicao(Scanner scan, int linhaMax, int ColunaMax){
        try{

        
        int linha = scan.nextInt();
        int coluna = scan.nextInt();
        return new CSTposicao(coluna, linha, linhaMax, ColunaMax);
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
            System.out.print((numeroLinhas-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j], false);
            }
            
            System.out.println();
        }
       
        System.out.println();
        
    }
    public static void printarTabuleiro(CSTpeca[][] pecas, int numeroLinhas, boolean[][] possiveisAtaques){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((numeroLinhas - i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j], possiveisAtaques[i][j]);
            }
            System.out.println();
        }
        System.out.print(" ");
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
                System.out.print(ANSI_BLACK + peca + ANSI_RESET);
            }
           
                
        }
        System.out.print(" ");
    }
}
