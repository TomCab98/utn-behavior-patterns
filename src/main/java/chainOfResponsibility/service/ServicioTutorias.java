package chainOfResponsibility.service;

import chainOfResponsibility.handler.Asistente;
import chainOfResponsibility.handler.Coordinador;
import chainOfResponsibility.handler.Handler;
import chainOfResponsibility.handler.Profesor;

public class ServicioTutorias {
  public static ServicioTutorias servicioTutorias;

  private ServicioTutorias() {}

  public static ServicioTutorias getServicioTutorias() {
    if (servicioTutorias == null) {
      servicioTutorias = new ServicioTutorias();
    }

    return servicioTutorias;
  }

  public Handler getChainHandler() {
    Handler asistente = new Asistente();
    Handler profesor = new Profesor();
    Handler coordinador  = new Coordinador();

    asistente.setNext(profesor);
    profesor.setNext(coordinador);

    return asistente;
  }
}
