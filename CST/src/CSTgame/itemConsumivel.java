package CSTgame;

import CSTgame.interfacesItems.consumivelIF;

/**
 * itemConsumivel
 */
public class itemConsumivel implements consumivelIF{
    private String nomeItem;

    public String getNome() {
        return nomeItem;
    }

    public itemConsumivel(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setNome(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    @Override
    public void efeitoFPyke(CSTpeca generica) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoPizza(CSTpeca generica) {
        generica.setVida(generica.getVida() + 20);
        
    }

    @Override
    public void efeitoPototonime(CSTpeca generica) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoBeats(CSTpeca generica) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoPrevDoom(CSTpeca generica) {
        // TODO Auto-generated method stub
        
    }
    public void efeito(CSTpeca generica){
        efeitoPizza(generica);
    }
    
    
}