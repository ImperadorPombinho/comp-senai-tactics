package aplicacao;


import java.util.InputMismatchException;
import java.util.Scanner;


import CSTgame.CSTposicao;
import CSTgame.exececaoCST;
import CSTgame.partidaCST;


public class mainzada {
    public static void main(String[] args) {
        int selec;
        Scanner scan = new Scanner(System.in);
        partidaCST partidaCST = new partidaCST(20, 20);
        String[] nomes = UI.lerNomes(scan);
        boolean[][] possiveisAlgumaCoisa;
        UI.printarSorteioAtqPecas(partidaCST);
        scan.nextLine();
        scan.nextLine();
        while(true){
            try{
            //UI.limparTelaConsole();
            selec = UI.printarPartida(partidaCST, nomes, 20, scan);
            if(selec == 1){
                System.out.println();
                System.out.println("Ataque");
                System.out.print("posicao origem: ");
                CSTposicao posicaoAtacante = UI.lerPosicao(scan, 20, 20);
                possiveisAlgumaCoisa = partidaCST.possiveisAtaques(posicaoAtacante);
                UI.limparTelaConsole();
                UI.printarTabuleiro(partidaCST.getPecas(), 20, possiveisAlgumaCoisa);
    
                System.out.println();
                System.out.print("posicao destino: ");
                CSTposicao posicaoAtacado = UI.lerPosicao(scan, 20, 20);
                partidaCST.perfomaceAtaque(posicaoAtacante, posicaoAtacado);
            }else if(selec == 2){
                System.out.println();
                System.out.println("Movimento");
                System.out.print("posicao origem: ");
                CSTposicao origem = UI.lerPosicao(scan, 20, 20);
                
                possiveisAlgumaCoisa = partidaCST.possiveisMovimentos(origem);
                UI.limparTelaConsole();
                UI.printarTabuleiro(partidaCST.getPecas(), 20, possiveisAlgumaCoisa);
    
                System.out.println();
                System.out.print("posicao destino: ");
                CSTposicao destino = UI.lerPosicao(scan, 20, 20);
                partidaCST.perfomaceFazerMovimento(origem, destino);
            }else if(selec == 3){
                System.out.println();
                System.out.println("Habilidade");
                System.out.print("posicao origem: ");
                CSTposicao origem = UI.lerPosicao(scan, 20, 20);
                System.out.println();
                System.out.print("posicao destino: ");
                CSTposicao destino = UI.lerPosicao(scan, 20, 20);
                partidaCST.perfomaceHabilidade(origem, destino);
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
