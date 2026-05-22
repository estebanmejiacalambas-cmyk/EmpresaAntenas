package Carrinho;

import Produto.Antena.Antena;

public class Encomenda {

    private Antena antena;
    private int quantidade;
    private String observacoes;
    private boolean atendida;

    public Encomenda(Antena antena, int quantidade, String observacoes) {
        this.antena = antena;
        this.quantidade = quantidade;
        this.observacoes = observacoes;
        this.atendida = false;
    }

    public double getPrecoTotal() {
        return antena.getPreco() * quantidade;
    }

    public void marcarComoAtendida() {
        this.atendida = true;
        System.out.println("Encomenda '" + antena.getNome() + "' marcada como atendida.");
    }

    public void exibirDetalhes() {
        antena.exibirDetalhes();
        System.out.println("Quantidade: " + quantidade);
        System.out.println("Observações: " + observacoes);
        System.out.println("Status: " + (atendida ? "Atendida" : "Aguardando..."));
        System.out.printf("Preço total: R$ %.2f%n", getPrecoTotal());
    }

    public String getCodigo()      { return antena.getCodigo(); }
    public Antena getAntena()      { return antena; }
    public int getQuantidade()     { return quantidade; }
    public String getObservacoes() { return observacoes; }
    public boolean isAtendida()    { return atendida; }
}