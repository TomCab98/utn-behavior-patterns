package commons.services;

public class Logger {

  private static Logger instance;

  private Logger() {
  }

  public static Logger getInstance() {
    if (instance == null) {
      instance = new Logger();
    }

    return instance;
  }

  public void log(String mensaje, LogColor color) {
    System.out.println(color.getColor() + mensaje + LogColor.RESET.getColor());
  }

  public void info(String mensaje) {
    System.out.println(mensaje);
  }

  public void error(String mensaje) {
    System.out.println(LogColor.RED.getColor() + mensaje + LogColor.RESET.getColor());
  }

  public void warn(String mensaje) {
    System.out.println(LogColor.YELLOW_SHINE.getColor() + mensaje + LogColor.RESET.getColor());
  }

  public void br() {
    System.out.println();
  }
}
