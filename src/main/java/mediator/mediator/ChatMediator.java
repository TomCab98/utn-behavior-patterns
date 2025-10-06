package mediator.mediator;

import mediator.model.Usuario;

public interface ChatMediator {
  void enviarMensaje(String mensaje, Usuario usuario);
  void enviarMensajePrivado(String mensaje, Usuario emisor, Usuario receptor);
  void agregarUsuario(Usuario usuario);
  void mostrarUsuarios();
}
