package Logica;

import java.awt.*;

/**
 * Subclase de los angeles y es el de "poder" medio.
 */
public class Querubin extends Angel {

    /**
     * Constructor que utiliza el de la superclase.
     *
     * @param bondad la bondad del querubín.
     * @param color el color del querubín.
     */
    public Querubin(int bondad, Color color) {
        super(bondad, 2, color);
    }
}
