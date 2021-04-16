package tabuleiroGame;

public class tabuleiro {
    private peca[][] pecas;
    private int linha;
    private int coluna;
    public tabuleiro(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
        pecas = new peca[linha][coluna];
    }
    public int getLinha() {
        return linha;
    }
    public void setLinha(int linha) {
        this.linha = linha;
    }
    public int getColuna() {
        return coluna;
    }
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    //METODOS:
    public peca peca(int linha, int coluna){
        return pecas[linha][coluna];
    }
    public peca peca(posicao posicao){
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
    
    



}
