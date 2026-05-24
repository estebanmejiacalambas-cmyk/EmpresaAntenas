package menu;

import arquivo.GerenciadorArquivo;
import carrinho.Carrinho;
import carrinho.Encomenda;
import estoque.Estoque;
import produto.antena.Antena;
import produto.antena.tipos.Corneta;
import produto.antena.tipos.Dipolo;
import produto.antena.tipos.Monopolo;
import produto.antena.tipos.Parabolica;
import produto.antena.tipos.Patch;
import produto.antena.tipos.Yagi;
import produto.antena.Direcional;

import java.util.Scanner;

public class Menu {

    private static final String SEP = "=".repeat(50);

    private Scanner input = new Scanner(System.in);
    private Estoque estoque = new Estoque();
    private Carrinho carrinho;

    private Monopolo  mon1 = new Monopolo ("MON-001", "Monopolo VHF 144MHz",   89.90, 20, 144.0);
    private Dipolo    dip1 = new Dipolo   ("DIP-001", "Dipolo HF 27MHz",       129.90, 10, 27.0);
    private Corneta   cor1 = new Corneta  ("COR-001", "Corneta Ku 12GHz",      349.90,  8, 12000.0, 25.0);
    private Patch     pat1 = new Patch    ("PAT-001", "Patch WiFi 2.4GHz",      79.90,  5, 2400.0, 60.0, 60.0, 8.5, 0.0);
    private Yagi      yag1 = new Yagi     ("YAG-001", "Yagi UHF 7 elementos",  219.90, 10, 470.0, 7, 12.0, 180.0);
    private Parabolica par1 = new Parabolica("PAR-001", "Parabólica 90cm Ku",  699.90,  3, 12000.0, 0.90, cor1, 37.0, 180.0);

    private static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls")
                .inheritIO()
                .start()
                .waitFor();
        } catch (Exception e) {
            System.out.println("\n".repeat(40));
        }
    }

    private static void pausar(Scanner input) {
        System.out.print("\nPressione ENTER para continuar...");
        input.nextLine();
    }

    public void inicializar() {
        estoque.cadastrarProduto(mon1);
        estoque.cadastrarProduto(dip1);
        estoque.cadastrarProduto(cor1);
        estoque.cadastrarProduto(pat1);
        estoque.cadastrarProduto(yag1);
        estoque.cadastrarProduto(par1);
        GerenciadorArquivo.salvarCatalogo(estoque);
    }

    public void apresentacao() {
        cls();
        System.out.println(SEP);
        System.out.println("       BEM-VINDO À ANTENTECH");
        System.out.println("     Sua loja especializada em antenas");
        System.out.println(SEP);
        System.out.println();
        estoque.listarCatalogo();
        pausar(input);
    }

    public void cadastro() {
        cls();
        System.out.println(SEP);
        System.out.println("            CADASTRO DO CLIENTE");
        System.out.println(SEP);

        String nome = "";
        while (nome.trim().isEmpty()) {
            System.out.print("Informe seu nome: ");
            nome = input.nextLine();
            if (nome.trim().isEmpty())
                System.out.println("Nome não pode ser vazio.");
        }

        String nomeCapitalizado = capitalizar(nome.trim());
        this.carrinho = new Carrinho(nomeCapitalizado);
        System.out.println("\nCadastro realizado com sucesso! Olá, " + nomeCapitalizado + ".");
        pausar(input);
    }

    private static String capitalizar(String nome) {
        String[] partes = nome.toLowerCase().split(" ");
        StringBuilder sb = new StringBuilder();
        for (String parte : partes) {
            if (!parte.isEmpty())
                sb.append(Character.toUpperCase(parte.charAt(0))).append(parte.substring(1)).append(" ");
        }
        return sb.toString().trim();
    }

    public Estoque getEstoque() { return estoque; }

    public void compra() {
        while (true) {
            cls();
            System.out.println(SEP);
            System.out.println("           SELECIONE UMA ANTENA");
            System.out.println(SEP);
            System.out.println("  1 - Monopolo VHF 144MHz    | R$  89,90  | Estoque: " + mon1.getQuantidadeEstoque());
            System.out.println("  2 - Dipolo HF 27MHz        | R$ 129,90  | Estoque: " + dip1.getQuantidadeEstoque());
            System.out.println("  3 - Corneta Ku 12GHz       | R$ 349,90  | Estoque: " + cor1.getQuantidadeEstoque());
            System.out.println("  4 - Patch WiFi 2.4GHz      | R$  79,90  | Estoque: " + pat1.getQuantidadeEstoque());
            System.out.println("  5 - Yagi UHF 7 elementos   | R$ 219,90  | Estoque: " + yag1.getQuantidadeEstoque());
            System.out.println("  6 - Parabólica 90cm Ku     | R$ 699,90  | Estoque: " + par1.getQuantidadeEstoque());
            System.out.println(SEP);
            System.out.println("  7 - Ver carrinho");
            System.out.println("  0 - Finalizar pedido");
            System.out.println(SEP);

            if (!carrinho.estaVazio()) {
                System.out.printf("  Itens no carrinho: %d  |  Total parcial: R$ %.2f%n",
                        carrinho.getEncomendas().size(), carrinho.calcularTotal());
                System.out.println(SEP);
            }

            System.out.print("\nEscolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 0 e 6.");
                pausar(input);
                continue;
            }

            if (opcao == 0) break;

            String codigo;
            switch (opcao) {
                case 1: codigo = "MON-001"; break;
                case 2: codigo = "DIP-001"; break;
                case 3: codigo = "COR-001"; break;
                case 4: codigo = "PAT-001"; break;
                case 5: codigo = "YAG-001"; break;
                case 6: codigo = "PAR-001"; break;
                case 7: codigo = "VER_CARRINHO"; break;
                default:
                    System.out.println("Opção inválida.");
                    pausar(input);
                    continue;
            }

            if (codigo.equals("VER_CARRINHO")) {
                cls();
                carrinho.mostrarCarrinho();
                pausar(input);
                continue;
            }

            try {
                Antena antena = estoque.buscarAntenaPorCodigo(codigo);

                if (antena == null)
                    throw new RuntimeException("Antena '" + codigo + "' não encontrada no estoque.");

                cls();
                System.out.println(SEP);
                antena.exibirDetalhes();
                System.out.println(SEP);

                if (antena instanceof Direcional d) {
                    System.out.print("Direção para apontar a antena (graus): ");
                    try {
                        d.apontar(Double.parseDouble(input.nextLine()));
                    } catch (NumberFormatException e) {
                        System.out.println("Direção inválida, mantendo direção atual.");
                    }

                    System.out.print("Potência do sinal recebido (dBm): ");
                    try {
                        System.out.println("Avaliação: " + d.avaliarSinal(Double.parseDouble(input.nextLine())));
                    } catch (NumberFormatException e) {
                        System.out.println("Potência inválida, avaliação ignorada.");
                    }
                    System.out.println();
                }

                int quantidade = 0;
                while (true) {
                    System.out.print("Quantidade: ");
                    try {
                        quantidade = Integer.parseInt(input.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Quantidade inválida. Tente novamente.");
                        continue;
                    }
                    if (quantidade <= 0) {
                        System.out.println("Quantidade deve ser maior que zero. Tente novamente.");
                    } else if (quantidade > antena.getQuantidadeEstoque()) {
                        System.out.println("Estoque insuficiente. Disponível: " + antena.getQuantidadeEstoque() + " unidades. Tente novamente.");
                    } else {
                        break;
                    }
                }

                System.out.print("Observações (ex: instalação em torre, uso interno): ");
                String observacoes = input.nextLine();

                antena.removerEstoque(quantidade);
                Encomenda encomenda = new Encomenda(antena, quantidade, observacoes);
                estoque.registrarEncomenda(encomenda);
                carrinho.adicionarEncomenda(encomenda);
                System.out.println("\n✔ Antena adicionada ao carrinho!");
                pausar(input);

            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage());
                pausar(input);
            }
        }

        cls();
        System.out.println(SEP);
        System.out.println("        OBRIGADO POR COMPRAR NA ANTENTECH!");
        System.out.println(SEP);
        carrinho.exibirRecibo();
        System.out.println(SEP);

        if (!carrinho.estaVazio())
            GerenciadorArquivo.salvarCompra(carrinho);
    }
}