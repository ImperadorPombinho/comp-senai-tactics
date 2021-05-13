package CSTgame;

import CSTgame.interfacesItems.equipavelIF;

public class itemEquipavel implements equipavelIF{
    private String nomeItem;
    private partidaCST partidaCST;
    private int ID;
    
    public int getID() {
        return ID;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public itemEquipavel(String nomeItem, partidaCST partidaCST, int ID) {
        this.nomeItem = nomeItem;
        this.partidaCST = partidaCST;
        this.ID = ID;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

 

    @Override
    public void efeitoCamPlaystation(CSTpeca generico) {
        if(partidaCST.euSouAliado(generico)){
            generico.setDefesa(generico.getDefesa() + 20);
        }else{
            throw new exececaoCST("nao pode usar em inimigo");
        }
        
    }

 

    @Override
    public void efeitoTacoDeSinuca(CSTpeca generico) {
        if(partidaCST.euSouAliado(generico)){
            generico.setAtaque(generico.getAtaque() + 30);
        }else{
            throw new exececaoCST("nao pode usar em inimigo");
        }
        
        
    }


    public void efeito(CSTpeca generico){
        if(getID() == 1){
            efeitoCamPlaystation(generico);
        }else if(getID() == 2){
            efeitoTacoDeSinuca(generico);
        }
    }
}
