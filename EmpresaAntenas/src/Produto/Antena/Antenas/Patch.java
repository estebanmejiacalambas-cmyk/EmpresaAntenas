package Produto.Antena.Antenas;

import Produto.Antena.Antena;

public class Patch extends Antena {

    private double largura;
    private double altura;

    public Patch(String codigo, String nome, double preco, int quantidadeEstoque,
                 double frequencia, double largura, double altura) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.largura = largura;
        this.altura = altura;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA PATCH");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Dimensões: " + largura + "mm x " + altura + "mm");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);

    }
}
