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
    public void efeitoBoneTeus(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoCamPlaystation(CSTpeca generico) {
        generico.setDefesa(generico.getDefesa() + 20);
    }

    @Override
    public void efeitoBencaoOraculo(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoTacoDeSinuca(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoOculosGamer(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }
    public void efeito(CSTpeca generico){
        efeitoCamPlaystation(generico);
    }
}
