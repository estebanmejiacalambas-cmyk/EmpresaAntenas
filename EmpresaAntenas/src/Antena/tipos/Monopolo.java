package antena.tipos;

import antena.Antena;

public class Monopolo extends Antena {

    public Monopolo(String nome, double frequencia) {
        super(nome, frequencia);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Monopolo: " + nome);
    }
}
