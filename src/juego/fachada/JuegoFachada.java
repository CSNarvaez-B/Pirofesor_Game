package juego.fachada;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import juego.combate.Combatiente;
import juego.combate.JugadorAdapter;
import juego.config.Configuracion;
import juego.config.ConfiguracionJuego;
import juego.habilidad.Habilidad;
import juego.habilidad.HabilidadCompuesta;
import juego.habilidad.HabilidadSimple;
import juego.jugador.JugadorBuilder;
import juego.profesor.ProfesorFactory;
import juego.util.Dificultad;
import juego.util.TipoProfesor;

/**
 * Fachada del juego (patrón Facade). Ofrece un punto de entrada simple para
 * crear los participantes y consultar la configuración, de modo que quien la
 * use no conozca el Builder, la Factory, el Adapter, el Composite ni el Singleton.
 */
public class JuegoFachada {

    private static final int VIDA_JUGADOR = 100;
    private static final int ATAQUE_JUGADOR = 15;
    private static final int DEFENSA_JUGADOR = 10;

    private final ConfiguracionJuego configuracion;
    private final ProfesorFactory fabricaDeProfesores;

    public JuegoFachada(ConfiguracionJuego configuracion, ProfesorFactory fabricaDeProfesores) {
        if (configuracion == null) {
            throw new IllegalArgumentException("La configuración no puede ser null");
        }
        if (fabricaDeProfesores == null) {
            throw new IllegalArgumentException("La fábrica de profesores no puede ser null");
        }
        this.configuracion = configuracion;
        this.fabricaDeProfesores = fabricaDeProfesores;
    }

    public JuegoFachada() {
        this(Configuracion.getInstance(), new ProfesorFactory());
    }

    public Combatiente crearJugador(String nombre) {
        return new JugadorAdapter(new JugadorBuilder()
            .establecerNombre(nombre)
            .establecerVida(VIDA_JUGADOR)
            .establecerAtaque(ATAQUE_JUGADOR)
            .establecerDefensa(DEFENSA_JUGADOR)
            .establecerHabilidad(crearComboAcademico())
            .construir());
    }

    public Combatiente crearOponente(TipoProfesor tipoProfesor) {
        return fabricaDeProfesores.crearProfesor(tipoProfesor);
    }

    public List<TipoProfesor> getProfesoresDisponibles() {
        return Collections.unmodifiableList(Arrays.asList(TipoProfesor.values()));
    }

    public Dificultad getDificultad() {
        return configuracion.getDificultad();
    }

    public void cambiarDificultad(Dificultad dificultad) {
        configuracion.setDificultad(dificultad);
    }

    private Habilidad crearComboAcademico() {
        HabilidadCompuesta combo = new HabilidadCompuesta(
            "Combo Académico",
            "Encadena varias habilidades en una sola acción"
        );
        combo.agregar(new HabilidadSimple(
            "Golpe Certero",
            "Un golpe adicional que suma daño extra al ataque normal",
            10
        ));
        combo.agregar(new HabilidadSimple(
            "Argumento Contundente",
            "Un argumento sólido que desconcierta al rival",
            5
        ));
        return combo;
    }
}