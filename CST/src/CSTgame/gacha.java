package CSTgame;
import CSTgame.interfacesItems.gachaRollIf;

public class gacha extends itemEquipavel implements gachaRollIf {

    public gacha(String nomeItem, CSTgame.partidaCST partidaCST, int ID) {
        super(nomeItem, partidaCST, ID);
    }

    @Override
    public void efeitoFoice(CSTpeca generico) {
        generico.setAtaque(generico.getAtaque()+5);
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
    public void desequiparGacha(itemEquipavel item, CSTpeca generico){
            String nome = item.getNomeItem();
            if(nome.equals("Foice")){
                generico.setAtaque(generico.getAtaque()-5);
            }
            if(nome.equals("AK Trovoada")){
                generico.setAtaque(generico.getAtaque()+5);
            }
            if(nome.equals("Martelo")){
                generico.setAtaque(generico.getAtaque()-20);
            }
            if(nome.equals("Bodychain da Gucci")){
                generico.setAtaque(generico.getAtaque()+10);
                generico.setDefesa(generico.getDefesa()-25);
            }
            if(nome.equals("Lucky Wheel")){
                System.out.println("Ativando roleta do gacha! Boa sorte!");
            }
            generico.setRangeMovimento(3);
    }
    
    public void atributos(CSTpeca generico, int id){
        desequiparGacha(generico.getInventario(), generico);
        System.out.println("Rodando o gacha...");
        System.out.println(generico.getNome() +" recebeu: ");
        switch(id){
            case 1:
                this.setNomeItem("Foice");
                generico.setInventario(this);
                efeitoFoice(generico);
                System.out.println("Racofoice!! Agora é possível utilizar o giro mortal!");
                break;
            case 2:
                this.setNomeItem("AK Trovoada");
                generico.setInventario(this);
                efeitoAk(generico);
                System.out.println("AK 47 trovoada!! Ataque a distancia!");
                break;
            case 3:
                this.setNomeItem("Martelo");
                generico.setInventario(this);  
                efeitoMartelo(generico);
                System.out.println("MARTELOBALDO!");
                break;
            case 4:
                this.setNomeItem("Bodychain da Gucci");
                generico.setInventario(this); 
                efeitoRoupaGrife(generico);
                System.out.println("Bodychain da Gucci! ta podendo filho!");
                break;
            default:
                break;                    
        }
    }
}