package command.model;

import lombok.Data;

@Data
public class Alumno {
  private final int legajo;
  private final String nombre;
  private final String email;
}
