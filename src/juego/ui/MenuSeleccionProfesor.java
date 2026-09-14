package juego.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import juego.profesor.Profesor;
import juego.profesor.ProfesorFactory;
import juego.util.TipoProfesor;

/**
 * Menú que permite al jugador elegir contra qué profesor combatir.
 *
 * <p>Muestra los tipos de profesor disponibles y, con el que el jugador
 * elija, usa {@link ProfesorFactory} (Factory Method) para construir el
 * oponente. Recibe el {@link Scanner} y la fábrica por constructor, igual
 * que {@link MenuPrincipal}, para poder inyectar dobles de prueba.</p>
 *
 * @author Juan
 * @version 1.0
 */
public class MenuSeleccionProfesor {

    private final Scanner scanner;
    private final ProfesorFactory fabricaDeProfesores;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param scanner             el scanner usado para leer la opción elegida
     * @param fabricaDeProfesores la fábrica usada para crear el profesor elegido
     */
    public MenuSeleccionProfesor(Scanner scanner, ProfesorFactory fabricaDeProfesores) {
        this.scanner = scanner;
        this.fabricaDeProfesores = fabricaDeProfesores;
    }

    /**
     * Constructor de conveniencia con las implementaciones por defecto.
     */
    public MenuSeleccionProfesor() {
        this(new Scanner(System.in), new ProfesorFactory());
    }

    /**
     * Muestra las opciones de profesor disponibles, lee la elección del
     * jugador y construye el profesor correspondiente.
     *
     * @return el profesor elegido por el jugador
     */
    public Profesor seleccionarProfesor() {
        TipoProfesor[] tiposDisponibles = TipoProfesor.values();
        mostrarOpciones(tiposDisponibles);

        int opcionElegida = leerOpcionValida(tiposDisponibles.length);
        TipoProfesor tipoElegido = tiposDisponibles[opcionElegida - 1];

        return fabricaDeProfesores.crearProfesor(tipoElegido);
    }

    private void mostrarOpciones(TipoProfesor[] tiposDisponibles) {
        System.out.println("\n  Elige contra qué profesor quieres combatir:\n");
        for (int indice = 0; indice < tiposDisponibles.length; indice++) {
            System.out.println("    " + (indice + 1) + ". " + tiposDisponibles[indice]);
        }
        System.out.println();
    }

    private int leerOpcionValida(int cantidadDeOpciones) {
        while (true) {
            System.out.print("  Seleccione una opción (1-" + cantidadDeOpciones + "): ");
            int opcionLeida = leerEntero();

            if (opcionLeida >= 1 && opcionLeida <= cantidadDeOpciones) {
                return opcionLeida;
            }

            System.out.println("\n  Opción inválida. Ingrese un número entre 1 y "
                    + cantidadDeOpciones + ".");
        }
    }

    private int leerEntero() {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (InputMismatchException excepcion) {
            scanner.nextLine();
            return -1;
        }
    }
}
