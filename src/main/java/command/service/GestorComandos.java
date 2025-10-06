package command.service;

import command.command.Command;

import java.util.ArrayList;
import java.util.List;

public class GestorComandos {
  private final List<Command> historialComandos = new ArrayList<>();

  public void ejecutarComando(Command comando) {
    comando.execute();
    historialComandos.add(comando);
  }

  public void mostrarHistorial() {
    System.out.println("\n --------- Historial de comandos ---------- ");

    if (historialComandos.isEmpty()) {
      System.out.println("No hay comandos ejecutados");
      return;
    }

    for (int i = 0; i < historialComandos.size(); i++) {
      System.out.println((i + 1) + ". " + historialComandos.get(i).getDescripcion());
    }

    System.out.println(" --------- Historial de comandos ---------- ");
  }

  public void limpiarHistorial() {
    historialComandos.clear();
    System.out.println("Historial limpio");
  }
}
