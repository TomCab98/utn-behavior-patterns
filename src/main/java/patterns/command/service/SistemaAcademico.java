package patterns.command.service;

import commons.model.Alumno;
import commons.model.Curso;

public class SistemaAcademico {

  private static SistemaAcademico instance;

  private SistemaAcademico() {
  }

  public static SistemaAcademico getInstance() {
    if (instance == null) {
      instance = new SistemaAcademico();
    }
    return instance;
  }

  public void inscribirAlumno(Alumno alumno, Curso curso) {
    alumno.inscribirCurso(curso);
  }

  public boolean abandonarCurso(Alumno alumno, Curso curso) {
    return alumno.eliminarCurso(curso);
  }

  public String emitirCertificado(Alumno alumno, Curso curso) {
    return "CERTIFICADO: Curso " + curso.getNombre() + " finalizado por el alumno "
        + alumno.getNombre() + " con legajo " + alumno.getLegajo();
  }
}
