package patterns.chainOfResponsibility.wrapper;

import commons.model.Coordinador;
import commons.model.Solicitud;
import commons.services.LogColor;
import commons.services.Logger;
import lombok.AllArgsConstructor;
import patterns.chainOfResponsibility.handler.AbstractHandler;

@AllArgsConstructor
public class CoordinadorCOR extends AbstractHandler {

  private final Logger LOGGER = Logger.getInstance();
  private final Coordinador coordinador;

  @Override
  public void handle(Solicitud solicitud) {
    LOGGER.log(
        "La solicitud " + solicitud.getCodigo() + ": " + solicitud.getAsunto()
            + " esta siendo atendida por " + coordinador.getNombre(),
        LogColor.GREEN
    );
  }
}
