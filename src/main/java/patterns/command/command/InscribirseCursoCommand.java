package patterns.command.command;

import commons.model.Alumno;
import commons.model.Curso;
import patterns.command.service.SistemaAcademico;

public class InscribirseCursoCommand implements Command {

  private final SistemaAcademico sistema;
  private final Alumno alumno;
  private final Curso curso;

  public InscribirseCursoCommand(Alumno alumno, Curso curso) {
    this.sistema = SistemaAcademico.getInstance();
    this.alumno = alumno;
    this.curso = curso;
  }

  @Override
  public void execute() {
    sistema.inscribirAlumno(alumno, curso);
  }

  @Override
  public String getDescripcion() {
    return "Alumno " + alumno.getNombre() + " con legajo: " + alumno.getLegajo() + " inscripto en "
        + curso.getNombre();
  }
}
