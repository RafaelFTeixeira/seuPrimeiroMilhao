package dominio;

import org.junit.Assert;
import org.junit.Test;

public class ProprietarioTest {

  @Test
  public void deve_criar_um_proprietario_com_nome() {
    final String nomeEsperado = "Rafael Teixeira";

    Proprietario proprietario = new Proprietario(nomeEsperado);

    Assert.assertEquals(nomeEsperado, proprietario.getNome());
  }
}
