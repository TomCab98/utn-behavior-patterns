package patterns.memento.wrapper;

import commons.model.Examen;
import commons.services.Logger;
import java.time.format.DateTimeFormatter;
import lombok.Data;
import patterns.memento.memento.ExamenMemento;

@Data
public class ExamenWrapped {

  private final Logger logger = Logger.getInstance();
  private final Examen examen;

  public ExamenMemento save(String descripcion) {
    logger.info("Guardando progreso: " + descripcion);
    return ExamenMemento.builder()
        .respuestas(examen.getRespuestas())
        .preguntaActual(examen.getPreguntaActual())
        .descripcion(descripcion)
        .build();
  }

  public void restore(ExamenMemento memento) {
    if (memento == null) {
      logger.info("No hay estado guardado para restaurar");
      return;
    }

    examen.setRespuestas(memento.getRespuestas());
    examen.setPreguntaActual(memento.getPreguntaActual());
    examen.setFinalizado(false);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    logger.info("Estado restaurado desde: " + memento.getDescripcion());
    logger.info("Fecha del guardado: " + memento.getFechaGuardado().format(formatter));
    logger.info("Pregunta actual: " + (examen.getPreguntaActual() + 1));
    logger.info("Respuestas guardadas: " + examen.getRespuestas().size());
  }
}
