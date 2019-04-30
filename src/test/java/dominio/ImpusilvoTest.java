package dominio;

import dominio.Jogador.Impulsivo;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class ImpusilvoTest {

  @Test
  public void deve_poder_comprar_propriedade_quando_o_saldo_eh_maior_que_valor_da_venda() {
    Propriedade propriedade = new Propriedade("Morumbi", BigDecimal.TEN, BigDecimal.ONE);
    Impulsivo impulsivo = new Impulsivo("Rafael Teixeira");

    Boolean deveComprar = impulsivo.deveComprar(propriedade);

    Assert.assertTrue(deveComprar);
  }

  @Test
  public void nao_deve_poder_comprar_propriedade_quando_o_saldo_eh_menor_que_valor_da_venda() {
    Propriedade propriedade = new Propriedade("Morumbi", BigDecimal.valueOf(400), BigDecimal.ONE);
    Impulsivo impulsivo = new Impulsivo("Rafael Teixeira");

    Boolean deveComprar = impulsivo.deveComprar(propriedade);

    Assert.assertFalse(deveComprar);
  }
}
