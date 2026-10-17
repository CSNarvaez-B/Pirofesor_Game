package juego;

import java.util.ArrayList;
import java.util.List;

import juego.combate.Combatiente;
import juego.combate.JugadorAdapter;
import juego.habilidad.Habilidad;
import juego.jugador.Jugador;
import juego.jugador.JugadorBuilder;
import juego.profesor.ProfesorFactory;
import juego.util.TipoProfesor;

/**
 * Pruebas del patrón Adapter: comprueban que {@link JugadorAdapter} permite
 * tratar al jugador como un {@link Combatiente}, igual que a los profesores.
 */
public class JugadorAdapterTest {

    public static void main(String[] args) {
        System.out.println("🧪 TESTS DEL PATRÓN ADAPTER\n");

        int pasados = 0;
        int total = 0;

        total++;
        if (testAdaptaLosDatosDelJugador()) pasados++;

        total++;
        if (testRecibirDanioSeReflejaEnElJugador()) pasados++;

        total++;
        if (testEstaVivoCambiaAlMorir()) pasados++;

        total++;
        if (testJugadorYProfesorComoCombatientes()) pasados++;

        total++;
        if (testJugadorNullLanzaExcepcion()) pasados++;

        System.out.println("\n📊 Resultado: " + pasados + "/" + total + " tests pasaron");
    }

    private static Jugador crearJugador() {
        Habilidad habilidad = new Habilidad("Golpe Certero", "Suma daño extra al ataque", 10);
        return new JugadorBuilder()
            .establecerNombre("Ana")
            .establecerVida(100)
            .establecerAtaque(15)
            .establecerDefensa(10)
            .establecerHabilidad(habilidad)
            .construir();
    }

    static boolean testAdaptaLosDatosDelJugador() {
        System.out.print("Test - El adapter expone los datos del jugador: ");
        Jugador jugador = crearJugador();
        Combatiente combatiente = new JugadorAdapter(jugador);
        boolean ok = combatiente.getNombre().equals("Ana")
            && combatiente.getVida() == 100
            && combatiente.getAtaque() == 15
            && combatiente.getDefensa() == 10;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testRecibirDanioSeReflejaEnElJugador() {
        System.out.print("Test - El daño recibido llega al jugador original: ");
        Jugador jugador = crearJugador();
        Combatiente combatiente = new JugadorAdapter(jugador);
        combatiente.recibirDanio(25); // 25 - defensa 10 = 15 de daño real
        boolean ok = combatiente.getVida() == 85 && jugador.getVida() == 85;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testEstaVivoCambiaAlMorir() {
        System.out.print("Test - estaVivo() pasa a false cuando la vida llega a 0: ");
        Combatiente combatiente = new JugadorAdapter(crearJugador());
        boolean vivoAntes = combatiente.estaVivo();
        combatiente.recibirDanio(1000);
        boolean ok = vivoAntes && !combatiente.estaVivo() && combatiente.getVida() == 0;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testJugadorYProfesorComoCombatientes() {
        System.out.print("Test - Jugador y profesor se usan igual como Combatiente: ");
        List<Combatiente> combatientes = new ArrayList<>();
        combatientes.add(new JugadorAdapter(crearJugador()));
        combatientes.add(new ProfesorFactory().crearProfesor(TipoProfesor.MATEMATICAS));

        boolean ok = true;
        for (Combatiente c : combatientes) {
            int vidaAntes = c.getVida();
            c.recibirDanio(c.getDefensa() + 20); // 20 de daño real
            ok = ok && c.getVida() == vidaAntes - 20 && c.estaVivo();
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testJugadorNullLanzaExcepcion() {
        System.out.print("Test - Adaptar un jugador null lanza excepción: ");
        boolean ok = false;
        try {
            new JugadorAdapter(null);
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }
}