package juego.config;

import juego.util.Dificultad;

/**
 * Configuración global del juego.
 *
 * <p>Patrón aplicado: Singleton. Garantiza una única instancia
 * accesible desde cualquier parte del código a través de
 * {@link #getInstance()}.</p>
 *
 * <p>Implementa {@link ConfiguracionJuego} para que el resto del
 * código dependa de la interfaz y no de esta clase concreta,
 * aunque la forma de obtener la instancia siga siendo estática.</p>
 *
 * <p>Nota: esta implementación no es thread-safe (la inicialización
 * perezosa de {@link #getInstance()} podría crear dos instancias si
 * dos hilos la llaman al mismo tiempo antes de la primera asignación).
 * Para esta aplicación, que es de un solo hilo, no representa un
 * problema real.</p>
 *
 * @author Cristian
 * @version 3.0
 */
public class Configuracion implements ConfiguracionJuego {

    private static Configuracion instance;

    private Dificultad dificultad;
    private String idioma;

    /**
     * Constructor privado para evitar instanciación externa.
     * Solo {@link #getInstance()} puede crear la única instancia.
     */
    private Configuracion() {
        this.dificultad = Dificultad.NORMAL;
        this.idioma = "es";
    }

    /**
     * Obtiene la única instancia de Configuracion.
     * La crea si no existe (lazy initialization).
     *
     * @return la única instancia de Configuracion
     */
    public static Configuracion getInstance() {
        if (instance == null) {
            instance = new Configuracion();
        }
        return instance;
    }

    @Override
    public Dificultad getDificultad() {
        return dificultad;
    }

    /**
     * Establece la dificultad del juego.
     *
     * @param dificultad la nueva dificultad
     * @throws IllegalArgumentException si dificultad es null
     */
    @Override
    public void setDificultad(Dificultad dificultad) {
        if (dificultad == null) {
            throw new IllegalArgumentException("La dificultad no puede ser null");
        }
        this.dificultad = dificultad;
    }

    @Override
    public String getIdioma() {
        return idioma;
    }

    /**
     * Establece el idioma del juego.
     *
     * @param idioma el nuevo idioma
     * @throws IllegalArgumentException si idioma es null o vacío
     */
    @Override
    public void setIdioma(String idioma) {
        if (idioma == null || idioma.trim().isEmpty()) {
            throw new IllegalArgumentException("El idioma no puede estar vacío");
        }
        this.idioma = idioma.trim();
    }

    @Override
    public String toString() {
        return "Configuracion{dificultad=" + dificultad + ", idioma='" + idioma + "'}";
    }
}