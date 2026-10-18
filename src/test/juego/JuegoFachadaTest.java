package juego;

import juego.combate.Combatiente;
import juego.config.Configuracion;
import juego.fachada.JuegoFachada;
import juego.profesor.Profesor;
import juego.profesor.ProfesorFactory;
import juego.util.Dificultad;
import juego.util.TipoProfesor;

/**
 * Pruebas del patrón Facade: comprueban que {@link JuegoFachada} permite crear
 * los participantes y consultar la configuración sin tocar los demás patrones.
 */
public class JuegoFachadaTest {

    public static void main(String[] args) {
        System.out.println("🧪 TESTS DEL PATRÓN FACADE\n");

        int pasados = 0;
        int total = 0;

        total++;
        if (testCrearJugadorDevuelveCombatienteConSusEstadisticas()) pasados++;

        total++;
        if (testCrearJugadorSinNombreLanzaExcepcion()) pasados++;

        total++;
        if (testCrearOponenteDevuelveElProfesorPedido()) pasados++;

        total++;
        if (testCrearOponenteNullLanzaExcepcion()) pasados++;

        total++;
        if (testJugadorYOponenteSeUsanIgual()) pasados++;

        total++;
        if (testProfesoresDisponiblesSonTresYDeSoloLectura()) pasados++;

        total++;
        if (testCambiarDificultadSeReflejaEnElSingleton()) pasados++;

        total++;
        if (testColaboradoresNullLanzanExcepcion()) pasados++;

        System.out.println("\n📊 Resultado: " + pasados + "/" + total + " tests pasaron");
    }

    static boolean testCrearJugadorDevuelveCombatienteConSusEstadisticas() {
        System.out.print("Test - crearJugador devuelve un combatiente con sus estadísticas: ");
        Combatiente jugador = new JuegoFachada().crearJugador("Ana");
        boolean ok = jugador.getNombre().equals("Ana")
            && jugador.getVida() == 100
            && jugador.getAtaque() == 15
            && jugador.getDefensa() == 10;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCrearJugadorSinNombreLanzaExcepcion() {
        System.out.print("Test - crearJugador con nombre vacío lanza excepción: ");
        boolean ok = false;
        try {
            new JuegoFachada().crearJugador("  ");
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCrearOponenteDevuelveElProfesorPedido() {
        System.out.print("Test - crearOponente devuelve el profesor del tipo pedido: ");
        JuegoFachada fachada = new JuegoFachada();
        boolean ok = true;
        for (TipoProfesor tipo : TipoProfesor.values()) {
            Combatiente oponente = fachada.crearOponente(tipo);
            ok = ok && oponente instanceof Profesor
                && ((Profesor) oponente).getTipoProfesor() == tipo;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCrearOponenteNullLanzaExcepcion() {
        System.out.print("Test - crearOponente con tipo null lanza excepción: ");
        boolean ok = false;
        try {
            new JuegoFachada().crearOponente(null);
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testJugadorYOponenteSeUsanIgual() {
        System.out.print("Test - Jugador y oponente de la fachada se usan igual: ");
        JuegoFachada fachada = new JuegoFachada();
        Combatiente jugador = fachada.crearJugador("Ana");
        Combatiente oponente = fachada.crearOponente(TipoProfesor.INFORMATICA);

        int vidaJugador = jugador.getVida();
        int vidaOponente = oponente.getVida();
        jugador.recibirDanio(jugador.getDefensa() + 20);
        oponente.recibirDanio(oponente.getDefensa() + 20);

        boolean ok = jugador.getVida() == vidaJugador - 20
            && oponente.getVida() == vidaOponente - 20;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testProfesoresDisponiblesSonTresYDeSoloLectura() {
        System.out.print("Test - Profesores disponibles son 3 y la lista es de solo lectura: ");
        JuegoFachada fachada = new JuegoFachada();
        boolean ok = false;
        try {
            fachada.getProfesoresDisponibles().add(TipoProfesor.MATEMATICAS);
        } catch (UnsupportedOperationException e) {
            ok = fachada.getProfesoresDisponibles().size() == 3;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCambiarDificultadSeReflejaEnElSingleton() {
        System.out.print("Test - cambiarDificultad se refleja en la Configuración global: ");
        JuegoFachada fachada = new JuegoFachada();
        Dificultad original = fachada.getDificultad();
        fachada.cambiarDificultad(Dificultad.EXTREMO);
        boolean ok = Configuracion.getInstance().getDificultad() == Dificultad.EXTREMO
            && fachada.getDificultad() == Dificultad.EXTREMO;
        fachada.cambiarDificultad(original);
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testColaboradoresNullLanzanExcepcion() {
        System.out.print("Test - Construir la fachada con colaboradores null lanza excepción: ");
        boolean sinConfiguracion = false;
        boolean sinFabrica = false;
        try {
            new JuegoFachada(null, new ProfesorFactory());
        } catch (IllegalArgumentException e) {
            sinConfiguracion = true;
        }
        try {
            new JuegoFachada(Configuracion.getInstance(), null);
        } catch (IllegalArgumentException e) {
            sinFabrica = true;
        }
        boolean ok = sinConfiguracion && sinFabrica;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }
}