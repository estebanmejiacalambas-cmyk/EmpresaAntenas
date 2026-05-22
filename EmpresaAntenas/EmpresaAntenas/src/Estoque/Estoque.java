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

    public Produto buscarPorCodigo(String codigo) {
        for (Produto produto : catalogo) {
            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return produto;
            }
        }
        return null;
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

    public void registrarEncomenda(Encomenda encomenda) {
        encomendas.add(encomenda);
        System.out.println("Encomenda registrada: " + encomenda.getAntena().getNome());
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

    public void listarEncomendas() {
        if (encomendas.size() == 0) {
            System.out.println("Nenhuma encomenda registrada.");
            return;
        }
        System.out.println("\nENCOMENDAS:");
        for (Encomenda encomenda : encomendas) {
            encomenda.exibirDetalhes();
            System.out.println();
        }
    }

    public List<Produto> getCatalogo()       { return catalogo; }
    public List<Encomenda> getEncomendas()   { return encomendas; }
}