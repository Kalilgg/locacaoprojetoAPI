package Services;

import ModelClass.Cliente;
import ModelClass.Objeto;

public interface Locacao {

    void locar(Objeto item, int dias, Cliente cliente);

    void devolver(Objeto item, Cliente cliente);

    void colocarEmManutencao(Objeto item);

    void retornarDeManutencao(Objeto item);
}