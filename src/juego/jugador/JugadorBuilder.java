package juego.jugador;

import juego.habilidad.Habilidad;

/**
 * Constructor paso a paso de un {@link Jugador}.
 *
 * <p>Patrón aplicado: Builder. Permite armar un jugador indicando sus
 * datos uno por uno, con una llamada encadenada por cada dato
 * ({@code establecerNombre(...).establecerVida(...)...}), y valida cada
 * dato apenas se recibe en vez de esperar hasta el final.</p>
 *
 * @author Juan
 * @version 1.0
 */
public class JugadorBuilder {

    private String nombre;
    private int vida;
    private int ataque;
    private Habilidad habilidad;

    /**
     * Establece el nombre del jugador.
     *
     * @param nombre el nombre del jugador
     * @return este mismo builder, para encadenar llamadas
     * @throws IllegalArgumentException si el nombre es null o está vacío
     */
    public JugadorBuilder establecerNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del jugador no puede estar vacío");
        }
        this.nombre = nombre.trim();
        return this;
    }

    /**
     * Establece los puntos de vida iniciales del jugador.
     *
     * @param vida los puntos de vida iniciales
     * @return este mismo builder, para encadenar llamadas
     * @throws IllegalArgumentException si la vida no es mayor que cero
     */
    public JugadorBuilder establecerVida(int vida) {
        if (vida <= 0) {
            throw new IllegalArgumentException("La vida del jugador debe ser mayor que cero");
        }
        this.vida = vida;
        return this;
    }

    /**
     * Establece el valor de ataque del jugador.
     *
     * @param ataque el valor de ataque
     * @return este mismo builder, para encadenar llamadas
     * @throws IllegalArgumentException si el ataque no es mayor que cero
     */
    public JugadorBuilder establecerAtaque(int ataque) {
        if (ataque <= 0) {
            throw new IllegalArgumentException("El ataque del jugador debe ser mayor que cero");
        }
        this.ataque = ataque;
        return this;
    }

    /**
     * Establece la habilidad especial del jugador.
     *
     * @param habilidad la habilidad del jugador
     * @return este mismo builder, para encadenar llamadas
     * @throws IllegalArgumentException si la habilidad es null
     */
    public JugadorBuilder establecerHabilidad(Habilidad habilidad) {
        if (habilidad == null) {
            throw new IllegalArgumentException("La habilidad del jugador no puede ser null");
        }
        this.habilidad = habilidad;
        return this;
    }

    /**
     * Construye el jugador con los datos establecidos hasta el momento.
     *
     * @return una nueva instancia de {@link Jugador}
     * @throws IllegalStateException si falta algún dato obligatorio
     */
    public Jugador construir() {
        if (nombre == null) {
            throw new IllegalStateException("No se puede construir el jugador sin un nombre");
        }
        if (vida <= 0) {
            throw new IllegalStateException("No se puede construir el jugador sin una vida válida");
        }
        if (ataque <= 0) {
            throw new IllegalStateException("No se puede construir el jugador sin un ataque válido");
        }
        if (habilidad == null) {
            throw new IllegalStateException("No se puede construir el jugador sin una habilidad");
        }
        return new Jugador(nombre, vida, ataque, habilidad);
    }
}
