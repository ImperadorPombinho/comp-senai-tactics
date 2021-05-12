package CSTgame;

import CSTgame.interfacesItems.gachaRollIf;

public class gacha extends itemEquipavel implements gachaRollIf {

    public gacha(String nomeItem) {
        super(nomeItem);
        
    }
    @Override
    public void efeitoFoice(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque()+15);
        generico.setRangeMovimento(5);
    }

    @Override
    public void efeitoAk(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque()-5);
        generico.setRangeMovimento(4);
        
    }

    @Override
    public void efeitoMartelo(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque()+20);
        generico.setRangeMovimento(2);
    }

    @Override
    public void efeitoRoupaGrife(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque()-10);
        generico.setDefesa(generico.getDefesa()+25);
        generico.setVida(generico.getVida()+(generico.getVida()/5));
    }
    
    public void atributos(CSTpeca generico, int id){
        generico.desequiparItem(this);
        System.out.println("teste");
        switch(id){
            case 1:
                this.setNomeItem("Foice");
                generico.equiparItem(this);
                efeitoFoice(generico);
                System.out.println(generico.getNome() +" agora possui a Racofoice em mãos!");
                break;
            case 2:
                this.setNomeItem("AK Trovoada");
                generico.equiparItem(this);
                efeitoAk(generico);
                System.out.println(generico.getNome() +" agora está de AK Trovoada");
                break;
            case 3:
                this.setNomeItem("Martelo");
                generico.equiparItem(this);  
                efeitoMartelo(generico);
                System.out.println(generico.getNome() +" MARTELA O MARTELOBALDO!");
                break;
            case 4:
                this.setNomeItem("Bodychain da Gucci");
                generico.equiparItem(this); 
                efeitoRoupaGrife(generico);
                System.out.println(generico.getNome() +" esta charlando de Bodychain da Gucci");
                break;
            default:
                break;                    
        }
    }
}