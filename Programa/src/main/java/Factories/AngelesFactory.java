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

    /**
    * Fusiona dos tipos de ángeles para generar uno nuevo, que tendrá el rango del angel con rango mayor.
    * 
    * @param angel1 solicitado en el primer altar para hacer la fusión.
    * @param angel2 solicitado en el segundo altar para hacer la fusión.
    * @return Angel generado tras la fusión.
    */
    public static Angel crearAngel(Angel angel1, Angel angel2) {
        Random random = new Random();
        int bondad;
        if(random.nextBoolean()) {
            bondad = (angel1.getColor().getRGB() / angel2.getColor().getRGB()) * (angel1.getBondad() + angel2.getBondad());
        } else {
            bondad = (angel2.getColor().getRGB() / angel1.getColor().getRGB()) * (angel1.getBondad() + angel2.getBondad());
        }
        if(angel1 instanceof Serafin || angel2 instanceof Serafin) {
            return SerafineFactory.crearSerafine(bondad, getColorAleatorio(2));
        } else if(angel1 instanceof Querubin || angel2 instanceof Querubin) {
            return QuerubinFactory.crearQuerubin(bondad, getColorAleatorio(2));
        } else {
            return ArcangelFactory.crearArcangel(bondad, getColorAleatorio(2));
        }
    }
}
