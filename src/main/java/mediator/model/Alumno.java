package mediator.model;

import mediator.mediator.ChatMediator;

public class Alumno extends Usuario {
  private String carrera;

  public Alumno(String id, String nombre, String carrera, ChatMediator mediator) {
    super(id, nombre, mediator);
    this.carrera = carrera;
  }

  @Override
  public void enviar(String mensaje) {
    System.out.println("\n👨‍🎓 [" + obtenerTimestamp() + "] " + nombre + " (Alumno) dice: " + mensaje);
    mediator.enviarMensaje(mensaje, this);
  }

  @Override
  public void enviarPrivado(String mensaje, Usuario receptor) {
    System.out.println("\n👨‍🎓 [" + obtenerTimestamp() + "] " + nombre + " (Alumno) envía mensaje privado a " + receptor.getNombre());
    mediator.enviarMensajePrivado(mensaje, this, receptor);
  }

  @Override
  public void recibir(String mensaje, Usuario emisor) {
    String mensajeCompleto = "[" + obtenerTimestamp() + "] De " + emisor.getNombre() + ": " + mensaje;
    historialMensajes.add(mensajeCompleto);
    System.out.println("   → " + nombre + " recibió el mensaje");
  }

  public String getCarrera() {
    return carrera;
  }
}
