package Produto.Antena;

public interface Direcional {
    void apontar(double novaDirecao);
    String avaliarSinal(double potenciaRecebida);
}
