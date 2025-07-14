package ModelClass;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private String cpf;
    private double saldo;
    private final List<Objeto> itensAlugados;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = 0.0;
        this.itensAlugados = new ArrayList<>();
    }

    public void debitar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor a ser debitado deve ser positivo.");
        }
        if (this.saldo < valor) {
            throw new RuntimeException("Saldo insuficiente.");
        }
        this.saldo -= valor;
    }

    public void creditar(double valor) {
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor a ser creditado deve ser positivo.");
        }
        this.saldo += valor;
    }

    public void adicionarItem(Objeto item) {
        this.itensAlugados.add(item);
    }

    public void removerItem(Objeto item) {
        this.itensAlugados.remove(item);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSaldo() {
        return saldo;
    }

    public List<Objeto> getItensAlugados() {
        return new ArrayList<>(this.itensAlugados);
    }
}