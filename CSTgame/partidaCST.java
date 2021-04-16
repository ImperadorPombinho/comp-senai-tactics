package CSTgame;

import CSTgame.personagensCST.leao;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class partidaCST {
    private tabuleiro tabuleiro;

    public partidaCST(int linha, int coluna) {
        tabuleiro = new tabuleiro(linha, coluna);
        setupInicial();
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
    


    private void setupInicial(){
        tabuleiro.colocarPeca(new leao(tabuleiro, time.TROPA, 40, 78, 100), new posicao(0, 4));
    }
}
