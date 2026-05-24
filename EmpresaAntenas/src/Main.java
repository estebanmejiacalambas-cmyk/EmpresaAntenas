import estoque.Estoque;
import estoque.MonitorEstoque;
import menu.Menu;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.inicializar();
        menu.apresentacao();

        Estoque estoque = menu.getEstoque();
        MonitorEstoque monitor = new MonitorEstoque(estoque);
        Thread threadMonitor = new Thread(monitor);
        threadMonitor.setDaemon(true);
        threadMonitor.start();

        menu.cadastro();
        menu.compra();
    }
}
