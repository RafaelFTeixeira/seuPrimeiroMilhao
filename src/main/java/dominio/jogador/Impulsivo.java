package dominio.jogador;

import dominio.Propriedade;

public class Impulsivo extends Jogador {
  public Impulsivo(String nome) {
    super(nome);
  }

  @Override
  public Boolean deveComprar(Propriedade propriedade) {
    return this.getSaldo().compareTo(propriedade.getValorDaVenda()) >= 0;
  }
}
