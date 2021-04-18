package CSTgame;

import tabuleiroGame.posicao;

public class CSTposicao {
    private int coluna;
    private int linha;


    private int linhaMax;
    private int ColunaMax;
    public int getColuna() {
        return coluna;
    }
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    public int getLinha() {
        return linha;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
    public int getLinhaMax() {
        return linhaMax;
    }

    public int getColunaMax() {
        return ColunaMax;
    }
    public CSTposicao(int coluna, int linha, int linhaMax, int ColunaMax) {
        
        this.coluna = coluna;
        this.linha = linha;
        this.linhaMax = linhaMax;
        this.ColunaMax = ColunaMax;
    }

    public posicao toPosicao(){
        return new posicao(getLinhaMax() - getLinha(), getColuna() - 1);
    }
    public CSTposicao voltaCsTposicao(posicao posicao){
        return new CSTposicao(posicao.getColuna() + 1, getLinhaMax() - getLinha(), linhaMax, ColunaMax);
    }



}
