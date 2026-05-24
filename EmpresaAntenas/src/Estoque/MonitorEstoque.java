package estoque;

import produto.Produto;
import java.util.HashMap;
import java.util.Map;

public class MonitorEstoque implements Runnable {

    private static final int ESTOQUE_MINIMO = 5;
    private static final int INTERVALO_MS   = 40000; // verifica a cada 40 segundos

    private Estoque estoque;
    private boolean rodando;
    private Map<String, Integer> ultimoEstoque = new HashMap<>();

    public MonitorEstoque(Estoque estoque) {
        this.estoque = estoque;
        this.rodando = true;
    }

    @Override
    public void run() {
        System.out.println("[Monitor] Monitoramento de estoque iniciado.");

        while (rodando) {
            verificarEstoque();

            try {
                Thread.sleep(INTERVALO_MS);
            } catch (InterruptedException e) {
                System.out.println("[Monitor] Monitoramento interrompido.");
                rodando = false;
            }
        }
    }

    private void verificarEstoque() {
        boolean alertaEmitido = false;

        for (Produto produto : estoque.getCatalogo()) {
            int qtd = produto.getQuantidadeEstoque();
            Integer anterior = ultimoEstoque.get(produto.getCodigo());

            boolean estoqueBaixo = qtd <= ESTOQUE_MINIMO;
            boolean mudou = anterior == null || anterior != qtd;

            if (estoqueBaixo && mudou) {
                if (!alertaEmitido) {
                    System.out.println("\n[Monitor] *** ALERTA DE ESTOQUE BAIXO ***");
                    alertaEmitido = true;
                }
                System.out.println("[Monitor] " + produto.getNome()
                        + " — apenas " + qtd + " unidades restantes!");
            }

            ultimoEstoque.put(produto.getCodigo(), qtd);
        }
    }

    public void parar() {
        this.rodando = false;
    }
}
