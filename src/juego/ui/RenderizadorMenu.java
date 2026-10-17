package juego.ui;
 
/**
 * Clase encargada de mostrar en consola los elementos visuales de los menús del juego, como títulos, opciones y mensajes.
 */
public class RenderizadorMenu {
 
    public void mostrarTitulo() {
        System.out.println();
        System.out.println(ArteAscii.TITULO);
        System.out.println();
        System.out.println(ArteAscii.SUBTITULO);
        System.out.println(ArteAscii.SEPARADOR);
        System.out.println();
    }
 
    public void mostrarOpciones() {
        System.out.println(ArteAscii.CAJA_OPCIONES);
        System.out.println();
    }
 
    public void mostrarPrompt() {
        System.out.print("  Seleccione una opción (" +
            ArteAscii.OPCION_MIN + "-" + ArteAscii.OPCION_MAX + "): ");
    }
 
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n  " + mensaje);
    }
 
    public void mostrarDespedida() {
        System.out.println();
        System.out.println(ArteAscii.DESPEDIDA);
        System.out.println();
    }
}