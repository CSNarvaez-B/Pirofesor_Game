package juego.config;
 
import juego.util.Dificultad;
 
/**
 * Contrato de configuración del juego. Las clases que necesiten
 * leer (o modificar) la configuración dependen de esta interfaz,
 * no de una implementación concreta ni de un acceso estático global.
 *
 * @author Cristian
 * @version 1.0
 */
public interface ConfiguracionJuego {
 
    Dificultad getDificultad();
 
    void setDificultad(Dificultad dificultad);
 
    String getIdioma();
 
    void setIdioma(String idioma);
}