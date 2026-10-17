package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Representa al profesor de Informática dentro del juego y define sus estadísticas iniciales de vida, ataque y defensa.
 */
public class ProfesorInformatica extends ProfesorBase {

    private static final String NOMBRE_POR_DEFECTO = "Profesor de Informática";
    private static final int VIDA_INICIAL = 95;
    private static final int ATAQUE_INICIAL = 24;
    private static final int DEFENSA_INICIAL = 8;

    /**
     * Crea un profesor de Informática con sus estadísticas iniciales.
     */
    public ProfesorInformatica() {
        super(NOMBRE_POR_DEFECTO, VIDA_INICIAL, ATAQUE_INICIAL, DEFENSA_INICIAL, TipoProfesor.INFORMATICA);
    }
}
