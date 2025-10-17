import commons.model.Alumno;
import commons.model.Asistente;
import commons.model.Coordinador;
import commons.model.Curso;
import commons.model.Examen;
import commons.model.Inscripcion;
import commons.model.PreguntaExamen;
import commons.model.Profesor;
import commons.model.Solicitud;
import commons.services.GestorExamen;
import commons.services.LogColor;
import commons.services.Logger;
import java.util.Arrays;
import java.util.List;
import patterns.chainOfResponsibility.handler.Handler;
import patterns.chainOfResponsibility.wrapper.AsistenteCOR;
import patterns.chainOfResponsibility.wrapper.CoordinadorCOR;
import patterns.chainOfResponsibility.wrapper.ProfesorCOR;
import patterns.command.command.AbandonarCursoCommand;
import patterns.command.command.Command;
import patterns.command.command.InscribirseCursoCommand;
import patterns.command.command.SolicitarCertificadoCommand;
import patterns.command.service.GestorComandos;
import patterns.iterator.iterator.Iterator;
import patterns.iterator.wrapper.AlumnoIterator;
import patterns.mediator.mediator.ChatRoom;
import patterns.mediator.wrapper.AlumnoMediator;
import patterns.mediator.wrapper.ProfesorMediator;
import patterns.memento.memento.ExamenMemento;
import patterns.memento.memento.HistorialExamen;
import patterns.memento.wrapper.ExamenWrapped;
import patterns.observer.observer.AlumnoObserver;
import patterns.observer.subject.CursoObserver;
import patterns.state.wrapper.InscripcionState;

public class Main {

  public static void main(String[] args) {
    final Logger logger = Logger.getInstance();

    Asistente asistente1 = Asistente.builder()
        .legajo(1)
        .nombre("Mario Lopez")
        .departamento("Basicas")
        .build();

    Profesor profesor1 = Profesor.builder()
        .legajo(1)
        .nombre("Juan Miraflores")
        .departamento("Algebra y geometria analitica")
        .build();

    Profesor profesor2 = Profesor.builder()
        .legajo(2)
        .nombre("Julian Peralta")
        .departamento("Desarrollo de software")
        .build();

    Coordinador coordinador1 = Coordinador.builder()
        .legajo(1)
        .nombre("Jorge Miranda")
        .departamento("Analisis matematico 1")
        .build();

    Alumno alumno1 = Alumno.builder()
        .legajo(1)
        .email("juan@utn.com")
        .nombre("Juan Perez")
        .build();

    Alumno alumno2 = Alumno.builder()
        .legajo(2)
        .email("pablitoC@utn.com")
        .nombre("Pablito Claudio")
        .build();

    Alumno alumno3 = Alumno.builder()
        .legajo(3)
        .email("marito@utn.com")
        .nombre("Mario Carabajal")
        .build();

    Solicitud solicitud1 = Solicitud.builder()
        .codigo("S001")
        .asunto("Medio Boleto")
        .complejidad(1)
        .alumno(alumno1)
        .build();

    Solicitud solicitud2 = Solicitud.builder()
        .codigo("S002")
        .asunto("Reparcializacion Analisis matematico 1")
        .complejidad(2)
        .alumno(alumno2)
        .build();

    Solicitud solicitud3 = Solicitud.builder()
        .codigo("S003")
        .asunto("Beca progresar")
        .complejidad(3)
        .alumno(alumno3)
        .build();

    Curso curso1 = Curso.builder()
        .codigo("C001")
        .nombre("Programacion en Java")
        .horario("11:00 a 13:00")
        .aula(2)
        .build();

    Curso curso2 = Curso.builder()
        .codigo("C002")
        .nombre("Programacion orientada a objetos")
        .horario("15:00 a 17:00")
        .aula(5)
        .build();

    Curso curso3 = Curso.builder()
        .codigo("C003")
        .nombre("Patrones de disenio")
        .horario("10:00 a 12:00")
        .aula(4)
        .build();

    Curso curso4 = Curso.builder()
        .codigo("C004")
        .nombre("Calculo 1")
        .horario("16:00 a 19:00")
        .aula(1)
        .build();

    Curso curso5 = Curso.builder()
        .codigo("C005")
        .nombre("Algebra y geometria analitica")
        .horario("19:00 a 22:00")
        .aula(2)
        .build();

    Inscripcion inscripcion1 = Inscripcion.builder()
        .codigo("INS001")
        .alumno(alumno1)
        .curso(curso1)
        .build();

    Inscripcion inscripcion2 = Inscripcion.builder()
        .codigo("INS002")
        .alumno(alumno2)
        .curso(curso1)
        .build();

    Inscripcion inscripcion3 = Inscripcion.builder()
        .codigo("INS003")
        .alumno(alumno3)
        .curso(curso1)
        .build();

    logger.br();
    logger.log(
        "---------------------------- CHAIN OF RESPONSIBILITY ------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Gestion de solicitudes:", LogColor.TITLE2);
    logger.br();

    //Crear los eslabones de la cadena
    Handler asistente = new AsistenteCOR(asistente1);
    Handler profesor = new ProfesorCOR(profesor1);
    Handler coordinador = new CoordinadorCOR(coordinador1);

    //Definir el proceso
    asistente.setNext(profesor);
    profesor.setNext(coordinador);

    //Enviar solicitudes a la cadena
    asistente.handle(solicitud1);
    logger.br();

    asistente.handle(solicitud2);
    logger.br();

    asistente.handle(solicitud3);

    logger.br();
    logger.log(
        "------------------------------------ COMMAND --------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Gestionar cursos y certificados:", LogColor.TITLE2);
    logger.br();

    //Crear los comandos y su gestor
    GestorComandos gestor = new GestorComandos();
    Command cmd1 = new InscribirseCursoCommand(alumno1, curso1);
    Command cmd2 = new InscribirseCursoCommand(alumno1, curso2);
    Command cmd3 = new InscribirseCursoCommand(alumno2, curso3);
    Command cmd4 = new AbandonarCursoCommand(alumno1, curso1);
    Command cmd5 = new SolicitarCertificadoCommand(alumno1, curso2);
    Command cmd6 = new SolicitarCertificadoCommand(alumno2, curso3);
    Command cmd7 = new AbandonarCursoCommand(alumno3, curso1);

    //Ejecutar los comandos
    logger.log("Ejecutando comandos:", LogColor.TITLE);
    gestor.ejecutarComando(cmd1);
    gestor.ejecutarComando(cmd2);
    gestor.ejecutarComando(cmd3);
    gestor.ejecutarComando(cmd4);
    gestor.ejecutarComando(cmd5);
    gestor.ejecutarComando(cmd6);
    gestor.ejecutarComando(cmd7);

    gestor.mostrarHistorial();

    logger.br();
    logger.log(
        "------------------------------------ ITERATOR -------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Iteracion y listado de cursos:", LogColor.TITLE2);
    logger.br();

    //Crear un alumno y asociar cursos a este
    AlumnoIterator alumnoIterator = new AlumnoIterator(alumno1);

    alumnoIterator.getAlumno().inscribirCurso(curso1);
    alumnoIterator.getAlumno().inscribirCurso(curso2);
    alumnoIterator.getAlumno().inscribirCurso(curso3);
    alumnoIterator.getAlumno().inscribirCurso(curso4);
    alumnoIterator.getAlumno().inscribirCurso(curso5);

    //Crear iterador para los cursos del alumno e iterar para mostrar
    logger.log(
        "Cursos inscriptos: (Alumno: " + alumnoIterator.getAlumno().getNombre() + ", Legajo: "
            + alumnoIterator.getAlumno().getLegajo() + ")", LogColor.BLUE);
    Iterator<Curso> iterator = alumnoIterator.createIterator();

    while (iterator.hasNext()) {
      Curso curso = iterator.next();
      logger.info(curso.toString());
    }

    //Eliminar uno de los cursos de la lista
    boolean cursoEliminado = alumnoIterator.getAlumno().eliminarCurso(curso3);
    if (cursoEliminado) {
      logger.warn(
          "\nCurso eliminado: " + curso3.getNombre() + " para alumno " + alumnoIterator.getAlumno()
              .getNombre());
    }

    //Mostrar lista de cursos actualizada
    logger.log("\nLuego de eliminar uno de los cursos:", LogColor.BLUE);
    Iterator<Curso> nuevoIterator = alumnoIterator.createIterator();
    while (nuevoIterator.hasNext()) {
      Curso curso = nuevoIterator.next();
      logger.info(curso.toString());
    }

    logger.br();
    logger.log(
        "------------------------------------ MEDIATOR -------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Creacion e interaccion de salas de chat entre alumnos y profesores:",
        LogColor.TITLE2);
    logger.br();

    ChatRoom sala1 = ChatRoom.builder()
        .nombreSala("Sala Ciencias de la Computacion")
        .build();

    AlumnoMediator alumnoMediator1 = new AlumnoMediator(alumno1, sala1);
    AlumnoMediator alumnoMediator2 = new AlumnoMediator(alumno2, sala1);
    AlumnoMediator alumnoMediator3 = new AlumnoMediator(alumno3, sala1);

    ProfesorMediator profesorMediator1 = new ProfesorMediator(profesor1, sala1);
    ProfesorMediator profesorMediator2 = new ProfesorMediator(profesor2, sala1);

    logger.log("Usuarios uniendose a " + sala1.getNombreSala(), LogColor.BLUE);
    sala1.agregarUsuario(alumnoMediator1);
    sala1.agregarUsuario(alumnoMediator2);
    sala1.agregarUsuario(alumnoMediator3);
    sala1.agregarUsuario(profesorMediator1);
    sala1.agregarUsuario(profesorMediator2);

    logger.log("\nConversacion grupal:", LogColor.BLUE);
    profesorMediator1.enviar("Buenos dias a todos. Hoy vamos a revisar patrones de disenio.");
    alumnoMediator1.enviar("Buenos dias profesor, empezamos con el patron Mediator?");
    profesorMediator1.enviar("Excelente idea Juan, ese es justamente el tema de hoy.");
    alumnoMediator2.enviar("Tengo una duda sobre la implementacion.");
    profesorMediator2.enviar("Recuerden entregar la practica antes del viernes.");

    logger.log("\nConversacion privada:", LogColor.BLUE);
    profesorMediator1.enviarPrivado("Maria, despues de clase resolvemos tu duda en detalle.",
        alumnoMediator2);
    alumnoMediator3.enviarPrivado("Juan, me ayudas con el ejercicio?", alumnoMediator1);

    alumnoMediator1.mostrarHistorial();
    alumnoMediator2.mostrarHistorial();

    logger.br();
    logger.log(
        "------------------------------------ MEMENTO --------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Gestion de examenes con historial:", LogColor.TITLE2);
    logger.br();

    List<PreguntaExamen> preguntas = Arrays.asList(
        PreguntaExamen.builder()
            .numero(1)
            .enunciado("Que es el patron Memento?")
            .opciones(Arrays.asList("Un patron estructural", "Un patron de comportamiento",
                "Un patron creacional", "Un antipatron"))
            .respuestaCorrecta(1)
            .build(),
        PreguntaExamen.builder()
            .numero(2)
            .enunciado("Cual es el proposito del Memento?")
            .opciones(
                Arrays.asList("Crear objetos", "Guardar y restaurar estado", "Conectar objetos",
                    "Iterar colecciones"))
            .respuestaCorrecta(1)
            .build(),
        PreguntaExamen.builder()
            .numero(3)
            .enunciado("Quien crea el Memento?")
            .opciones(
                Arrays.asList("El Caretaker", "El Originator", "El Memento mismo", "El Cliente"))
            .respuestaCorrecta(1)
            .build(),
        PreguntaExamen.builder()
            .numero(4)
            .enunciado("El Memento debe ser inmutable?")
            .opciones(
                Arrays.asList("No, puede cambiar", "Si, debe ser inmutable", "Depende del caso",
                    "No importa"))
            .respuestaCorrecta(1)
            .build()
    );

    Examen modeloExamen = Examen.builder()
        .codigo("EX001")
        .materia("Desarrollo de software")
        .titulo("Parcial 1")
        .preguntas(preguntas)
        .build();
    GestorExamen gestorExamen = new GestorExamen(modeloExamen);

    ExamenWrapped examen = new ExamenWrapped(modeloExamen);
    HistorialExamen historial = new HistorialExamen(alumno1.getNombre());

    logger.log("Alumno comenzando examen:", LogColor.BLUE);

    // Responder 1er pregunta
    gestorExamen.mostrarPreguntaActual();
    gestorExamen.responderPregunta(1, 1);
    gestorExamen.avanzarPregunta();
    logger.info("----------------\n");

    // Guardar estado
    ExamenMemento guardado1 = examen.save("Despues de pregunta 1");
    historial.guardarEstado(guardado1);
    logger.br();

    // Responder 2da pregunta
    gestorExamen.mostrarPreguntaActual();
    gestorExamen.responderPregunta(2, 1);
    gestorExamen.avanzarPregunta();
    logger.info("----------------\n");

    // Guardar estado
    ExamenMemento guardado2 = examen.save("Despues de pregunta 2");
    historial.guardarEstado(guardado2);
    logger.br();

    // Responder 3er pregunta
    gestorExamen.mostrarPreguntaActual();
    gestorExamen.responderPregunta(3, 0); // Respuesta incorrecta
    gestorExamen.avanzarPregunta();
    logger.info("----------------\n");

    logger.log("Alumno  restaura guardado anterior del examen:", LogColor.BLUE);
    gestorExamen.mostrarProgreso();

    // Simular que el alumno quiere volver atras
    logger.info("\n--- Alumno decide restaurar progreso anterior ---");
    ExamenMemento estadoAnterior = historial.obtenerUltimoEstado();
    examen.restore(estadoAnterior);

    gestorExamen.mostrarProgreso();

    logger.log("\nContinuando examen:", LogColor.BLUE);
    gestorExamen.mostrarPreguntaActual();

    // Continuar desde donde restauro: 3er pregunta
    gestorExamen.responderPregunta(3, 1);
    gestorExamen.avanzarPregunta();
    logger.info("----------------\n");

    // Responder 4ta pregunta
    gestorExamen.mostrarPreguntaActual();
    gestorExamen.responderPregunta(4, 1);
    logger.info("----------------\n");

    // Finalizar
    gestorExamen.finalizarExamen();
    gestorExamen.mostrarProgreso();

    logger.br();
    logger.log(
        "------------------------------------ OBSERVER --------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Notificaciones de modificacion de cursos:", LogColor.TITLE2);
    logger.br();

    CursoObserver cursoOb1 = CursoObserver.builder()
        .curso(curso1)
        .build();
    CursoObserver cursoOb2 = CursoObserver.builder()
        .curso(curso2)
        .build();
    CursoObserver cursoOb3 = CursoObserver.builder()
        .curso(curso3)
        .build();

    AlumnoObserver alumnoOb1 = AlumnoObserver.builder()
        .alumno(alumno1)
        .build();
    AlumnoObserver alumnoOb2 = AlumnoObserver.builder()
        .alumno(alumno2)
        .build();
    AlumnoObserver alumnoOb3 = AlumnoObserver.builder()
        .alumno(alumno3)
        .build();

    cursoOb1.suscribir(alumnoOb1);
    cursoOb1.suscribir(alumnoOb2);
    cursoOb1.suscribir(alumnoOb3);

    cursoOb2.suscribir(alumnoOb1);
    cursoOb2.suscribir(alumnoOb2);

    cursoOb3.suscribir(alumnoOb2);
    cursoOb3.suscribir(alumnoOb3);

    cursoOb1.mostrarInfo();

    logger.br();
    logger.log("Publicando Avisos:", LogColor.BLUE);
    cursoOb1.publicarAviso("Recordatorio: Traer laptop para la clase practica");
    logger.br();
    logger.log("Cambios de horario:", LogColor.BLUE);
    cursoOb1.cambiarHorario("20:00 a 23:00");

    logger.br();
    logger.log("Asignacion de tareas:", LogColor.BLUE);
    cursoOb2.asignarTarea("Implementar patron Observer", "15/10/2024");

    logger.br();
    logger.log("Programando examen:", LogColor.BLUE);
    cursoOb3.programarExamen("20/10/2024", "Normalizacion, SQL, Transacciones");

    logger.br();
    logger.log("Cambio de aula:", LogColor.BLUE);
    cursoOb1.cambiarAula(6);

    logger.br();
    logger.log("Cancelacion de clase:", LogColor.BLUE);
    cursoOb2.cancelarClase("12/10/2024", "Dia feriado");

    logger.br();
    logger.log("Desuscripcion de alumno:", LogColor.BLUE);
    cursoOb1.desuscribir(alumnoOb1);

    logger.br();
    logger.log("Nuevo aviso:", LogColor.BLUE);
    cursoOb1.publicarAviso("Clase de recuperacion este sábado 10:00");

    logger.br();
    alumnoOb2.desactivarNotificaciones();

    logger.br();
    cursoOb1.publicarAviso("Material adicional disponible en el campus virtual");

    alumnoOb1.mostrarUltimasNotificaciones(3);
    alumnoOb2.mostrarNotificaciones();
    alumnoOb3.mostrarUltimasNotificaciones(3);

    logger.br();
    logger.log(
        "------------------------------------- STATE ---------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Notificaciones de modificacion de cursos:", LogColor.TITLE2);
    logger.br();

    InscripcionState inscripcionState1 = InscripcionState.builder()
        .inscripcion(inscripcion1)
        .build();

    logger.br();
    logger.log("Flujo normal del estado de las inscripciones:", LogColor.BLUE);

    inscripcionState1.mostrarEstadoActual();

    inscripcionState1.inscribir("Promedio alto");

    inscripcionState1.mostrarEstadoActual();

    logger.br();
    logger.log("Intentando inscribir en una solicitud con estado Inscripto:", LogColor.BLUE);

    inscripcionState1.inscribir("Aceptado por buenas notas");

    logger.br();
    logger.log("Cancelando inscripcion confirmada:", LogColor.BLUE);

    inscripcionState1.cancelar("Error en el sistema");

    inscripcionState1.mostrarEstadoActual();

    logger.br();
    logger.log(
        "------------------------------------- STATE ---------------------------------------------------",
        LogColor.DIVIDER);
    logger.br();

    logger.log("Notificaciones de modificacion de cursos:", LogColor.TITLE2);
    logger.br();


  }
}
