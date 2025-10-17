package patterns.observer.observer;

import commons.model.Alumno;
import commons.model.Notificacion;
import commons.model.TipoNotificacion;
import commons.services.LogColor;
import commons.services.Logger;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlumnoObserver implements Observer {

  private final Logger logger = Logger.getInstance();
  private final Alumno alumno;

  @Builder.Default
  private List<Notificacion> notificaciones = new ArrayList<>();

  @Builder.Default
  private boolean notificacionesActivas = true;

  @Override
  public void update(String mensaje, TipoNotificacion tipoCambio, String nombreCurso) {
    if (!notificacionesActivas) {
      return;
    }

    Notificacion notificacion = Notificacion.builder()
        .nombreCurso(nombreCurso)
        .mensaje(mensaje)
        .tipoCambio(tipoCambio)
        .build();

    notificaciones.add(notificacion);

    logger.log(alumno.getNombre() + " recibio una nueva notificacion", LogColor.SKY);
  }

  @Override
  public String getNombre() {
    return alumno.getNombre();
  }

  public void activarNotificaciones() {
    notificacionesActivas = true;
    logger.info("Notificaciones activadas para " + alumno.getNombre());
  }

  public void desactivarNotificaciones() {
    notificacionesActivas = false;
    logger.info("Notificaciones desactivadas para " + alumno.getNombre());
  }

  public void mostrarNotificaciones() {
    logger.log("\nNotificaciones de " + alumno.getNombre(), LogColor.BLUE);
    if (notificaciones.isEmpty()) {
      logger.warn("No hay notificaciones");
      return;
    }

    for (int i = notificaciones.size() - 1; i >= 0; i--) {
      logger.info((notificaciones.size() - i) + ". " + notificaciones.get(i));
    }
  }

  public void mostrarUltimasNotificaciones(int cantidad) {
    logger.log("\nUltimas " + cantidad + " notificaciones de " + alumno.getNombre(), LogColor.BLUE);
    int inicio = Math.max(0, notificaciones.size() - cantidad);

    if (notificaciones.isEmpty()) {
      System.out.println("No hay notificaciones");
      return;
    }

    for (int i = notificaciones.size() - 1; i >= inicio; i--) {
      System.out.println((notificaciones.size() - i) + ". " + notificaciones.get(i));
    }
  }

  public void limpiarNotificaciones() {
    int cantidad = notificaciones.size();
    notificaciones.clear();
    logger.info(cantidad + " notificaciones eliminadas");
  }
}
