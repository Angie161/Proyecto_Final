package Logica;

import java.awt.*;

/**
 * Esta es una subclase de Demonio y representa al demonio de mayor nivel.
 */
public class Satan extends Demonio {

    /**
     * Constructor personalizado en el que usamos el constructor de la superclase.
     *
     * @param maldad la maldad que le quedemos asignar.
     * @param color  el color que le queremos asignar.
     */
    public Satan(int maldad, Color color) {
        super(maldad,3, color);
    }
}
