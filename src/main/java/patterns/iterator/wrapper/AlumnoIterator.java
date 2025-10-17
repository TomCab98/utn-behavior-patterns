package patterns.iterator.wrapper;

import commons.model.Alumno;
import commons.model.Curso;
import lombok.AllArgsConstructor;
import lombok.Data;
import patterns.iterator.iterator.CursoCollection;
import patterns.iterator.iterator.CursoIterator;
import patterns.iterator.iterator.Iterator;

@Data
@AllArgsConstructor
public class AlumnoIterator implements CursoCollection {

  private final Alumno alumno;

  @Override
  public Iterator<Curso> createIterator() {
    return new CursoIterator(alumno.getCursosInscritos());
  }
}
