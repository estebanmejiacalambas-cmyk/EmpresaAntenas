package pedido;

import produto.Produto;

public class ItemPedido {

    private Produto produto;
    private int quantidade;

    public ItemPedido(Produto produto, int quantidade) {

        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double calcularSubtotal() {

        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() {

        return produto;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void exibir() {

        System.out.println("Produto    : " + produto.getNome());
        System.out.println("Quantidade : " + quantidade);
        System.out.println("Subtotal   : R$ " + calcularSubtotal());
    }
}
