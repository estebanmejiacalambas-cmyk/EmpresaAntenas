import Estoque.Estoque;
import Estoque.MonitorEstoque;
import Menu.Menu;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.inicializar();
        MonitorEstoque monitor = new MonitorEstoque(menu.getEstoque());
        Thread threadMonitor = new Thread(monitor);
        threadMonitor.setDaemon(true);
        threadMonitor.start();

        menu.apresentacao();
        menu.cadastro();
        menu.compra();
    }
}
