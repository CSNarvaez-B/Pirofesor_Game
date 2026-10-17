package juego;

import java.util.Scanner;

import juego.config.Configuracion;
import juego.config.ConfiguracionJuego;
import juego.habilidad.Habilidad;
import juego.jugador.Jugador;
import juego.jugador.JugadorBuilder;
import juego.profesor.Profesor;
import juego.profesor.ProfesorFactory;
import juego.ui.MenuPrincipal;
import juego.ui.MenuSeleccionProfesor;
import juego.ui.RenderizadorMenu;
import juego.util.LimpiadorPantalla;

/**
 * Clase principal del juego. Se encarga de iniciar la aplicación y mostrar el menú principal para comenzar la partida.
 */
public class Main {

    public static void main(String[] args) {
        // Configuracion es un Singleton: getInstance() siempre
        // devuelve la misma instancia en toda la ejecución.
        ConfiguracionJuego config = Configuracion.getInstance();

        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal(scanner, new LimpiadorPantalla(), new RenderizadorMenu());

        int opcion = menu.mostrar();

        switch (opcion) {
            case 1:
                menu.mostrarMensaje("Iniciando nueva partida en dificultad "
                    + config.getDificultad() + "...");
                iniciarPartida(scanner, menu);
                break;
            case 2:
                menu.mostrarDespedida();
                break;
            default:
                // No debería ocurrir: MenuPrincipal ya garantiza el rango
                break;
        }

        menu.cerrar();
    }

    /**
     * Construye al jugador (Builder) y al profesor elegido (Factory Method)
     * para arrancar la partida.
     */
    private static void iniciarPartida(Scanner scanner, MenuPrincipal menu) {
        Jugador jugador = crearJugador(scanner);
        Profesor profesor = new MenuSeleccionProfesor(scanner, new ProfesorFactory()).seleccionarProfesor();

        menu.mostrarMensaje(jugador.getNombre() + " se prepara para enfrentar a "
            + profesor.getNombre() + "...");

        // TODO: implementar el combate por turnos entre jugador y profesor
    }

    private static Jugador crearJugador(Scanner scanner) {
        System.out.print("\n  Ingrese el nombre de su jugador: ");
        String nombreDelJugador = scanner.nextLine();

        Habilidad golpeCertero = new Habilidad(
            "Golpe Certero",
            "Un golpe adicional que suma daño extra al ataque normal",
            10
        );

        return new JugadorBuilder()
            .establecerNombre(nombreDelJugador)
            .establecerVida(100)
            .establecerAtaque(15)
            .establecerDefensa(10)
            .establecerHabilidad(golpeCertero)
            .construir();
    }
}