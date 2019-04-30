package dominio.Jogador;

import dominio.Propriedade;

public class Aleatorio extends Jogador {
  public Aleatorio(String nome) {
    super(nome);
  }

  @Override
  public Boolean deveComprar(Propriedade propriedade) {
    return this.getSaldo().compareTo(propriedade.getValorDaVenda()) >= 0
        && (int)(Math.random() * 100 + 1) > 50;
  }
}
