package juego.profesor;

import juego.util.TipoProfesor;

/**
 * Clase base abstracta que reúne los atributos y el comportamiento común de
 * todos los profesores.
 *
 * <p>Patrón aplicado: Factory Method. Los productos concretos
 * ({@link ProfesorMatematicas}, {@link ProfesorArquitectura} y
 * {@link ProfesorInformatica}) heredan de esta clase y solo aportan sus
 * estadísticas iniciales, evitando repetir los getters, los setters y las
 * validaciones en cada uno.</p>
 *
 * @author Juan
 * @version 1.0
 */
public abstract class ProfesorBase implements Profesor {

    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private final TipoProfesor tipoProfesor;

    /**
     * Construye un profesor con sus estadísticas iniciales.
     *
     * @param nombre        el nombre visible del profesor
     * @param vida          los puntos de vida iniciales
     * @param ataque        el valor de ataque inicial
     * @param defensa       el valor de defensa inicial
     * @param tipoProfesor  el tipo de profesor
     * @throws IllegalArgumentException si algún dato es inválido
     */
    protected ProfesorBase(String nombre, int vida, int ataque, int defensa, TipoProfesor tipoProfesor) {
        if (tipoProfesor == null) {
            throw new IllegalArgumentException("El tipo de profesor no puede ser null");
        }
        setNombre(nombre);
        setVida(vida);
        setAtaque(ataque);
        setDefensa(defensa);
        this.tipoProfesor = tipoProfesor;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del profesor no puede estar vacío");
        }
        this.nombre = nombre.trim();
    }

    @Override
    public int getVida() {
        return vida;
    }

    @Override
    public void setVida(int vida) {
        if (vida < 0) {
            throw new IllegalArgumentException("La vida no puede ser negativa");
        }
        this.vida = vida;
    }

    @Override
    public int getAtaque() {
        return ataque;
    }

    @Override
    public void setAtaque(int ataque) {
        if (ataque < 0) {
            throw new IllegalArgumentException("El ataque no puede ser negativo");
        }
        this.ataque = ataque;
    }

    @Override
    public int getDefensa() {
        return defensa;
    }

    @Override
    public void setDefensa(int defensa) {
        if (defensa < 0) {
            throw new IllegalArgumentException("La defensa no puede ser negativa");
        }
        this.defensa = defensa;
    }

    @Override
    public TipoProfesor getTipoProfesor() {
        return tipoProfesor;
    }

    @Override
    public void recibirDanio(int cantidadDanio) {
        if (cantidadDanio < 0) {
            throw new IllegalArgumentException("La cantidad de daño no puede ser negativa");
        }
        int danioReal = Math.max(cantidadDanio - defensa, 0);
        this.vida = Math.max(this.vida - danioReal, 0);
    }

    @Override
    public boolean estaVivo() {
        return vida > 0;
    }

    @Override
    public String toString() {
        return "Profesor{nombre='" + nombre + "'"
                + ", tipo=" + tipoProfesor
                + ", vida=" + vida
                + ", ataque=" + ataque
                + ", defensa=" + defensa + "}";
    }
}
