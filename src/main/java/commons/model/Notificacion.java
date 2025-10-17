package commons.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class Notificacion {
  private String mensaje;
  private TipoNotificacion tipoCambio;
  private String nombreCurso;

  @Builder.Default
  private LocalDateTime fecha  =  LocalDateTime.now();

  @Override
  public String toString() {
    return "Notificacion:\n" + "\tASUNTO = '" + tipoCambio + "',\n\tCURSO = " + nombreCurso + ",\n\tMENSAJE = " + mensaje + ",\n\tfecha = " + fecha;
  }
}
