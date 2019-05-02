package dominio;

import dominio.jogador.Exigente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class ExigenteTest {

    private Exigente exigente;

    @Before
    public void setUp() {
        exigente = new Exigente("Rafael");
    }

    @Test
    public void deve_poder_comprar_quando_o_valor_do_aluguel_é_apartir_de_50() {
        Propriedade propriedade = new Propriedade("Santo Amaro", BigDecimal.valueOf(300), BigDecimal.valueOf(50));

        Boolean deveComprar = exigente.deveComprar(propriedade);

        Assert.assertTrue(deveComprar);
    }

    @Test
    public void nao_deve_poder_comprar_quando_o_valor_do_aluguel_é_abaixo_de_50() {
        Propriedade propriedade = new Propriedade("Santo Amaro", BigDecimal.valueOf(200), BigDecimal.valueOf(49));

        Boolean deveComprar = exigente.deveComprar(propriedade);

        Assert.assertFalse(deveComprar);
    }

    @Test
    public void deve_poder_comprar_propriedade_quando_o_saldo_eh_maior_que_valor_da_venda() {
        Propriedade propriedade = new Propriedade("Morumbi", BigDecimal.TEN, BigDecimal.valueOf(55));

        Boolean deveComprar = exigente.deveComprar(propriedade);

        Assert.assertTrue(deveComprar);
    }

    @Test
    public void nao_deve_poder_comprar_propriedade_quando_o_saldo_eh_menor_que_valor_da_venda() {
        Propriedade propriedade = new Propriedade("Morumbi", BigDecimal.valueOf(400), BigDecimal.valueOf(55));

        Boolean deveComprar = exigente.deveComprar(propriedade);

        Assert.assertFalse(deveComprar);
    }
}
