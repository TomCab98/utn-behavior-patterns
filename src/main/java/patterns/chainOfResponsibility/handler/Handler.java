package patterns.chainOfResponsibility.handler;

import commons.model.Solicitud;

public interface Handler {

  void setNext(Handler next);

  void handle(Solicitud s);
}
