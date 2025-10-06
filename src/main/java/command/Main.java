package command;

import command.command.AbandonarCursoCommand;
import command.command.Command;
import command.command.InscribirseCursoCommand;
import command.command.SolicitarCertificadoCommand;
import command.model.Alumno;
import command.model.Curso;
import command.service.GestorComandos;
import command.service.SistemaAcademico;

public class Main {
  public static void main(String[] args) {
    SistemaAcademico sistema = new SistemaAcademico();
    GestorComandos gestor = new GestorComandos();

    Alumno alumno1 = new Alumno(1, "Juan Perez", "juan.perez@email.com");
    Alumno alumno2 = new Alumno(2, "Juana Garcia", "maria.garcia@email.com");

    Curso cursoJava = new Curso("CS101", "Programacion en Java");
    Curso cursoPOO = new Curso("CS202", "Programacion Orientada a Objetos");
    Curso cursoPatrones = new Curso("CS303", "Patrones de Disenio");

    System.out.println("\n ----------- SISTEMA DE GESTION DE CURSOS -----------");

    Command cmd1 = new InscribirseCursoCommand(sistema, alumno1, cursoJava);
    gestor.ejecutarComando(cmd1);

    Command cmd2 = new InscribirseCursoCommand(sistema, alumno1, cursoPOO);
    gestor.ejecutarComando(cmd2);

    Command cmd3 = new InscribirseCursoCommand(sistema, alumno2, cursoPatrones);
    gestor.ejecutarComando(cmd3);

    Command cmd4 = new AbandonarCursoCommand(sistema, alumno1, cursoPOO);
    gestor.ejecutarComando(cmd4);

    Command cmd5 = new SolicitarCertificadoCommand(sistema, alumno1, cursoJava);
    gestor.ejecutarComando(cmd5);

    Command cmd6 = new SolicitarCertificadoCommand(sistema, alumno2, cursoPatrones);
    gestor.ejecutarComando(cmd6);

    gestor.mostrarHistorial();

    System.out.println("\n ----------- SISTEMA DE GESTION DE CURSOS -----------");
  }
}
