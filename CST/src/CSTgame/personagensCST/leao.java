package CSTgame.personagensCST;

import java.util.ArrayList;
import java.util.List;

import CSTgame.CSTpeca;

import CSTgame.time;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class leao extends CSTpeca{
    private boolean travaratq; 
    private List<CSTpeca> aliados = new ArrayList<>();
    public boolean isTravaratq() {
        return travaratq;
    }



    public void setTravaratq(boolean travaratq) {
        this.travaratq = travaratq;
    }



    public boolean isHabAtivado() {
        return habAtivado;
    }



    public void setHabAtivado(boolean habAtivado) {
        this.habAtivado = habAtivado;
    }



    private int contSurtez;
    private boolean habAtivado;
   public int getContSurtez() {
        return contSurtez;
    }



    public void setContSurtez(int contSurtez) {
        this.contSurtez = contSurtez;
    }




    public leao(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento) {
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento);
        setTravaratq(true);
        setHabAtivado(false);
    }

    

    @Override
    public String toString(){
        if(modoSurtado()){
            return "🤬";
        }
        return "😇";
    }


    private boolean modoSurtado(){
        setContSurtez(getContTomarAtq());
        if(getContSurtez() == 3 && isTravaratq() == true){
            setAtaque(getAtaque() + 100);
            setTravaratq(false);
            return true;
        }else if(getContSurtez() > 3 || isTravaratq() == false){
            return true;
        }else{
            return false;
        }
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
    public void habilidade(CSTpeca aliado) {
        CSTpeca auxaliado;
        if(isHabAtivado() == false){
            aliado.setDefesa(aliado.getDefesa() + 5);
            aliados.add(aliado);
            setHabAtivado(true);
        }
        if(isHabAtivado() == true){
            auxaliado = aliados.get(0);
            auxaliado.setDefesa(auxaliado.getDefesa() - 5);
            aliado.setDefesa(aliado.getDefesa() + 5);
            aliados.remove(0);
            aliados.add(aliado);
            setHabAtivado(true);
        }
        
        
    }


    
}
