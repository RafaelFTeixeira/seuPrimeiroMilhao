package dominio;

import dominio.Jogador.Cauteloso;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class CautelosoTest {

    private Cauteloso cauteloso;

    @Before
    public void setUp() {
        cauteloso = new Cauteloso("Teixeira");
    }

    @Test
    public void deve_poder_comprar_quando_seu_saldo_restante_for_apartir_de_80() {
        Propriedade propriedade = new Propriedade("Botafogo", BigDecimal.valueOf(220), BigDecimal.TEN);

        Boolean deveComprar = cauteloso.deveComprar(propriedade);

        Assert.assertTrue(deveComprar);
    }

    @Test
    public void nao_deve_poder_comprar_quando_seu_saldo_restante_for_menor_que_80() {
        Propriedade propriedade = new Propriedade("Botafogo", BigDecimal.valueOf(221), BigDecimal.TEN);

        Boolean deveComprar = cauteloso.deveComprar(propriedade);

        Assert.assertFalse(deveComprar);
    }
}
