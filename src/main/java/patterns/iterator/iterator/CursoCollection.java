package patterns.iterator.iterator;

import commons.model.Curso;

public interface CursoCollection {

  Iterator<Curso> createIterator();
}
