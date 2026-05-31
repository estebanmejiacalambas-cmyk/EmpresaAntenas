package Produto.Antena;

import Produto.Produto;

public abstract class Antena extends Produto {

    protected double frequencia;

    public Antena(String codigo, String nome, double preco, int quantidadeEstoque, double frequencia) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.categoria = "Antena";
        this.frequencia = frequencia;
    }

    @Override
    public abstract void exibirDetalhes();
}
