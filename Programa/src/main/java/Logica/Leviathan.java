package Logica;

import java.awt.*;

/**
 * Esta es una subclase de Demonio y representa al demonio de más bajo nivel.
 */
public class Leviathan extends Demonio {

    /**
     * Constructor personalizado en el que usamos el constructor de la superclase.
     *
     * @param maldad la maldad que le quedemos asignar.
     * @param color  el color que le queremos asignar.
     */
    public Leviathan(int maldad, Color color) {
        super(maldad,1, color);
    }
}
