package dominio;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Tabuleiro {
  private Integer vezDeJogar = 0;
  private List<Jogador> jogadores;
  private List<Propriedade> propriedades;

  public Tabuleiro(List<Propriedade> propriedades, List<Jogador> jogadores) {
    this.propriedades = propriedades;
    this.jogadores = jogadores;
  }

  public void Jogar() {
    int numeroDeCasas = (int)(Math.random() * 6 + 1);
    Jogador jogador = jogadores.get(vezDeJogar);
    jogador.pularCasas(numeroDeCasas);
    Propriedade propriedade = propriedades.get(jogador.getNumeroDaCasa());
    if (jogador.getTipoDeJogador() == TipoDeJogador.Impulsivo) {
      comprarPropriedade(propriedade, jogador);
      pagarAluguelDaPropriedade(jogador, propriedade);
    }
    else if (jogador.getTipoDeJogador() == TipoDeJogador.Exigente) {
      if (propriedade.getValorDoAluguel().compareTo(BigDecimal.valueOf(50)) > 0)
        comprarPropriedade(propriedade, jogador);
      pagarAluguelDaPropriedade(jogador, propriedade);
    }
    else if (jogador.getTipoDeJogador() == TipoDeJogador.Cauteloso) {
      if (jogador.getSaldo().subtract(propriedade.getValorDaVenda()).compareTo(BigDecimal.valueOf(80)) > 0)
        comprarPropriedade(propriedade, jogador);
      pagarAluguelDaPropriedade(jogador, propriedade);
    }
    else if (jogador.getTipoDeJogador() == TipoDeJogador.Aleatorio) {
      int probalidade = (int)(Math.random() * 100 + 1);
      if (probalidade > 50)
        comprarPropriedade(propriedade, jogador);
      pagarAluguelDaPropriedade(jogador, propriedade);
    }
  }

  public void comprarPropriedade(Propriedade propriedade, Jogador jogador) {
    if(!propriedade.getEstaVendida()) {
      obter(jogador).debitar(propriedade.getValorDaVenda());
      propriedades.stream()
          .filter(p -> p.getNome().equals(propriedade.getNome()))
          .forEach(p -> p.inserir(jogador));
    }
  }

  public void pagarAluguelDaPropriedade(Jogador jogador, Propriedade propriedade) {
    if(propriedade.getEstaVendida() && jogador.getNome() != propriedade.getProprietario().getNome()) {
      obter(jogador).debitar(propriedade.getValorDoAluguel());
      obterJogadorPor(propriedade.getProprietario().getNome())
          .depositar(propriedade.getValorDoAluguel());
    }
  }

  private Jogador obter(Jogador jogador) {
    return obterJogadorPor(jogador.getNome());
  }

  private Jogador obterJogadorPor(String nome) {
    return jogadores.stream()
        .filter(j -> j.getNome().equals(nome))
        .findFirst().get();
  }
}
