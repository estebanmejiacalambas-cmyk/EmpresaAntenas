package Antena;

public abstract class Antena {
    protected String nome;
    protected double frequencia;

    public Antena(String nome, double frequencia) {
        this.nome = nome;
        this.frequencia = frequencia;
    }

    public abstract void exibirInfo();
}

