package produto;

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

    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getCategoria() {
        return categoria;
    }

    public void adicionarEstoque(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    public void removerEstoque(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }

    public abstract void exibirDetalhes();
}


