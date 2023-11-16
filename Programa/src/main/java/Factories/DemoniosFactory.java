package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

/**
 * Clase que representa y funciona como una fábrica de almas de Demonios, la cual creará un subtipo de demonio dependiendo de un valor al azar.
 */
public class DemoniosFactory extends AlmasFactory{

    /**
     * Genera almas de demonios a partir de un número random que puede ser 1, 2 o 3 para obtener un Leviathan, lucifer o satan.
     * @param laMuerte con la cual obtendremos sus estadísticas de poder para influir en el cálculo de la maldad de los demonios.
     * @param color que se pasará como parámetro al método de creación de un alma de demonio específico.
     * @return demonio de un tipo al azar.
     */
    public static Demonio crearDemonio(LaMuerte laMuerte, Color color){
        Random random = new Random();

        int maldad=(int)(random.nextInt(100) * Math.pow(laMuerte.getPoder(),2));
        int numSelect=random.nextInt(2)+1;

        switch (numSelect){
            case 1:
                return LeviathanFactory.crearLeviathan(maldad,color);
            case 2:
                return LuciferFactory.crearLucifer(maldad,color);
            case 3:
                return SatanFactory.crearSatan(maldad,color);
            default:
                System.out.println("Se creó un Demonios nulo");
                return null;
        }
    }
}
