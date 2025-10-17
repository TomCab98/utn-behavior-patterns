package patterns.mediator.wrapper;

import commons.services.LogColor;
import commons.model.Usuario;
import commons.services.Logger;
import lombok.Data;
import patterns.mediator.mediator.ChatMediator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public abstract class UsuarioMediator {
  private final Logger logger = Logger.getInstance();
  protected Usuario usuario;
  protected ChatMediator mediator;
  protected List<String> historialMensajes;

  public UsuarioMediator(Usuario usuario, ChatMediator mediator) {
    this.usuario = usuario;
    this.mediator = mediator;
    this.historialMensajes = new ArrayList<>();
  }

  public abstract void enviar(String mensaje);
  public abstract void enviarPrivado(String mensaje, UsuarioMediator receptor);
  public abstract void recibir(String mensaje, UsuarioMediator emisor);

  public void mostrarHistorial() {
    logger.log("\nHistorial de " + usuario.getNombre(), LogColor.BLUE);
    if (historialMensajes.isEmpty()) {
      logger.error("No hay mensajes");
      return;
    }
    for (String msg : historialMensajes) {
      logger.info(msg);
    }
  }

  protected String obtenerTimestamp() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    return LocalDateTime.now().format(formatter);
  }
}
