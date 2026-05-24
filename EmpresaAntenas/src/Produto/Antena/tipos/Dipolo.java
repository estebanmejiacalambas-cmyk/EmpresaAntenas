package produto.antena.tipos;

public class Dipolo extends Monopolo {

    private Monopolo bracoDireito;
    private Monopolo bracoEsquerdo;

    public Dipolo(String codigo, String nome, double preco, int quantidadeEstoque, double frequencia) {
        super(codigo, nome, preco, quantidadeEstoque, frequencia);

        this.bracoDireito  = new Monopolo(codigo + "-D", nome + " (braço direito)",   preco / 2, quantidadeEstoque, frequencia);
        this.bracoEsquerdo = new Monopolo(codigo + "-E", nome + " (braço esquerdo)", preco / 2, quantidadeEstoque, frequencia);
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("ANTENA DIPOLO");
        System.out.println("Nome: " + nome);
        System.out.println("Código: " + codigo);
        System.out.println("Frequência: " + frequencia + " MHz");
        System.out.printf("Preço: R$ %.2f%n", preco);
        System.out.println("Estoque: " + quantidadeEstoque);
        //try catch
        System.out.println("--- Braço direito ---");
        bracoDireito.exibirDetalhes();
        System.out.println("--- Braço esquerdo ---");
        bracoEsquerdo.exibirDetalhes();
    }
}