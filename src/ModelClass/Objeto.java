package ModelClass;

public abstract class Objeto {
    private String nome;
    private double valor;
    private boolean status;

    public Objeto(String nome, double valor, boolean status) {
        this.nome = nome;
        this.valor = valor;
        this.status = status;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}