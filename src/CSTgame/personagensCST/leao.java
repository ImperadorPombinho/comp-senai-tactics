package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import tabuleiroGame.tabuleiro;

public class leao extends CSTpeca{

    public leao(tabuleiro tabul, time timinho, int ataque, int defesa, int vida) {
        super(tabul, timinho, ataque, defesa, vida);
        
    }

    @Override
    public String toString(){
        return "😇";
    }

    
    
}
