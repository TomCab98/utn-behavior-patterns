package command.command;

import command.model.Alumno;
import command.model.Curso;
import command.service.SistemaAcademico;

public class InscribirseCursoCommand implements Command {
  private final SistemaAcademico sistema;
  private final Alumno alumno;
  private final Curso curso;

  public InscribirseCursoCommand(SistemaAcademico sistema, Alumno alumno, Curso curso) {
    this.sistema = sistema;
    this.alumno = alumno;
    this.curso = curso;
  }

  @Override
  public void execute() {
    sistema.inscribirAlumno(alumno, curso);
  }

  @Override
  public String getDescripcion() {
    return "Inscripciopn de " + alumno.getNombre() + " en " + curso.getNombre();
  }
}
