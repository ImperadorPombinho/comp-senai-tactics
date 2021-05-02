package CSTgame;

public class jogador {
    private String nome;
    private time timeAtual;
    private CSTpeca pecaAtual;
    
    public CSTpeca getPecaAtual() {
        return pecaAtual;
    }
    public void setPecaAtual(CSTpeca pecaAtual) {
        this.pecaAtual = pecaAtual;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public time getTimeAtual() {
        return timeAtual;
    }
    public void setTimeAtual(time timeAtual) {
        this.timeAtual = timeAtual;
    }
    
    
    
}
