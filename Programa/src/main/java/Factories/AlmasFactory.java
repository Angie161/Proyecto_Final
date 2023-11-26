package Factories;

import Logica.*;
import java.awt.*;
import java.util.Random;

/**
 * Clase que representa y funciona como una fábrica de almas, permitiendo crear de manera al azar un tipo de alma, ya se Angeles, Personas o Demonios.
 */
public class AlmasFactory{

    /**
     * Crea un tipo de alma a partir de un número random.
     * @param laMuerte la cual se solicita para posteriormente acceder a sus estadísticas.
     * @return un alma de un tipo al azar.
     */
    public static Almas crearAlmas(LaMuerte laMuerte){
        Random random = new Random();
        int numSelect=random.nextInt(101);
        if(numSelect>50){
            return AngelesFactory.crearAngel(laMuerte, getColorAleatorio(2));
        } else if (numSelect==50) {
            return PersonaFactory.crearPersona(laMuerte,getColorAleatorio(0));
        } else {
            return DemoniosFactory.crearDemonio(laMuerte, getColorAleatorio(1));
        }
    }
    public static Almas fusionarAlmas(LaMuerte laMuerte, Almas alma1, Almas alma2) {
        if(alma1 instanceof Angel) {
            if(alma2 instanceof Angel) {
                return AngelesFactory.crearAngel((Angel) alma1, (Angel) alma2);
            } else if(alma2 instanceof Persona || alma2 instanceof Demonio) {
                return PersonaFactory.crearPersona(alma1, alma2);
            }
        } else if(alma1 instanceof Demonio) {
            if(alma2 instanceof Demonio) {
                return DemoniosFactory.crearDemonio((Demonio) alma1, (Demonio) alma2);
            } else if(alma2 instanceof Persona || alma2 instanceof Angel) {
                return PersonaFactory.crearPersona(alma1, alma2);
            }
        } else if(alma1 instanceof Persona) {
            return PersonaFactory.crearPersona(alma1, alma2);
        }
        return null;
    }

    /**
     * Obtiene un color al azar dentro de la gama de colores permitida para cada tipo de alma.
     * @param cual entero con un valor entre 0 y 2 que permitirá seleccionar la gama de colores.
     * @return un color al azar dentro de la gama correspondiente al alma.
     */
    protected static Color getColorAleatorio(int cual) {
        Random random = new Random();
        // 0 para persona, 1 para demonios y 2 para ángeles.
        if(cual == 0) {
            // Color para las personas.
            int red   = random.nextInt(231) + 25;
            int green = random.nextInt(231) + 25;
            int blue  = random.nextInt(231) + 25;
            return new Color(red, green, blue);

        } else if(cual == 1) {
            // Color para los demonios.
            int r = random.nextInt(101);
            int red = (int) (-Math.pow(r, 3)*0.00049 + Math.pow(r, 2)*0.0685 + 24.9);
            return new Color(red, 0, 0);

        } else if(cual == 2) {
            // Color para los ángeles.
            int r = random.nextInt(101);
            int red   = (int) (Math.pow(r, 3)*0.0000036 - Math.pow(r, 2)*0.00066 + 255);
            int green = (int) (-Math.pow(r, 3)*0.000024897959 - Math.pow(r, 2)*0.00091 + 255);
            int blue  = (int) (-Math.pow(r, 3)*0.0001534 - Math.pow(r, 2)*0.00415986 + 255);
            return new Color(red, green, blue);

        } else {
            // Si se ingresa un numero erróneo.
            return null;
        }
    }
}