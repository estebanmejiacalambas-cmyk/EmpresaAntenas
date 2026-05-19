package estoque;

import produto.Produto;
import encomenda.NovaAntena;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    //Estudar mais a parte de lista e entender melhor como se aplica a meu codigo
    //Porque usou listas?
    private List<Produto> catalogo;
    private List<NovaAntena> encomendas;

    public Estoque() {

        catalogo = new ArrayList<>();
        encomendas = new ArrayList<>();
    }

    public void cadastrarProduto(Produto produto) {

        catalogo.add(produto);

        System.out.println("Produto cadastrado: "
                + produto.getNome()); //Aqui nao seria setter porque seta o que foi colocado?
    }

    public Produto buscarPorCodigo(String codigo) {

        for (Produto produto : catalogo) {

            if (produto.getCodigo().equalsIgnoreCase(codigo)) {
                return produto;
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

    public void registrarEncomenda(NovaAntena encomenda) {

        encomendas.add(encomenda);

        System.out.println("Encomenda registrada: "
                + encomenda.getNome());
    }

    public void listarEncomendas() {

        if (encomendas.size() == 0) {

            System.out.println("Nenhuma encomenda registrada.");
            return;
        }

        System.out.println("\nENCOMENDAS");

        for (NovaAntena encomenda : encomendas) {

            encomenda.exibirDetalhes();
            System.out.println();
        }
    }

    public List<Produto> getCatalogo() {
        return catalogo;
    }

    public List<NovaAntena> getEncomendas() {
        return encomendas;
    }
}