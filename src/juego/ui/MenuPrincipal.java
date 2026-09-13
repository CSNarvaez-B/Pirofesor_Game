package juego.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import juego.util.LimpiadorPantalla;

/**
 * Menú principal del juego. Orquesta la limpieza de pantalla y el
 * renderizado (delegados a otras clases) y se encarga de leer y
 * validar la opción elegida por el usuario.
 *
 * <p>Las dependencias ({@link Scanner}, {@link LimpiadorPantalla},
 * {@link RenderizadorMenu}) se reciben por constructor en vez de
 * crearse internamente. Esto invierte la dependencia: MenuPrincipal
 * ya no decide con qué implementación concreta trabaja, y en pruebas
 * unitarias se pueden inyectar dobles de prueba (por ejemplo un
 * Scanner sobre un String, o un LimpiadorPantalla que no haga nada).</p>
 *
 * @author Cristian
 * @version 4.0
 */
public class MenuPrincipal {

    private final Scanner scanner;
    private final LimpiadorPantalla limpiador;
    private final RenderizadorMenu renderizador;

    /**
     * Constructor con inyección de dependencias. Es el que se
     * recomienda usar desde pruebas unitarias o cuando se necesita
     * controlar explícitamente cada colaborador.
     */
    public MenuPrincipal(Scanner scanner, LimpiadorPantalla limpiador, RenderizadorMenu renderizador) {
        this.scanner = scanner;
        this.limpiador = limpiador;
        this.renderizador = renderizador;
    }

    /**
     * Constructor de conveniencia con las implementaciones por defecto
     * (consola estándar). Útil en el punto de entrada real de la app,
     * donde no hace falta inyectar dobles de prueba.
     */
    public MenuPrincipal() {
        this(new Scanner(System.in), new LimpiadorPantalla(), new RenderizadorMenu());
    }

    /**
     * Muestra el menú principal y devuelve una opción válida.
     *
     * @return opción seleccionada, garantizada entre OPCION_MIN y OPCION_MAX
     */
    public int mostrar() {
        limpiador.limpiar();
        renderizador.mostrarTitulo();
        renderizador.mostrarOpciones();

        return leerOpcionValida();
    }

    private int leerOpcionValida() {
        while (true) {
            renderizador.mostrarPrompt();
            int opcion = leerEntero();

            if (opcion >= ArteAscii.OPCION_MIN && opcion <= ArteAscii.OPCION_MAX) {
                return opcion;
            }

            renderizador.mostrarMensaje(
                "Opción inválida. Ingrese un número entre " +
                ArteAscii.OPCION_MIN + " y " + ArteAscii.OPCION_MAX + "."
            );
        }
    }

    private int leerEntero() {
        try {
            int valor = scanner.nextInt();
            scanner.nextLine();
            return valor;
        } catch (InputMismatchException e) {
            scanner.nextLine();
            return -1;
        }
    }

    public void mostrarMensaje(String mensaje) {
        renderizador.mostrarMensaje(mensaje);
    }

    public void mostrarDespedida() {
        limpiador.limpiar();
        renderizador.mostrarDespedida();
    }

    public void cerrar() {
        scanner.close();
    }
}