package patterns.chainOfResponsibility.wrapper;

import commons.model.Profesor;
import commons.model.Solicitud;
import commons.services.LogColor;
import commons.services.Logger;
import lombok.AllArgsConstructor;
import patterns.chainOfResponsibility.handler.AbstractHandler;

@AllArgsConstructor
public class ProfesorCOR extends AbstractHandler {

  private final Logger LOGGER = Logger.getInstance();
  private Profesor profesor;

  @Override
  public void handle(Solicitud solicitud) {
    if (solicitud.getComplejidad() <= 2) {
      LOGGER.log(
          "La solicitud " + solicitud.getCodigo() + ": " + solicitud.getAsunto()
              + " esta siendo atendida por " + profesor.getNombre(),
          LogColor.GREEN
      );
    } else {
      LOGGER.error("Profesor " + profesor.getNombre() + " no puede atender: Solicitud "
          + solicitud.getAsunto());
      next(solicitud);
    }
  }
}
