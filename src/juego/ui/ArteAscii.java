package juego.ui;

/**
 * Contiene los textos y dibujos en ASCII utilizados para mostrar los elementos visuales de los menús del juego.
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