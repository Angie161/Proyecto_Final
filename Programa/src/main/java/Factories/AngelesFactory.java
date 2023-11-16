package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

/**
 * Clase que representa y funciona como una fábrica de almas de Angeles, la cual creará un subtipo de ángel dependiendo de un valor al azar.
 */
public class AngelesFactory extends AlmasFactory{
    protected int numSelect;
    private int bondad;
    private ArcangelFactory arcangelFactory = new ArcangelFactory();
    private QuerubinFactory querubinFactory = new QuerubinFactory();
    private SerafineFactory serafineFactory = new SerafineFactory();

    /**
     * Genera almas de ángeles a partir de un número random que puede ser 1, 2 o 3 para obtener un arcángel, querubín o serafine.
     * @param laMuerte con la cual obtendremos sus estadísticas de poder para influir en el cálculo de la bondad de los ángeles.
     * @param color que se pasará como parámetro al método de creación de un alma de ángel específico.
     * @return ángel de un tipo al azar.
     */
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