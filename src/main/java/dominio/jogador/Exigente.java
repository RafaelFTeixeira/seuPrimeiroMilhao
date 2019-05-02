package dominio.jogador;

import dominio.Propriedade;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
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
