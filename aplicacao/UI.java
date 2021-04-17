package aplicacao;

import java.util.InputMismatchException;
import java.util.Scanner;

import CSTgame.CSTpeca;
import CSTgame.CSTposicao;
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


    public static CSTposicao lerPosicao(Scanner scan, int linhaMax, int ColunaMax){
        try{

        
        int linha = scan.nextInt();
        int coluna = scan.nextInt();
        return new CSTposicao(coluna, linha, linhaMax, ColunaMax);
        }catch(RuntimeException e){
            throw new InputMismatchException("erro lendo posicao");
        }
        
    }

    public static void printarTabuleiro(CSTpeca[][] pecas, int numeroLinhas){
        for (int i = 0; i < pecas.length; i++) {
            System.out.print((numeroLinhas-i) + " ");
            for (int j = 0; j < pecas.length; j++) {
                printarPeca(pecas[i][j]);
            }
            
            System.out.println();
        }
        System.out.print("  ");
        for (int i = 0; i < pecas.length; i++) {
            
            if(i == 19){
                System.out.print((i+1));
            }else{
                System.out.print((i+1) + " ");
            }
            
        }
        
    }



    private static void printarPeca(CSTpeca peca){

        if(peca == null){
            System.out.print("-");
        }else{
            if(peca.getTiminho() == time.ORACULO){
                System.out.print(ANSI_BLUE+peca+ANSI_RESET);
            }else{
                System.out.print(ANSI_RED+peca+ANSI_RESET);
            }
                
        }
        System.out.print(" ");
    }
}
