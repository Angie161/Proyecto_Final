package Factories;

import Logica.*;
import java.awt.*;

/**
 * Clase que representa y funciona como una fábrica de demonios de tipo Lucifer.
 */
public class LuciferFactory extends DemoniosFactory{
    /**
     * Crea un demonio del tipo Lucifer.
     * @param maldad la cual se le asignará al nuevo demonio como estadística.
     * @param color el cual se le asignará al nuevo demonio como estadística.
     * @return demonio Lucifer con las características concedidas.
     */
    public static Demonio crearLucifer(int maldad, Color color){
        return new Lucifer(maldad,color);
    }
}
