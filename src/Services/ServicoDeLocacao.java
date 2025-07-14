package Services;

import Exceptions.Indisponivel;
import Exceptions.SaldoInsuficiente;
import ModelClass.Cliente;
import ModelClass.Objeto;

public class ServicoDeLocacao implements Locacao {

    @Override
    public void locar(Objeto item, int dias, Cliente cliente) {
        if (!item.isStatus()) {
            throw new Indisponivel("O item '" + item.getNome() + "' não está disponível para locação.");
        }
        if (dias <= 0) {
            throw new IllegalArgumentException("O número de dias deve ser positivo.");
        }

        double valorTotal = calcularValorDevido(item, dias);

        try {
            cliente.debitar(valorTotal);
            item.setStatus(false);
            cliente.adicionarItem(item);

            System.out.println("'" + item.getNome() + "' alugado para '" + cliente.getNome() + "' por " + dias + " dias.");
            System.out.println("Valor da operação: R$ " + String.format("%.2f", valorTotal));

        } catch (SaldoInsuficiente e) {
            System.out.println("Falha na locação: " + e.getMessage());
            throw e;
        }
    }

    @Override
    public void devolver(Objeto item, Cliente cliente) {
        if (!cliente.getItensAlugados().contains(item)) {
            System.out.println("Operação inválida: O cliente " + cliente.getNome() + " não possui o item '" + item.getNome() + "'.");
            return;
        }

        item.setStatus(true);
        cliente.removerItem(item);
        System.out.println("O item '" + item.getNome() + "' foi devolvido por '" + cliente.getNome() + "'.");
    }

    @Override
    public void colocarEmManutencao(Objeto item) {
        item.setStatus(false);
        System.out.println("O item '" + item.getNome() + "' foi colocado em manutenção e está indisponível.");
    }

    @Override
    public void retornarDeManutencao(Objeto item) {
        item.setStatus(true);
        System.out.println("O item '" + item.getNome() + "' retornou da manutenção e está disponível.");
    }

    private double calcularValorDevido(Objeto item, int dias) {
        return item.getValor() * dias;
    }
}