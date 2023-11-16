package Factories;

import Logica.*;
import java.awt.*;

/**
 * Clase que representa y funciona como una fábrica de ángeles de tipo Serafine.
 */
public class SerafineFactory extends AngelesFactory{
    /**
     * Crea un ángel Serafine.
     * @param bondad la cual se le asignará al nuevo ángel como estadística.
     * @param color el cual se le asignará al nuevo ángel como estadística.
     * @return Serafine con las características concedidas.
     */
    public static Serafin crearSerafine(int bondad, Color color){
        return new Serafin(bondad, color);
    }
}