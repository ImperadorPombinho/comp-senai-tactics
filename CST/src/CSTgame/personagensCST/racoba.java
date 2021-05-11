package CSTgame.personagensCST;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CSTgame.CSTpeca;

import CSTgame.time;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class racoba {
    Random aleatorio = new Random();

    @Override
    public String toString(){
        return "R";
    }

    @Override
    public void habilidade(CSTpeca atacado){
        gacha gachaDaVez = new gacha();
        //selecionar gacha
        gachaDaVez.atributos(this, aleatorio.nextInt(4)+1);

    }

}
