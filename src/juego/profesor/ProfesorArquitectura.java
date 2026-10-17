package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Representa al profesor de Arquitectura dentro del juego y define sus estadísticas iniciales de vida, ataque y defensa.
 */
public class ProfesorArquitectura extends ProfesorBase {

    private static final String NOMBRE_POR_DEFECTO = "Profesor de Arquitectura";
    private static final int VIDA_INICIAL = 140;
    private static final int ATAQUE_INICIAL = 14;
    private static final int DEFENSA_INICIAL = 18;

    /**
     * Crea un profesor de Arquitectura con sus estadísticas iniciales.
     */
    public ProfesorArquitectura() {
        super(NOMBRE_POR_DEFECTO, VIDA_INICIAL, ATAQUE_INICIAL, DEFENSA_INICIAL, TipoProfesor.ARQUITECTURA);
    }
}
