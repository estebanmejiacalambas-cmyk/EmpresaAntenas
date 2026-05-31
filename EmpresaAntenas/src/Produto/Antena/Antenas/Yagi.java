package Produto.Antena.Antenas;

import Produto.Antena.Antena;
import Produto.Antena.Direcional;

public class Yagi extends Antena implements Direcional {

    private int elementos;
    private double ganho;
    private double direcao;

    public Yagi(String codigo, String nome, double preco, int quantidadeEstoque,
                double frequencia, int elementos, double ganho, double direcao) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);
        this.elementos = elementos;
        this.ganho = ganho;
        this.direcao = direcao;
    }

    @Override
    public void apontar(double novaDirecao) {
        this.direcao = novaDirecao;
        System.out.println("Yagi reposicionada para " + novaDirecao + "°");
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
        System.out.println("ANTENA YAGI");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.println("Elementos: " + elementos);
        System.out.println("Ganho: " + ganho + " dBi");
        System.out.println("Direção: " + direcao + "°");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
    }
}