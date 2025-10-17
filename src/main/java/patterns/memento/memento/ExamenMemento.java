package patterns.memento.memento;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExamenMemento {

  private final Map<Integer, Integer> respuestas;
  private final int preguntaActual;
  private final LocalDateTime fechaGuardado = LocalDateTime.now();
  private final String descripcion;

  public Map<Integer, Integer> getRespuestas() {
    return new HashMap<>(respuestas);
  }
}
