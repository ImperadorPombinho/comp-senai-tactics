package CSTgame;

import CSTgame.interfacesItems.consumivelIF;

/**
 * itemConsumivel
 */
public class itemConsumivel implements consumivelIF{
    private String nomeItem;
    private int quantidade;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nomeItem;
    }

    public itemConsumivel(String nomeItem, int quantidade) {
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
    }

    public void setNome(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public void efeitoFPyke(CSTpeca generica) {
        generica.setAtaque(generica.getAtaque() + 5);
        generica.setDefesa(generica.getDefesa() + 5);
        
    }

    @Override
    public void efeitoPizza(CSTpeca generica) {
        generica.setVida(generica.getVida() + 20);
        
    }

    @Override
    public void efeitoPototonime(CSTpeca generica) {
        generica.setVida(generica.getVida() - 5);
        
    }


    public void efeito(CSTpeca generica){
        efeitoPizza(generica);
    }
    
    
}