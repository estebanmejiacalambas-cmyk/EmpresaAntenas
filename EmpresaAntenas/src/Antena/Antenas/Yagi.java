package Antena.Antenas;

import Antena.Antena;

public class Yagi extends Antena {

    private int elementos;

    public Yagi(String nome, double frequencia, int elementos) {
        super(nome, frequencia);
        this.elementos = elementos;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Yagi: " + nome);
        System.out.println("Elementos: " + elementos);
    }
}

