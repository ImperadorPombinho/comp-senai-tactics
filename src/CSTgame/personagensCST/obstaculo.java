package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import tabuleiroGame.tabuleiro;

public class obstaculo extends CSTpeca{

    public obstaculo(tabuleiro tabul, time timinho, int ataque, int defesa, int vida) {
        super(tabul, timinho, ataque, defesa, vida);
        
    }

    public String toString(){
        return "👽";
    }

    
}