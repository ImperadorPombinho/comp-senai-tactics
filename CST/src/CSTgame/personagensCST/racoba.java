package CSTgame.personagensCST;

import java.util.Random;

import CSTgame.CSTpeca;
import CSTgame.gacha;
import CSTgame.partidaCST;
import CSTgame.time;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class racoba extends CSTpeca {
    private partidaCST partidaCST;

    public racoba(tabuleiro tabul, time timinho, int ataque, int defesa, int vida, int rangeMovimento, String nome, partidaCST partidaCST){
        super(tabul, timinho, ataque, defesa, vida, rangeMovimento, nome);
        setTravaMov(false);
        this.partidaCST = partidaCST;
        setInventario(new gacha("Lucky Wheel", partidaCST, 0));
    }
    
    Random aleatorio = new Random();
    
    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possiveisAtaques() {
        boolean[][] matAux = new boolean[getTabul().getLinha()][getTabul().getColuna()];
        int contMovimento = 1;
        int rangeAtq;
        if(getInventario().getNomeItem().equals("AK Trovoada")){
            rangeAtq = getRangeMovimento()+3;
        }
        else{
            rangeAtq = getRangeMovimento()-1;
        }
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
    public void habilidade(CSTpeca generico) {
        if(getInventario().getNomeItem().equals("Foice")){
            System.out.println(getPosicao().getLinha());
            System.out.println(getPosicao().getLinha()+1);
            CSTpeca qualquercoisa;
            posicao posTeste = new posicao (0, 0);
            int rangehab = 7;
            int cont = 1;
            // cima
        
            posTeste.setCoordenada(getPosicao().getLinha() - 1, getPosicao().getColuna());
            while (cont <= rangehab  && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
                posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna());
    
                cont++;
            }
            
            // baixo
            cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha() + 1, getPosicao().getColuna());
            while ( cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
                posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna());
    
                cont++;
            }
            
            // esquerda
           cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() - 1);
            while (cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
            }
                posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() - 1);
    
                cont++;
            }
            
            // direita
            cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha(), getPosicao().getColuna() + 1);
            while ( cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
    
                posTeste.setCoordenada(posTeste.getLinha(), posTeste.getColuna() + 1);
    
                cont++;
            }
            // sup erquera
            cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha() - 1, getPosicao().getColuna() - 1);
            while ( cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
    
                posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna() - 1);
    
                cont++;
            }
            //inf esquerda
            cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha() + 1, getPosicao().getColuna() - 1);
            while ( cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
    
                posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna() - 1);
    
                cont++;
            }
            //sup direita
            cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha() - 1, getPosicao().getColuna() + 1);
            while ( cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
    
                posTeste.setCoordenada(posTeste.getLinha() - 1, posTeste.getColuna() + 1);
    
                cont++;
            }
            //inf direita
            cont = 1;
            posTeste.setCoordenada(getPosicao().getLinha() + 1, getPosicao().getColuna() + 1);
            while ( cont <= rangehab && getTabul().posicaoExiste(posTeste)) {
                if (haUmaPecaDoOponente(posTeste) && getTabul().posicaoExiste(posTeste)) {
                    qualquercoisa = (CSTpeca) getTabul().peca(posTeste);
                    qualquercoisa.setVida(qualquercoisa.getVida() - 120);
                    partidaCST.morreu(qualquercoisa, this);
                    System.out.println("vida do qualquer coisa: " + qualquercoisa.getVida());
                }
    
                posTeste.setCoordenada(posTeste.getLinha() + 1, posTeste.getColuna() + 1);
    
                cont++;
            }
            //posicao posTeste = new posicao (0, 0);
            //CSTpeca pecax;
            //int lin;
            //int col;
            /*for(lin = getPosicao().getLinha()+1; lin > getPosicao().getLinha()-2; lin--){
                for(col = getPosicao().getColuna()-1; col < getPosicao().getColuna()+2; col++){
                    posTeste.setCoordenada(lin, col);
                    if(getTabul().posicaoExiste(posTeste)){
                        if(haUmaPecaDoOponente(posTeste)){
                            pecax = (CSTpeca) getTabul().peca(posTeste);
                            pecax.setVida(pecax.getVida() - 300);
                            partidaCST.morreu(pecax,this);
                            System.out.println("atacado: " +pecax.getNome());
                        }
                    }
                }
            }*/
            System.out.println("A racofoice atual foi quebrada!");
        }
        ((gacha)getInventario()).atributos(this, aleatorio.nextInt(1)+1);
    }
    
    
}