package commons.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Inscripcion {
  private final String codigo;
  private final Alumno alumno;
  private final Curso curso;

  @Builder.Default
  private LocalDateTime fechaInscripcion = LocalDateTime.now();
}
