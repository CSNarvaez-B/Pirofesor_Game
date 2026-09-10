package juego;

import juego.config.Configuracion;
import juego.ui.MenuPrincipal;
import juego.util.Dificultad;

/**
 * Clase principal del juego.
 * 
 * @author Cristian, Santiago, Camilo
 * @version 1.0
 */
public class Main {
    
    public static void main(String[] args) {
        System.out.println("🎮 BIENVENIDO AL JUEGO DE COMBATE AL PIROFESOR 🎮");
        
        // Singleton - Configuración global
        Configuracion config = Configuracion.getInstance();
        config.setDificultad(Dificultad.NORMAL);
        
        System.out.println("\n✓ Configuración inicializada");
        System.out.println("  Dificultad: " + config.getDificultad());
        
        // Verificar misma instancia
        Configuracion otraConfig = Configuracion.getInstance();
        System.out.println("✓ ¿Misma instancia? " + (config == otraConfig));
        
        // Menú principal
        MenuPrincipal menu = new MenuPrincipal();
        boolean salir = false;
        
        while (!salir) {
            int opcion = menu.mostrar();
            
            switch (opcion) {
                case 1:
                    menu.mostrarMensaje("🆕 Iniciando nueva partida...");
                    //...
                    break;
                case 2:
                    salir = true;
                    System.out.println("\n¡Gracias por jugar! 👋");
                    break;
                default:
                    System.out.println("❌ Opción no válida.");
            }
        }
        
        menu.cerrar();
    }
}