package juego.ui;

/**
 * Contiene las constantes de arte ASCII y textos estáticos usados
 * en la interfaz del menú. Mantener esto separado permite editar
 * la apariencia visual sin tocar la lógica de renderizado.
 *
 * @author Cristian
 * @version 1.0
 */
public final class ArteAscii {

    private ArteAscii() {
        // Clase utilitaria: no se instancia
    }

    public static final String TITULO =
        "  ██████╗ ██╗██████╗  ██████╗ ███████╗███████╗███████╗ ██████╗ ██████╗ \n" +
        "  ██╔══██╗██║██╔══██╗██╔═══██╗██╔════╝██╔════╝██╔════╝██╔═══██╗██╔══██╗\n" +
        "  ██████╔╝██║██████╔╝██║   ██║█████╗  ██████╗ ███████╗██║   ██║██████╔╝\n" +
        "  ██╔═══╝ ██║██╔══██╗██║   ██║██╔══╝  ██║     ╚════██║██║   ██╔██╗ ██\n" +
        "  ██║     ██║██║  ██║╚██████╔╝██║     ███████║███████║╚██████╔╝██║  ██║\n" +
        "  ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚══════╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝";

    public static final String SUBTITULO = "                G A M E    -   Combate a Muerte";

    public static final String SEPARADOR =
        "  ══════════════════════════════════════════════════════════════════════";

    public static final String CAJA_OPCIONES =
        "    ╔════════════════════════════════════╗\n" +
        "    ║              PIROFESOR             ║\n" +
        "    ╠════════════════════════════════════╣\n" +
        "    ║                                    ║\n" +
        "    ║      1. Nueva Partida              ║\n" +
        "    ║                                    ║\n" +
        "    ║      2. Salir                      ║\n" +
        "    ║                                    ║\n" +
        "    ╚════════════════════════════════════╝";

    public static final String DESPEDIDA =
        "  ╔═══════════════════════════════════════════════════════════╗\n" +
        "  ║                                                           ║\n" +
        "  ║              👋 ¡GRACIAS POR JUGAR! 👋                    ║\n" +
        "  ║                                                           ║\n" +
        "  ║         Nos vemos en la próxima batalla a sangre          ║\n" +
        "  ║                                                           ║\n" +
        "  ╚═══════════════════════════════════════════════════════════╝";

    /** Opción mínima válida del menú principal. */
    public static final int OPCION_MIN = 1;

    /** Opción máxima válida del menú principal. */
    public static final int OPCION_MAX = 2;
}