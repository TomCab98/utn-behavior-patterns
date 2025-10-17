package patterns.state.wrapper;

import commons.model.CambioEstadoInscripcion;
import commons.model.Inscripcion;
import commons.services.Logger;
import java.util.ArrayList;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import patterns.state.state.EstadoEnEspera;
import patterns.state.state.EstadoInscripcion;

@Data
@Builder
public class InscripcionState {

  private final Logger logger = Logger.getInstance();
  private final Inscripcion inscripcion;

  @Builder.Default
  private List<CambioEstadoInscripcion> cambioEstadoInscripcion = defaultEstado();

  private static List<CambioEstadoInscripcion> defaultEstado() {
    List<CambioEstadoInscripcion> estados = new ArrayList<>();
    estados.add(
        CambioEstadoInscripcion.builder()
            .estado(new EstadoEnEspera())
            .motivo("")
            .build()
    );
    return estados;
  }

  public EstadoInscripcion obtenerEstadoActual() {
    return cambioEstadoInscripcion.getLast().getEstado();
  }

  public void inscribir(String motivo) {
    obtenerEstadoActual().inscribir(this, motivo);
  }

  public void ponerEnEspera(String motivo) {
    obtenerEstadoActual().ponerEnEspera(this, motivo);
  }

  public void cancelar(String motivo) {
    obtenerEstadoActual().cancelar(this, motivo);
  }

  public void mostrarEstadoActual() {
    logger.info("Codigo de solicitud: " + inscripcion.getCodigo() + "\n\tNombre del alumno: "
        + inscripcion.getAlumno() + "\n\tCurso solicitado: " + inscripcion.getCurso().getCodigo()
        + " - " + inscripcion.getCurso().getNombre() + "\n\tFecha de solicitud: "
        + inscripcion.getFechaInscripcion() + "\n\tEstado de solicitud: "
        + cambioEstadoInscripcion.getLast().getEstado().getNombre());
  }
}
