package CSTgame;

import CSTgame.interfacesItems.gachaRollIf;

public class gacha extends itemEquipavel implements gachaRollIf {

    public gacha(String nomeItem) {
        super(nomeItem);
        //TODO Auto-generated constructor stub
    }
    @Override
    public void efeitoFoice(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque()+20);
        generico.setRangeMovimento(5);
    }

    @Override
    public void efeitoAk(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoMartelo(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void efeitoRoupaGrife(CSTpeca generico) {
        // TODO Auto-generated method stub
        
    }
    public void alternarGacha(CSTpeca generico){
        String item = this.getNomeItem();
        if(item.equals("Foice")){
            generico.setAtaque(generico.getAtaque()-20);

        }
        if(item.equals("AK Trovoada")){

        }
        if(item.equals("Martelo")){

        }
        if(item.equals("Bodychain da Gucci")){

        }
    }
    public void atributos(CSTpeca generico, int id){
        this.alternarGacha(generico);
        switch(id){
            case 1:
                this.setNomeItem("Foice");
                generico.setInventario(this);
                efeitoFoice(generico);
                break;
            case 2:
                this.setNomeItem("AK Trovoada");
                generico.setInventario(this);
                efeitoAk(generico);
                break;
            case 3:
                this.setNomeItem("Martelo");
                generico.setInventario(this);  
                efeitoMartelo(generico);
                break;
            case 4:
                this.setNomeItem("Bodychain da Gucci");
                generico.setInventario(this); 
                efeitoRoupaGrife(generico);
                break;
            default:
                break;                    
        }
    }
}