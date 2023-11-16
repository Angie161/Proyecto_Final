package Factories;

import Logica.*;
import java.awt.*;

/**
 * Clase que representa y funciona como una fábrica de ángeles de tipo Arcángel.
 */
public class ArcangelFactory extends AngelesFactory {
    /**
     * Crea un ángel Arcángel.
     * @param bondad la cual se le asignará al nuevo ángel como estadística.
     * @param color el cual se le asignará al nuevo ángel como estadística.
     * @return Arcángel con las características concedidas.
     */
    public static Arcangel crearArcangel(int bondad, Color color){
        return new Arcangel(bondad, color);
    }
}