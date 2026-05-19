import estoque.Estoque;
import produto.antena.antenas.*;
import sistema.SistemaAntenas;

public class Main {

    public static void main(String[] args) {

        Estoque estoque = new Estoque();

        // ── Produtos de exemplo ───────────────────────────────────────────────

        Corneta feedCorneta = new Corneta("COR-001", "Corneta Ku-Band", 350.00, 5, 11700.0, 20.0);
        estoque.cadastrarProduto(feedCorneta);

        estoque.cadastrarProduto(
                new Parabolica("PAR-001", "Parabólica 1.2m Ku", 1200.00, 3,
                        11700.0, 1.2, feedCorneta));

        estoque.cadastrarProduto(
                new Yagi("YAG-001", "Yagi VHF 7 Elementos", 280.00, 10,
                        144.0, 7));

        estoque.cadastrarProduto(
                new Patch("PAT-001", "Patch 2.4GHz WiFi", 95.00, 20,
                        2400.0, 60.0, 60.0));

        estoque.cadastrarProduto(
                new Monopolo("MON-001", "Monopolo UHF", 45.00, 15, 433.0));

        estoque.cadastrarProduto(
                new Dipolo("DIP-001", "Dipolo FM", 70.00, 8, 98.0));

        // ── Iniciar sistema ───────────────────────────────────────────────────

        SistemaAntenas sistema = new SistemaAntenas(estoque);
        sistema.iniciar();
    }
}