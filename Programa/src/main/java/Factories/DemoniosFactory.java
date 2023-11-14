package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

public class DemoniosFactory extends AlmasFactory{
    protected int maldadRandom;
    protected Color color;
    private int xColor;
    private LuciferFactory luciferFactory = new LuciferFactory();
    private SatanFactory satanFactory = new SatanFactory();
    private LeviathanFactory leviathanFactory = new LeviathanFactory();

    public Demonio crearDemonio(LaMuerte laMuerte){
        Random NumrandomSelect = new Random();
        Random NumrandomMaldad = new Random();

        maldadRandom=(int)(NumrandomMaldad.nextInt(100) * Math.pow(laMuerte.getPoder(),2));
        numRandom=NumrandomSelect.nextInt(2)+1;

        switch (numRandom){
            case 1:
                return leviathanFactory.crearLeviathan(maldadRandom,selectColor());
            case 2:
                return luciferFactory.crearLucifer(maldadRandom,selectColor());
            case 3:
                return satanFactory.crearSatan(maldadRandom,selectColor());
            default:
                System.out.println("Se creó un alma nula");
                return null;
        }
    }

    @Override
    public Color selectColor() {
        Random NumrandomColor = new Random();
        xColor=NumrandomColor.nextInt(101);
        int redComponent=0; //Funcion para red
        int greenComponent=0; //Funcion para green
        int blueComponent=0; //Funcion para blue

        return color=new Color(redComponent, greenComponent, blueComponent);
    }
}
