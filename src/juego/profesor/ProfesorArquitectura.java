package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Profesor de Arquitectura. Producto concreto del Factory Method con un perfil
 * defensivo: mucha vida y defensa, pero poco ataque.
 *
 * @author Juan
 * @version 1.0
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
