package Logica;

import java.awt.*;
import java.util.Random;

/**
 * Esta es una subclase de Almas y representa las almas de las personas.
 */
public class Persona extends Almas {

    /**
     * Constructor personalizado para poder asignar las características a las personas.
     *
     * @param bondad la cantidad de bondad que se le quiere asignar a la persona.
     * @param maldad  la cantidad de maldad que se le quiere asignar a la persona.
     * @param color  el color que tendrá la persona.
     */
    public Persona(int bondad, int maldad, Color color) {
        this.bondad = bondad;
        this.maldad = maldad;
        this.color  = color;
    }

    /**
     * Implementado calcValor() que contiene la fórmula para calcular el valor de la persona.
     *
     * @return el valor de la persona.
     */
    public int calcValor() {
        int    colores    = color.getBlue() + color.getRed() + color.getGreen();
        double random     = ((new Random()).nextDouble(0.4) + 0.8);
        double valorFinal = random * Math.pow((maldad * bondad)/(maldad + bondad), 1.5)*(colores + maldad + bondad);
        return (int) valorFinal;
    }
}
