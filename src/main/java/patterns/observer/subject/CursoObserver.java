package patterns.observer.subject;

import commons.model.Curso;
import commons.model.TipoNotificacion;
import commons.services.LogColor;
import commons.services.Logger;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import patterns.observer.observer.Observer;

@Data
@Builder
public class CursoObserver implements Subject {

  private final Logger logger = Logger.getInstance();
  private final Curso curso;

  @Builder.Default
  private List<Observer> observadores = new ArrayList<>();

  @Builder.Default
  private List<String> avisos = new ArrayList<>();

  @Override
  public void suscribir(Observer observer) {
    if (!observadores.contains(observer)) {
      observadores.add(observer);
      logger.info("El alumno " + observer.getNombre() + " se ha suscrito a " + curso.getNombre());
    } else {
      logger.info("El alumno " + observer.getNombre() + " ya esta suscrito a " + curso.getNombre());
    }
  }

  @Override
  public void desuscribir(Observer observer) {
    if (observadores.remove(observer)) {
      System.out.println(
          "El alumno " + observer.getNombre() + " se ha desuscrito de " + curso.getNombre());
    } else {
      System.out.println(
          "El alumno " + observer.getNombre() + " no estaba suscrito a " + curso.getNombre());
    }
  }

  @Override
  public void notificar(String mensaje, TipoNotificacion tipoCambio) {
    System.out.println(
        "Notificando a " + observadores.size() + " alumno(s) de " + curso.getNombre());
    for (Observer observer : observadores) {
      observer.update(mensaje, tipoCambio, curso.getNombre());
    }
  }

  public void cambiarHorario(String nuevoHorario) {
    String horarioAnterior = curso.getHorario();
    curso.setHorario(nuevoHorario);
    String mensaje = "Horario cambiado de '" + horarioAnterior + "' a '" + nuevoHorario + "'";
    notificar(mensaje, TipoNotificacion.CAMBIO_HORARIO);
  }

  public void cambiarAula(int nuevaAula) {
    int aulaAnterior = curso.getAula();
    curso.setAula(nuevaAula);
    String mensaje = "Aula cambiada de '" + aulaAnterior + "' a '" + nuevaAula + "'";
    notificar(mensaje, TipoNotificacion.CAMBIO_AULA);
  }

  public void publicarAviso(String aviso) {
    avisos.add(aviso);
    notificar(aviso, TipoNotificacion.NUEVO_AVISO);
  }

  public void cancelarClase(String fecha, String motivo) {
    String mensaje = "Clase del " + fecha + " cancelada. Motivo: " + motivo;
    notificar(mensaje, TipoNotificacion.CANCELACION);
  }

  public void asignarTarea(String descripcion, String fechaEntrega) {
    String mensaje = "Nueva tarea: " + descripcion + " - Entrega: " + fechaEntrega;
    notificar(mensaje, TipoNotificacion.NUEVA_TAREA);
  }

  public void programarExamen(String fecha, String temas) {
    String mensaje = "Examen programado para " + fecha + " - Temas: " + temas;
    notificar(mensaje, TipoNotificacion.EXAMEN_PROGRAMADO);
  }

  public void mostrarInfo() {
    logger.log("\nInformacion del Curso:", LogColor.BLUE);
    logger.info("Codigo: " + curso.getCodigo());
    logger.info("Nombre: " + curso.getNombre());
    logger.info("Horario: " + curso.getHorario());
    logger.info("Aula: " + curso.getAula());
    logger.info("Alumnos suscritos: " + observadores.size());
  }
}
