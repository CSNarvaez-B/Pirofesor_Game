package juego.jugador;

import juego.habilidad.Habilidad;

/**
 * Jugador que combate contra un profesor.
 *
 * <p>Patrón aplicado: Builder. Esta clase es el "producto" que construye
 * {@link JugadorBuilder}. El constructor no es público a propósito: la
 * única forma de crear un {@link Jugador} desde fuera de este paquete es
 * a través del builder, que ya se encarga de validar los datos.</p>
 *
 * @author Juan
 * @version 1.0
 */
public class Jugador {

    private final String nombre;
    private int vida;
    private final int ataque;
    private final Habilidad habilidad;

    /**
     * Crea un jugador con sus datos ya validados por {@link JugadorBuilder}.
     *
     * @param nombre    el nombre del jugador
     * @param vida      los puntos de vida iniciales
     * @param ataque    el valor de ataque
     * @param habilidad la habilidad especial del jugador
     */
    Jugador(String nombre, int vida, int ataque, Habilidad habilidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.habilidad = habilidad;
    }

    /**
     * Devuelve el nombre del jugador.
     *
     * @return el nombre del jugador
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve los puntos de vida actuales del jugador.
     *
     * @return los puntos de vida actuales
     */
    public int getVida() {
        return vida;
    }

    /**
     * Devuelve el valor de ataque del jugador.
     *
     * @return el valor de ataque
     */
    public int getAtaque() {
        return ataque;
    }

    /**
     * Devuelve la habilidad especial del jugador.
     *
     * @return la habilidad del jugador
     */
    public Habilidad getHabilidad() {
        return habilidad;
    }

    /**
     * Aplica daño al jugador. Los puntos de vida nunca bajan de cero.
     *
     * @param cantidadDanio el daño recibido
     * @throws IllegalArgumentException si la cantidad de daño es negativa
     */
    public void recibirDanio(int cantidadDanio) {
        if (cantidadDanio < 0) {
            throw new IllegalArgumentException("La cantidad de daño no puede ser negativa");
        }
        this.vida = Math.max(this.vida - cantidadDanio, 0);
    }

    /**
     * Indica si el jugador sigue en combate.
     *
     * @return {@code true} si los puntos de vida son mayores que cero
     */
    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String toString() {
        return "Jugador{nombre='" + nombre + "'"
                + ", vida=" + vida
                + ", ataque=" + ataque
                + ", habilidad=" + habilidad.getNombre() + "}";
    }
}
