package patterns.command.command;

import commons.model.Alumno;
import commons.model.Curso;
import patterns.command.service.SistemaAcademico;

public class SolicitarCertificadoCommand implements Command {

  private final SistemaAcademico sistema;
  private final Alumno alumno;
  private final Curso curso;
  private String certificado;

  public SolicitarCertificadoCommand(Alumno alumno, Curso curso) {
    this.sistema = SistemaAcademico.getInstance();
    this.alumno = alumno;
    this.curso = curso;
  }

  @Override
  public void execute() {
    certificado = sistema.emitirCertificado(alumno, curso);
  }

  @Override
  public String getDescripcion() {
    return certificado;
  }
}
