package juego.combate;

import juego.jugador.Jugador;

/**
 * Adapter que permite tratar a un {@link Jugador} como un {@link Combatiente}.
 * Envuelve al jugador y delega cada llamada en él, sin modificar la clase
 * Jugador ni su Builder.
 */
public class JugadorAdapter implements Combatiente {

    private final Jugador jugador;

    /**
     * Crea el adaptador sobre un jugador ya construido.
     *
     * @param jugador el jugador que se va a adaptar
     * @throws IllegalArgumentException si el jugador es null
     */
    public JugadorAdapter(Jugador jugador) {
        if (jugador == null) {
            throw new IllegalArgumentException("El jugador no puede ser null");
        }
        this.jugador = jugador;
    }

    @Override
    public String getNombre() {
        return jugador.getNombre();
    }

    @Override
    public int getVida() {
        return jugador.getVida();
    }

    @Override
    public int getAtaque() {
        return jugador.getAtaque();
    }

    @Override
    public int getDefensa() {
        return jugador.getDefensa();
    }

    @Override
    public void recibirDanio(int cantidadDanio) {
        jugador.recibirDanio(cantidadDanio);
    }

    @Override
    public boolean estaVivo() {
        return jugador.estaVivo();
    }

    /**
     * Devuelve el jugador original, por si el combate necesita algo que no
     * está en Combatiente (por ejemplo su habilidad).
     *
     * @return el jugador adaptado
     */
    public Jugador getJugador() {
        return jugador;
    }
}