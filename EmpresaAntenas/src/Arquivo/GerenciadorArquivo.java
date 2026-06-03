package Arquivo;

import Carrinho.Carrinho;
import Carrinho.Encomenda;
import Produto.Produto;
import Estoque.Estoque;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

public class GerenciadorArquivo {

    private static final Path PATH_CATALOGO  = Paths.get("catalogo.txt");
    private static final Path PATH_COMPRAS   = Paths.get("compras.txt");

    public static void salvarCatalogo(Estoque estoque) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("CATÁLOGO ANTENTECH\n");

            for (Produto produto : estoque.getCatalogo()) {
                sb.append("Código : ").append(produto.getCodigo()).append("\n");
                sb.append("Nome   : ").append(produto.getNome()).append("\n");
                sb.append(String.format("Preço  : R$ %.2f%n", produto.getPreco()));
                sb.append("Estoque: ").append(produto.getQuantidadeEstoque()).append(" unidades\n");
            }

            Files.writeString(PATH_CATALOGO, sb.toString());
            System.out.println("Catálogo salvo em: " + PATH_CATALOGO.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Erro ao salvar catálogo: " + e.getMessage());
        }
    }

    public static void salvarCompra(Carrinho carrinho) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("RECIBO\n");
            sb.append("ID     : ").append(carrinho.getId()).append("\n");
            sb.append("Cliente: ").append(carrinho.getNomeCliente()).append("\n");

            if (!carrinho.estaVazio()) {
                sb.append("\nItens:\n");
                for (Encomenda encomenda : carrinho.getEncomendas()) {
                    sb.append("  - ").append(encomenda.getAntena().getNome())
                            .append("Qtd: ").append(encomenda.getQuantidade())
                            .append(String.format(" | R$ %.2f%n", encomenda.getPrecoTotal()));
                    sb.append("Obs: ").append(encomenda.getObservacoes()).append("\n");
                    sb.append("Status: ")
                            .append(encomenda.isAtendida() ? "Atendida" : "Aguardando...")
                            .append("\n");
                }
            }

            sb.append(String.format("Total: R$ %.2f%n", carrinho.calcularTotal()));
            Files.writeString(PATH_COMPRAS, sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Compra registrada em: " + PATH_COMPRAS.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Erro ao salvar compra: " + e.getMessage());
        }
    }

}
