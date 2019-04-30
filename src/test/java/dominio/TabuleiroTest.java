package dominio;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class TabuleiroTest {

  @Test
  public void deve_criar_um_tabuleiro_valido() {
    Propriedade propriedade = new Propriedade("Sto Antonio", BigDecimal.valueOf(230), BigDecimal.valueOf(23));
    List<Propriedade> propriedades = Arrays.asList(propriedade);
    Jogador jogador = new Jogador("Rafael Teixeira");
    List<Jogador> jogadores = Arrays.asList(jogador);

    Tabuleiro tabuleiro = new Tabuleiro(propriedades, jogadores);

    Assert.assertArrayEquals(propriedades.toArray(), tabuleiro.getPropriedades().toArray());
  }

  @Test
  public void deve_vender_uma_propriedade_para_um_jogador() {
    Propriedade propriedade = new Propriedade("Sto Antonio", BigDecimal.valueOf(230), BigDecimal.valueOf(23));
    List<Propriedade> propriedades = Arrays.asList(propriedade);
    Jogador jogador = new Jogador("Rafael Teixeira");
    List<Jogador> jogadores = Arrays.asList(jogador);
    Tabuleiro tabuleiro = new Tabuleiro(propriedades, jogadores);

    tabuleiro.comprarPropriedade(propriedade, jogador);

    Assert.assertTrue(propriedade.getEstaVendida());
  }

  @Test
  public void deve_debitar_do_jogador_ao_comprar_uma_propriedade() {
    Propriedade propriedade = new Propriedade("Sto Antonio", BigDecimal.valueOf(230), BigDecimal.valueOf(23));
    List<Propriedade> propriedades = Arrays.asList(propriedade);
    Jogador jogador = new Jogador("Rafael Teixeira");
    List<Jogador> jogadores = Arrays.asList(jogador);
    Tabuleiro tabuleiro = new Tabuleiro(propriedades, jogadores);
    BigDecimal saldoEsperado = BigDecimal.valueOf(300).subtract(propriedade.getValorDaVenda());

    tabuleiro.comprarPropriedade(propriedade, jogador);

    Assert.assertEquals(saldoEsperado, jogador.getSaldo());
  }

  @Test
  public void deve_pagar_aluguel_da_propriedade_quando_houver_um_proprietario() {
    Propriedade propriedade = new Propriedade("Sto Antonio", BigDecimal.valueOf(230), BigDecimal.valueOf(23));
    List<Propriedade> propriedades = Arrays.asList(propriedade);
    Jogador jogador = new Jogador("Rafael Teixeira");
    Jogador proprietario = new Jogador("Anderson Dantas");
    List<Jogador> jogadores = Arrays.asList(jogador, proprietario);
    Tabuleiro tabuleiro = new Tabuleiro(propriedades, jogadores);
    BigDecimal saldoEsperado = BigDecimal.valueOf(300).subtract(propriedade.getValorDoAluguel());
    tabuleiro.comprarPropriedade(propriedade, proprietario);
    BigDecimal saldoEsperadoDoProprietario = proprietario.getSaldo().add(propriedade.getValorDoAluguel());

    tabuleiro.pagarAluguelDaPropriedade(jogador, propriedade);

    Assert.assertEquals(saldoEsperado, jogador.getSaldo());
    Assert.assertEquals(saldoEsperadoDoProprietario, proprietario.getSaldo());
  }
}
