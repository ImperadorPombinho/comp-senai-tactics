package CSTgame;

import tabuleiroGame.tabuleiro;

public class partidaCST {
    private tabuleiro tabuleiro;

    public partidaCST(int linha, int coluna) {
        tabuleiro = new tabuleiro(linha, coluna);
    }

    public CSTpeca[][] getPecas(){
        CSTpeca[][] matriz = new CSTpeca[tabuleiro.getLinha()][tabuleiro.getColuna()];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (CSTpeca) tabuleiro.peca(i, j);
            }
        }
        return matriz;
    }
    
}
