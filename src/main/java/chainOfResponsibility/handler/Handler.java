package chainOfResponsibility.handler;

import chainOfResponsibility.model.Solicitud;

public interface Handler {
  void setNext(Handler next);
  void handle(Solicitud s);
}
