package antena.tipos;

import antena.Antena;

public class Yagi extends Antena {

    private int elementos;

    public Yagi(String nome, double frequencia, int elementos) {
        super(nome, frequencia);
        this.elementos = elementos;
    }

    public int getElementos() {
        return elementos;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Yagi: " + nome);
        System.out.println("Elementos: " + getElementos());
    }
}

