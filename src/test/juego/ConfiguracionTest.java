package juego;

import juego.config.Configuracion;
import juego.util.Dificultad;

public class ConfiguracionTest {
    
    public static void main(String[] args) {
        System.out.println("🧪 TESTS DEL PATRÓN SINGLETON\n");
        
        int pasados = 0;
        int total = 0;
        
        total++;
        if (testMismaInstancia()) pasados++;
        
        total++;
        if (testMultiplesLlamadas()) pasados++;
        
        total++;
        if (testConfiguracionPersistente()) pasados++;
        
        total++;
        if (testDificultadNull()) pasados++;
        
        total++;
        if (testIdiomaVacio()) pasados++;
        
        System.out.println("\n📊 Resultado: " + pasados + "/" + total + " tests pasaron");
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
    
    static boolean testDificultadNull() {
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
    
    static boolean testIdiomaVacio() {
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
}