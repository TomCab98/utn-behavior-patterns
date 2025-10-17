package patterns.state.state;

import commons.model.CambioEstadoInscripcion;
import patterns.state.wrapper.InscripcionState;

public interface EstadoInscripcion {

  void inscribir(InscripcionState inscripcion, String motivo);

  void ponerEnEspera(InscripcionState inscripcion, String motivo);

  void cancelar(InscripcionState inscripcion, String motivo);

  CambioEstadoInscripcion generarNuevoEstado(EstadoInscripcion estado, String motivo);

  String getNombre();
}
