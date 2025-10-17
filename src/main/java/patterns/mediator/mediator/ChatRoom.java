package patterns.mediator.mediator;

import commons.services.Logger;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import patterns.mediator.wrapper.UsuarioMediator;

@Data
@SuperBuilder
public class ChatRoom implements ChatMediator {

  private final Logger logger = Logger.getInstance();
  private final List<UsuarioMediator> usuarioMediators = new ArrayList<>();
  private final String nombreSala;

  @Override
  public void agregarUsuario(UsuarioMediator usuarioMediator) {
    usuarioMediators.add(usuarioMediator);
    logger.info(usuarioMediator.getUsuario().getNombre() + " se ha unido a " + nombreSala);
  }

  @Override
  public void enviarMensaje(String mensaje, UsuarioMediator emisor) {
    for (UsuarioMediator usuarioMediator : usuarioMediators) {
      if (usuarioMediator != emisor) {
        usuarioMediator.recibir(mensaje, emisor);
      }
    }
  }

  @Override
  public void enviarMensajePrivado(String mensaje, UsuarioMediator emisor,
      UsuarioMediator receptor) {
    if (usuarioMediators.contains(receptor)) {
      receptor.recibir(mensaje, emisor);
    } else {
      logger.error("El usuario " + receptor.getUsuario().getNombre() + " no esta en la sala");
    }
  }
}
