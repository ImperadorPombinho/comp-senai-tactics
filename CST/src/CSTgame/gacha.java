package CSTgame;

import CSTgame.interfacesItems.gachaRollIf;
import CSTgame.personagensCST.racoba;


public class gacha implements gachaRollIf {
    private String nomeGacha;

    public String getNomeGacha (){
        return nomeGacha;
    }

    public void setNome(String nomeGacha){
        this.nomeGacha = nomeGacha;
    }

    @Override
    public void efeitoFoice(CSTpeca generico) {
        // TODO Auto-generated method stub
        
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

    public void atributos(CSTpeca generico, int id){
        switch(id){
            case 1:
                efeitoFoice(generico);
                break;
            case 2:
                efeitoAk(generico);
                break;
            case 3:
                efeitoMartelo(generico);
                break;
            case 4:
                efeitoRoupaGrife(generico);
                break;
            default:
                break;                    
        }
    }
}