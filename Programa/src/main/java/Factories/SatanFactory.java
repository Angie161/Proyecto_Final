package Factories;

import Logica.*;
import java.awt.*;

/**
 * Clase que representa y funciona como una fábrica de demonios de tipo Satan.
 */
public class SatanFactory extends DemoniosFactory{
    /**
     * Crea un demonio del tipo Satan.
     * @param maldad la cual se le asignará al nuevo demonio como estadística.
     * @param color el cual se le asignará al nuevo demonio como estadística.
     * @return demonio Satan con las características concedidas.
     */
    public static Demonio crearSatan(int maldad, Color color){
        return new Satan(maldad,color);
    }
}
