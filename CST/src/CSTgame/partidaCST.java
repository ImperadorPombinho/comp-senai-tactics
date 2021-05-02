package CSTgame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import CSTgame.personagensCST.leao;

import CSTgame.personagensCST.obstaculo;

import tabuleiroGame.peca;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class partidaCST {
    private tabuleiro tabuleiro;
    private int linhaMax;
    private int ColunaMax;
    private boolean trava;
    private jogador jogador = new jogador();
    private List<CSTpeca> pecasNoTabuleiro = new ArrayList<>();
    private List<CSTpeca> pecasOraculo= new ArrayList<>();
    private List<CSTpeca> pecasTropa = new ArrayList<>();
    private int turno;
    private int indOraculo;
    private int indTropa;
    public boolean isTrava() {
        return trava;
    }

    public void setTrava(boolean trava) {
        this.trava = trava;
    }

    public partidaCST(int linha, int coluna) {
        tabuleiro = new tabuleiro(linha, coluna);
        this.linhaMax = linha;
        this.ColunaMax = coluna;
        turno = 1;
        jogador.setTimeAtual(time.ORACULO);
        setupInicial();
        Collections.shuffle(pecasOraculo);
        Collections.shuffle(pecasTropa);
        indOraculo = 0;
        indTropa = 0;
    }

    public CSTpeca[][] getPecas(){
        CSTpeca[][] matriz = new CSTpeca[tabuleiro.getLinha()][tabuleiro.getColuna()];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (CSTpeca) tabuleiro.peca(i, j);
            }
        }
        return matriz;
    }
    public boolean[][] possiveisMovimentos(CSTposicao posicaoOrigem){
        posicao posicao = posicaoOrigem.toPosicao();
        validacaoOrigem(posicao);
        return tabuleiro.peca(posicao).possiveisMovimentos();
    }
    public boolean[][] possiveisAtaques(CSTposicao posicaoOrigem){
        posicao posicao = posicaoOrigem.toPosicao();
        validacaoAtqO(posicao);
        return tabuleiro.peca(posicao).possiveisAtaques();
    }

    public void perfomaceFazerMovimento(CSTposicao posicaoOrigem, CSTposicao posicaoDestino){
        posicao origem = posicaoOrigem.toPosicao();
        posicao destino = posicaoDestino.toPosicao();
        validacaoOrigem(origem);
        validacaoOrigemDestino(origem, destino);
        fazerMovimento(origem, destino);
        proximoTurno();
    }
    public void perfomaceAtaque(CSTposicao posicaoAtacante, CSTposicao posicaoAtacado){
        posicao posAtacante = posicaoAtacante.toPosicao();
        posicao posAtacado =  posicaoAtacado.toPosicao();
        validacaoAtaqueOD(posAtacado, posAtacante);
        CSTpeca atacante = (CSTpeca) tabuleiro.peca(posAtacante);
        CSTpeca atacado = (CSTpeca) tabuleiro.peca(posAtacado);
        validacaoAtaque(atacante, atacado);
        if(atacado instanceof leao){
            atacado.contarAtqTomado();
           
        }
        ataque(atacante, atacado);
        System.out.println(atacado.getAtaque());
        System.out.println(atacante.getAtaque());
        if(atacado.getVida() <= 0){
            peca capturada = tabuleiro.removerPeca(posAtacado);
            
        }
        proximoTurno();
    }
    public void perfomaceHabilidade(CSTposicao posicaoVoce, CSTposicao posicaoAliado){
        posicao posicaooVoce = posicaoVoce.toPosicao();
        posicao posicaooAliado = posicaoAliado.toPosicao();
        CSTpeca voce = (CSTpeca) tabuleiro.peca(posicaooVoce);
        CSTpeca aliado = (CSTpeca) tabuleiro.peca(posicaooAliado);
        validacaoHabilidade(voce, aliado);
        habilidade(voce, aliado);
        proximoTurno();
    }

    private void fazerMovimento(posicao origem, posicao destino){
        peca naOrigem = tabuleiro.removerPeca(origem);
        tabuleiro.colocarPeca(naOrigem, destino);
    }
    private void ataque(CSTpeca atacante, CSTpeca atacado){
        atacado.setVida(atacado.getVida() - (atacante.getAtaque() - atacado.getDefesa()));
        System.out.println("vida atacado: " + atacado.getVida());
        
    }
    private void habilidade(CSTpeca voce, CSTpeca aliado){
        voce.habilidade(aliado);
        System.out.println("defesa aliado: " + aliado.getDefesa());
    }
    private void validacaoOrigem(posicao origem){
        if(!tabuleiro.istoEhUmaPeca(origem)){
            throw new exececaoCST("isto nao eh uma peca para se mover");
        }
        if(jogador.getTimeAtual() != ((CSTpeca)tabuleiro.peca(origem)).getTiminho()){
            throw new exececaoCST("nao pode mover pecas adversarias");
        }
        if(!tabuleiro.peca(origem).haAlgumMovimentoPossivel() || tabuleiro.peca(origem) instanceof obstaculo){
            throw new exececaoCST("nao ha movimento possivel para essa peca ou essa peca eh um obstaculo");
        }
        

    }
    private void validacaoOrigemDestino(posicao origem, posicao destino){
        if(!tabuleiro.peca(origem).possivelMovimentaDeUmaPeca(destino)){
            throw new exececaoCST("essa peca escolhida nao pode mover para tal posicao de destino");
        }
    }
    private void validacaoAtaque(CSTpeca atacante, CSTpeca atacado){
        if(!tabuleiro.istoEhUmaPeca(atacado.getPosicao())){
            throw new exececaoCST("isto nao eh uma pecapara ataque");
        }
        
        if(!atacante.haUmaPecaDoOponente(atacado.getPosicao())){
            throw new exececaoCST("nao eh inimigo para atacar");
        }
        if(!tabuleiro.peca(atacante.getPosicao()).haAlgumAtaquePossivel()){
            throw new exececaoCST("nao ha ataques disponiveis para essa peca");
        }
    }
    private void validacaoHabilidade(CSTpeca voce, CSTpeca aliado){
        if(!tabuleiro.istoEhUmaPeca(aliado.getPosicao())){
            throw new exececaoCST("isto nao eh uma peca do tabuleiro");
        }
        if(!voce.haUmaPecaAliada(aliado.getPosicao())){
            throw new exececaoCST("nao eh aliado para ajudar");
        }

    }
    private void validacaoAtaqueOD(posicao destino, posicao origem){
        if(jogador.getTimeAtual() != ((CSTpeca)tabuleiro.peca(origem)).getTiminho()){
            throw new exececaoCST("esta peça escolhida nao eh do seu campo");
        }
        if(!tabuleiro.peca(origem).possivelAtaque(destino)){
            throw new exececaoCST("essa peca escolhida nao pode atacar nessa direção");
        }
        
    }
    private void validacaoAtqO(posicao origem){
        if(!tabuleiro.istoEhUmaPeca(origem)){
            throw new exececaoCST("isto nao eh uma peca para se mover");
        }
        if(!tabuleiro.peca(origem).haAlgumAtaquePossivel()){
            throw new exececaoCST("nao ha ataque possivel para essa peca ou essa peca eh um obstaculo");
        }
        

    }
    
    private void colocarNovaPeca(peca peca, int linha, int coluna){
        tabuleiro.colocarPeca(peca, new CSTposicao(coluna, linha, linhaMax, ColunaMax).toPosicao());
        if(!(peca instanceof obstaculo) && ((CSTpeca)peca).getTiminho() == time.ORACULO){
            pecasOraculo.add((CSTpeca)peca);
        }
        if(!(peca instanceof obstaculo) && ((CSTpeca)peca).getTiminho() == time.TROPA){
            pecasTropa.add((CSTpeca)peca);
        }
    }
    private void proximoTurno(){
        turno++;
        jogador.setTimeAtual((jogador.getTimeAtual() == time.ORACULO) ? time.TROPA : time.ORACULO);
        


    }

    private void setupInicial(){
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14, 5), 20, 20);
        colocarNovaPeca(new leao(tabuleiro, time.TROPA, 0, 0, 120,5), 19, 5);
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14,5), 7, 14);
        colocarNovaPeca(new obstaculo(tabuleiro, time.TROPA, 0, 0, 14,5), 1, 1);
        colocarNovaPeca(new leao(tabuleiro, time.ORACULO, 20, 2, 500, 5), 14, 5);
        colocarNovaPeca(new obstaculo(tabuleiro, time.ORACULO, 0, 0, 14,5), 1, 2);
        
        
    }
}
