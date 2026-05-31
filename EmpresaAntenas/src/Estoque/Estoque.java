package Estoque;

import Carrinho.Encomenda;
import Produto.Antena.Antena;
import Produto.Produto;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    private List<Produto> catalogo;
    private List<Encomenda> encomendas;

    public Estoque() {
        catalogo = new ArrayList<>();
        encomendas = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {
        catalogo.add(produto);
        System.out.println("Produto cadastrado: " + produto.getNome());
    }

    public Antena buscarAntenaPorCodigo(String codigo) {
        for (Produto produto : catalogo) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)
                    && produto instanceof Antena) {
                return (Antena) produto;
            }
        }
        return null;
    }


    public void listarCatalogo() {
        if (catalogo.size() == 0) {
            System.out.println("Catálogo vazio.");
            return;
        }
        System.out.println("\nCATÁLOGO:");
        for (Produto produto : catalogo) {
            produto.exibirDetalhes();
            System.out.println();
        }
    }

    public List<Produto> getCatalogo()       { return catalogo; }
}