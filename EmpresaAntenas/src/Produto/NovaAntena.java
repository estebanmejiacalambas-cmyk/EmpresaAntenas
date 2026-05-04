package Produto;
//PEnsar em tirar caso nao usar
public class NovaAntena extends Produto {

    private double frequencia;
    private boolean digital;

    public NovaAntena(String codigo, String nome, double preco, int quantidadeEstoque,
                      double frequencia, boolean digital) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.frequencia = frequencia;
        this.digital = digital;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Antena.Antenas.Antena.Antena: " + nome);
        System.out.println("Frequência: " + frequencia);
        System.out.println("Tipo: " + (digital ? "Digital" : "Analógica"));
    }
}



