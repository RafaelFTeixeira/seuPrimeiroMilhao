package dominio;

import java.util.ArrayList;
import java.util.List;

public class ExcecaoDeDominio extends RuntimeException {
  private List<String> erros = new ArrayList<String>();

  public ExcecaoDeDominio() {
    super();
  }

  public ExcecaoDeDominio quandoEhNuloOuVazio(String texto, String mensagem) {
    if (null == texto || texto.trim() == "") {
      erros.add(mensagem);
    }
    return this;
  }

  public ExcecaoDeDominio quandoEhNulo(Object objeto, String mensagem) {
    if (null == objeto) {
      erros.add(mensagem);
    }
    return this;
  }

  public ExcecaoDeDominio quando(Boolean condicao, String mensagem) {
    if (condicao) {
      erros.add(mensagem);
    }
    return this;
  }

  public void entaoDispara() {
    if (!erros.isEmpty()) {
      throw this;
    }
  }

  @Override
  public String toString() {
    List<String> texto = new ArrayList<String>();
    texto.add("\n");

    erros.forEach(texto::add);

    return texto.toString();
  }
}