package CSTgame;

import CSTgame.interfacesItems.consumivelIF;

/**
 * itemConsumivel
 */
public class itemConsumivel implements consumivelIF{
    private String nomeItem;
    private int quantidade;
    private partidaCST partidaCST;
    private int ID;

    public int getID() {
        return ID;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nomeItem;
    }

    public itemConsumivel(String nomeItem, int quantidade, partidaCST partidaCST, int ID) {
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
        this.partidaCST = partidaCST;
        this.ID = ID;
    }

    public void setNome(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public void efeitoFPyke(CSTpeca generica) {
        if(partidaCST.euSouAliado(generica)){
             generica.setAtaque(generica.getAtaque() + 5);
              generica.setDefesa(generica.getDefesa() + 5);
        }else{
            throw new exececaoCST("nao pode usar em inimigo");
        }
    }

    @Override
    public void efeitoPizza(CSTpeca generica) {
        if(partidaCST.euSouAliado(generica)){
            generica.setVida(generica.getVida() + 20);
        }else{
            throw new exececaoCST("Não pode usar em inimigo");
        }
        
        
    }

    @Override
    public void efeitoPototonime(CSTpeca generica) {
        if(partidaCST.euSouInimigo(generica)){
            generica.setVida(generica.getVida() - 5);
        }else{
            throw new exececaoCST("nao pode usar em aliado");
        }
    }


    public void efeito(CSTpeca generica){
        efeitoPizza(generica);
    }
    
 
}