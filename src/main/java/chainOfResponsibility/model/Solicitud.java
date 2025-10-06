package chainOfResponsibility.model;

import lombok.Data;

@Data
public class Solicitud {
  private final String estudiante;
  private final String asunto;
  private final int complejidad;
}
