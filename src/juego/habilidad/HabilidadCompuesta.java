package juego.habilidad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Habilidad compuesta: es el composite del patrón. Agrupa otras habilidades
 * (simples o también compuestas) y se usa como si fuera una sola. Su daño
 * adicional es la suma del daño de las habilidades que contiene.
 */
public class HabilidadCompuesta implements Habilidad {

    private final String nombre;
    private final String descripcion;
    private final List<Habilidad> habilidades = new ArrayList<>();

    /**
     * Crea una habilidad compuesta vacía; las partes se agregan con
     * {@link #agregar(Habilidad)}.
     *
     * @param nombre      el nombre visible de la habilidad
     * @param descripcion una breve explicación de qué hace
     * @throws IllegalArgumentException si el nombre o la descripción están vacíos
     */
    public HabilidadCompuesta(String nombre, String descripcion) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la habilidad no puede estar vacío");
        }
        if (descripcion == null || descripcion.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción de la habilidad no puede estar vacía");
        }
        this.nombre = nombre.trim();
        this.descripcion = descripcion.trim();
    }

    /**
     * Agrega una habilidad (simple o compuesta) a este grupo.
     *
     * @param habilidad la habilidad que se va a agregar
     * @throws IllegalArgumentException si es null o si crearía un ciclo
     *                                  (una habilidad que se contiene a sí misma)
     */
    public void agregar(Habilidad habilidad) {
        if (habilidad == null) {
            throw new IllegalArgumentException("La habilidad a agregar no puede ser null");
        }
        if (habilidad == this
                || (habilidad instanceof HabilidadCompuesta && ((HabilidadCompuesta) habilidad).contiene(this))) {
            throw new IllegalArgumentException("Una habilidad no puede contenerse a sí misma");
        }
        habilidades.add(habilidad);
    }

    /**
     * Devuelve las habilidades de este grupo. La lista no se puede modificar
     * desde afuera: para agregar se usa {@link #agregar(Habilidad)}.
     *
     * @return una vista de solo lectura de las habilidades
     */
    public List<Habilidad> getHabilidades() {
        return Collections.unmodifiableList(habilidades);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int getDanioAdicional() {
        int total = 0;
        for (Habilidad habilidad : habilidades) {
            total += habilidad.getDanioAdicional();
        }
        return total;
    }

    /**
     * Revisa, también dentro de los grupos anidados, si esta habilidad
     * contiene a la buscada.
     */
    private boolean contiene(Habilidad buscada) {
        for (Habilidad habilidad : habilidades) {
            if (habilidad == buscada) {
                return true;
            }
            if (habilidad instanceof HabilidadCompuesta
                    && ((HabilidadCompuesta) habilidad).contiene(buscada)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "HabilidadCompuesta{nombre='" + nombre + "'"
                + ", partes=" + habilidades.size()
                + ", danioAdicional=" + getDanioAdicional() + "}";
    }
}