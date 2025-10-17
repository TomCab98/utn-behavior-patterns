package patterns.chainOfResponsibility.handler;


import commons.model.Solicitud;
import commons.services.Logger;

public abstract class AbstractHandler implements Handler {

  private final Logger LOGGER = Logger.getInstance();
  protected Handler nextHandler;

  @Override
  public void setNext(Handler next) {
    this.nextHandler = next;
  }

  protected void next(Solicitud solicitud) {
    if (nextHandler != null) {
      nextHandler.handle(solicitud);
    } else {
      LOGGER.error("Solicitud no encontrada");
    }
  }
}
