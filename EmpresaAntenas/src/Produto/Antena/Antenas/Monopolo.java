package produto.antena.antenas;

import produto.antena.Antena;

public class Monopolo extends Antena {

    public Monopolo(String codigo, String nome, double preco, int quantidadeEstoque, double frequencia) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA MONOPOLO");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
    }
}