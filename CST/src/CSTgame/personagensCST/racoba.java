package CSTgame.personagensCST;

import java.util.Random;

import CSTgame.CSTpeca;
import CSTgame.gacha;
import CSTgame.time;
import tabuleiroGame.tabuleiro;

public class racoba extends CSTpeca {
    public racoba(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        //TODO Auto-generated constructor stub
    }
    
    Random aleatorio = new Random();
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possiveisAtaques() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void habilidade(CSTpeca atacado) {
        gacha roll = new gacha("vazio");
        //selecionar gacha
        roll.atributos(this, aleatorio.nextInt(4)+1);
        
    }

}