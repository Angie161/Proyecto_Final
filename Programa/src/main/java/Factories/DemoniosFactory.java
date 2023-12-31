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

        int maldad=(int)(random.nextInt(101) * Math.pow(laMuerte.getPoder(),2));
        int numSelect=random.nextInt(3)+1;

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

    /**
    * Fusiona dos tipos de demonios para generar uno nuevo, que tendrá el rango del demonio con rango mayor.
    * 
    * @param demonio1 solicitado en el primer altar para hacer la fusión.
    * @param demonio2 solicitado en el segundo altar para hacer la fusión.
    * @return Demonio generado tras la fusión.
    */
    public static Demonio crearDemonio(Demonio demonio1, Demonio demonio2) {
        Random random = new Random();
        int maldad;
        if(random.nextBoolean()) {
            maldad = (int) (Math.pow(demonio1.getColor().getRed(), 0.5) * (demonio1.getMaldad() + demonio2.getMaldad() * 1.5));
        } else {
            maldad = (int) (Math.pow(demonio2.getColor().getRed(), 0.5) * (demonio1.getBondad() * 1.5 + demonio2.getMaldad()));
        }
        if(demonio1 instanceof Satan || demonio2 instanceof Satan) {
            return SatanFactory.crearSatan(maldad, getColorAleatorio(1));
        } else if(demonio1 instanceof Lucifer || demonio2 instanceof Lucifer) {
            return LuciferFactory.crearLucifer(maldad, getColorAleatorio(1));
        } else {
            return LeviathanFactory.crearLeviathan(maldad, getColorAleatorio(1));
        }
    }
}
