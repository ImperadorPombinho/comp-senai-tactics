package CSTgame;

public abstract class item {
    private String nome;
    private tipoItem tipo;
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public item(String nome, tipoItem tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public abstract void efeito(CSTpeca generica);
}
