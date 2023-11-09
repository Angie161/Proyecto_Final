package Logica;

import java.awt.*;
import java.util.Random;

/**
 * Esta es una subclase de Almas y va a ser superclase de todos los tipos de demonios.
 */
public abstract class Demonio extends Almas {
    protected int rango;
    protected boolean enElLimbo;

    /**
     * Constructor personalizado para poder asignar las características a los demonios.
     *
     * @param maldad la cantidad de maldad que se le quiere asignar al demonio.
     * @param rango  el rango que se le asignara al demonio.
     * @param color  el color que tendrá el demonio.
     */
    public Demonio(int maldad, int rango, Color color) {
        super();
        this.enElLimbo = true;
        this.maldad    = maldad;
        this.rango     = rango;
        this.color     = color;
    }

    /**
     * Override de calcValor() que contiene la fórmula para calcular el valor del demonio.
     *
     * @return el valor del demonio.
     */
    @Override
    public int calcValor() {
        int    colores    = color.getBlue() + color.getRed() + color.getGreen();
        double random     = ((new Random()).nextDouble(0.4) + 0.4);
        double valorFinal = random * Math.pow(rango,1.5)*(colores + maldad);
        return (int) valorFinal;
    }
}
