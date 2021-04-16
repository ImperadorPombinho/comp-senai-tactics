package CSTgame;

import tabuleiroGame.peca;
import tabuleiroGame.tabuleiro;

public class CSTpeca extends peca{
    private time timinho;
    public CSTpeca(tabuleiro tabul, time timinho) {
        super(tabul);
        this.timinho = timinho;
        
    }
    public time getTiminho() {
        return timinho;
    }


    

}
