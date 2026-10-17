package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Representa al profesor de Matemáticas dentro del juego y define sus estadísticas iniciales de vida, ataque y defensa.
 */
public class ProfesorMatematicas extends ProfesorBase {

    private static final String NOMBRE_POR_DEFECTO = "Profesor de Matemáticas";
    private static final int VIDA_INICIAL = 110;
    private static final int ATAQUE_INICIAL = 18;
    private static final int DEFENSA_INICIAL = 12;

    /**
     * Crea un profesor de Matemáticas con sus estadísticas iniciales.
     */
    public ProfesorMatematicas() {
        super(NOMBRE_POR_DEFECTO, VIDA_INICIAL, ATAQUE_INICIAL, DEFENSA_INICIAL, TipoProfesor.MATEMATICAS);
    }
}
