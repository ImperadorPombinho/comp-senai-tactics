package tabuleiroGame;

public class tabuleiro {
    private peca[][] pecas;
    private int linha;
    private int coluna;
    public tabuleiro(int linha, int coluna) {
        if(linha < 1 || coluna < 1){
            throw new exececaotabul("erro ao criar mapa, precisa de pelo menos 1 linha e 1 coluna");
        } 
        this.linha = linha;
        this.coluna = coluna;
        pecas = new peca[linha][coluna];
    }
    public int getLinha() {
        return linha;
    }
    /*public void setLinha(int linha) {
        this.linha = linha;
    }*/
    public int getColuna() {
        return coluna;
    }
    /*public void setColuna(int coluna) {
        this.coluna = coluna;
    }*/

    //METODOS:
    public peca peca(int linha, int coluna){
        if(!posicaoExiste(linha, coluna)){
            throw new exececaotabul("nao existe essa posicao nesse tabuleiro");
        }
        return pecas[linha][coluna];
    }
    public peca peca(posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new exececaotabul("nao existe essa posicao nesse tabuleiro");
        }
        return pecas[posicao.getLinha()][posicao.getColuna()];
    }
    public void colocarPeca(peca peca, posicao posicao){
        if(istoEhUmaPeca(posicao)){
            throw new exececaotabul("ja existe essa peca no tabuleiro" + posicao);
        }
        pecas[posicao.getLinha()][posicao.getColuna()] = peca;
        peca.posicao = posicao;
    }
    public peca removerPeca(posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new exececaotabul("nao existe essa posicao");
        }
        if(!istoEhUmaPeca(posicao)){
            return null;
        }
        peca aux = peca(posicao);
        pecas[posicao.getLinha()][posicao.getColuna()] = null;
        aux.posicao = null;
        return aux;
    }
    
    public boolean posicaoExiste(int linha, int coluna){
        return linha >= 0  && linha <= getLinha() && coluna >= 0 && coluna <= getColuna();
    }
    public boolean posicaoExiste(posicao posicao){
        return posicaoExiste(posicao.getLinha(), posicao.getColuna());
    }

    public boolean istoEhUmaPeca(posicao posicao){
        if(!posicaoExiste(posicao)){
            throw new exececaotabul("essa peca nao foi encontrada, erro de posicao");
        }
        return peca(posicao) != null;
    }




}
