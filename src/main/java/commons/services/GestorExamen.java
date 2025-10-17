package commons.services;

import commons.model.Examen;
import commons.model.PreguntaExamen;
import java.util.Map;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GestorExamen {

  private final Logger logger = Logger.getInstance();
  private final Examen examen;

  public void responderPregunta(int numeroPregunta, int respuesta) {
    if (examen.isFinalizado()) {
      logger.warn("El examen ya ha sido finalizado");
      return;
    }

    examen.getRespuestas().put(numeroPregunta, respuesta);
    logger.info("Respuesta seleccionada: " + (respuesta + 1));
  }

  public void avanzarPregunta() {
    int preguntaActual = examen.getPreguntaActual();
    if (preguntaActual < examen.getPreguntas().size() - 1) {
      examen.setPreguntaActual(++preguntaActual);
      logger.info("Avanzando a pregunta " + (preguntaActual + 1));
    } else {
      logger.info("Ya estás en la última pregunta");
    }
  }

  public void retrocederPregunta() {
    int preguntaActual = examen.getPreguntaActual();
    if (preguntaActual > 0) {
      examen.setPreguntaActual(--preguntaActual);
      logger.info("Retrocediendo a pregunta " + (preguntaActual + 1));
    } else {
      logger.info("Ya estás en la primera pregunta");
    }
  }

  public void finalizarExamen() {
    examen.setFinalizado(true);
    logger.info("\nEXAMEN FINALIZADO");
    logger.log("Calificacion final: " + calcularCalificacion() + "%",
        calcularCalificacion() >= 60 ? LogColor.GREEN : LogColor.RED);
  }

  public void mostrarProgreso() {
    logger.info("\n--- Progreso del Examen: " + examen.getTitulo() + " ---");
    logger.info(
        "Pregunta actual: " + (examen.getPreguntaActual() + 1) + " de " + examen.getPreguntas()
            .size());
    logger.info(
        "Respuestas completadas: " + examen.getRespuestas().size() + " de " + examen.getPreguntas()
            .size());
    logger.info("Estado: " + (examen.isFinalizado() ? "Finalizado" : "En progreso"));
    logger.br();
  }

  public void mostrarPreguntaActual() {
    if (examen.getPreguntaActual() >= examen.getPreguntas().size()) {
      logger.info("No hay más preguntas");
      return;
    }

    PreguntaExamen p = examen.getPreguntas().get(examen.getPreguntaActual());
    logger.info("--- Pregunta " + (examen.getPreguntaActual() + 1) + " ---");
    logger.info(p.getEnunciado());
    for (int i = 0; i < p.getOpciones().size(); i++) {
      logger.info("  " + (i + 1) + ". " + p.getOpciones().get(i));
    }
    logger.br();
  }

  private int calcularCalificacion() {
    int correctas = 0;
    for (Map.Entry<Integer, Integer> entry : examen.getRespuestas().entrySet()) {
      int numPregunta = entry.getKey();
      int respuesta = entry.getValue();

      PreguntaExamen pregunta = examen.getPreguntas().stream()
          .filter(p -> p.getNumero() == numPregunta)
          .findFirst()
          .orElse(null);

      if (pregunta != null && pregunta.esCorrecta(respuesta)) {
        correctas++;
      }
    }

    return (int) ((correctas * 100.0) / examen.getPreguntas().size());
  }
}
