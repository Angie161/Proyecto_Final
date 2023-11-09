package Logica;

import java.awt.*;

/**
 * Subclase de los angeles y es el de "poder" más alto.
 */
public class Serafin extends Angel {

    /**
     * Constructor que utiliza el de la superclase.
     *
     * @param bondad la bondad del serafin.
     * @param color el color del serafin.
     */
    public Serafin(int bondad, Color color) {
        super(bondad, 3, color);
    }
}
