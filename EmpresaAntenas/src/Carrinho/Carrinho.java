package carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static int contadorId = arquivo.GerenciadorArquivo.lerProximoId();
    private int id;
    private String nomeCliente;
    private List<Encomenda> encomendas;

    public Carrinho(String nomeCliente) {
        this.id = contadorId++;
        this.nomeCliente = nomeCliente;
        this.encomendas = new ArrayList<>();
    }

    public void adicionarEncomenda(Encomenda encomenda) {
        encomendas.add(encomenda);
        System.out.println("Adicionado: " + encomenda.getAntena().getNome());
    }

    public double calcularTotal() {
        double total = 0;
        for (Encomenda encomenda : encomendas) {
            total += encomenda.getPrecoTotal();
        }
        return total;
    }

    public boolean estaVazio() {
        return encomendas.isEmpty();
    }

    public void mostrarCarrinho() {
        System.out.println("\nCARRINHO");
        System.out.println("Cliente: " + nomeCliente);
        System.out.println("ID: " + id);

        if (estaVazio()) {
            System.out.println("Carrinho vazio.");
            return;
        }

        for (Encomenda encomenda : encomendas) {
            System.out.println(encomenda.getAntena().getNome()
                    + " x" + encomenda.getQuantidade()
                    + " | R$ " + String.format("%.2f", encomenda.getPrecoTotal()));
        }

        System.out.printf("%nTotal: R$ %.2f%n", calcularTotal());
    }

    public void exibirRecibo() {
        System.out.println("\nRECIBO");
        System.out.println("ID     : " + id);
        System.out.println("Cliente: " + nomeCliente);

        if (!estaVazio()) {
            System.out.println("\nItens:");
            for (int i = 0; i < encomendas.size(); i++) {
                encomendas.get(i).exibirDetalhes();
                System.out.println();
            }
        }

        System.out.printf("Total: R$ %.2f%n", calcularTotal());
    }

    public List<Encomenda> getEncomendas() { return encomendas; }
    public int getId()                     { return id; }
    public String getNomeCliente()         { return nomeCliente; }
}