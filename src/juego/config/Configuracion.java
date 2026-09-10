package juego.config;

import juego.util.Dificultad;

/**
 * Configuración global del juego.
 * 
 * <p>Patrón aplicado: Singleton</p>
 * <p>Garantiza una única instancia accesible desde cualquier parte del código.</p>
 * 
 * @author Cristian
 * @version 1.0
 */
public class Configuracion {
    
    private static Configuracion instance;
    private Dificultad dificultad;
    private String idioma;
    
    /**
     * Constructor privado para evitar instanciación externa.
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
    
    public Dificultad getDificultad() {
        return dificultad;
    }
    
    /**
     * Establece la dificultad del juego.
     * 
     * @param dificultad la nueva dificultad
     * @throws IllegalArgumentException si dificultad es null
     */
    public void setDificultad(Dificultad dificultad) {
        if (dificultad == null) {
            throw new IllegalArgumentException("La dificultad no puede ser null");
        }
        this.dificultad = dificultad;
    }
    
    public String getIdioma() {
        return idioma;
    }
    
    /**
     * Establece el idioma del juego.
     * 
     * @param idioma el nuevo idioma
     * @throws IllegalArgumentException si idioma es null o vacío
     */
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