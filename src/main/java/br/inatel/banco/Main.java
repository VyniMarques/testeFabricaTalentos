package br.inatel.banco;

import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;

public class Main {
    public static void main(String[] args) {
        System.out.printf("------------------------------Inatel Bank------------------------------");

        ContaCorrenteService ContaCorrente =
                new ContaCorrenteService("1111", "1234567-9");
        ContaPoupancaService ContaPoupanca =
                new ContaPoupancaService("2222", "9876543-1");

        System.out.println("-------------Conta Corrente-------------");
        ContaCorrente.pagarConta(70.56, "CEMIG");
        ContaCorrente.depositoConta(300, "PIX");
        ContaCorrente.adicionarCredito(3000);
        ContaCorrente.pagarConta(70.56,"CEMIG");
        ContaCorrente.pagarCredito(100);
        ContaCorrente.consultaExtrato();

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        System.out.println("-------------Conta Poupança-------------");
        ContaPoupanca.depositoConta(5600, "PIX");
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.pagarConta(99.90, "Internet");
        ContaPoupanca.adicionaRendimento();
        System.out.println("Rendimento: " + ContaPoupanca.consultaRendimento());
        ContaPoupanca.consultaExtrato();
    }
}
