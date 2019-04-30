package dominio;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Jogador extends Proprietario{
  private final TipoDeJogador tipoDeJogador;
  private BigDecimal saldo;
  private int numeroDaCasa;

  public Jogador(String nome, TipoDeJogador tipoDeJogador) {
    super(nome);
    this.saldo = BigDecimal.valueOf(300);
    this.tipoDeJogador = tipoDeJogador;
    this.numeroDaCasa = 0;
  }

  public void debitar(BigDecimal valor) {
    new ExcecaoDeDominio()
        .quando(valor.compareTo(saldo) > 0, "Não há saldo suficiente")
        .entaoDispara();
    saldo = saldo.subtract(valor);
  }

  public void depositar(BigDecimal valorDoAluguel) {
    saldo = saldo.add(valorDoAluguel);
  }

  public void pularCasas(int numeroDeCasas) {
    this.numeroDaCasa += numeroDeCasas;
  }
}
