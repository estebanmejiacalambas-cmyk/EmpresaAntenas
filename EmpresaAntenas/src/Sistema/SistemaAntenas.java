package sistema;
import encomenda.NovaAntena;
import estoque.Estoque;
import pedido.ItemPedido;
import pedido.Pedido;
import produto.Produto;
import java.util.Scanner;

//Dividir em varias classes

public class SistemaAntenas {

    private Estoque estoque;
    private Scanner scanner;

    public SistemaAntenas(Estoque estoque) {

        this.estoque = estoque;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {

        System.out.println("LOJA DE ANTENAS ");

        boolean rodando = true;

        while (rodando) {

            exibirMenuPrincipal();

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {

                fluxoCompra();

            } else if (opcao == 2) {

                estoque.listarCatalogo();

            } else if (opcao == 3) {

                fluxoEncomenda();

            } else if (opcao == 4) {

                estoque.listarEncomendas();

            } else if (opcao == 5) {

                fluxoAdminEstoque();

            } else if (opcao == 0) {

                System.out.println("Sistema encerrado.");
                rodando = false;

            } else {

                System.out.println("Opção inválida.");
            }
        }
    }

    private void exibirMenuPrincipal() {

        System.out.println("\n===== MENU =====");

        System.out.println("1 - Fazer Pedido");
        System.out.println("2 - Ver Catálogo");
        System.out.println("3 - Fazer Encomenda");
        System.out.println("4 - Ver Encomendas");
        System.out.println("5 - Administrar Estoque");
        System.out.println("0 - Sair");
    }

    private void fluxoCompra() {

        System.out.print("Nome do cliente: ");
        String nomeCliente = scanner.nextLine();

        Pedido pedido = new Pedido(nomeCliente);

        boolean adicionando = true;

        while (adicionando) {

            estoque.listarCatalogo();

            System.out.print("Digite o código do produto: ");
            String codigo = scanner.nextLine();

            if (codigo.equalsIgnoreCase("fim")) {

                adicionando = false;

            } else {

                Produto produto = estoque.buscarPorCodigo(codigo);

                if (produto == null) {

                    System.out.println("Produto não encontrado.");

                    System.out.print("Deseja fazer encomenda? ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("s")) {

                        fluxoEncomenda();
                    }

                } else {

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (produto.removerEstoque(quantidade)) {

                        ItemPedido item =
                                new ItemPedido(produto, quantidade);

                        pedido.adicionarItem(item);

                        System.out.println("Item adicionado.");

                    } else {

                        System.out.println("Estoque insuficiente.");
                    }
                }
            }
        }

        if (pedido.getItens().size() == 0) {

            System.out.println("Pedido vazio.");

        } else {

            pedido.exibirRecibo();
        }
    }

    private void fluxoEncomenda() {

        System.out.println("\n===== NOVA ENCOMENDA =====");

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Tipo: ");
        String tipo = scanner.nextLine();

        System.out.print("Frequência: ");
        double frequencia = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Sinal (digital ou analogico): ");
        String tipoSinal = scanner.nextLine();

        boolean digital;

        if (tipoSinal.equalsIgnoreCase("digital")) {

            digital = true;

        } else {

            digital = false;
        }

        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Observações: ");
        String observacoes = scanner.nextLine();

        NovaAntena encomenda = new NovaAntena(
                codigo,
                nome,
                preco,
                frequencia,
                digital,
                tipo,
                observacoes
        );

        estoque.registrarEncomenda(encomenda);

        System.out.println("Encomenda cadastrada.");

        encomenda.exibirDetalhes();
    }

    private void fluxoAdminEstoque() {

        System.out.println("\n===== ADMINISTRAÇÃO =====");

        System.out.println("1 - Adicionar Estoque");
        System.out.println("2 - Atender Encomenda");
        System.out.println("0 - Voltar");

        System.out.print("Escolha: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        if (opcao == 1) {

            System.out.print("Código do produto: ");
            String codigo = scanner.nextLine();

            Produto produto =
                    estoque.buscarPorCodigo(codigo);

            if (produto == null) {

                System.out.println("Produto não encontrado.");

            } else {

                System.out.print("Quantidade: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                produto.adicionarEstoque(quantidade);

                System.out.println("Estoque atualizado.");
            }

        } else if (opcao == 2) {

            estoque.listarEncomendas();

            System.out.print("Código da encomenda: ");
            String codigo = scanner.nextLine();

            boolean encontrada = false;

            for (NovaAntena encomenda :
                    estoque.getEncomendas()) {

                if (encomenda.getCodigo()
                        .equalsIgnoreCase(codigo)) {

                    encomenda.marcarComoAtendida();

                    encontrada = true;
                }
            }

            if (encontrada) {

                System.out.println("Encomenda atendida.");

            } else {

                System.out.println("Encomenda não encontrada.");
            }

        } else if (opcao == 0) {

            System.out.println("Voltando...");

        } else {

            System.out.println("Opção inválida.");
        }
    }
}