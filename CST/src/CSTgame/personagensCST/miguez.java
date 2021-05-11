package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.partidaCST;
import CSTgame.time;

import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

import java.util.Random;

public class miguez extends CSTpeca {
    Random aleatorio = new Random();
    private int dormindo;
    private partidaCST partida;

    public miguez(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, partidaCST partida, String nome) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        this.partida = partida;
        setTravaMov(false);
    }

    @Override
    public String toString(){
        return "M";
    }

    public int getDormindo() {
        dormindo = aleatorio.nextInt(10)+1;
        return dormindo;
    }

    public void setDormindo(int dormindo) {
        this.dormindo = dormindo;
    }

    public String dormiuVez(){
        if(getDormindo() == 1){
            partida.proximoTurno();
            return "Miguez acabou dormindo demais e perdeu a jogada!";
        }
        else{ 
        return null;
        }
    }

    public miguez(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        //TODO Auto-generated constructor stub
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        posicao posTeste = new posicao(0, 0);
        //acima
        
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna());
            contMovimento++;
        }
        //abaixo
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna());
            contMovimento++;
        }
        //esquerda
          contMovimento = 1;
          posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() - 1);
          while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
              matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
              posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
              contMovimento++;
          }
            //direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
            contMovimento++;
        }



        return matAux;
    }



    @Override
    public boolean[][] possiveisAtaques() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        posicao posTeste = new posicao(0, 0);
        //acima
        posTeste.setCoordenada(getPosicao().getLinha() - 2, getPosicao().getColuna());
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //baixo
        posTeste.setCoordenada(getPosicao().getLinha() + 2, getPosicao().getColuna());
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //esquerda
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 2);
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }
        //direita
        posTeste.setCoordenada(getPosicao().getLinha() , getPosicao().getColuna() + 2);
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
        }

        return matAux;
    }

    @Override
    public void habilidade(CSTpeca generico) {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        posicao posTeste = new posicao(0, 0);
        int cooldown=0;

        if(cooldown==0){
        //acima
        posTeste.setCoordenada(getPosicao().getLinha() - 2, getPosicao().getColuna());
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            
            cooldown = 3;
        }
        //abaixo
        posTeste.setCoordenada(getPosicao().getLinha() + 2, getPosicao().getColuna());
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            
            cooldown = 3;
        }
        //acima
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 2);
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            
            cooldown = 3;
        }
        //acima
        posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() + 2);
        while(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            generico.setTravaMov(true);
            
            cooldown = 3;
        }
    }
       else{
           System.out.println("A habilidade está em recarga");
       } 
       cooldown--;
    }
}