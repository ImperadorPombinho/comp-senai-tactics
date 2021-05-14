package CSTgame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import CSTgame.personagensCST.henridog;
import CSTgame.personagensCST.juao;
import CSTgame.personagensCST.leao;
import CSTgame.personagensCST.miguez;
import CSTgame.personagensCST.obstaculo;

import tabuleiroGame.peca;
import tabuleiroGame.posicao;
import tabuleiroGame.tabuleiro;

public class partidaCST {
    private tabuleiro tabuleiro;
    private int linhaMax;
    private int ColunaMax;
    private boolean partida;
    private boolean trava;
    private jogador jogador = new jogador();
    private List<CSTpeca> pecasOraculo= new ArrayList<>();
    private List<CSTpeca> pecasTropa = new ArrayList<>();
    private List<itemEquipavel> itensEquipavels = new ArrayList<>();
    private List<itemConsumivel> itensConsumivels = new ArrayList<>();
    private List<itemEquipavel> itensEquipavelsO = new ArrayList<>();
    private List<itemConsumivel> itensConsumivelsO = new ArrayList<>();
    private List<itemEquipavel> itensEquipavelsT = new ArrayList<>();
    private List<itemConsumivel> itensConsumivelsT = new ArrayList<>();
    private int turno;
    private int indOraculo;
    public boolean ispartida() {
        return partida;
    }
    public void setPartida(boolean partida) {
        this.partida = partida;
    }
    public List<CSTpeca> getPecasOraculo() {
        return pecasOraculo;
    }

    public List<itemConsumivel> getItensConsumivels() {
        return itensConsumivels;
    }
    public List<itemEquipavel> getItensEquipavels() {
        return itensEquipavels;
    }
    public List<CSTpeca> getPecasTropa() {
        return pecasTropa;
    }

   

    private int indTropa;
    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getIndOraculo() {
        return indOraculo;
    }

    public void setIndOraculo(int indOraculo) {
        this.indOraculo = indOraculo;
    }

    public int getIndTropa() {
        return indTropa;
    }

    public void setIndTropa(int indTropa) {
        this.indTropa = indTropa;
    }

    public jogador getJogador() {
        return jogador;
    }



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
        setTurno(1);
        jogador.setTimeAtual(time.ORACULO);
        setupInicial();
        Collections.shuffle(pecasOraculo);
        Collections.shuffle(pecasTropa);
        setIndOraculo(0);
        setIndTropa(0);
        jogador.setPecaAtual(pecasOraculo.get(getIndOraculo()));
        setPartida(true);
        encherListaConsumivel(itensConsumivels);
        encherListaEquipavel(itensEquipavels);
        
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
        CSTpeca miguezz = (CSTpeca) tabuleiro.peca(origem);
        if(miguezz instanceof miguez){
            String msg = ((miguez)miguezz).dormiuVez();
            System.out.println(msg);
        }
        posicao destino = posicaoDestino.toPosicao();
        validacaoOrigem(origem);
        validacaoOrigemDestino(origem, destino);
        fazerMovimento(origem, destino);
        proximoTurno();
    }
    public void perfomaceAtaque(CSTposicao posicaoAtacante, CSTposicao posicaoAtacado){
        posicao posAtacante = posicaoAtacante.toPosicao();
        CSTpeca miguezz = (CSTpeca) tabuleiro.peca(posAtacante);
        if(miguezz instanceof miguez){
            String msg = ((miguez)miguezz).dormiuVez();
            System.out.println(msg);
        }
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
            if((CSTpeca) capturada instanceof henridog){
                if(((henridog)capturada).isRENASCEU() == false){
                    ((henridog)capturada).passiva();
                    tabuleiro.colocarPeca(capturada, posAtacado);
                }else{
                    if(((CSTpeca)capturada).getTiminho() == time.ORACULO){
                        pecasOraculo.remove((CSTpeca)capturada);
                        setIndOraculo(getIndOraculo() - 1);
                    }else{
                        pecasTropa.remove((CSTpeca)capturada);
                        setIndTropa(getIndTropa() - 1);
                    }
                }
            }else{
                if(((CSTpeca)capturada).getTiminho() == time.ORACULO){
                    pecasOraculo.remove((CSTpeca)capturada);
                }else{
                    pecasTropa.remove((CSTpeca)capturada);
                }
            }

            
        }
        proximoTurno();
    }
    public void perfomaceHabilidade(CSTposicao posicaoVoce, CSTposicao posicaoAliado){
        posicao posicaooVoce = posicaoVoce.toPosicao();
        posicao posicaooAliado = posicaoAliado.toPosicao();
        CSTpeca voce = (CSTpeca) tabuleiro.peca(posicaooVoce);
        CSTpeca aliado = (CSTpeca) tabuleiro.peca(posicaooAliado);
        habilidade(voce, aliado);
        proximoTurno();
    }
    public void perfomaceUsarItem(CSTposicao posicaoGenerica, int IDItem){
        posicao posgenerica = posicaoGenerica.toPosicao();
        CSTpeca generica = (CSTpeca) tabuleiro.peca(posgenerica);
        usarItemConsumivel(IDItem, generica);
    }
    public void perfomaceEquiparItem(CSTposicao posicaogenerica, int ID){
        posicao possgenerica = posicaogenerica.toPosicao();
        CSTpeca generico = (CSTpeca) tabuleiro.peca(possgenerica);
        equiparItemEquipavel(ID, generico);
    }

    private void fazerMovimento(posicao origem, posicao destino){
        peca naOrigem = tabuleiro.removerPeca(origem);
        System.out.println(((CSTpeca) naOrigem).isTravaMov());
        if(((CSTpeca) naOrigem).isTravaMov()==true){
            tabuleiro.colocarPeca(naOrigem, origem);
            System.out.println("Essa peça está congelada e será descongelada na próxima rodada!");
            //proximoTurno();
            ((CSTpeca) naOrigem).setTravaMov(false);
        }
        else{
        tabuleiro.colocarPeca(naOrigem, destino);
        }

    }
    
    private void ataque(CSTpeca atacante, CSTpeca atacado){
        if(atacante instanceof juao){
            if(atacante.getVida() < atacado.getVida()){
                atacado.setVida(atacado.getVida() - ((atacante.getAtaque() + (atacante.getAtaque()/10)) - atacado.getDefesa()));
                System.out.println("vida atacado: " + atacado.getVida());
            }else{
                atacado.setVida(atacado.getVida() - (atacante.getAtaque() - atacado.getDefesa()));
                System.out.println("vida atacado: " + atacado.getVida());
            }
        }else{
            atacado.setVida(atacado.getVida() - (atacante.getAtaque() - atacado.getDefesa()));
            System.out.println("vida atacado: " + atacado.getVida());
        }
        
    }
    private void habilidade(CSTpeca voce, CSTpeca aliado){
        voce.habilidade(aliado);
        System.out.println("defesa aliado: " + aliado.getDefesa());
        System.out.println("vida: " + aliado.getVida());
    }
    private void habilidadeJuao(juao voce, CSTpeca oponente){
            if(!voce.haUmaPecaDoOponente(oponente.getPosicao())){
                throw new exececaoCST("isto nao eh uma peça para ataque");
            }else{
                voce.habilidade(oponente);
                oponente.setVida(oponente.getVida() - voce.voltarDano(oponente));
                System.out.println("vida de juao: " + voce.getVida());
                System.out.println("vida do oponente: " + oponente.getVida());
            }
    }
    private int somaVida(List<CSTpeca> qualquer){
        int soma = 0;
        for (CSTpeca csTpeca : qualquer) {
            soma += csTpeca.getVida();
        }
        return soma;
    }
    private time testaDepoisTurno(int quantOraculo, int quantTropa){
        int somaOraculo, somaTropa;

        if(quantOraculo > quantTropa){
            return time.ORACULO;
        }else if(quantTropa > quantOraculo){
            return time.TROPA;
        }else{
            somaOraculo = somaVida(pecasOraculo);
            somaTropa = somaVida(pecasTropa);
            if(somaOraculo > somaTropa){
                return time.ORACULO;
            }else if(somaTropa > somaOraculo){
                return time.TROPA;
            }else{
                return null;
            }
        }
    }
    public time testaQuemGanhou(){
        time timinho;
        int turno = getTurno();
        int quantOraculo = pecasOraculo.size();
        int quantTropa = pecasTropa.size();
        if(quantOraculo == 0){
            setPartida(false);
            return time.TROPA;
        }else if(quantTropa == 0){
            setPartida(false);
            return time.ORACULO;
        }else if(turno == 17){
            setPartida(false);
            timinho = testaDepoisTurno(quantOraculo, quantTropa);
            return timinho;
        }else{
            return null;
        }

    }
    private boolean pesquisarSeEhIgual(List<itemConsumivel> qualquer, itemConsumivel itemgacha){
        for (int i = 0; i < qualquer.size(); i++) {
            if(itemgacha.hashCode() == qualquer.get(i).hashCode()){
                return true;
            }
            
        }
        return false;
    }
    private void darItemAleatorio(List<itemConsumivel> qualquer){
        Random gachazinho = new Random();
        int gacha;
        while(true){
            gacha = gachazinho.nextInt(qualquer.size());
            itemConsumivel itemgacha = itensConsumivels.get(gacha);
            boolean ganhougacha = pesquisarSeEhIgual(qualquer, itemgacha);
            if(ganhougacha == false){
                qualquer.add(itemgacha);
                break;
            }
        }

    }
    private void encherListaEquipavel(List<itemEquipavel> lEquipavels){
        lEquipavels.add(new itemEquipavel("Camisa da Playstation", this, 1));
        lEquipavels.add(new itemEquipavel("Taco de Sinuca", this, 2));
    }
    private void encherListaConsumivel(List<itemConsumivel> lConsumivels){
        lConsumivels.add(new itemConsumivel("Flexao Pyke", 5, this, 1));
        lConsumivels.add(new itemConsumivel("Pizza", 5, this, 2));
        lConsumivels.add(new itemConsumivel("Pototonime", 5, this, 3));
    }
    private void usarItemConsumivel(int IDUI, CSTpeca generica){
        int item;
        itemConsumivel itemUsado;
        if(jogador.getTimeAtual() == time.ORACULO){
            item = pesquisarListaConsumivel(IDUI, itensConsumivelsO);
            itemUsado = itensConsumivelsO.get(item);
        }else{
            item = pesquisarListaConsumivel(IDUI, itensConsumivelsT);
            itemUsado = itensConsumivelsT.get(item);
        }
         
        itemUsado.efeito(generica);
        itemUsado.setQuantidade(itemUsado.getQuantidade() - 1);

    }
    private int pesquisarListaConsumivel(int IDUI, List<itemConsumivel> qualquer){
        for (int i = 0; i < qualquer.size(); i++) {
            if(i == IDUI - 1){
                return i;
            }
        }
        return -1;
    }
    private void equiparItemEquipavel(int ID, CSTpeca generico){
        int equipavel;
        itemEquipavel equipar;
        if(generico.getTiminho() == time.ORACULO){
            equipavel = pesquisarListaEquipavel(ID, itensEquipavelsO);
            equipar = itensEquipavelsO.get(equipavel);
        }else{
            equipavel = pesquisarListaEquipavel(ID, itensEquipavelsT);
            equipar = itensEquipavelsT.get(equipavel);
        }
        generico.equiparItem(equipar, generico);
    }
    private int pesquisarListaEquipavel(int ID, List<itemEquipavel> qualquer2){
        for (int i = 0; i < qualquer2.size(); i++) {
            if(i == ID - 1){
                return i;
            }
        }
        return -1;
    }
    public void morreu(CSTpeca peca){
        posicao aux = peca.getPosicao();
        if(peca.getVida() <= 0){
            tabuleiro.removerPeca(peca.getPosicao());
            if(peca instanceof henridog){
                if(((henridog)peca).isRENASCEU() == false){
                    ((henridog)peca).passiva();
                    tabuleiro.colocarPeca(peca, aux);
                }else{
                    if(((CSTpeca)peca).getTiminho() == time.ORACULO){
                        pecasOraculo.remove(peca);
                        setIndOraculo(getIndOraculo() - 1);
                    }else{
                        pecasTropa.remove(peca);
                        setIndTropa(getIndTropa() - 1);
                    }
                }
            }else{
            if(peca.getTiminho() == time.ORACULO){
                pecasOraculo.remove(peca);
                
            }else{
                pecasTropa.remove(peca);
                
            }
         }
        }
    }
    private void validacaoOrigem(posicao origem){
        if(!tabuleiro.istoEhUmaPeca(origem)){
            throw new exececaoCST("isto nao eh uma peca para se mover");
        }
        if(jogador.getTimeAtual() != ((CSTpeca)tabuleiro.peca(origem)).getTiminho()){
            throw new exececaoCST("nao pode mover pecas adversarias");
        }
        if(jogador.getPecaAtual() != ((CSTpeca)tabuleiro.peca(origem))){
            throw new exececaoCST("nao eh essa peca para ser jogada");
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
            throw new exececaoCST("isto nao eh uma peça para ataque");
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
        if(jogador.getPecaAtual() != ((CSTpeca)tabuleiro.peca(origem))){
            throw new exececaoCST("nao eh essa peca para ser jogada");
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

    public void proximoTurno(){

        setTurno(getTurno() + 1);
        if(pecasOraculo.size() != 0 && pecasTropa.size() != 0){
            jogador.setTimeAtual((jogador.getTimeAtual() == time.ORACULO) ? time.TROPA : time.ORACULO);
            if(jogador.getTimeAtual() == time.ORACULO){
                jogador.setPecaAtual(pecasOraculo.get(getIndOraculo()));
                
                if(getIndTropa() +1 == pecasTropa.size()){
                    setIndTropa(0);
                }else{
                    setIndTropa(getIndTropa() + 1);
                    System.out.println("indice Tropa: "+getIndTropa());
                }
            }else{
                
                jogador.setPecaAtual(pecasTropa.get(getIndTropa()));
                if(getIndOraculo() +1 == pecasOraculo.size()){
                    setIndOraculo(0);
                }else{
                    setIndOraculo(getIndOraculo() + 1);
                    System.out.println("indice Oraculo: "+getIndOraculo());
                }
              
            }
        }



    }

    private void setupInicial(){
        colocarNovaPeca(new leao(tabuleiro, time.TROPA, 20, 0, 240,1,"LeaoO"), 16, 5);
        colocarNovaPeca(new miguez(tabuleiro, time.TROPA, 20, 0, 120,1, this,"miguezO"), 13, 8);
        colocarNovaPeca(new henridog(tabuleiro, time.TROPA, 20, 0, 120,1,"dogO", this), 14, 5);
        colocarNovaPeca(new henridog(tabuleiro, time.ORACULO, 1, 0, 700,5,"henridogT", this), 15, 5);
        
    }
    protected boolean euSouInimigo(CSTpeca generico){
        return generico != null && generico.getTiminho() != jogador.getTimeAtual();
    }
    protected boolean euSouAliado(CSTpeca generico){
        return generico != null && generico.getTiminho() == jogador.getTimeAtual();
    }
}
