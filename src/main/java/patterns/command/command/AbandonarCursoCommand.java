package patterns.command.command;

import commons.model.Alumno;
import commons.model.Curso;
import patterns.command.service.SistemaAcademico;

public class AbandonarCursoCommand implements Command {

  private final SistemaAcademico sistema;
  private final Alumno alumno;
  private final Curso curso;
  private boolean alumnoInscripto;

  public AbandonarCursoCommand(Alumno alumno, Curso curso) {
    this.sistema = SistemaAcademico.getInstance();
    this.alumno = alumno;
    this.curso = curso;
  }

  @Override
  public void execute() {
    alumnoInscripto = sistema.abandonarCurso(alumno, curso);
  }

  @Override
  public String getDescripcion() {
    if (alumnoInscripto) {
      return "Alumno " + alumno.getNombre() + " con legajo: " + alumno.getLegajo()
          + " se dado de baja en " + curso.getNombre();
    } else {
      return "El alumno " + alumno.getNombre() + " con legajo: " + alumno.getLegajo()
          + " no esta inscripto en " + curso.getNombre();
    }
  }
}
