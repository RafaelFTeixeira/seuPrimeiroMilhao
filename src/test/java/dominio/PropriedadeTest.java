package dominio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class PropriedadeTest {
  private Propriedade propriedade;

  @Before
  public void setUp() {
    propriedade = new Propriedade("Sto Amaro", BigDecimal.valueOf(200), BigDecimal.valueOf(22));
  }

  @Test
  public void deve_criar_uma_propriedade_valida() {
    final BigDecimal valorDaVenda = BigDecimal.valueOf(150);
    final BigDecimal valorDoAluguel = BigDecimal.valueOf(20);
    final String nome = "Morumbi";

    Propriedade propriedade = new Propriedade(nome, valorDaVenda, valorDoAluguel);

    Assert.assertEquals(valorDaVenda, propriedade.getValorDaVenda());
    Assert.assertEquals(nome, propriedade.getNome());
    Assert.assertEquals(valorDoAluguel, propriedade.getValorDoAluguel());
  }

  @Test
  public void deve_criar_uma_propriedade_sem_proprietario() {
    Propriedade propriedade = new Propriedade("Sto Amaro", BigDecimal.valueOf(200), BigDecimal.valueOf(22));

    Assert.assertNull(propriedade.getProprietario());
  }

  @Test
  public void deve_vender_uma_propriedade_quando_nao_ha_um_proprietario() {
    Proprietario proprietario = new Proprietario("Alex");

    propriedade.inserir(proprietario);

    Assert.assertEquals(proprietario, propriedade.getProprietario());
  }
}
