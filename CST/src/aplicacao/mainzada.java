package aplicacao;


import java.util.InputMismatchException;
import java.util.Scanner;


import CSTgame.CSTposicao;
import CSTgame.exececaoCST;
import CSTgame.partidaCST;


public class mainzada {
    public static void main(String[] args) {
        int selec, linhas, colunas;
        Scanner scan = new Scanner(System.in);
        linhas = UI.escolhaDoFormato(scan);
        colunas = linhas;
        partidaCST partidaCST = new partidaCST(linhas, colunas);
        String[] nomes = UI.lerNomes(scan);
        boolean[][] possiveisAlgumaCoisa;
        UI.printarSorteioAtqPecas(partidaCST);
        partidaCST.lerDoArquivo();
        scan.nextLine();
        scan.nextLine();
        while(partidaCST.ispartida()){
            try{
            
            selec = UI.printarPartida(partidaCST, nomes, linhas, scan);
            if(partidaCST.ispartida() == false){
                partidaCST.escreverNoArquivo();
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
                System.out.print("posicao destino: ");
                CSTposicao destino = UI.lerPosicao(scan, linhas);
                partidaCST.perfomaceHabilidade(origem, destino);
            }else if(selec == 4){
                scan.nextLine();
                UI.menuItem(scan, partidaCST);
               System.out.println();
                
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
        

    }
    
}
