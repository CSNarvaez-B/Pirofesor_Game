package juego;

import juego.config.Configuracion;
import juego.util.Dificultad;

/**
 * Clase que contiene pruebas para comprobar el funcionamiento de la clase {@link Configuracion} y sus validaciones principales.
 */
public class ConfiguracionTest {

    public static void main(String[] args) {
        System.out.println("🧪 TESTS DEL PATRÓN SINGLETON\n");

        int pasados = 0;
        int total = 0;

        // Debe ir primero: verifica los valores por defecto antes
        // de que cualquier otro test mute el estado global compartido.
        total++;
        if (testValoresPorDefecto()) pasados++;

        total++;
        if (testMismaInstancia()) pasados++;

        total++;
        if (testMultiplesLlamadas()) pasados++;

        total++;
        if (testConfiguracionPersistente()) pasados++;

        total++;
        if (testDificultadNullLanzaExcepcion()) pasados++;

        total++;
        if (testIdiomaVacioLanzaExcepcion()) pasados++;

        total++;
        if (testIdiomaNullLanzaExcepcion()) pasados++;

        System.out.println("\n📊 Resultado: " + pasados + "/" + total + " tests pasaron");
    }

    static boolean testValoresPorDefecto() {
        System.out.print("Test - Valores por defecto (NORMAL, \"es\"): ");
        Configuracion config = Configuracion.getInstance();
        boolean ok = config.getDificultad() == Dificultad.NORMAL
            && config.getIdioma().equals("es");
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testMismaInstancia() {
        System.out.print("Test - Misma instancia: ");
        Configuracion c1 = Configuracion.getInstance();
        Configuracion c2 = Configuracion.getInstance();
        boolean ok = (c1 == c2);
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testMultiplesLlamadas() {
        System.out.print("Test - Múltiples llamadas: ");
        Configuracion c1 = Configuracion.getInstance();
        Configuracion c2 = Configuracion.getInstance();
        Configuracion c3 = Configuracion.getInstance();
        boolean ok = (c1 == c2 && c2 == c3);
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testConfiguracionPersistente() {
        System.out.print("Test - Configuración persiste: ");
        Configuracion config = Configuracion.getInstance();
        config.setDificultad(Dificultad.EXTREMO);
        Configuracion otraConfig = Configuracion.getInstance();
        boolean ok = (otraConfig.getDificultad() == Dificultad.EXTREMO);
        System.out.println(ok ? "✅" : "❌");
        return ok;
    }

    static boolean testDificultadNullLanzaExcepcion() {
        System.out.print("Test - Dificultad null lanza excepción: ");
        try {
            Configuracion.getInstance().setDificultad(null);
            System.out.println("❌");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("✅");
            return true;
        }
    }

    static boolean testIdiomaVacioLanzaExcepcion() {
        System.out.print("Test - Idioma vacío lanza excepción: ");
        try {
            Configuracion.getInstance().setIdioma("");
            System.out.println("❌");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("✅");
            return true;
        }
    }

    static boolean testIdiomaNullLanzaExcepcion() {
        System.out.print("Test - Idioma null lanza excepción: ");
        try {
            Configuracion.getInstance().setIdioma(null);
            System.out.println("❌");
            return false;
        } catch (IllegalArgumentException e) {
            System.out.println("✅");
            return true;
        }
    }
}