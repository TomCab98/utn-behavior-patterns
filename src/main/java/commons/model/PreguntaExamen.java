package commons.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PreguntaExamen {
  private final int numero;
  private final String enunciado;
  private final List<String> opciones;
  private final int respuestaCorrecta;

  public boolean esCorrecta(int respuesta) {
    return respuestaCorrecta == respuesta;
  }
}
