package antena.tipos;

public class Dipolo extends Monopolo {

    public Dipolo(String nome, double frequencia){
        super(nome, frequencia);
    }

    @Override
    public void exibirInfo() {
        System.out.println("Dipolo: " + nome);
    }
}
