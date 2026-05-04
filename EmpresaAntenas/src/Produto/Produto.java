package Produto;

abstract class Produto {

    protected String codigo;
    protected String nome;
    protected double preco;
    protected int quantidadeEstoque;
    protected String categoria;

    public Produto(String codigo, String nome, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }

    public abstract void exibirDetalhes();
}


