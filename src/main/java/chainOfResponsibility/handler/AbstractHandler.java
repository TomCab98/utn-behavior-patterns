package chainOfResponsibility.handler;

import chainOfResponsibility.model.Solicitud;

public abstract class AbstractHandler implements Handler {
  protected Handler nextHandler;

  @Override
  public void setNext(Handler next) {
    this.nextHandler = next;
  }

  protected void pasarAlSiguiente(Solicitud s) {
    if (nextHandler != null) {
      nextHandler.handle(s);
    } else {
      System.err.println("Solicitud no encontrada");
    }
  }
}
