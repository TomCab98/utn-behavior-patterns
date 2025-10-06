package command.service;

import command.model.Alumno;
import command.model.Curso;

public class SistemaAcademico {

  public void inscribirAlumno(Alumno alumno, Curso curso) {
    System.out.println("Alumno " + alumno.getNombre() + " inscrito en el curso: " + curso.getNombre());
  }

  public void abandonarCurso(Alumno alumno, Curso curso) {
    System.out.println("Alumno " + alumno.getNombre() + " ha abandonado el curso: " + curso.getNombre());
  }

  public void emitirCertificado(Alumno alumno, Curso curso) {
    System.out.println("Certificado del curso: " + curso.getNombre() +" emitido para " + alumno.getNombre());
  }
}
