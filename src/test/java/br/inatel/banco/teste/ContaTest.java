package br.inatel.banco.teste;

import br.inatel.banco.services.ContaCorrenteService;
import br.inatel.banco.services.ContaPoupancaService;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContaTest {

    ContaPoupancaService ContaPoupanca;
    ContaCorrenteService ContaCorrente;

    @Before
    public void setup(){
        ContaCorrente = new ContaCorrenteService("1111", "1234567-9");
        ContaPoupanca = new ContaPoupancaService("2222", "9876543-1");
    }

    @Test
    public void ContaCorrentePagarCreditoTest_Ok (){
        // ContaPoupancaService ContaPoupanca = new ContaPoupancaService("2222", "9876543-1");
        // ContaCorrenteService ContaCorrente = new ContaCorrenteService("1111", "1234567-9");
        boolean verifica = ContaCorrente.pagarCredito(10);
        assertEquals(true, verifica);
    }

    @Test
    public void contaCorrentePagarCreditoTest_Error(){
        // ContaPoupancaService ContaPoupanca = new ContaPoupancaService("2222", "9876543-1");
        // ContaCorrenteService ContaCorrente = new ContaCorrenteService("1111", "1234567-9");
        assertEquals(false, ContaCorrente.pagarCredito(-10));
    }

    @Test
    public void contaPoupancaAdicionaRendimentoTest_Ok(){
        // ContaPoupancaService ContaPoupanca = new ContaPoupancaService("2222", "9876543-1");
        // ContaCorrenteService ContaCorrente = new ContaCorrenteService("1111", "1234567-9");
        ContaPoupanca.depositoConta(5600, "teste");
        ContaPoupanca.adicionaRendimento();
        assertEquals(56.0, ContaPoupanca.consultaRendimento(), 0);
    }

    @Test
    public void contaCorrentePagarContaTest_Error(){
        // Pagando conta com saldo insuficiente
        ContaCorrenteService ContaCorrente = new ContaCorrenteService("1111", "1234567-9");

        assertEquals(false, ContaCorrente.pagarConta(100,"Pagamento teste"));
    }

    @Test
    public void contaCorrentePagarContaTest_Ok(){
        // Pagando conta com saldo suficiente
        ContaCorrenteService ContaCorrente = new ContaCorrenteService("1111", "1234567-9");

        ContaCorrente.depositoConta(1000,"Depósito teste");
        assertEquals(true, ContaCorrente.pagarConta(100,"Pagamento teste"));
    }

    @Test
    public void contaPoupancaDepositoTest_Ok(){
        // Depositando na Conta
        ContaPoupancaService ContaPoupanca = new ContaPoupancaService("2222", "9876543-1");

        ContaPoupanca.depositoConta(200,"Depósito teste");
        assertEquals(200, ContaPoupanca.consultaSaldo(),0);
    }
}
