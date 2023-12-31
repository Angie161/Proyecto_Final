package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

/**
 * Clase que representa y funciona como una fábrica de almas de Personas.
 */
public class PersonaFactory extends AlmasFactory{

    /**
     * Crea almas de Personas, calculando su maldad y bondad previamente a partir de las estadísticas de Poder de la muerte.
     * @param laMuerte personaje que maneja el usuario con el que obtendremos las estadísticas de poder.
     * @param color que se pasará como parámetro al método de creación del alma de la persona.
     * @return Persona con las estadísticas asignadas.
     */
    public static Persona crearPersona(LaMuerte laMuerte, Color color){
        Random random = new Random();

        int maldadRandom=(int)(random.nextInt(101) * Math.pow(laMuerte.getPoder(),2));
        int bondadRandom=(int)(random.nextInt(101) * Math.pow(laMuerte.getPoder(),2));

        return new Persona(bondadRandom,maldadRandom,color);
    }

    /**
    * Fusiona dos tipos de almas para generar una persona.
    * 
    * @param alma1 solicitada en el primer altar para hacer la fusión.
    * @param alma2 solicitada en el segundo altar para hacer la fusión.
    * @return Persona generada tras la fusión.
    */
    public static Persona crearPersona(Almas alma1, Almas alma2) {
        Random random = new Random();
        int maldadRandom;
        int bondadRandom;
        if(random.nextBoolean()) {
            maldadRandom = (int) (alma1.getMaldad() + alma2.getMaldad() * 1.5);
        } else {
            maldadRandom = (int) (alma1.getMaldad() * 1.5 + alma2.getMaldad());
        }
        if(random.nextBoolean()) {
            bondadRandom = (alma1.getBondad() + alma2.getBondad() * 2);
        } else {
            bondadRandom = (alma1.getBondad() * 2 + alma2.getBondad());
        }

        return new Persona(bondadRandom,maldadRandom,getColorAleatorio(0));
    }
}
