package command.command;

import command.model.Alumno;
import command.model.Curso;
import command.service.SistemaAcademico;

public class SolicitarCertificadoCommand implements Command {
  private final SistemaAcademico sistema;
  private final Alumno alumno;
  private final Curso curso;

  public SolicitarCertificadoCommand(SistemaAcademico sistema, Alumno alumno, Curso curso) {
    this.sistema = sistema;
    this.alumno = alumno;
    this.curso = curso;
  }

  @Override
  public void execute() {
    sistema.emitirCertificado(alumno, curso);
  }

  @Override
  public String getDescripcion() {
    return "Solicitud de certificado de " + curso.getNombre() + " para " + alumno.getNombre();
  }
}
