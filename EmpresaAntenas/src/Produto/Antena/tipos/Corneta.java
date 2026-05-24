package produto.antena.tipos;

import produto.antena.Antena;

public class Corneta extends Antena {

    private double abertura;

    //Ta certo a forma de construir?
    public Corneta(String codigo, String nome, double preco, int quantidadeEstoque,
                   double frequencia, double abertura) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.abertura = abertura;
    }

    public double getAbertura() { return abertura; }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA CORNETA");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Abertura: " + abertura + "°");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
    }
}
