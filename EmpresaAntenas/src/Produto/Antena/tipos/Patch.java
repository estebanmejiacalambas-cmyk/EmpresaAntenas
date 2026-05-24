package produto.antena.tipos;

import produto.antena.Antena;
import produto.antena.Direcional;

public class Patch extends Antena implements Direcional {

    private double largura;
    private double altura;
    private double ganho;
    private double direcao;

    public Patch(String codigo, String nome, double preco, int quantidadeEstoque,
                 double frequencia, double largura, double altura,
                 double ganho, double direcao) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.largura = largura;
        this.altura = altura;
        this.ganho = ganho;
        this.direcao = direcao;
    }

    @Override
    public void apontar(double novaDirecao) {
        this.direcao = novaDirecao;
        System.out.println("Patch reposicionada para " + novaDirecao + "°");
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
        System.out.println("ANTENA PATCH");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Dimensões: " + largura + "mm x " + altura + "mm");
        System.out.println("Ganho: " + ganho + " dBi");
        System.out.println("Direção: " + direcao + "°");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
    }
}