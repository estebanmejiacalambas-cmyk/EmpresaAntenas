package produto.antena.antenas;

import produto.antena.Antena;

public class Parabolica extends Antena {

    private double diametro;
    private Corneta feed;

    public Parabolica(String codigo, String nome, double preco, int quantidadeEstoque,
                      double frequencia, double diametro, Corneta feed) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.diametro = diametro;
        this.feed = feed;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA PARABÓLICA");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Diâmetro: " + diametro + " m");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("Feed (Corneta):");
        System.out.println("│   - " + feed.getNome() + " | Abertura: " + feed.getAbertura() + "°");
    }
}
