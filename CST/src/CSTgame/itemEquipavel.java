package CSTgame;

import CSTgame.interfacesItems.equipavelIF;

public class itemEquipavel implements equipavelIF{
    private String nomeItem;

    public String getNomeItem() {
        return nomeItem;
    }

    public itemEquipavel(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

 

    @Override
    public void efeitoCamPlaystation(CSTpeca generico) {
        generico.setDefesa(generico.getDefesa() + 20);
    }

 

    @Override
    public void efeitoTacoDeSinuca(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque() + 30);
        
    }


    public void efeito(CSTpeca generico){
        efeitoCamPlaystation(generico);
    }
}
