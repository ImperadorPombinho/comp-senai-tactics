package CSTgame;


import CSTgame.personagensCST.leao;
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
    public boolean[][] possiveisMovimentos(CSTposicao posicaoOrigem){
        posicao posicao = posicaoOrigem.toPosicao();
        validacaoOrigem(posicao);
        return tabuleiro.peca(posicao).possiveisMovimentos();
    }

    public void perfomaceFazerMovimento(CSTposicao posicaoOrigem, CSTposicao posicaoDestino){
        posicao origem = posicaoOrigem.toPosicao();
        posicao destino = posicaoDestino.toPosicao();
        validacaoOrigem(origem);
        validacaoOrigemDestino(origem, destino);
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
        if(!tabuleiro.peca(origem).haAlgumMovimentoPossivel() || tabuleiro.peca(origem) instanceof obstaculo){
            throw new exececaoCST("nao ha movimento possivel para essa peca ou essa peca eh um obstaculo");
        }
        

    }
    private void validacaoOrigemDestino(posicao origem, posicao destino){
        if(!tabuleiro.peca(origem).possivelMovimentaDeUmaPeca(destino)){
            throw new exececaoCST("essa peca escolhida nao pode mover para tal posicao de destino");
        }
    }
    
    private void colocarNovaPeca(peca peca, int linha, int coluna){
        tabuleiro.colocarPeca(peca, new CSTposicao(coluna, linha, linhaMax, ColunaMax).toPosicao());
    }

    private void setupInicial(){
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14, 5), 20, 20);
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14,5), 11, 16);
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14,5), 7, 14);
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14,5), 1, 1);
        colocarNovaPeca(new leao(tabuleiro, time.ORACULO, 0, 2, 10, 5), 14, 5);
    }
}
