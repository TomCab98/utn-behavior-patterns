package patterns.state.state;

import commons.model.CambioEstadoInscripcion;
import commons.services.Logger;
import patterns.state.wrapper.InscripcionState;

public class EstadoEnEspera implements EstadoInscripcion {

  private final Logger logger = Logger.getInstance();

  @Override
  public void inscribir(InscripcionState inscripcion, String motivo) {
    logger.info("Inscribiendo alumno en lista de espera");
    CambioEstadoInscripcion nuevoEstado = generarNuevoEstado(new EstadoInscripto(), motivo);
    inscripcion.getCambioEstadoInscripcion().add(nuevoEstado);
  }

  @Override
  public void ponerEnEspera(InscripcionState inscripcion, String motivo) {
    logger.warn("El estado actual de la solicitud es 'En espera'");

  }

  @Override
  public void cancelar(InscripcionState inscripcion, String motivo) {
    logger.info("Cancelando solicitud en espera");
    CambioEstadoInscripcion nuevoEstado = generarNuevoEstado(new EstadoCancelado(), motivo);
    inscripcion.getCambioEstadoInscripcion().add(nuevoEstado);
  }

  @Override
  public String getNombre() {
    return "EN ESPERA";
  }

  @Override
  public CambioEstadoInscripcion generarNuevoEstado(EstadoInscripcion estado, String motivo) {
    return CambioEstadoInscripcion.builder()
        .estado(estado)
        .motivo(motivo)
        .build();
  }
}
