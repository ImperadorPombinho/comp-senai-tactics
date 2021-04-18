package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class leao extends CSTpeca{

    public leao(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento);
        
    }
    
    

    @Override
    public String toString(){
        return "😇";
    }



    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        posicao posTeste = new posicao(0, 0);
        //acima
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
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
          while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
              matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
              posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
              contMovimento++;
          }
            //direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
            contMovimento++;
        }



        return matAux;
    }


    
}
