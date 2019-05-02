package dominio;

import dominio.Jogador.*;
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
    Jogador jogador = new Impulsivo("Rafael Teixeira");
    List<Jogador> jogadores = Arrays.asList(jogador);

    Tabuleiro tabuleiro = new Tabuleiro(propriedades, jogadores);

    Assert.assertArrayEquals(propriedades.toArray(), tabuleiro.getPropriedades().toArray());
  }

  @Test
  public void deve_vencer_apenas_um_jogador() {
    Impulsivo impulsivo = new Impulsivo("Rafael");
    Cauteloso cauteloso = new Cauteloso("Dantas");
    Aleatorio aleatorio = new Aleatorio("Alex");
    Exigente exigente = new Exigente("Fabio");
    List<Jogador> jogadores = Arrays.asList(impulsivo, cauteloso, aleatorio, exigente);
    List<Propriedade> propriedades = Arrays.asList(
        new Propriedade("A", BigDecimal.valueOf(60), BigDecimal.valueOf(35)),
        new Propriedade("B", BigDecimal.valueOf(150), BigDecimal.valueOf(60)),
        new Propriedade("C", BigDecimal.valueOf(250), BigDecimal.valueOf(80)),
        new Propriedade("D", BigDecimal.valueOf(350), BigDecimal.valueOf(120)),
        new Propriedade("E", BigDecimal.valueOf(450), BigDecimal.valueOf(160)),
        new Propriedade("F", BigDecimal.valueOf(550), BigDecimal.valueOf(200)),
        new Propriedade("G", BigDecimal.valueOf(80), BigDecimal.valueOf(30)),
        new Propriedade("H", BigDecimal.valueOf(120), BigDecimal.valueOf(50)),
        new Propriedade("I", BigDecimal.valueOf(300), BigDecimal.valueOf(100)),
        new Propriedade("J", BigDecimal.valueOf(120), BigDecimal.valueOf(50)),
        new Propriedade("H", BigDecimal.valueOf(60), BigDecimal.valueOf(30)),
        new Propriedade("K", BigDecimal.valueOf(70), BigDecimal.valueOf(40)),
        new Propriedade("L", BigDecimal.valueOf(90), BigDecimal.valueOf(50)),
        new Propriedade("M", BigDecimal.valueOf(110), BigDecimal.valueOf(70)),
        new Propriedade("N", BigDecimal.valueOf(100), BigDecimal.valueOf(60)),
        new Propriedade("O", BigDecimal.valueOf(140), BigDecimal.valueOf(80)),
        new Propriedade("P", BigDecimal.valueOf(50), BigDecimal.valueOf(20)),
        new Propriedade("Q", BigDecimal.valueOf(75), BigDecimal.valueOf(30)),
        new Propriedade("R", BigDecimal.valueOf(95), BigDecimal.valueOf(60)),
        new Propriedade("S", BigDecimal.valueOf(665), BigDecimal.valueOf(300))
    );
    Tabuleiro tabuleiro = new Tabuleiro(propriedades, jogadores);

    tabuleiro.iniciar();

    long quantidadeDeJogadorComSaldoPositivo = tabuleiro.getJogadores().stream()
        .filter(j -> j.getSaldo().compareTo(BigDecimal.ZERO) == 1)
        .count();
    Assert.assertTrue(quantidadeDeJogadorComSaldoPositivo == 1);
  }
}
