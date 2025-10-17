package patterns.strategy;

import java.util.List;

public class PromedioSimple implements CalculoNota {

  @Override
  public Integer calcular(List<Integer> notas) {
    if (notas == null || notas.isEmpty()) {
      throw new IllegalArgumentException("La lista no puede ser nula ni vacia");
    }

    double promedio = notas.stream()
        .mapToInt(Integer::intValue)
        .average()
        .orElse(0.0);

    return (int) Math.round(promedio);
  }
}
