package CSTgame.ItensCST;

import CSTgame.CSTpeca;
import CSTgame.item;
import CSTgame.tipoItem;

public class camPlay extends item{

    public camPlay(String nome, tipoItem tipo) {
        super(nome, tipo);
        
    }

    @Override
    public void efeito(CSTpeca generica) {
       if(generica.haUmaPecaAliada(generica.getPosicao())){
            generica.setDefesa(generica.getDefesa() + 10);
       }
        
        
    }
    
}
