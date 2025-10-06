package iterator;

import iterator.iterator.Iterator;
import iterator.model.Alumno;
import iterator.model.Curso;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    System.out.println("\n ----------- SISTEMA DE CURSOS --------- \n");

    Alumno alumno = new Alumno("A001", "Juan Perez");

    Curso curso1 = new Curso("CS101", "Introduccion a la Programacion", 4);
    Curso curso2 = new Curso("CS102", "Estructura de Datos", 5);
    Curso curso3 = new Curso("MAT201", "Calculo I", 6);
    Curso curso4 = new Curso("CS201", "Programacion orientada a objetos", 4);
    Curso curso5 = new Curso("CS301", "Patrones de Disenio", 3);

    System.out.println("--- Inscripcion de Cursos ---");
    alumno.inscribirCurso(curso1);
    alumno.inscribirCurso(curso2);
    alumno.inscribirCurso(curso3);
    alumno.inscribirCurso(curso4);
    alumno.inscribirCurso(curso5);

    System.out.println("\n--- Cursos Inscritos ---");
    Iterator<Curso> iterator = alumno.createIterator();
    int contador = 1;

    while (iterator.hasNext()) {
      Curso curso = iterator.next();
      System.out.println(contador + ". " + curso);
      contador++;
    }

    // Mostrar estadísticas usando el iterator
    System.out.println("\n--- Estadisticas ---");
    System.out.println("Total de cursos: " + alumno.getCantidadCursos());
    System.out.println("Total de creditos: " + alumno.getTotalCreditos());

    System.out.println("\n--- Despues de eliminar un curso ---");
    alumno.eliminarCurso(curso3);

    Iterator<Curso> nuevoIterator = alumno.createIterator();
    contador = 1;
    while (nuevoIterator.hasNext()) {
      Curso curso = nuevoIterator.next();
      System.out.println(contador + ". " + curso);
      contador++;
    }

    System.out.println("\nTotal de creditos actualizado: " + alumno.getTotalCreditos());
  }
}
