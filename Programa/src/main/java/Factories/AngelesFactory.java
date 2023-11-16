package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

/**
 * Clase que representa y funciona como una fábrica de almas de Angeles, la cual creará un subtipo de ángel dependiendo de un valor al azar.
 */
public class AngelesFactory extends AlmasFactory{

    /**
     * Genera almas de ángeles a partir de un número random que puede ser 1, 2 o 3 para obtener un arcángel, querubín o serafine.
     * @param laMuerte con la cual obtendremos sus estadísticas de poder para influir en el cálculo de la bondad de los ángeles.
     * @param color que se pasará como parámetro al método de creación de un alma de ángel específico.
     * @return ángel de un tipo al azar.
     */
    public static Angel crearAngel(LaMuerte laMuerte, Color color){
        Random random = new Random();

        int bondad=(int)(random.nextInt(101) * Math.pow(laMuerte.getPoder(),2));
        int numSelect=random.nextInt(3)+1;

        switch (numSelect){
            case 1:
                return ArcangelFactory.crearArcangel(bondad, color);
            case 2:
                return QuerubinFactory.crearQuerubin(bondad, color);
            case 3:
                return SerafineFactory.crearSerafine(bondad, color);
            default:
                System.out.println("Se creó un Angel nulo");
                return null;
        }
    }
}