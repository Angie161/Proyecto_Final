package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

public class PersonaFactory extends AlmasFactory{
    protected int maldadRandom;
    protected int bondadRandom;

    public Persona crearPersona(LaMuerte laMuerte, Color color){
        Random random = new Random();

        maldadRandom=(int)(random.nextInt(100) * Math.pow(laMuerte.getPoder(),2));
        bondadRandom=(int)(random.nextInt(100) * Math.pow(laMuerte.getPoder(),2));

        return new Persona(bondadRandom,maldadRandom,color);
    }
}
