package CSTgame;


import CSTgame.personagensCST.obstaculo;

import tabuleiroGame.peca;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class partidaCST {
    private tabuleiro tabuleiro;
    private int linhaMax;
    private int ColunaMax;
    public partidaCST(int linha, int coluna) {
        tabuleiro = new tabuleiro(linha, coluna);
        this.linhaMax = linha;
        this.ColunaMax = coluna;
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

    public void perfomaceFazerMovimento(CSTposicao posicaoOrigem, CSTposicao posicaoDestino){
        posicao origem = posicaoOrigem.toPosicao();
        posicao destino = posicaoDestino.toPosicao();
        validacaoOrigem(origem);
        fazerMovimento(origem, destino);
    }

    private void fazerMovimento(posicao origem, posicao destino){
        peca naOrigem = tabuleiro.removerPeca(origem);
        tabuleiro.colocarPeca(naOrigem, destino);
    }
    private void validacaoOrigem(posicao origem){
        if(!tabuleiro.istoEhUmaPeca(origem)){
            throw new exececaoCST("isto nao eh uma peca para se mover");
        }

    }
    
    private void colocarNovaPeca(peca peca, int linha, int coluna){
        tabuleiro.colocarPeca(peca, new CSTposicao(linha, coluna, linhaMax, ColunaMax).toPosicao());
    }

    private void setupInicial(){
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14), 20, 20);
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14), 11, 16);
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14), 7, 14);
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14), 1, 1);
    }
}
