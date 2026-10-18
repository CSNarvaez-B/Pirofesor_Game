package juego.habilidad;

/**
 * Componente del patrón Composite. Representa cualquier habilidad del juego,
 * ya sea una habilidad simple o un grupo de habilidades. Quien la use no
 * necesita saber de cuál de las dos se trata.
 */
public interface Habilidad {

    /**
     * Devuelve el nombre visible de la habilidad.
     *
     * @return el nombre de la habilidad
     */
    String getNombre();

    /**
     * Devuelve la descripción de la habilidad.
     *
     * @return la descripción de la habilidad
     */
    String getDescripcion();

    /**
     * Devuelve el daño adicional total que aporta la habilidad al usarse.
     * En una habilidad compuesta es la suma del daño de todas sus partes.
     *
     * @return el daño adicional
     */
    int getDanioAdicional();
}