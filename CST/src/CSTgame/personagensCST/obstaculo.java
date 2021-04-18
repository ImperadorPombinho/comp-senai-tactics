package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import tabuleiroGame.tabuleiro;

public class obstaculo extends CSTpeca{

    public obstaculo(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento);
        
    }

    public String toString(){
        return "👽";
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];

        return matAux;
    }
    
}