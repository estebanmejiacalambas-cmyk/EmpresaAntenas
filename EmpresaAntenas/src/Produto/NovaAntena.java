package produto;
//Pensar em tirar caso nao usar
public class NovaAntena extends Produto {

    private double frequencia;
    private boolean digital;

    public NovaAntena(String codigo, String nome, double preco, int quantidadeEstoque,
                      double frequencia, boolean digital) {
        super(codigo, nome, preco, quantidadeEstoque);
        this.frequencia = frequencia;
        this.digital = digital;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public boolean isDigital() {
        return digital;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Antena: " + nome);
        System.out.println("Frequência: " + getFrequencia());
        System.out.println("Tipo: " + (isDigital() ? "Digital" : "Analógica"));
    }
}



