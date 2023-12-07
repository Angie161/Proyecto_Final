package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase del tipo test unitario para probar el correcto funcionamiento del método de agregarDemonio() en clase MundoTerrenal.
 */
public class TestMundoTerrenal {
    private MundoTerrenal mundoTerrenal;
    private Color color;
    private Lucifer lucifer;
    private Satan satan;
    private LaMuerte laMuerte;

    /**
     * Inicializa las variables que se emplearán en todas las pruebas.
     */
    @BeforeEach
    void setup(){
        mundoTerrenal = new MundoTerrenal();
        color = new Color(255,0,0);
        lucifer = new Lucifer(30, color);
        satan = new Satan(50, color);
        laMuerte = new LaMuerte();
    }

    /**
     * Se agrega un demonio en el depósito en mundo terrenal y se corroboran los estados iniciales y finales.
     *
     * @throws SinCapPermitidaException En caso de que se intente agregar otro demonio cuando no haya más capacidad en el mundo terrenal.
     */
    @Test
    @DisplayName("Test añadido de demonio al mundo terrenal")
    void agregadoDemonios() throws SinCapPermitidaException {
        assertEquals(0, mundoTerrenal.getCantDemEnviados());
        mundoTerrenal.agregarDemonio(lucifer);
        assertEquals(1, mundoTerrenal.getCantDemEnviados());
    }

    /**
     * Se prueba agregar dos demonios cuando solo hay capacidad para uno.
     * Se busca corroborar el correcto funcionamiento de la excepción SinCapPermitidaException.
     *
     * @throws SinCapPermitidaException En caso de que se intente agregar otro demonio cuando no haya más capacidad en el mundo terrenal.
     */
    @Test
    @DisplayName("Test sin capacidad")
    void sinCapacidad() throws SinCapPermitidaException {
        assertEquals(1, mundoTerrenal.getCapacidad());
        assertEquals(0, mundoTerrenal.getCantDemEnviados());
        mundoTerrenal.agregarDemonio(lucifer);
        assertEquals(1, mundoTerrenal.getCantDemEnviados());
        assertThrows(SinCapPermitidaException.class, () ->{
            mundoTerrenal.agregarDemonio(satan);
        });
    }

    /**
     * Se prueba que la cantidad de muertes generadas por un solo demonio en el mundo terrenal sea la correcta.
     *
     * @throws SinCapPermitidaException En caso de que se intente agregar otro demonio cuando no haya más capacidad en el mundo terrenal.
     */
    @Test
    @DisplayName("Test muertes por un demonio")
    void revisionMuertes() throws SinCapPermitidaException {
        mundoTerrenal.agregarDemonio(lucifer);
        assertEquals(1, mundoTerrenal.getCantDemEnviados());

        assertEquals(24, mundoTerrenal.muertes(laMuerte));
        laMuerte.setPoder(2);
        assertEquals(48, mundoTerrenal.muertes(laMuerte));
    }
}
