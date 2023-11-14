package Factories;

import Logica.Almas;
import Logica.LaMuerte;

import java.awt.*;
import java.util.Random;

public abstract class AlmasFactory {
    protected int numRandom;
    private AngelesFactory angelesFactory = new AngelesFactory();
    private PersonaFactory personaFactory = new PersonaFactory();
    private DemoniosFactory demoniosFactory = new DemoniosFactory();
    protected LaMuerte laMuerte= null;

    public Almas crearAlma(LaMuerte laMuerte){
        this.laMuerte=laMuerte;
        Random random = new Random();
        numRandom=random.nextInt(101);
        if (numRandom < 50) {
            return demoniosFactory.crearDemonio(laMuerte);
        } else if (numRandom==50) {
            return;
        }else{
            return;
        }
    }
    public abstract Color selectColor();
}
