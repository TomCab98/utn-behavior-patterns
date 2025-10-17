package patterns.state.state;

import commons.model.CambioEstadoInscripcion;
import commons.services.Logger;
import patterns.state.wrapper.InscripcionState;

public class EstadoInscripto implements EstadoInscripcion {

  private final Logger logger = Logger.getInstance();

  @Override
  public void inscribir(InscripcionState inscripcion, String motivo) {
    logger.warn("El estado actual de la solicitud es 'Inscripto'");
  }

  @Override
  public void ponerEnEspera(InscripcionState inscripcion, String motivo) {
    logger.warn("No se puede poner en lista de espera una solicitud confirmada");
  }

  @Override
  public void cancelar(InscripcionState inscripcion, String motivo) {
    logger.info("Cancelando solicitud confirmada");
    CambioEstadoInscripcion nuevoEstado = generarNuevoEstado(new EstadoCancelado(), motivo);
    inscripcion.getCambioEstadoInscripcion().add(nuevoEstado);
  }

  @Override
  public String getNombre() {
    return "INSCRIPTO";
  }

  @Override
  public CambioEstadoInscripcion generarNuevoEstado(EstadoInscripcion estado, String motivo) {
    return CambioEstadoInscripcion.builder()
        .estado(estado)
        .motivo(motivo)
        .build();
  }
}
