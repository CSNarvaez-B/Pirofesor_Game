package juego.habilidad;

/**
 * Habilidad especial que un jugador puede usar en combate, además de su
 * ataque normal.
 *
 * <p>Es una clase simple e inmutable pensada para crecer: con el tiempo
 * puede haber muchas habilidades distintas (curación, ataques especiales,
 * defensa, etc.), todas representadas con esta misma forma.</p>
 *
 * @author Juan
 * @version 1.0
 */
public class Habilidad {

    private final String nombre;
    private final String descripcion;
    private final int danioAdicional;

    /**
     * Crea una habilidad con su nombre, descripción y el daño adicional
     * que aporta al usarla en combate.
     *
     * @param nombre         el nombre visible de la habilidad
     * @param descripcion    una breve explicación de qué hace la habilidad
     * @param danioAdicional el daño extra que suma al ataque del jugador
     * @throws IllegalArgumentException si el nombre o la descripción están
     *                                  vacíos, o si el daño adicional es negativo
     */
    public Habilidad(String nombre, String descripcion, int danioAdicional) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la habilidad no puede estar vacío");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la habilidad no puede estar vacía");
        }
        if (danioAdicional < 0) {
            throw new IllegalArgumentException("El daño adicional no puede ser negativo");
        }
        this.nombre = nombre.trim();
        this.descripcion = descripcion.trim();
        this.danioAdicional = danioAdicional;
    }

    /**
     * Devuelve el nombre visible de la habilidad.
     *
     * @return el nombre de la habilidad
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la descripción de la habilidad.
     *
     * @return la descripción de la habilidad
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el daño adicional que aporta esta habilidad al usarse.
     *
     * @return el daño adicional
     */
    public int getDanioAdicional() {
        return danioAdicional;
    }

    @Override
    public String toString() {
        return "Habilidad{nombre='" + nombre + "'"
                + ", descripcion='" + descripcion + "'"
                + ", danioAdicional=" + danioAdicional + "}";
    }
}
