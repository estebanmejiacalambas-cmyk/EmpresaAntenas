package Estoque;

import Produto.Produto;

public class MonitorEstoque implements Runnable {

    private static final int ESTOQUE_MINIMO   = 5;
    private static final int INTERVALO_MS     = 40000;

    private Estoque estoque;
    private boolean rodando;

    public MonitorEstoque(Estoque estoque) {
        this.estoque  = estoque;
        this.rodando  = true;
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
            if (produto.getQuantidadeEstoque() <= ESTOQUE_MINIMO) {
                if (!alertaEmitido) {
                    System.out.println("\n[Monitor] *** ALERTA DE ESTOQUE BAIXO ***");
                    alertaEmitido = true;
                }
                System.out.println("[Monitor] " + produto.getNome()
                        + " — apenas " + produto.getQuantidadeEstoque() + " unidades restantes!");
            }
        }

        if (!alertaEmitido) {
            System.out.println("[Monitor] Estoque OK — nenhuma antena em nível crítico.");
        }
    }

}
