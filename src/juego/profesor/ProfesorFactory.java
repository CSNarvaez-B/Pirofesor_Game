package juego.profesor;

import java.util.Random;

import juego.util.TipoProfesor;

/**
 * Fábrica de profesores.
 *
 * <p>Patrón aplicado: Factory Method. Centraliza la creación de los productos
 * concretos ({@link ProfesorMatematicas}, {@link ProfesorArquitectura} y
 * {@link ProfesorInformatica}) para que el resto del juego pida un profesor sin
 * conocer sus clases ni sus constructores.</p>
 *
 * @author Juan
 * @version 1.0
 */
public class ProfesorFactory {

    private final Random generadorAleatorio;

    /**
     * Crea una fábrica con su propio generador de números aleatorios.
     */
    public ProfesorFactory() {
        this.generadorAleatorio = new Random();
    }

    /**
     * Crea un profesor del tipo indicado.
     *
     * @param tipoProfesor el tipo de profesor que se desea crear
     * @return una nueva instancia del profesor concreto correspondiente
     * @throws IllegalArgumentException si el tipo es null o no está soportado
     */
    public Profesor crearProfesor(TipoProfesor tipoProfesor) {
        if (tipoProfesor == null) {
            throw new IllegalArgumentException("El tipo de profesor no puede ser null");
        }
        switch (tipoProfesor) {
            case MATEMATICAS:
                return new ProfesorMatematicas();
            case ARQUITECTURA:
                return new ProfesorArquitectura();
            case INFORMATICA:
                return new ProfesorInformatica();
            default:
                throw new IllegalArgumentException("Tipo de profesor no soportado: " + tipoProfesor);
        }
    }

    /**
     * Crea un profesor de un tipo elegido al azar entre todos los disponibles.
     *
     * @return una nueva instancia de un profesor concreto aleatorio
     */
    public Profesor crearProfesorAleatorio() {
        TipoProfesor[] tiposDisponibles = TipoProfesor.values();
        int indiceAleatorio = generadorAleatorio.nextInt(tiposDisponibles.length);
        return crearProfesor(tiposDisponibles[indiceAleatorio]);
    }
}
