package iterator.iterator;

import iterator.model.Curso;

import java.util.List;

public class CursoIterator implements Iterator<Curso> {
  private final List<Curso> cursos;
  private int posicion;

  public CursoIterator(List<Curso> cursos) {
    this.cursos = cursos;
    this.posicion = 0;
  }

  @Override
  public boolean hasNext() {
    return posicion < cursos.size();
  }

  @Override
  public Curso next() {
    if (!hasNext()) {
      throw new IndexOutOfBoundsException("No hay mas cursos");
    }
    Curso curso = cursos.get(posicion);
    posicion++;
    return curso;
  }
}
