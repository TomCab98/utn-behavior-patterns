package patterns.state.state;

import commons.model.CambioEstadoInscripcion;
import commons.services.Logger;
import patterns.state.wrapper.InscripcionState;

public class EstadoCancelado implements EstadoInscripcion {

  private final Logger logger = Logger.getInstance();

  @Override
  public void inscribir(InscripcionState inscripcion, String motivo) {
    logger.info("Reactivando inscripcion cancelada");
    CambioEstadoInscripcion nuevoEstado = generarNuevoEstado(new EstadoInscripto(), motivo);
    inscripcion.getCambioEstadoInscripcion().add(nuevoEstado);
  }

  @Override
  public void ponerEnEspera(InscripcionState inscripcion, String motivo) {
    logger.info("Moviendo inscripcion a lista de espera");
    CambioEstadoInscripcion nuevoEstado = generarNuevoEstado(new EstadoEnEspera(), motivo);
    inscripcion.getCambioEstadoInscripcion().add(nuevoEstado);
  }

  @Override
  public void cancelar(InscripcionState inscripcion, String motivo) {
    logger.warn("El estado actual de la solicitud es 'Cancelado'");
  }

  @Override
  public String getNombre() {
    return "CANCELADO";
  }

  @Override
  public CambioEstadoInscripcion generarNuevoEstado(EstadoInscripcion estado, String motivo) {
    return CambioEstadoInscripcion.builder()
        .estado(estado)
        .motivo(motivo)
        .build();
  }
}
