package commons.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class Examen {
  private final String codigo;
  private final String materia;
  private final String titulo;
  private final Date fecha = new Date();
  private List<PreguntaExamen> preguntas;

  @Builder.Default
  private Map<Integer, Integer> respuestas = new HashMap<>();

  @Builder.Default
  private int preguntaActual = 0;

  @Builder.Default
  private boolean finalizado  = false;

  @Builder.Default
  private double nota = 0.0;
}
