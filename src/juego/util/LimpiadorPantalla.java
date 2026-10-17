package juego.util;
 
/**
 * Clase encargada de limpiar la pantalla de la consola para facilitar la presentación de las diferentes partes del juego.
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