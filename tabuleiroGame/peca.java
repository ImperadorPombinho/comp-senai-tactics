package tabuleiroGame;

public class peca {
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
    
    
}
