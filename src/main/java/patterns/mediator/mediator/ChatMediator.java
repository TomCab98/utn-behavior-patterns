package patterns.mediator.mediator;

import patterns.mediator.wrapper.UsuarioMediator;

public interface ChatMediator {

  void enviarMensaje(String mensaje, UsuarioMediator usuario);

  void enviarMensajePrivado(String mensaje, UsuarioMediator emisor, UsuarioMediator receptor);

  void agregarUsuario(UsuarioMediator usuario);
}
