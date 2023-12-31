package Factories;

import Logica.*;
import java.awt.*;

/**
 * Clase que representa y funciona como una fábrica de demonios de tipo Leviathan.
 */
public class LeviathanFactory extends DemoniosFactory{
    /**
     * Crea un demonio Leviathan.
     * @param maldad la cual se le asignará al nuevo demonio como estadística.
     * @param color el cual se le asignará al nuevo demonio como estadística.
     * @return Leviathan con las características concedidas.
     */
    public static Demonio crearLeviathan(int maldad, Color color){
        return new Leviathan(maldad,color);
    }
}
