package patterns.observer.observer;

import commons.model.TipoNotificacion;

public interface Observer {

  void update(String mensaje, TipoNotificacion tipoCambio, String nombreCurso);

  String getNombre();
}
