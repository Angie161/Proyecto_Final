package Logica;

public abstract class Demonio extends Almas{
    protected int rango;
    protected boolean enElLimbo;

    public Demonio(int maldad){
        super();
        enElLimbo=true;
        this.maldad=maldad;
        this.rango=rango;
    }

    @Override
    public int calcValor() {
        //Por definir
        return 0;
    }
}
