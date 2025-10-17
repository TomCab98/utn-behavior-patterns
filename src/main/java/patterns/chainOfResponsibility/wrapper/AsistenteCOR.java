package patterns.chainOfResponsibility.wrapper;

import commons.model.Asistente;
import commons.model.Solicitud;
import commons.services.LogColor;
import commons.services.Logger;
import lombok.AllArgsConstructor;
import patterns.chainOfResponsibility.handler.AbstractHandler;

@AllArgsConstructor
public class AsistenteCOR extends AbstractHandler {

  private final Asistente asistente;
  private final Logger LOGGER = Logger.getInstance();

  @Override
  public void handle(Solicitud solicitud) {
    if (solicitud.getComplejidad() == 1) {
      LOGGER.log(
          "La solicitud " + solicitud.getCodigo() + ": " + solicitud.getAsunto()
              + " esta siendo atendida por " + asistente.getNombre(),
          LogColor.GREEN
      );
    } else {
      LOGGER.error("Asistente " + asistente.getNombre() + " no puede atender: Solicitud "
          + solicitud.getAsunto());
      next(solicitud);
    }
  }
}
