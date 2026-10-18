package juego;

import java.util.ArrayList;
import java.util.List;

import juego.habilidad.Habilidad;
import juego.habilidad.HabilidadCompuesta;
import juego.habilidad.HabilidadSimple;
import juego.jugador.Jugador;
import juego.jugador.JugadorBuilder;

/**
 * Pruebas del patrón Composite: comprueban que una {@link HabilidadCompuesta}
 * se comporta como una {@link Habilidad} más, sumando el daño de sus partes.
 */
public class HabilidadCompuestaTest {

    public static void main(String[] args) {
        System.out.println("🧪 TESTS DEL PATRÓN COMPOSITE\n");

        int pasados = 0;
        int total = 0;

        total++;
        if (testHabilidadSimpleDevuelveSuDanio()) pasados++;

        total++;
        if (testCompuestaSumaElDanioDeSusPartes()) pasados++;

        total++;
        if (testCompuestaAnidadaSumaRecursivamente()) pasados++;

        total++;
        if (testCompuestaVaciaTieneDanioCero()) pasados++;

        total++;
        if (testSimpleYCompuestaSeUsanIgual()) pasados++;

        total++;
        if (testAgregarNullLanzaExcepcion()) pasados++;

        total++;
        if (testAgregarseASiMismaLanzaExcepcion()) pasados++;

        total++;
        if (testCicloIndirectoLanzaExcepcion()) pasados++;

        total++;
        if (testListaDePartesNoSePuedeModificar()) pasados++;

        total++;
        if (testBuilderAceptaHabilidadCompuesta()) pasados++;

        System.out.println("\n📊 Resultado: " + pasados + "/" + total + " tests pasaron");
    }

    private static Habilidad simple(String nombre, int danio) {
        return new HabilidadSimple(nombre, "Descripción de " + nombre, danio);
    }

    private static HabilidadCompuesta compuesta(String nombre) {
        return new HabilidadCompuesta(nombre, "Descripción de " + nombre);
    }

    static boolean testHabilidadSimpleDevuelveSuDanio() {
        System.out.print("Test - Habilidad simple devuelve su propio daño: ");
        boolean ok = simple("Golpe", 10).getDanioAdicional() == 10;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCompuestaSumaElDanioDeSusPartes() {
        System.out.print("Test - La compuesta suma el daño de sus partes (10 + 5 = 15): ");
        HabilidadCompuesta combo = compuesta("Combo");
        combo.agregar(simple("Golpe", 10));
        combo.agregar(simple("Argumento", 5));
        boolean ok = combo.getDanioAdicional() == 15 && combo.getHabilidades().size() == 2;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCompuestaAnidadaSumaRecursivamente() {
        System.out.print("Test - Compuesta dentro de compuesta suma recursivamente (10 + 5 + 3 = 18): ");
        HabilidadCompuesta interna = compuesta("Interna");
        interna.agregar(simple("A", 5));
        interna.agregar(simple("B", 3));
        HabilidadCompuesta externa = compuesta("Externa");
        externa.agregar(simple("C", 10));
        externa.agregar(interna);
        boolean ok = externa.getDanioAdicional() == 18;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCompuestaVaciaTieneDanioCero() {
        System.out.print("Test - Compuesta vacía tiene daño 0: ");
        boolean ok = compuesta("Vacía").getDanioAdicional() == 0;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testSimpleYCompuestaSeUsanIgual() {
        System.out.print("Test - Simple y compuesta se usan igual como Habilidad: ");
        HabilidadCompuesta combo = compuesta("Combo");
        combo.agregar(simple("X", 4));
        combo.agregar(simple("Y", 6));

        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(simple("Golpe", 10));
        habilidades.add(combo);

        int suma = 0;
        for (Habilidad h : habilidades) {
            suma += h.getDanioAdicional();
        }
        boolean ok = suma == 20;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testAgregarNullLanzaExcepcion() {
        System.out.print("Test - Agregar null lanza excepción: ");
        boolean ok = false;
        try {
            compuesta("Combo").agregar(null);
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testAgregarseASiMismaLanzaExcepcion() {
        System.out.print("Test - Una compuesta no puede agregarse a sí misma: ");
        HabilidadCompuesta combo = compuesta("Combo");
        boolean ok = false;
        try {
            combo.agregar(combo);
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testCicloIndirectoLanzaExcepcion() {
        System.out.print("Test - Un ciclo indirecto (A dentro de B dentro de A) lanza excepción: ");
        HabilidadCompuesta a = compuesta("A");
        HabilidadCompuesta b = compuesta("B");
        a.agregar(b);
        boolean ok = false;
        try {
            b.agregar(a);
        } catch (IllegalArgumentException e) {
            ok = true;
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testListaDePartesNoSePuedeModificar() {
        System.out.print("Test - La lista de partes es de solo lectura: ");
        HabilidadCompuesta combo = compuesta("Combo");
        boolean ok = false;
        try {
            combo.getHabilidades().add(simple("Golpe", 10));
        } catch (UnsupportedOperationException e) {
            ok = combo.getHabilidades().isEmpty();
        }
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testBuilderAceptaHabilidadCompuesta() {
        System.out.print("Test - El Builder arma un jugador con habilidad compuesta: ");
        HabilidadCompuesta combo = compuesta("Combo");
        combo.agregar(simple("Golpe", 10));
        combo.agregar(simple("Argumento", 5));

        Jugador jugador = new JugadorBuilder()
            .establecerNombre("Ana")
            .establecerVida(100)
            .establecerAtaque(15)
            .establecerDefensa(10)
            .establecerHabilidad(combo)
            .construir();

        boolean ok = jugador.getHabilidad() == combo
            && jugador.getHabilidad().getDanioAdicional() == 15;
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }
}