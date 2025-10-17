package patterns.observer.subject;

import commons.model.TipoNotificacion;
import patterns.observer.observer.Observer;

public interface Subject {

  void suscribir(Observer observer);

  void desuscribir(Observer observer);

  void notificar(String mensaje, TipoNotificacion tipoCambio);
}
