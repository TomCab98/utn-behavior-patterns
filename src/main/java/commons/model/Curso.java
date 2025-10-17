package commons.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Curso {
  private final String codigo;
  private String nombre;
  private String horario;
  private int aula;
}
