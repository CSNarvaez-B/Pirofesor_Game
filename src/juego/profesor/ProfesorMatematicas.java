package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Profesor de Matemáticas. Producto concreto del Factory Method con un perfil
 * equilibrado entre vida, ataque y defensa.
 *
 * @author Juan
 * @version 1.0
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
