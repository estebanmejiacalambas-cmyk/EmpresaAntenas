package antena.tipos;

import antena.Antena;

public class Corneta extends Antena {

    private double abertura;

    public Corneta(String nome, double frequencia, double abertura) {
        super(nome, frequencia);
        this.abertura = abertura;
    }

    public double getAbertura() {
        return abertura;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Corneta: " + nome);
        System.out.println("Abertura: " + getAbertura());
    }
}