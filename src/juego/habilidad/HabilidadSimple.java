package juego.habilidad;

/**
 * Habilidad simple: es la hoja del patrón Composite. Tiene su propio nombre,
 * descripción y daño adicional, y no contiene otras habilidades.
 */
public class HabilidadSimple implements Habilidad {

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
    public HabilidadSimple(String nombre, String descripcion, int danioAdicional) {
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
    @Override
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve la descripción de la habilidad.
     *
     * @return la descripción de la habilidad
     */
    @Override
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Devuelve el daño adicional que aporta esta habilidad al usarse.
     *
     * @return el daño adicional
     */
    @Override
    public int getDanioAdicional() {
        return danioAdicional;
    }

    @Override
    public String toString() {
        return "HabilidadSimple{nombre='" + nombre + "'"
                + ", descripcion='" + descripcion + "'"
                + ", danioAdicional=" + danioAdicional + "}";
    }
}