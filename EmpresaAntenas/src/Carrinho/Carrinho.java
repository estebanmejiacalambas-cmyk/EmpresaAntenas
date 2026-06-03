package Carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private static int contadorId = 1;
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