package CSTgame;


import CSTgame.personagensCST.obstaculo;
import tabuleiroGame.peca;
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
    
    private void colocarNovaPeca(peca peca, posicao posicao){
        tabuleiro.colocarPeca(peca, posicao);
    }

    private void setupInicial(){
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14), new posicao(15, 7));
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14), new posicao(10, 15));
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14), new posicao(6, 14));
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14), new posicao(9, 10));
    }
}
