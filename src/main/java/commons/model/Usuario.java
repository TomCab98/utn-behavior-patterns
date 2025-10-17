package commons.model;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class Usuario {
  private final int legajo;
  private final String nombre;
  private final String apellido;
  private final String email;
}
