package Logica;

import java.awt.*;
import java.util.Random;

/**
 * Esta es una subclase de Almas y va a ser superclase de todos los tipos de demonios.
 */
public abstract class Demonio extends Almas {
    protected int rango;

    /**
     * Constructor personalizado para poder asignar las características a los demonios.
     *
     * @param maldad la cantidad de maldad que se le quiere asignar al demonio.
     * @param rango  el rango que se le asignara al demonio.
     * @param color  el color que tendrá el demonio.
     */
    public Demonio(int maldad, int rango, Color color) {
        super();

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
    public int calcValor(LaMuerte laMuerte) {
        double colores    = (color.getBlue() + color.getRed() + color.getGreen()) / 255;
        double random     = ((new Random()).nextDouble(0.4) + 0.8);
        double valorFinal = Math.pow(laMuerte.getPoder(),5) * random * Math.pow(rango,1.5) * (colores + maldad);
        return (int) valorFinal;
    }

    /**
     * Realiza el cálculo de la cantidad de muertes que un demonio puede provocar basándonos en sus estadísticas.
     *
     * @return entero con la cantidad de asesinatos provocados por el demonio.
     */
    public int matar() {
        double asesinatos = maldad * Math.pow(rango,1.5);
        return (int) asesinatos;
    }
}
