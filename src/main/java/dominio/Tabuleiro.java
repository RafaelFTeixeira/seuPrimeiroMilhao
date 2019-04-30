package dominio;

import dominio.Jogador.Jogador;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Getter
public class Tabuleiro {
  private Integer indiceVezDeJogar = 0;
  private List<Jogador> jogadores;
  private Integer quantidadeDeJogadoresAtivo;
  private List<Propriedade> propriedades;
  private Jogador vencedor;

  public Tabuleiro(List<Propriedade> propriedades, List<Jogador> jogadores) {
    this.propriedades = propriedades;
    this.jogadores = jogadores;
    this.quantidadeDeJogadoresAtivo = jogadores.size();
  }

  public void iniciar() {
    while(quantidadeDeJogadoresAtivo > 1) {
      Jogador vezDoJogador = jogadores.get(indiceVezDeJogar);

      if (!vezDoJogador.getEstaFalido()) {
        jogar(vezDoJogador);
      }

      indiceVezDeJogar = jogadores.size() - 1 == indiceVezDeJogar ? 0 : indiceVezDeJogar + 1;
    }
    vencedor = jogadores.stream().filter(j -> j.getSaldo().compareTo(BigDecimal.ZERO) == 1).findFirst().get();
  }

  private void removerPropriedadesDoJogadorQuandoEstiverFalido(Jogador jogador) {
    if(jogador.getEstaFalido()) {
      propriedades.stream()
          .filter(p -> p.estaVendida() && jogador.getNome() == p.getProprietario().getNome())
          .forEach(p -> p.removerProprietario());
      quantidadeDeJogadoresAtivo--;
    }
  }

  private Integer rodarDado() {
    return (int)(Math.random() * 6 + 1);
  }

  private void jogar(Jogador jogador) {
    int numeroDeCasas = rodarDado();
    jogador.pularCasas(numeroDeCasas);
    premiarJogadorQuandoDerUmaVoltaNoTabuleiro(jogador);

    Propriedade propriedade = propriedades.get(jogador.getNumeroDaCasa());
    pagarAluguelQuandoNaoForProprietario(jogador, propriedade);
    comprarPropriedadeQuandoNaoEstiverProprietario(jogador, propriedade);
    removerPropriedadesDoJogadorQuandoEstiverFalido(jogador);
  }

  private void premiarJogadorQuandoDerUmaVoltaNoTabuleiro(Jogador jogador) {
    Boolean deuUmaVoltaNoTabuleiro = jogador.getNumeroDaCasa() >= propriedades.size();
    if (deuUmaVoltaNoTabuleiro) {
      jogador.depositar(BigDecimal.valueOf(100));
      jogador.pularCasas(propriedades.size() * (-1));
    }
  }

  private void pagarAluguelQuandoNaoForProprietario(Jogador jogador, Propriedade propriedade) {
    Boolean devePagarAluguel = propriedade.estaVendida() && jogador.getNome() != propriedade.getProprietario().getNome();
    if(devePagarAluguel) {
      pagarAluguelDaPropriedade(jogador, propriedade);
    }
  }

  private void comprarPropriedadeQuandoNaoEstiverProprietario(Jogador jogador, Propriedade propriedade) {
    if (jogador.deveComprar(propriedade)) {
      comprarPropriedade(propriedade, jogador);
    }
  }

  public void comprarPropriedade(Propriedade propriedade, Jogador jogador) {
    if(!propriedade.estaVendida()) {
      obter(jogador).debitar(propriedade.getValorDaVenda());
      obter(propriedade).inserir(jogador);
    }
  }

  public void pagarAluguelDaPropriedade(Jogador jogador, Propriedade propriedade) {
    obter(jogador).debitar(propriedade.getValorDoAluguel());
    obterJogadorPor(propriedade.getProprietario().getNome())
        .depositar(propriedade.getValorDoAluguel());
  }

  private Jogador obter(Jogador jogador) {
    return obterJogadorPor(jogador.getNome());
  }

  private Propriedade obter(Propriedade propriedade) {
    return propriedades.stream()
        .filter(p -> p.getNome().equals(propriedade.getNome()))
        .findFirst().get();
  }

  private Jogador obterJogadorPor(String nome) {
    return jogadores.stream()
        .filter(j -> j.getNome().equals(nome))
        .findFirst().get();
  }
}
