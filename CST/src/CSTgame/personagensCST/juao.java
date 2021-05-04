package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class juao extends CSTpeca{
    
    public juao(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento){
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento);
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        posicao posTeste = new posicao(0, 0);

        //diagonal pra baixo esquerda
        posTeste.setCoordenada(posicao.getLinha() + 2, posicao.getColuna() - 2);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() - 2, posTeste.getColuna() + 2);
            contMovimento++;
        }
        //diagonal pra cima direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() - 2, posicao.getColuna() + 2);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() + 2, posTeste.getColuna() - 2);
            contMovimento++;
        }
        //diagonal pra baixo direita
          contMovimento = 1;
          posTeste.setCoordenada(posicao.getLinha() + 2, posicao.getColuna() + 2);
          while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
              matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
              posTeste.setCoordenada(posTeste.getLinha() - 2, posTeste.getColuna() - 2);
              contMovimento++;
          }
        //diagonal pra cima esquerda
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() - 2, posicao.getColuna() - 2);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() + 2, posTeste.getColuna() + 2);
            contMovimento++;
        }
        return matAux;
    }

        @Override
        public boolean[][] possiveisAtaques() {
            boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
            posicao posTeste = new posicao(0, 0);
            //acima
            posTeste.setCoordenada(getPosicao().getLinha() - 5, getPosicao().getColuna());
            if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            //baixo
            posTeste.setCoordenada(getPosicao().getLinha() + 5, getPosicao().getColuna());
            if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            //esquerda
            posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 5);
            if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            //direita
            posTeste.setCoordenada(getPosicao().getLinha() , getPosicao().getColuna() + 5);
            if(getTabul().posicaoExiste(posTeste) && haUmaPecaDoOponente(posTeste)&& getTabul().istoEhUmaPeca(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
    
            return matAux;
        }

        @Override
    public void habilidade(CSTpeca alvo) {
            int dano;
            dano = alvo.getVida()/20;
            this.setVida(this.getVida() + dano);
    }
    public int voltarDano(CSTpeca alvo){
        int dano;
        dano = alvo.getVida()/20;
        return dano;
    }
}
