package dominio.jogador;

import dominio.Propriedade;
import dominio.Proprietario;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public abstract class Jogador extends Proprietario {
  private BigDecimal saldo;
  private int numeroDaCasa;
  private Boolean estaFalido;

  public Jogador(String nome) {
    super(nome);
    this.saldo = BigDecimal.valueOf(300);
    this.numeroDaCasa = 0;
    this.estaFalido = false;
  }

  public abstract Boolean deveComprar(Propriedade propriedade);

  public void debitar(BigDecimal valor) {

    saldo = saldo.subtract(valor);
    if (BigDecimal.ZERO.compareTo(saldo) == 1) {
      estaFalido = true;
    }
  }

  public void depositar(BigDecimal valorDoAluguel) {
    saldo = saldo.add(valorDoAluguel);
  }

  public void pularCasas(int numeroDeCasas) {
    this.numeroDaCasa += numeroDeCasas;
  }
}
