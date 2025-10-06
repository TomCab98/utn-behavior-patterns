package mediator.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import mediator.mediator.ChatMediator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class Usuario {
  protected String nombre;
  protected String id;
  protected ChatMediator mediator;
  protected List<String> historialMensajes;

  public Usuario(String id, String nombre, ChatMediator mediator) {
    this.id = id;
    this.nombre = nombre;
    this.mediator = mediator;
    this.historialMensajes = new ArrayList<>();
  }

  public abstract void enviar(String mensaje);
  public abstract void enviarPrivado(String mensaje, Usuario receptor);
  public abstract void recibir(String mensaje, Usuario emisor);

  public void mostrarHistorial() {
    System.out.println("\n--- Historial de " + nombre + " ---");
    if (historialMensajes.isEmpty()) {
      System.out.println("No hay mensajes.");
      return;
    }
    for (String msg : historialMensajes) {
      System.out.println(msg);
    }
  }

  protected String obtenerTimestamp() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    return LocalDateTime.now().format(formatter);
  }
}
