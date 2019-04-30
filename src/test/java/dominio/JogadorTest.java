package dominio;

import dominio.Jogador.Impulsivo;
import dominio.Jogador.Jogador;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class JogadorTest {

  @Test
  public void deve_criar_um_jogador_com_nome() {
    final String nomeDoJogador = "Rafael Teixeira";

    Jogador jogador = new Impulsivo(nomeDoJogador);

    Assert.assertEquals(nomeDoJogador, jogador.getNome());
  }

  @Test
  public void deve_iniciar_com_saldo_de_300_ao_criar_um_jogador() {
    final BigDecimal saldoEsperado = BigDecimal.valueOf(300);

    Jogador jogador = new Impulsivo("Anderson Dantas");

    Assert.assertEquals(saldoEsperado, jogador.getSaldo());
  }

  @Test
  public void deve_debitar_no_saldo_do_jogador() {
    final BigDecimal saldoEsperado = BigDecimal.valueOf(250);
    Jogador jogador = new Impulsivo("Alex");

    jogador.debitar(BigDecimal.valueOf(50));

    Assert.assertEquals(saldoEsperado, jogador.getSaldo());
  }

  @Test
  public void deve_depositar_no_saldo_do_jogador() {
    final BigDecimal saldoEsperado = BigDecimal.valueOf(350);
    Jogador jogador = new Impulsivo("Alex");

    jogador.depositar(BigDecimal.valueOf(50));

    Assert.assertEquals(saldoEsperado, jogador.getSaldo());
  }

  @Test
  public void deve_esta_falido_o_jogador_com_saldo_negativo() {
    Jogador jogador = new Impulsivo("Rafael");

    jogador.debitar(BigDecimal.valueOf(400));

    Assert.assertTrue(jogador.getEstaFalido());
  }
}
