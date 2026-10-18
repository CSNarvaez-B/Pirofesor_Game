package juego;

import java.util.Scanner;
import juego.combate.Combatiente;
import juego.fachada.JuegoFachada;
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
        JuegoFachada fachada = new JuegoFachada();

        Scanner scanner = new Scanner(System.in);
        MenuPrincipal menu = new MenuPrincipal(scanner, new LimpiadorPantalla(), new RenderizadorMenu());

        int opcion = menu.mostrar();

        switch (opcion) {
            case 1:
                menu.mostrarMensaje("Iniciando nueva partida en dificultad "
                    + fachada.getDificultad() + "...");
                iniciarPartida(scanner, menu, fachada);
                break;
            case 2:
                menu.mostrarDespedida();
                break;
            default:
                break;
        }

        menu.cerrar();
    }

    private static void iniciarPartida(Scanner scanner, MenuPrincipal menu, JuegoFachada fachada) {
        System.out.print("\n  Ingrese el nombre de su jugador: ");
        Combatiente jugador = fachada.crearJugador(scanner.nextLine());

        Profesor profesor = new MenuSeleccionProfesor(scanner, new ProfesorFactory()).seleccionarProfesor();

        menu.mostrarMensaje(jugador.getNombre() + " se prepara para enfrentar a "
            + profesor.getNombre() + "...");

        // TODO: implementar el combate por turnos entre jugador y profesor
    }
}