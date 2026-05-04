package Antena.Antenas;

import Antena.Antena;

public class Parabolica extends Antena {

    private double diametro;
    private Corneta feed;

    public Parabolica(String nome, double frequencia, double diametro, Corneta feed) {
        super(nome, frequencia);
        this.diametro = diametro;
        this.feed = feed;
    }



    @Override
    public void exibirInfo() {
        System.out.println("Parabólica: " + nome);
        System.out.println("Diâmetro: " + diametro);
        feed.exibirInfo();
    }
}

