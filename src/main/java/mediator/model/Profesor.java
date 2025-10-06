package mediator.model;

import mediator.mediator.ChatMediator;

public class Profesor extends Alumno {
  private String departamento;

  public Profesor(String id, String nombre, String departamento, ChatMediator mediator) {
    super(id, nombre, mediator);
    this.departamento = departamento;
  }

  @Override
  public void enviar(String mensaje) {
    System.out.println("\n👨‍🏫 [" + obtenerTimestamp() + "] Prof. " + nombre + " dice: " + mensaje);
    mediator.enviarMensaje(mensaje, this);
  }

  @Override
  public void enviarPrivado(String mensaje, Usuario receptor) {
    System.out.println("\n👨‍🏫 [" + obtenerTimestamp() + "] Prof. " + nombre + " envía mensaje privado a " + receptor.getNombre());
    mediator.enviarMensajePrivado(mensaje, this, receptor);
  }

  @Override
  public void recibir(String mensaje, Usuario emisor) {
    String mensajeCompleto = "[" + obtenerTimestamp() + "] De " + emisor.getNombre() + ": " + mensaje;
    historialMensajes.add(mensajeCompleto);
    System.out.println("   → Prof. " + nombre + " recibió el mensaje");
  }

  public String getDepartamento() {
    return departamento;
  }
}
