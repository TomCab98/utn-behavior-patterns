package patterns.memento.memento;

import commons.services.LogColor;
import commons.services.Logger;
import java.util.Stack;

public class HistorialExamen {

  private final Logger logger = Logger.getInstance();
  private final Stack<ExamenMemento> historial;
  private final String nombreAlumno;

  public HistorialExamen(String nombreAlumno) {
    this.historial = new Stack<>();
    this.nombreAlumno = nombreAlumno;
  }

  public void guardarEstado(ExamenMemento memento) {
    historial.push(memento);
    logger.info("Total de guardados: " + historial.size());
  }

  public ExamenMemento obtenerUltimoEstado() {
    if (historial.isEmpty()) {
      logger.warn("No hay estados guardados");
      return null;
    }
    return historial.pop();
  }

  public ExamenMemento verUltimoEstado() {
    if (historial.isEmpty()) {
      return null;
    }
    return historial.peek();
  }

  public void mostrarHistorial() {
    logger.log("\nHistorial de Guardados - " + nombreAlumno, LogColor.BLUE);
    if (historial.isEmpty()) {
      logger.warn("No hay estados guardados");
      return;
    }

    int i = 1;
    for (ExamenMemento m : historial) {
      logger.info(i + ". " + m);
      i++;
    }
  }

  public int cantidadGuardados() {
    return historial.size();
  }

  public void limpiarHistorial() {
    historial.clear();
    logger.info("Historial limpiado");
  }
}
