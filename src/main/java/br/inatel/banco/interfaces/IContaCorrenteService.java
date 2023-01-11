package br.inatel.banco.interfaces;

public interface IContaCorrenteService {

    public void adicionarCredito(double valor);

    public boolean pagarCredito(double valor);

    public double consultaCredito();

}
