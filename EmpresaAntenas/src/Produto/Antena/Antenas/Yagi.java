package produto.antena.antenas;

import produto.antena.Antena;

public class Yagi extends Antena {

    private int elementos;

    public Yagi(String codigo, String nome, double preco, int quantidadeEstoque,
                double frequencia, int elementos) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.elementos = elementos;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA YAGI");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Elementos: " + elementos);
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
    }
}