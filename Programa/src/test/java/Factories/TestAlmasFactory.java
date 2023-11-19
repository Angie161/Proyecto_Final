package Factories;

import Logica.LaMuerte;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase del tipo test unitario para probar el correcto funcionamiento de los métodos de creación de almas de las Factory.
 */
class TestAlmasFactory {
    private AlmasFactory almasFactory;
    private AngelesFactory angelesFactory;
    private DemoniosFactory demoniosFactory;
    private PersonaFactory personaFactory;
    private LaMuerte laMuerte;
    private Color color;
    int i=100;

    /**
     * Inicializa las variables que se emplearán en todas las pruebas.
     */
    @BeforeEach
    void setup(){
        almasFactory = new AlmasFactory();
        angelesFactory = new AngelesFactory();
        demoniosFactory = new DemoniosFactory();
        personaFactory = new PersonaFactory();
        laMuerte = new LaMuerte();
        color = new Color(255,255,255);
    }

    /**
     * Se realizan 100 creaciones de almas distintas y se verifica que no sean nulas.
     * Se ejecuta esta cantidad de veces porque para crear almas se seleccionan números al azar entre el 1 y el 3 para elegir que subtipo de alma se crea,
     * por ende se realizan varias repeticiones para asegurar que no haya algún caso default.
     */
    @Test
    @DisplayName("Test de creación de almas")
    void creacionAlmas(){
        while(i!=0){
            assertNotNull(almasFactory.crearAlmas(laMuerte));
            assertNotNull(angelesFactory.crearAngel(laMuerte, color));
            assertNotNull(demoniosFactory.crearDemonio(laMuerte, color));
            assertNotNull(personaFactory.crearPersona(laMuerte, color));
            i-=1;
        }
    }
}