package chainOfResponsibility.handler;

import chainOfResponsibility.model.Solicitud;

public class Profesor extends AbstractHandler {

  @Override
  public void handle(Solicitud solicitud) {
    if (solicitud.getComplejidad() <= 2) {
      System.out.println("Profesor atendiendo: " + solicitud.getAsunto());
    } else {
      System.out.println("Profesor no puede atender: " + solicitud.getAsunto());
      pasarAlSiguiente(solicitud);
    }
  }
}
