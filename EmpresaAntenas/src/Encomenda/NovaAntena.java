package Encomenda;

import Produto.Produto;

public class NovaAntena extends Produto {

    private double frequencia;
    private boolean sinal;
    private String tipoSolicitado;
    private String observacoes;
    private boolean atendida;

    public NovaAntena(String codigo, String nome, double preco,
                      double frequencia, boolean sinal,
                      String tipoSolicitado, String observacoes) {

        super(codigo, nome, preco, 0);

        this.categoria = "Encomenda";
        this.frequencia = frequencia;
        this.sinal = sinal;
        this.tipoSolicitado = tipoSolicitado;
        this.observacoes = observacoes;
        this.atendida = false;
    }

    public void marcarComoAtendida() {

        this.atendida = true;
        this.quantidadeEstoque = 1;

        System.out.println("Encomenda '" + this.nome + "' marcada como atendida.");
    }

    @Override
    public void exibirDetalhes() {

        System.out.println("ENCOMENDA");
        System.out.println("Nome: " + this.nome);
        System.out.println("Código: " + this.codigo);
        System.out.println("Tipo Solicitado: " + this.tipoSolicitado);
        System.out.println("Frequência: " + this.frequencia + " MHz");

        if (this.sinal) {
            System.out.println("Sinal: Digital");
        } else {
            System.out.println("Sinal: Analógico");
        }

        System.out.println("Preço Estimado: R$ " + this.preco);
        System.out.println("Observações: " + this.observacoes);

        if (this.atendida) {
            System.out.println("Status: Atendida");
        } else {
            System.out.println("Status: Aguardando...");
        }
    }
}