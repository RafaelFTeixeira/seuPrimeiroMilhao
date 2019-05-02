package dominio;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Propriedade {
  private BigDecimal valorDaVenda;
  private BigDecimal valorDoAluguel;
  private String nome;
  private Proprietario proprietario;

  public Propriedade(String nome, BigDecimal valorDaVenda, BigDecimal valorDoAluguel) {
    this.nome = nome;
    this.valorDaVenda = valorDaVenda;
    this.valorDoAluguel = valorDoAluguel;
  }

  public void inserir(Proprietario proprietario) {
    if (!estaVendida()) {
      this.proprietario = proprietario;
    }
  }

  public boolean estaVendida() {
    return null != this.proprietario;
  }

  public void removerProprietario() {
    this.proprietario = null;
  }
}
