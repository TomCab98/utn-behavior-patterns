package iterator.model;

import iterator.iterator.CursoCollection;
import iterator.iterator.CursoIterator;
import iterator.iterator.Iterator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Alumno implements CursoCollection {
  private final String nombre;
  private final String codigo;
  private final List<Curso> cursosInscritos;

  public Alumno(String codigo, String nombre) {
    this.codigo = codigo;
    this.nombre = nombre;
    this.cursosInscritos = new ArrayList<>();
  }

  public void inscribirCurso(Curso curso) {
    cursosInscritos.add(curso);
    System.out.println(nombre + " inscrito en: " + curso.getNombre());
  }

  public void eliminarCurso(Curso curso) {
    cursosInscritos.remove(curso);
    System.out.println(nombre + " elimino: " + curso.getNombre());
  }

  public int getCantidadCursos() {
    return cursosInscritos.size();
  }

  public int getTotalCreditos() {
    int total = 0;
    Iterator<Curso> iterator = createIterator();
    while (iterator.hasNext()) {
      total += iterator.next().getCreditos();
    }
    return total;
  }

  @Override
  public Iterator<Curso> createIterator() {
    return new CursoIterator(cursosInscritos);
  }
}
