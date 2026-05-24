package produto;

public abstract class Produto {

    //Porque usei protected e nao private
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

    public void adicionarEstoque(int quantidade) { //Este metodo é abstrato?
        this.quantidadeEstoque += quantidade;
    }

    public boolean removerEstoque(int quantidade) {
        if (quantidade > this.quantidadeEstoque) {
            System.out.println("Estoque insuficiente para: " + nome);
            return false;
        }else {
            this.quantidadeEstoque -= quantidade;
            return true;
        }
    }

    public String getCodigo()            { return codigo; }
    public String getNome()              { return nome; }
    public double getPreco()             { return preco; }
    public int getQuantidadeEstoque()    { return quantidadeEstoque; }


    public abstract void exibirDetalhes();
}
