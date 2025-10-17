package patterns.command.service;

import commons.services.LogColor;
import commons.services.Logger;
import java.util.ArrayList;
import java.util.List;
import patterns.command.command.Command;

public class GestorComandos {

  private final Logger LOGGER = Logger.getInstance();
  private final List<Command> historialComandos = new ArrayList<>();

  public void ejecutarComando(Command comando) {
    comando.execute();
    LOGGER.info(comando.getDescripcion());
    historialComandos.add(comando);
  }

  public void mostrarHistorial() {
    LOGGER.log("\nHistorial de comandos:", LogColor.TITLE);

    if (historialComandos.isEmpty()) {
      LOGGER.error("No hay comandos ejecutados");
      return;
    }

    for (int i = 0; i < historialComandos.size(); i++) {
      LOGGER.info((i + 1) + ". " + historialComandos.get(i).getDescripcion());
    }
  }

  public void limpiarHistorial() {
    historialComandos.clear();
    LOGGER.info("Historial limpio");
  }
}
