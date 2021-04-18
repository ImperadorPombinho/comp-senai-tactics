package aplicacao;


import java.util.Scanner;

import CSTgame.CSTposicao;
import CSTgame.partidaCST;


public class mainzada {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        partidaCST partidaCST = new partidaCST(20, 20);
        while(true){
            UI.printarTabuleiro(partidaCST.getPecas(), 20);
            System.out.println();
            System.out.print("posicao origem: ");
            CSTposicao origem = UI.lerPosicao(scan, 20, 20);
            System.out.println();
            System.out.print("posicao destino: ");
            CSTposicao destino = UI.lerPosicao(scan, 20, 20);

            partidaCST.perfomaceFazerMovimento(origem, destino);
        }
        

    }
    
}
