package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

public class DemoniosFactory extends AlmasFactory{
    protected int numSelect;
    private int maldad;

    private LuciferFactory luciferFactory = new LuciferFactory();
    private SatanFactory satanFactory = new SatanFactory();
    private LeviathanFactory leviathanFactory = new LeviathanFactory();

    public Demonio crearDemonio(LaMuerte laMuerte, Color color){
        Random random = new Random();

        maldad=(int)(random.nextInt(100) * Math.pow(laMuerte.getPoder(),2));
        numSelect=random.nextInt(2)+1;

        switch (numSelect){
            case 1:
                return leviathanFactory.crearLeviathan(maldad,color);
            case 2:
                return luciferFactory.crearLucifer(maldad,color);
            case 3:
                return satanFactory.crearSatan(maldad,color);
            default:
                System.out.println("Se creó un Demonios nulo");
                return null;
        }
    }
}
