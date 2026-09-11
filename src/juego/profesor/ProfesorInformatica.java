package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Profesor de Informática. Producto concreto del Factory Method con un perfil
 * ofensivo: mucho ataque a costa de menos vida y defensa.
 *
 * @author Juan
 * @version 1.0
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
