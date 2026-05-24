package arquivo;

import carrinho.Carrinho;
import carrinho.Encomenda;
import produto.Produto;
import estoque.Estoque;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class GerenciadorArquivo {

    private static final Path PATH_CATALOGO = Paths.get("catalogo.txt");
    private static final Path PATH_COMPRAS  = Paths.get("compras.txt");
    private static final String SEP         = "-".repeat(40);
    private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static int lerProximoId() {
        if (!Files.exists(PATH_COMPRAS)) return 1;
        try {
            List<String> linhas = Files.readAllLines(PATH_COMPRAS);
            int maior = 0;
            for (String linha : linhas) {
                if (linha.startsWith("  ID      : #")) {
                    try {
                        int id = Integer.parseInt(linha.replace("  ID      : #", "").trim());
                        if (id > maior) maior = id;
                    } catch (NumberFormatException ignored) {}
                }
            }
            return maior + 1;
        } catch (IOException e) {
            return 1;
        }
    }

    public static void salvarCatalogo(Estoque estoque) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SEP).append("\n");
            sb.append("  CATÁLOGO ANTENTECH\n");
            sb.append(SEP).append("\n\n");

            for (Produto produto : estoque.getCatalogo()) {
                sb.append(String.format("  %-8s %s%n", produto.getCodigo(), produto.getNome()));
                sb.append(String.format("  Preço  : R$ %.2f%n", produto.getPreco()));
                sb.append(String.format("  Estoque: %d unidades%n", produto.getQuantidadeEstoque()));
                sb.append("\n");
            }

            sb.append(SEP).append("\n");
            Files.writeString(PATH_CATALOGO, sb.toString());

        } catch (IOException e) {
            System.out.println("Erro ao salvar catálogo: " + e.getMessage());
        }
    }

    public static void lerCatalogo() {
        try {
            if (!Files.exists(PATH_CATALOGO)) {
                System.out.println("Arquivo de catálogo não encontrado.");
                return;
            }
            List<String> linhas = Files.readAllLines(PATH_CATALOGO);
            for (String linha : linhas) System.out.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler catálogo: " + e.getMessage());
        }
    }

    public static void salvarCompra(Carrinho carrinho) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(SEP).append("\n");
            sb.append(String.format("  RECIBO DE COMPRA%n"));
            sb.append(SEP).append("\n");
            sb.append(String.format("  ID      : #%d%n", carrinho.getId()));
            sb.append(String.format("  Cliente : %s%n", carrinho.getNomeCliente()));
            sb.append(String.format("  Data    : %s%n", LocalDateTime.now().format(FMT)));
            sb.append(SEP).append("\n");

            if (!carrinho.estaVazio()) {
                sb.append(String.format("  ITENS%n"));
                sb.append(SEP).append("\n");
                for (Encomenda encomenda : carrinho.getEncomendas()) {
                    sb.append(String.format("  Produto : %s%n", encomenda.getAntena().getNome()));
                    sb.append(String.format("  Código  : %s%n", encomenda.getCodigo()));
                    sb.append(String.format("  Qtd     : %d un.%n", encomenda.getQuantidade()));
                    sb.append(String.format("  Subtotal: R$ %.2f%n", encomenda.getPrecoTotal()));
                    if (!encomenda.getObservacoes().isBlank())
                        sb.append(String.format("  Obs     : %s%n", encomenda.getObservacoes()));
                    sb.append("\n");
                }
            }

            sb.append(SEP).append("\n");
            sb.append(String.format("  TOTAL   : R$ %.2f%n", carrinho.calcularTotal()));
            sb.append(SEP).append("\n\n");

            Files.writeString(PATH_COMPRAS, sb.toString(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Compra registrada em: " + PATH_COMPRAS.toAbsolutePath());

        } catch (IOException e) {
            System.out.println("Erro ao salvar compra: " + e.getMessage());
        }
    }

    public static void lerCompras() {
        try {
            if (!Files.exists(PATH_COMPRAS)) {
                System.out.println("Nenhuma compra registrada ainda.");
                return;
            }
            List<String> linhas = Files.readAllLines(PATH_COMPRAS);
            for (String linha : linhas) System.out.println(linha);
        } catch (IOException e) {
            System.out.println("Erro ao ler compras: " + e.getMessage());
        }
    }
}