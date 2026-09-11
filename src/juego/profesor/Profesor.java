package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Contrato que define el comportamiento de un profesor dentro del juego.
 *
 * <p>Patrón aplicado: Factory Method. Esta interfaz representa el "producto"
 * que la clase {@link ProfesorFactory} construye. El resto del juego trabaja
 * siempre contra este tipo y nunca contra las clases concretas.</p>
 *
 * @author Juan
 * @version 1.0
 */
public interface Profesor {

    /**
     * Devuelve el nombre visible del profesor.
     *
     * @return el nombre del profesor
     */
    String getNombre();

    /**
     * Establece el nombre visible del profesor.
     *
     * @param nombre el nuevo nombre
     * @throws IllegalArgumentException si el nombre es null o está vacío
     */
    void setNombre(String nombre);

    /**
     * Devuelve los puntos de vida actuales del profesor.
     *
     * @return los puntos de vida actuales
     */
    int getVida();

    /**
     * Establece los puntos de vida del profesor.
     *
     * @param vida los nuevos puntos de vida
     * @throws IllegalArgumentException si el valor es negativo
     */
    void setVida(int vida);

    /**
     * Devuelve el valor de ataque del profesor.
     *
     * @return el valor de ataque
     */
    int getAtaque();

    /**
     * Establece el valor de ataque del profesor.
     *
     * @param ataque el nuevo valor de ataque
     * @throws IllegalArgumentException si el valor es negativo
     */
    void setAtaque(int ataque);

    /**
     * Devuelve el valor de defensa del profesor.
     *
     * @return el valor de defensa
     */
    int getDefensa();

    /**
     * Establece el valor de defensa del profesor.
     *
     * @param defensa el nuevo valor de defensa
     * @throws IllegalArgumentException si el valor es negativo
     */
    void setDefensa(int defensa);

    /**
     * Devuelve el tipo de profesor, que identifica a qué materia pertenece.
     *
     * @return el tipo de profesor
     */
    TipoProfesor getTipoProfesor();

    /**
     * Aplica daño al profesor. La defensa reduce el daño recibido y los puntos
     * de vida nunca bajan de cero.
     *
     * @param cantidadDanio el daño bruto recibido
     * @throws IllegalArgumentException si la cantidad de daño es negativa
     */
    void recibirDanio(int cantidadDanio);

    /**
     * Indica si el profesor sigue en combate.
     *
     * @return {@code true} si los puntos de vida son mayores que cero
     */
    boolean estaVivo();
}
