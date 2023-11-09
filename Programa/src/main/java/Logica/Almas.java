package Logica;

import java.awt.*;

public abstract class Almas {
    protected int bondad;
    protected int maldad;
    protected Color color;

    public Almas(){
        bondad=0;
        maldad=0;
        color=null;
    }

    public int getBondad(){
        return bondad;
    }

    public int getMaldad(){
        return maldad;
    }

    public Color getColor(){
        return color;
    }

    //Consultar al Walter si trabajaremos con enteros o doubles
    public abstract int calcValor();
}
