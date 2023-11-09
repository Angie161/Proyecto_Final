package Logica;

import java.awt.*;

public abstract class Demonio extends Almas{
    protected int rango;
    protected boolean enElLimbo;

    public Demonio(int maldad, int rango, Color color){
        super();
        enElLimbo=true;
        this.maldad=maldad;
        this.rango=rango;
        this.color=color;
    }

    @Override
    public int calcValor() {
        //Por definir
        return 0;
    }
}
