package juego.config;
 
import juego.util.Dificultad;
 
/**
 * Define las operaciones necesarias para consultar y modificar la configuración del juego, como la dificultad y el idioma.
 */
public interface ConfiguracionJuego {
 
    Dificultad getDificultad();
 
    void setDificultad(Dificultad dificultad);
 
    String getIdioma();
 
    void setIdioma(String idioma);
}