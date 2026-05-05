package antena.tipos;

import antena.Antena;

public class Patch extends Antena {

    private double largura;
    private double altura;

    public Patch(String nome, double frequencia, double largura, double altura) {
        super(nome, frequencia);
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Patch: " + nome);
    }
}

