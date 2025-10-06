package chainOfResponsibility.handler;

import chainOfResponsibility.model.Solicitud;

public class Coordinador extends AbstractHandler {

  @Override
  public void handle(Solicitud solicitud) {
    System.out.println("Coordinador atendiendo: " + solicitud.getAsunto());
  }
}
