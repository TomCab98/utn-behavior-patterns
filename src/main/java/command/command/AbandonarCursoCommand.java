package command.command;

import command.model.Alumno;
import command.model.Curso;
import command.service.SistemaAcademico;

public class AbandonarCursoCommand implements Command {
  private final SistemaAcademico sistema;
  private final Alumno alumno;
  private final Curso curso;

  public AbandonarCursoCommand(SistemaAcademico sistema, Alumno alumno, Curso curso) {
    this.sistema = sistema;
    this.alumno = alumno;
    this.curso = curso;
  }

  @Override
  public void execute() {
    sistema.abandonarCurso(alumno, curso);
  }

  @Override
  public String getDescripcion() {
    return "Abandono de curso " + curso.getNombre() + " por " + alumno.getNombre();
  }
}
