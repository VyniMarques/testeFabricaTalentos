package br.inatel.banco.teste;

import br.inatel.banco.controller.ManipulaConta;
import br.inatel.banco.services.ContaBaseService;
import br.inatel.banco.services.ContaCorrenteService;
import org.junit.Assert;
import org.junit.Test;

public class ManipulaContaTest {
    ManipulaConta ManipulaContaFake;

    @Test
    public void depositarValorContaCorrenteTest_Ok(){
        ManipulaContaFake = new ManipulaConta();

        ContaBaseService cc = new ContaCorrenteService("1111", "123456789-0");

        String resultado = ManipulaContaFake.depositarValor(cc, 1500, "PIX");

        Assert.assertEquals("Depósito realizado com sucesso", resultado);
    }

    @Test
    public void depositarValorContaCorrentetest_Error(){
        ManipulaContaFake = new ManipulaConta();

        ContaBaseService cc = new ContaCorrenteService("1111", "123456789-0");

        String resultado = ManipulaContaFake.depositarValor(cc, -1500, "PIX");

        Assert.assertEquals("Falha ao realizar depósito", resultado);
    }

    @Test
    public void pagamentoContaCorrenteTest_Error(){
        ManipulaContaFake = new ManipulaConta();

        ContaBaseService cc = new ContaCorrenteService("1111", "123456789-0");

        ManipulaContaFake.depositarValor(cc, 15, "PIX");

        String resultado = ManipulaContaFake.pagamentoConta(cc, 99.90, "Internet");

        Assert.assertEquals("Falha ao realizar pagamento", resultado);

    }

    @Test
    public void pagamentoContaCorrenteTest_Ok(){
        ManipulaContaFake = new ManipulaConta();

        ContaBaseService cc = new ContaCorrenteService("1111", "123456789-0");

        ManipulaContaFake.depositarValor(cc, 1500, "PIX");

        String resultado = ManipulaContaFake.pagamentoConta(cc, 99.90, "Internet");

        Assert.assertEquals("Pagamento realizado com sucesso", resultado);

    }
}
