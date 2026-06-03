package Menu;

import Arquivo.GerenciadorArquivo;
import Carrinho.Carrinho;
import Carrinho.Encomenda;
import Estoque.Estoque;
import Produto.Antena.Antena;
import Produto.Antena.Antenas.Corneta;
import Produto.Antena.Antenas.Dipolo;
import Produto.Antena.Antenas.Monopolo;
import Produto.Antena.Antenas.Parabolica;
import Produto.Antena.Antenas.Patch;
import Produto.Antena.Antenas.Yagi;
import Produto.Antena.Direcional;

import java.util.Scanner;

public class Menu {

    private Scanner input = new Scanner(System.in);
    private Estoque estoque = new Estoque();
    private Carrinho carrinho;

    private Monopolo mon1 = new Monopolo("MON-001", "Monopolo VHF 144MHz",  89.90,  20, 144.0);
    private Dipolo   dip1 = new Dipolo  ("DIP-001", "Dipolo HF 27MHz",      129.90, 10, 27.0);
    private Corneta  cor1 = new Corneta ("COR-001", "Corneta Ku 12GHz",     349.90,  8, 12000.0, 25.0);
    private Patch    pat1 = new Patch   ("PAT-001", "Patch WiFi 2.4GHz",     79.90,  5, 2400.0, 60.0, 60.0, 8.5, 0.0);
    private Yagi     yag1 = new Yagi    ("YAG-001", "Yagi UHF 7 elementos", 219.90, 10, 470.0, 7, 12.0, 180.0);
    private Parabolica par1 = new Parabolica("PAR-001", "Parabólica 90cm Ku", 699.90, 3, 12000.0, 0.90, cor1, 37.0, 180.0);

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
        System.out.println("Bem-vindo a AntenaTech - Sua loja de antenas!");
        System.out.println("Confira nosso catálogo completo:\n");
        estoque.listarCatalogo();
        System.out.println("Digite 0 a qualquer momento para finalizar a compra.");
    }

    public void cadastro() {
        System.out.println("CADASTRANDO O CLIENTE");
        System.out.print("Informe seu nome: ");

        String nome = "";
        while (nome.trim().isEmpty()) {
            nome = input.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.print("Nome não pode ser vazio. Informe seu nome: ");
            }
        }

        this.carrinho = new Carrinho(nome.trim());
        System.out.println("Cadastro realizado com sucesso para: " + nome.trim() + "\n");
    }

    public Estoque getEstoque() { return estoque; }

    public void compra() {
        System.out.println("--- SELECIONE AS ANTENAS ---");
        System.out.println("1 - Monopolo VHF 144MHz  | R$ 89.90");
        System.out.println("2 - Dipolo HF 27MHz      | R$ 129.90");
        System.out.println("3 - Corneta Ku 12GHz     | R$ 349.90");
        System.out.println("4 - Patch WiFi 2.4GHz    | R$ 79.90");
        System.out.println("5 - Yagi UHF 7 elementos | R$ 219.90");
        System.out.println("6 - Parabólica 90cm Ku   | R$ 699.90");
        System.out.println("(Digite 0 para finalizar)\n");

        while (true) {
            System.out.print("Escolha uma opção: ");

            int opcao;
            try {
                opcao = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número entre 0 e 6.\n");
                continue;
            }

            if (opcao == 0) {
                break;
            }

            String codigo;
            switch (opcao) {
                case 1: codigo = "MON-001"; break;
                case 2: codigo = "DIP-001"; break;
                case 3: codigo = "COR-001"; break;
                case 4: codigo = "PAT-001"; break;
                case 5: codigo = "YAG-001"; break;
                case 6: codigo = "PAR-001"; break;
                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    continue;
            }

            try {
                Antena antena = estoque.buscarAntenaPorCodigo(codigo);

                if (antena == null) {
                    throw new RuntimeException("Antena com código '" + codigo + "' não encontrada no estoque.");
                }

                if (antena instanceof Direcional d) {
                    System.out.print("Informe a direção para apontar a antena (em graus): ");
                    try {
                        double novaDirecao = Double.parseDouble(input.nextLine());
                        d.apontar(novaDirecao);
                    } catch (NumberFormatException e) {
                        System.out.println("Direção inválida, mantendo direção atual.\n");
                    }

                    System.out.print("Informe a potência do sinal recebido (em dBm): ");
                    try {
                        double potencia = Double.parseDouble(input.nextLine());
                        System.out.println("Avaliação: " + d.avaliarSinal(potencia));
                    } catch (NumberFormatException e) {
                        System.out.println("Potência inválida, avaliação ignorada.\n");
                    }
                    System.out.println();
                }

                System.out.print("Quantidade: ");
                int quantidade;
                try {
                    quantidade = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Quantidade inválida. Tente novamente.\n");
                    continue;
                }

                if (quantidade <= 0) {
                    System.out.println("Quantidade deve ser maior que zero.\n");
                    continue;
                }

                if (quantidade > antena.getQuantidadeEstoque()) {
                    System.out.println("Estoque insuficiente. Disponível: "
                            + antena.getQuantidadeEstoque() + " unidades.\n");
                    continue;
                }

                System.out.print("Observações (ex: instalação em torre, uso interno): ");
                String observacoes = input.nextLine();

                Encomenda encomenda = new Encomenda(antena, quantidade, observacoes);
                carrinho.adicionarEncomenda(encomenda);
                antena.reduzirEstoque(quantidade);
                encomenda.marcarAtendida();
                System.out.println("Antena adicionada ao carrinho!\n");

            } catch (RuntimeException e) {
                System.out.println("Erro: " + e.getMessage() + " Tente novamente.\n");
            }
        }

        System.out.println("Obrigado por comprar na AntenaTech!");
        carrinho.exibirRecibo();

        if (!carrinho.estaVazio()) {
            GerenciadorArquivo.salvarCompra(carrinho);
        }
    }
}