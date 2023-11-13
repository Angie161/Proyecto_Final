package Logica;

import java.awt.*;

/**
 * Esta es la superclase de todas las almas del juego y contiene las variables base y métodos básicos.
 */
public abstract class Almas {
    protected int bondad;
    protected int maldad;
    protected Color color;

    /**
     * Este es el constructor en el que inicializamos las variables base.
     */
    public Almas() {
        bondad = 0;
        maldad = 0;
        color  = null;
    }

    /**
     * Getter de la variable bondad.
     *
     * @return el valor de la variable bondad.
     */
    public int getBondad() {
        return bondad;
    }

    /**
     * Getter de la variable maldad.
     *
     * @return el valor de la variable maldad.
     */
    public int getMaldad() {
        return maldad;
    }

    /**
     * Getter del color del alma.
     *
     * @return  el color del alma como una instancia de la clase Color.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Método para calcular el valor.
     *
     * @return el valor que va a tomar el objeto.
     */
    public abstract int calcValor(LaMuerte laMuerte);
}
