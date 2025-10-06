package chainOfResponsibility.handler;

import chainOfResponsibility.model.Solicitud;

public class Asistente extends AbstractHandler {

  @Override
  public void handle(Solicitud solicitud) {
    if (solicitud.getComplejidad() == 1) {
      System.out.println("Asistente atendiendo: " + solicitud.getAsunto());
    } else {
      System.out.println("Asistente no puede atender: " + solicitud.getAsunto());
      pasarAlSiguiente(solicitud);
    }
  }
}
