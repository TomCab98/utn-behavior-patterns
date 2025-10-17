package commons.model;

import lombok.Builder;
import lombok.Data;
import patterns.state.state.EstadoInscripcion;

import java.time.LocalDateTime;

@Data
@Builder
public class CambioEstadoInscripcion {
  private EstadoInscripcion estado;
  private String motivo;

  @Builder.Default
  private LocalDateTime fecha = LocalDateTime.now();
}
