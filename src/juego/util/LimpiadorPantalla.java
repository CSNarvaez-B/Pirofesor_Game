package juego.util;
 
/**
 * Responsable exclusivamente de limpiar la pantalla de la consola,
 * detectando el sistema operativo. Es una utilidad genérica, sin
 * conocimiento del juego ni de la interfaz de menú, por lo que
 * vive en el paquete util y puede reutilizarse desde cualquier
 * otra pantalla (combate, inventario, etc.).
 *
 * @author Cristian
 * @version 1.0
 */
public class LimpiadorPantalla {
 
    private static final int LINEAS_RESPALDO = 50;
 
    /**
     * Limpia la pantalla. Si falla la limpieza nativa del SO,
     * usa un respaldo imprimiendo líneas en blanco.
     */
    public void limpiar() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            limpiarConRespaldo();
        }
    }
 
    private void limpiarConRespaldo() {
        for (int i = 0; i < LINEAS_RESPALDO; i++) {
            System.out.println();
        }
    }
}