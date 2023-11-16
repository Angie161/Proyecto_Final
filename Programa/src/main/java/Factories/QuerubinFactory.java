package Factories;

import Logica.*;
import java.awt.*;

/**
 * Clase que representa y funciona como una fábrica de ángeles de tipo Querubín.
 */
public class QuerubinFactory extends AngelesFactory{
    /**
     * Crea un ángel Querubín.
     * @param bondad la cual se le asignará al nuevo ángel como estadística.
     * @param color el cual se le asignará al nuevo ángel como estadística.
     * @return Querubín con las características concedidas.
     */
    public Angel crearQuerubin(int bondad, Color color){
        return new Querubin(bondad,color);
    }
}
