package aplicacao;


import CSTgame.partidaCST;


/**
 * maizada
 */
public class maizada {
    public static void main(String[] args) {
        partidaCST partidaCST = new partidaCST(20, 20);
        UI.printarTabuleiro(partidaCST.getPecas(), 20);

    }
    
}