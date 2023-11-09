package Logica;

public abstract class Angel extends Almas{
    protected int rango;
    protected boolean enElLimbo;

    public Angel(int bondad, int rango){
        super();
        enElLimbo=true;
        this.bondad=bondad;
        this.rango=rango;
    }

    @Override
    public int calcValor() {
        //Por definir
        return 0;
    }
}
