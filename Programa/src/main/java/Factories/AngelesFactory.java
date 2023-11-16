package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

public class AngelesFactory extends AlmasFactory{
    protected int numSelect;
    private int bondad;

    private ArcangelFactory arcangelFactory = new ArcangelFactory();
    private QuerubinFactory querubinFactory = new QuerubinFactory();
    private SerafineFactory serafineFactory = new SerafineFactory();

    public Angel crearAngel(LaMuerte laMuerte, Color color){
        Random random = new Random();

        bondad=(int)(random.nextInt(100) * Math.pow(laMuerte.getPoder(),2));
        numSelect=random.nextInt(2)+1;

        switch (numSelect){
            case 1:
                return arcangelFactory.crearArcangel(bondad, color);
            case 2:
                return querubinFactory.crearQuerubin(bondad, color);
            case 3:
                return serafineFactory.crearSerafine(bondad, color);
            default:
                System.out.println("Se creó un Angel nulo");
                return null;
        }
    }
}