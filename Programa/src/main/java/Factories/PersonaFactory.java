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
}
