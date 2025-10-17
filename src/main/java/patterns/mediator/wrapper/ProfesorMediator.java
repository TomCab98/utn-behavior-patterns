package patterns.mediator.wrapper;

import commons.model.Usuario;
import commons.services.LogColor;
import commons.services.Logger;
import lombok.Getter;
import patterns.mediator.mediator.ChatMediator;

@Getter
public class ProfesorMediator extends UsuarioMediator {
  private final Logger logger = Logger.getInstance();

  public ProfesorMediator(Usuario usuario, ChatMediator mediator) {
    super(usuario, mediator);
  }

  @Override
  public void enviar(String mensaje) {
    logger.info("\n[" + obtenerTimestamp() + "] Prof. " + usuario.getNombre() + ": " + LogColor.WHITE_CURSIVE.getColor() + mensaje + LogColor.RESET.getColor());
    mediator.enviarMensaje(mensaje, this);
  }

  @Override
  public void enviarPrivado(String mensaje, UsuarioMediator receptor) {
    logger.info("\n[" + obtenerTimestamp() + "] Prof. " + usuario.getNombre() + " envia mensaje privado a " + receptor.getUsuario().getNombre());
    mediator.enviarMensajePrivado(mensaje, this, receptor);
  }

  @Override
  public void recibir(String mensaje, UsuarioMediator emisor) {
    String mensajeCompleto = "[" + obtenerTimestamp() + "] De " + emisor.getUsuario().getNombre() + ": " + mensaje;
    historialMensajes.add(mensajeCompleto);
    logger.log("Prof. " + usuario.getNombre() + " recibio el mensaje", LogColor.SKY);
  }
}
