package aplicacao;


import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


import CSTgame.CSTposicao;
import CSTgame.ManipuladorDeArquivo;
import CSTgame.exececaoCST;
import CSTgame.partidaCST;
import CSTgame.personagensCST.racoba;



public class mainzada {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean pog = true;
        System.out.println("Seja Bem vindo ao Comp-Senai-Tactics");
        while(pog){
        System.out.println("EScolha qual ação quer visualizar: ");
        System.out.println("1 - Jogar");
        System.out.println("2 - Ver Regras");
        System.out.println("3 - Sair do jogo");
        int selec = scan.nextInt();
        if(selec == 1){
            rodarPartida(scan);
        }else if(selec  == 2){
            try {
                ManipuladorDeArquivo.lerArquivo("Regras.txt");
            } catch (IOException e) {
            }
        }else if(selec == 3){
            System.out.println("Saindo...");
            pog = false;
        }
    }
      }

      public static void rodarPartida(Scanner scan){
        int selec, linhas, colunas;
        String resp = "S";
       
        linhas = UI.escolhaDoFormato(scan);
        colunas = linhas;
        String[] nomes = UI.lerNomes(scan);
        boolean[][] possiveisAlgumaCoisa;
        
        partidaCST partidaCST = new partidaCST(linhas, colunas);
        
         while(resp == "S"){
            
            
            UI.printarSorteioAtqPecas(partidaCST);
            scan.nextLine();
            scan.nextLine();
            while(partidaCST.ispartida()){
                try{
                
                selec = UI.printarPartida(partidaCST, nomes, linhas, scan);
                if(partidaCST.ispartida() == false){
                    partidaCST.escreverNoArquivo(partidaCST);
                    break;
                }
                if(selec == 1){
                    scan.nextLine();
                    System.out.println();
                    System.out.println("Ataque");
                    System.out.print("posicao origem: ");
                    CSTposicao posicaoAtacante = UI.lerPosicao(scan, linhas);
                    possiveisAlgumaCoisa = partidaCST.possiveisAtaques(posicaoAtacante);
                    UI.limparTelaConsole();
                    UI.printarTabuleiro(partidaCST.getPecas(), linhas, possiveisAlgumaCoisa);
        
                    System.out.println();
                    System.out.print("posicao destino: ");
                    CSTposicao posicaoAtacado = UI.lerPosicao(scan, linhas);
                    partidaCST.perfomaceAtaque(posicaoAtacante, posicaoAtacado);
                }else if(selec == 2){
                    scan.nextLine();
                    System.out.println();
                    System.out.println("Movimento");
                    System.out.print("posicao origem: ");
                    CSTposicao origem = UI.lerPosicao(scan, linhas);
                    
                    possiveisAlgumaCoisa = partidaCST.possiveisMovimentos(origem);
                    UI.limparTelaConsole();
                    UI.printarTabuleiro(partidaCST.getPecas(), linhas, possiveisAlgumaCoisa);
        
                    System.out.println();
                    System.out.print("posicao destino: ");
                    CSTposicao destino = UI.lerPosicao(scan, linhas);
                    partidaCST.perfomaceFazerMovimento(origem, destino);
                }else if(selec == 3){
                    scan.nextLine();
                    System.out.println();
                    System.out.println("Habilidade");
                    System.out.print("posicao origem: ");
                    CSTposicao origem = UI.lerPosicao(scan, linhas);
                    System.out.println();
                    if(partidaCST.getJogador().getPecaAtual() instanceof racoba){
                        System.out.println();
                        partidaCST.perfomaceHabilidade(origem, origem);
                    }
                    else{
                        System.out.print("posicao destino: ");
                        CSTposicao destino = UI.lerPosicao(scan, linhas);
                        partidaCST.perfomaceHabilidade(origem, destino);
                    }
                }else if(selec == 4){
                    if(partidaCST.getJogador().getPecaAtual() instanceof racoba){
                        System.out.println("Nada de itens! só equipamentos gacha!!!!");
                    }
                    else{
                        scan.nextLine();
                        UI.menuItem(scan, partidaCST);
                        System.out.println();
                    }
                }
                
                    //alou; 
                    //alou  
                }
                catch(exececaoCST e){
                    System.out.println(e.getMessage());
                    scan.nextLine();
                    scan.nextLine();
                }
                catch(InputMismatchException e){
                    System.out.println(e.getMessage());
                    scan.nextLine();
                    scan.nextLine();
                }
            }
            System.out.println("Quer jogar de novo[S/N}");
            resp = scan.nextLine();
            if(resp.intern() == "N"){
                break;
            }else{
                resp = "S";
                partidaCST.resetarPartida(linhas, colunas);
            }
        }
      }
           

        

    
    
}
