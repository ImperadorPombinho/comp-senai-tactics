package tabuleiroGame;

public abstract class peca {
    protected posicao posicao;
    private tabuleiro tabul;
    

    
    protected posicao getPosicao() {
        return posicao;
    }

    protected tabuleiro getTabul() {
        return tabul;
    }

    public peca(tabuleiro tabul) {
        this.tabul = tabul;
        posicao = null;
    }
    
    public abstract boolean[][] possiveisMovimentos();

    public boolean possivelMovimentaDeUmaPeca(posicao posicao){
        return possiveisMovimentos()[posicao.getLinha()][posicao.getColuna()];
    }

    public boolean haAlgumMovimentoPossivel(){
        boolean[][] matAux = possiveisMovimentos();
        for (int i = 0; i < matAux.length; i++) {
            for (int j = 0; j < matAux.length; j++) {
                if(matAux[i][j] == true){
                    return true;
                }
            }
        }
        return false;
    }
    
}
