package commons.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Solicitud {
  private final String codigo;
  private final Alumno alumno;
  private final String asunto;
  private final int complejidad;
}
