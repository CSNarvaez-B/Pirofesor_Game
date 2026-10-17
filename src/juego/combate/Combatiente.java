package juego.combate;

/**
 * Interfaz común para todo lo que participa en un combate (jugador y profesores).
 * Es la interfaz objetivo del patrón Adapter: el sistema de combate solo conoce
 * a los Combatiente y no necesita saber si detrás hay un jugador o un profesor.
 */
public interface Combatiente {

    /**
     * Devuelve el nombre visible del combatiente.
     *
     * @return el nombre del combatiente
     */
    String getNombre();

    /**
     * Devuelve los puntos de vida actuales.
     *
     * @return los puntos de vida actuales
     */
    int getVida();

    /**
     * Devuelve el valor de ataque.
     *
     * @return el valor de ataque
     */
    int getAtaque();

    /**
     * Devuelve el valor de defensa.
     *
     * @return el valor de defensa
     */
    int getDefensa();

    /**
     * Aplica daño al combatiente. La defensa reduce el daño recibido y la vida
     * nunca baja de cero.
     *
     * @param cantidadDanio el daño bruto recibido
     * @throws IllegalArgumentException si la cantidad de daño es negativa
     */
    void recibirDanio(int cantidadDanio);

    /**
     * Indica si el combatiente sigue en combate.
     *
     * @return {@code true} si la vida es mayor que cero
     */
    boolean estaVivo();
}