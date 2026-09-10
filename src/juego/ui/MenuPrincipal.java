package juego.ui;

import java.util.Scanner;

/**
 * Menú principal del juego con interfaz mejorada.
 * 
 * @author Cristian
 * @version 2.0
 */
public class MenuPrincipal {
    
    private Scanner scanner;
    
    public MenuPrincipal() {
        this.scanner = new Scanner(System.in);
    }
    
    /**
     * Muestra el menú principal con arte ASCII.
     * 
     * @return opción seleccionada
     */
    public int mostrar() {
        limpiarPantalla();
        mostrarTitulo();
        mostrarOpciones();
        
        return leerOpcion();
    }
    
    /**
     * Limpia la pantalla según el sistema operativo.
     */
    private void limpiarPantalla() {
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            // Si falla, imprimir líneas en blanco
            for (int i = 0; i < 50; i++) System.out.println();
        }
    }
    
    /**
     * Muestra el título del juego con arte ASCII.
     */
    private void mostrarTitulo() {
        System.out.println();
        System.out.println("  ██████╗ ██╗██████╗  ██████╗ ███████╗███████╗███████╗ ██████╗ ██████╗ ");
        System.out.println("  ██╔══██╗██║██╔══██╗██╔═══██╗██╔════╝██╔════╝██╔════╝██╔═══██╗██╔══██╗");
        System.out.println("  ██████╔╝██║██████╔╝██║   ██║█████╗  ██████╗ ███████╗██║   ██║██████╔╝");
        System.out.println("  ██╔═══╝ ██║██╔══██╗██║   ██║██╔══╝  ██║     ╚════██║██║   ██╔██╗ ██");
        System.out.println("  ██║     ██║██║  ██║╚██████╔╝██║     ███████║███████║╚██████╔╝██║  ██║");
        System.out.println("  ╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝ ╚═╝     ╚══════╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝");
        System.out.println();
        System.out.println("                G A M E    -   Combate a Muerte");
        System.out.println("  ══════════════════════════════════════════════════════════════════════");
        System.out.println();
    }
    
    /**
     * Muestra las opciones del menú.
     */
    private void mostrarOpciones() {
        System.out.println("    ╔════════════════════════════════════╗");
        System.out.println("    ║              PIROFESOR             ║");
        System.out.println("    ╠════════════════════════════════════╣");
        System.out.println("    ║                                    ║");
        System.out.println("    ║      1. Nueva Partida              ║");
        System.out.println("    ║                                    ║");
        System.out.println("    ║      2. Salir                      ║");
        System.out.println("    ║                                    ║");
        System.out.println("    ╚════════════════════════════════════╝");
        System.out.println();
    }
    
    /**
     * Lee la opción seleccionada por el usuario.
     * 
     * @return opción válida o -1 si hay error
     */
    private int leerOpcion() {
        System.out.print("  Seleccione una opción (1-2): ");
        
        try {
            int opcion = scanner.nextInt();
            scanner.nextLine();
            return opcion;
        } catch (Exception e) {
            scanner.nextLine();
            return -1;
        }
    }
    
    /**
     * Muestra un mensaje formateado.
     * 
     * @param mensaje el mensaje a mostrar
     */
    public void mostrarMensaje(String mensaje) {
        System.out.println("\n  " + mensaje);
    }
    
    /**
     * Muestra un mensaje de despedida.
     */
    public void mostrarDespedida() {
        limpiarPantalla();
        System.out.println();
        System.out.println("  ╔═══════════════════════════════════════════════════════════╗");
        System.out.println("  ║                                                           ║");
        System.out.println("  ║              👋 ¡GRACIAS POR JUGAR! 👋                    ║");
        System.out.println("  ║                                                           ║");
        System.out.println("  ║         Nos vemos en la próxima batalla a sangre          ║");
        System.out.println("  ║                                                           ║");
        System.out.println("  ╚═══════════════════════════════════════════════════════════╝");
        System.out.println();
    }
    
    public void cerrar() {
        scanner.close();
    }
}