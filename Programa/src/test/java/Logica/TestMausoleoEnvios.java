package Logica;

import Factories.*;
import Logica.*;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestMausoleoEnvios {
    private Mausoleo mausoleo;
    private LaMuerte laMuerte;
    private MundoTerrenal mundoTerrenal;
    private Barca barca;
    private DemoniosFactory demFactory;
    private AngelesFactory angFactory;
    private Color color;

    @BeforeEach
    void setup(){
        laMuerte = new LaMuerte();
        barca = new Barca();
        mundoTerrenal = new MundoTerrenal(barca);
        mausoleo = new Mausoleo(laMuerte,mundoTerrenal);
        color = new Color(0,0,0);
        demFactory = new DemoniosFactory();
        angFactory = new AngelesFactory();

        // Hacemos la barca funcional
        mausoleo.getBarca().setFuncional(true);

        // Agregamos el mínimo de fragmentos de alma para hacer un envío
        laMuerte.addFragAlmas(500);

        // Agregamos un 5 Angeles al depósito de la muerte, el mínimo para hacer un envío
        for(int i=0; i<5; i++) {
            laMuerte.getDepSobre()[2].add(angFactory.crearAngel(laMuerte, color));
        }

        //Agregamos el demonio que queremos enviar
        laMuerte.getDepSobre()[1].add(demFactory.crearDemonio(laMuerte, color));
    }

    //Enviar demonio normal
    @Test
    @DisplayName("Test envío correcto")
    void envioCorrecto() throws DemonioNullException, BarcaRotaException, FragmentosInsuficientesException, SinCapPermitidaException, AngelesInsuficienteException {
        assertNotNull(laMuerte.getDepSobre()[1].see(0));
        assertEquals(500, mausoleo.getPrecios().getPrecioFragEnvio(mundoTerrenal));
        assertEquals(5, mausoleo.getPrecios().getCantAngelesEnvio(mundoTerrenal));

        assertEquals(1, mausoleo.getTierra().getCapacidad());
        assertEquals(0, mausoleo.getTierra().getCantDemEnviados());
        mausoleo.enviarDemonio();
        assertEquals(1, mausoleo.getTierra().getCantDemEnviados());

        assertEquals(0, laMuerte.getFragAlmas());
        assertEquals(0, laMuerte.getDepSobre()[1].getTam());
        assertEquals(0, laMuerte.getDepSobre()[2].getTam());
    }

    //Enviar 2 demonios con capacidad de 1 en mundoTerrenal
    @Test
    @DisplayName("Test capacidad insuficiente")
    void capacidadInsuficiente() throws DemonioNullException, BarcaRotaException, FragmentosInsuficientesException, SinCapPermitidaException, AngelesInsuficienteException {
        //Añadimos un segundo demonio al depósito de la muerte.
        laMuerte.getDepSobre()[1].add(demFactory.crearDemonio(laMuerte, color));
        assertEquals(2, laMuerte.getDepSobre()[1].getTam());

        mausoleo.enviarDemonio();
        assertEquals(1,mausoleo.getTierra().getCantDemEnviados());
        assertEquals(0, laMuerte.getFragAlmas());
        assertEquals(1, laMuerte.getDepSobre()[1].getTam());
        assertEquals(0, laMuerte.getDepSobre()[2].getTam());

        //Añadimos 10 ángeles al depósito de la muerte.
        for(int i=0; i<10; i++) {
            laMuerte.getDepSobre()[2].add(angFactory.crearAngel(laMuerte, color));
        }
        assertEquals(10, laMuerte.getDepSobre()[2].getTam());

        //Añadimos 600 fragmentos de almas al depósito de la muerte.
        laMuerte.addFragAlmas(600);

        assertThrows(SinCapPermitidaException.class, () -> {
            mausoleo.enviarDemonio();
        });
    }

    //Enviar demonio con la barca rota
    @Test
    @DisplayName("Test envío con barca rota")
    void envioBarcaRota() throws DemonioNullException, BarcaRotaException, FragmentosInsuficientesException, SinCapPermitidaException, AngelesInsuficienteException {
        mausoleo.getBarca().setFuncional(false);
        assertThrows(BarcaRotaException.class, () -> {
           mausoleo.enviarDemonio();
        });
    }

    //Enviar demonio con Angeles insuficientes
    @Test
    @DisplayName("Test envío con ángeles insuficientes")
    void envioAngelesInsuficientes() throws DemonioNullException, BarcaRotaException, FragmentosInsuficientesException, SinCapPermitidaException, AngelesInsuficienteException {
        laMuerte.getDepSobre()[2].get();
        assertEquals(4,laMuerte.getDepSobre()[2].getTam());
        assertThrows(AngelesInsuficienteException.class, () -> {
            mausoleo.enviarDemonio();
        });
    }

    //Enviar demonio con fragmentos insuficientes
    @Test
    @DisplayName("Test envío con fragmentos insuficientes")
    void envioFragmentosInsuficientes() throws DemonioNullException, BarcaRotaException, FragmentosInsuficientesException, SinCapPermitidaException, AngelesInsuficienteException {
        laMuerte.addFragAlmas(-10);
        assertEquals(490,laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.enviarDemonio();
        });
    }
}