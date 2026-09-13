package juego;
 
import juego.config.Configuracion;
import juego.config.ConfiguracionJuego;
import juego.ui.MenuPrincipal;
 
/**
 * Punto de entrada de la aplicación.
 *
 * <p>Aquí se obtiene la única instancia de {@link Configuracion}
 * (Singleton) y se crea el {@link MenuPrincipal} con sus dependencias
 * por defecto. El resto del sistema recibe sus colaboradores por
 * constructor y no sabe (ni le importa) cómo fueron construidos —
 * a esto se le llama "composition root" — con la excepción de
 * Configuracion, que por ser Singleton se obtiene vía
 * {@code getInstance()} en cualquier punto que la necesite.</p>
 *
 * @author Cristian, Camilo, Santiago
 * @version 1.1
 */
public class Main {
 
    public static void main(String[] args) {
        // Configuracion es un Singleton: getInstance() siempre
        // devuelve la misma instancia en toda la ejecución.
        ConfiguracionJuego config = Configuracion.getInstance();
 
        MenuPrincipal menu = new MenuPrincipal();
 
        int opcion = menu.mostrar();
 
        switch (opcion) {
            case 1:
                menu.mostrarMensaje("Iniciando nueva partida en dificultad "
                    + config.getDificultad() + "...");
                // TODO: arrancar el juego, pasando 'config' a quien lo necesite
                break;
            case 2:
                menu.mostrarDespedida();
                break;
            default:
                // No debería ocurrir: MenuPrincipal ya garantiza el rango
                break;
        }
 
        menu.cerrar();
    }
}