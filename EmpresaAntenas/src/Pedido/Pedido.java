package pedido;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
//Perguntar pro pizzoni
    private static int contadorId = 1;
    private int id;
    private String nomeCliente;
    private List<ItemPedido> itens;

    public Pedido(String nomeCliente) {

        this.id = contadorId;
        contadorId++;

        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemPedido item) {

        itens.add(item);
    }

    public double calcularTotalPedido() {

        double total = 0;

        for (ItemPedido item : itens) {

            total += item.calcularSubtotal();
        }

        return total;
    }

    public void exibirRecibo() {

        System.out.println("\nRECIBO DO PEDIDO");

        System.out.println("ID do Pedido : " + id);
        System.out.println("Cliente: " + nomeCliente);

        System.out.println("\nItens do Pedido:");

        for (ItemPedido item : itens) {
            item.exibir();
            System.out.println();
        }

        System.out.println("Total do Pedido: R$ "
                + calcularTotalPedido());
    }

    public List<ItemPedido> getItens() {

        return itens;
    }

    public int getId() {

        return id;
    }

    public String getNomeCliente() {

        return nomeCliente;
    }
}