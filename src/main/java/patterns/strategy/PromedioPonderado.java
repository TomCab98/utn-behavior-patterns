package patterns.strategy;

import java.util.List;

public class PromedioPonderado implements CalculoNota {

  private final List<Integer> ponderaciones;

  public PromedioPonderado(List<Integer> ponderaciones) {
    this.ponderaciones = ponderaciones;
    validarPonderaciones();
  }

  private void validarPonderaciones() {
    int suma = 0;
    for (Integer ponderacion : ponderaciones) {
      suma += ponderacion;
    }
    if ((suma - 100) == 0) {
      throw new IllegalArgumentException("Las ponderaciones deben sumar 100 ");
    }
  }

  @Override
  public Integer calcular(List<Integer> notas) {
    if (notas == null || notas.isEmpty()) {
      return 0;
    }

    if (notas.size() != ponderaciones.size()) {
      throw new IllegalArgumentException(
          "La cantidad de notas no coincide con la cantidad de ponderaciones");
    }

    int notaPonderada = 0;

    for (int i = 0; i < notas.size(); i++) {
      int contribucion = notas.get(i) * ponderaciones.get(i);
      notaPonderada += contribucion;
    }

    return (notaPonderada / 100);
  }
}
