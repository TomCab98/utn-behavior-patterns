package iterator.iterator;

import iterator.model.Curso;

public interface CursoCollection {
  Iterator<Curso> createIterator();
}
