package Logica;

import java.awt.*;

public abstract class Angel extends Almas{
    protected int rango;

    public Angel(int bondad, int rango, Color color){
        super();
        this.bondad=bondad;
        this.rango=rango;
        this.color=color;
    }

    @Override
    public int calcValor() {
        //Por definir
        return 0;
    }
}
