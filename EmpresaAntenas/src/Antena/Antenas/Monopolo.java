package Antena.Antenas;

import Antena.Antena;

public class Monopolo extends Antena {

    public Monopolo(String nome, double frequencia) {
        super(nome, frequencia);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Monopolo: " + nome);
    }
}
