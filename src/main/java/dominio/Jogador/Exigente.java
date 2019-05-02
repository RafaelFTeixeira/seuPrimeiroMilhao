package dominio.Jogador;

import dominio.Propriedade;

import java.math.BigDecimal;

public class Exigente extends Jogador {
  public Exigente(String nome) {
    super(nome);
  }

  @Override
  public Boolean deveComprar(Propriedade propriedade) {
    return this.getSaldo().compareTo(propriedade.getValorDaVenda()) >= 0
        && propriedade.getValorDoAluguel().compareTo(BigDecimal.valueOf(50)) >= 0;
  }
}
