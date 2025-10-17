package commons.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class Alumno extends Usuario {
  private final String carrera;
  private final List<Curso> cursosInscritos = new ArrayList<>();

  public void inscribirCurso(Curso curso) {
    if (!cursosInscritos.contains(curso)) {
      cursosInscritos.add(curso);
    }
  }

  public boolean eliminarCurso(Curso curso) {
    return cursosInscritos.remove(curso);
  }
}
