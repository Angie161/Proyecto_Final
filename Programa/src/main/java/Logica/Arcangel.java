package Logica;

import java.awt.*;

/**
 * Subclase de los angeles y es el de menos "poder".
 */
public class Arcangel extends Angel {

    /**
     * Constructor que utiliza el de la superclase.
     *
     * @param bondad la bondad del ángel.
     * @param color el color del ángel.
     */
    public Arcangel(int bondad, Color color) {
        super(bondad, 1, color);
    }
}
