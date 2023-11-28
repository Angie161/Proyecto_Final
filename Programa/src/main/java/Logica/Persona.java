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
    @Override
    public int calcValor(LaMuerte laMuerte) {
        double colores    = (color.getBlue() + color.getRed() + color.getGreen())/8 + 100;
        double valorFinal = Math.pow(laMuerte.getPoder(),2.5) * (Math.pow(colores, 1.1) + Math.pow(maldad, 1) + Math.pow(bondad,1.5));
        return (int) Math.pow(valorFinal, 0.85);
    }
}
