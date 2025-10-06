package chainOfResponsibility;

import chainOfResponsibility.handler.Handler;
import chainOfResponsibility.model.Solicitud;
import chainOfResponsibility.service.ServicioTutorias;

public class Main {
  public static void main(String[] args) {

    ServicioTutorias servicioTutorias = ServicioTutorias.getServicioTutorias();
    Handler asistente = servicioTutorias.getChainHandler();

    Solicitud solicitud1 = new Solicitud("Estudiante 1", "Solicitud 1", 1);
    Solicitud solicitud2 = new Solicitud("Estudiante 2", "Solicitud 2", 2);
    Solicitud solicitud3 = new Solicitud("Estudiante 3", "Solicitud 3", 3);

    System.out.println("\n ---- Sistema de solicitud de tutorias ---------- ");

    System.out.println();
    asistente.handle(solicitud1);

    System.out.println();
    asistente.handle(solicitud2);

    System.out.println();
    asistente.handle(solicitud3);

    System.out.println("\n ---- Sistema de solicitud de tutorias ---------- ");
  }
}
