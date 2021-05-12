package CSTgame.personagensCST;

import CSTgame.CSTpeca;
import CSTgame.time;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class juao extends CSTpeca{
    
    public juao(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome){
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        setTravaMov(false);
        
    }

    @Override
    public String toString() {
        return "J";
    }

    @Override
    public boolean[][] possiveisMovimentos() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        posicao posTeste = new posicao(0, 0);

        //diagonal pra baixo esquerda
        posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna() - 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna() - 1);
            contMovimento++;
        }
        //diagonal pra cima direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento()){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna() + 1);
            contMovimento++;
        }
        //diagonal pra baixo direita
          contMovimento = 1;
          posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna() + 1);
          while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
              matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
              posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna() + 1);
              contMovimento++;
          }
        //diagonal pra cima esquerda
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna() - 1);
        while(getTabul().posicaoExiste(posTeste) && !getTabul().istoEhUmaPeca(posTeste) && contMovimento <= getRangeMovimento() ){
            matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna() - 1);
            contMovimento++;
        }
        return matAux;
    }

    @Override
    public boolean[][] possiveisAtaques() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        int rangeAtq = 6;
        posicao posTeste = new posicao(0, 0);

        //cima
        posTeste.setCoordenada(posicao.getLinha() - 1, posicao.getColuna());
        while(getTabul().posicaoExiste(posTeste) && contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste) && getTabul().istoEhUmaPeca(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            
            posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna() );
            contMovimento++;
        }
        //direita
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() + 1);
        while(getTabul().posicaoExiste(posTeste) && contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() + 1);
            contMovimento++;
        }
        //baixo
          contMovimento = 1;
          posTeste.setCoordenada(posicao.getLinha() + 1, posicao.getColuna() );
          while(getTabul().posicaoExiste(posTeste) && contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
              posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna() );
              contMovimento++;
          }
        //esquerda
        contMovimento = 1;
        posTeste.setCoordenada(posicao.getLinha() , posicao.getColuna() - 1);
        while(getTabul().posicaoExiste(posTeste)&& contMovimento <= rangeAtq ){
            if(haUmaPecaDoOponente(posTeste)){
                matAux[posTeste.getLinha()][posTeste.getColuna()] = true;
            }
            posTeste.setCoordenada(posTeste.getLinha() , posTeste.getColuna() - 1);
            contMovimento++;
        }

        return matAux;
    }

        @Override
    public void habilidade(CSTpeca alvo) {
        if(Math.abs(alvo.getPosicao().getLinha() - this.getPosicao().getLinha()) <= 5 && Math.abs(alvo.getPosicao().getColuna() - this.getPosicao().getColuna()) <= 5){
            int dano;
            dano = alvo.getVida()/20;
            if(dano == 0){
                dano = 1;
            }
            
            this.setVida(this.getVida() + dano);
        }else{
            System.out.println("peça fora do alcance de ataque! tente novamente");
            
        }
    }
    public int voltarDano(CSTpeca alvo){
        int dano;
        dano = alvo.getVida()/20;
        if(dano == 0){
            dano = 1;
        }
        
        return dano;
    }
}
