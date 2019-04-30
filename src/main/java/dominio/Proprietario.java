package dominio;

import lombok.Getter;

@Getter
public class Proprietario{
  private String nome;

  public Proprietario(String nome) {
    this.nome = nome;
  }
}
