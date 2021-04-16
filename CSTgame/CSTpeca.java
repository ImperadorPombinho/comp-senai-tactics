package CSTgame;

import tabuleiroGame.peca;
import tabuleiroGame.tabuleiro;

public class CSTpeca extends peca{
    private time timinho;
    private int ataque;
    private int vida;
    private int defesa;
    
    public int getAtaque() {
        return ataque;
    }
    protected void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getVida() {
        return vida;
    }
    protected void setVida(int vida) {
        this.vida = vida;
    }
    public int getDefesa() {
        return defesa;
    }
    protected void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public CSTpeca(tabuleiro tabul, time timinho, int ataque, int defesa, int vida) {
        super(tabul);
        this.timinho = timinho;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        
    }
    public time getTiminho() {
        return timinho;
    }


    

}
