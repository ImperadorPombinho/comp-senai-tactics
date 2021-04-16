package aplicacao;

import CSTgame.CSTpeca;


public class UI {
    


    public static void printarTabuleiro(CSTpeca[][] pecas, int numeroLinhas){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((numeroLinhas-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j]);
            }
            System.out.println();
        }
        
    }



    private static void printarPeca(CSTpeca peca){

        if(peca == null){
            System.out.print("-");
        }else{
            System.out.print(peca);
        }
        System.out.print(" ");
    }
}
