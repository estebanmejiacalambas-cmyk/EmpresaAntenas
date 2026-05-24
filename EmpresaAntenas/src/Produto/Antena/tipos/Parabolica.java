package produto.antena.tipos;

import produto.antena.Antena;
import produto.antena.Direcional;

public class Parabolica extends Antena implements Direcional {

    private double diametro;
    private Corneta feed;
    private double ganho;
    private double direcao;

    public Parabolica(String codigo, String nome, double preco, int quantidadeEstoque,
                      double frequencia, double diametro, Corneta feed,
                      double ganho, double direcao) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.diametro = diametro;
        this.feed = feed;
        this.ganho = ganho;
        this.direcao = direcao;
    }

    @Override
    public void apontar(double novaDirecao) {
        this.direcao = novaDirecao;
        System.out.println("Parabólica reposicionada para " + novaDirecao + "°");
    }

    @Override
    public String avaliarSinal(double potenciaRecebida) {
        double efetiva = potenciaRecebida + ganho;
        if (efetiva >= 30) return "Sinal excelente";
        if (efetiva >= 15) return "Sinal aceitável";
        return "Sinal fraco — reposicione a antena";
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA PARABÓLICA");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Diâmetro: " + diametro + " m");
        System.out.println("Ganho: " + ganho + " dBi");
        System.out.println("Direção: " + direcao + "°");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
        System.out.println("Feed (Corneta):");
        System.out.println("   - " + feed.getNome() + " | Abertura: " + feed.getAbertura() + "°");
    }
}