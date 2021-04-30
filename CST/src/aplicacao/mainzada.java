package aplicacao;


import java.util.InputMismatchException;
import java.util.Scanner;


import CSTgame.CSTposicao;
import CSTgame.exececaoCST;
import CSTgame.partidaCST;


public class mainzada {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        partidaCST partidaCST = new partidaCST(20, 20);
        while(true){
            try{
            //UI.limparTelaConsole();
            UI.printarTabuleiro(partidaCST.getPecas(), 20);
            System.out.println();
            System.out.println("Ataque");
            System.out.print("posicao origem: ");
            CSTposicao origem = UI.lerPosicao(scan, 20, 20);
            
            UI.limparTelaConsole();
            UI.printarTabuleiro(partidaCST.getPecas(), 20);

            System.out.println();
            System.out.print("posicao destino: ");
            CSTposicao destino = UI.lerPosicao(scan, 20, 20);
                //alou; 
                //alou
            partidaCST.perfomaceHabilidade(origem, destino);
             
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
