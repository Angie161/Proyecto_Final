package Logica;

import java.awt.*;
import java.util.Random;

/**
 * Esta es una subclase de Almas y va a ser superclase de todos los tipos de ángeles.
 */
public abstract class Angel extends Almas {
    protected int rango;

    /**
     * Constructor personalizado para poder asignar las características a los ángeles.
     *
     * @param bondad la cantidad de bondad que se le quiere asignar al ángel.
     * @param rango  el rango que se le asignara al ángel.
     * @param color  el color que tendrá el ángel.
     */
    public Angel(int bondad, int rango, Color color) {
        super();
        this.bondad = bondad;
        this.rango  = rango;
        this.color  = color;
    }

    /**
     * Override de calcValor() que contiene la fórmula para calcular el valor del ángel.
     *
     * @return el valor del ángel.
     */
    public int calcValor() {
        int    colores    = color.getBlue() + color.getRed() + color.getGreen();
        double random     = ((new Random()).nextDouble(0.4) + 0.8);
        double valorFinal = random*Math.pow(rango,1.5)*(colores + bondad);
        return (int) valorFinal;
    }
}
