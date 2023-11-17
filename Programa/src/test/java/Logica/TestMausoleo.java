package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestMausoleo {
    private Mausoleo mausoleo;
    private LaMuerte laMuerte;
    private MundoTerrenal mundoTerrenal;
    private Barca barca;
    private Puente puente;

    @BeforeEach
    void setup(){
        laMuerte = new LaMuerte();
        barca = new Barca();
        mundoTerrenal = new MundoTerrenal(barca);
        mausoleo = new Mausoleo(laMuerte,mundoTerrenal);
        puente = new Puente();
    }

    //Test aumento de capacidad con dinero insuficiente
    @Test
    @DisplayName("Test mejora de capacidad con fragmentos insuficientes")
    void aumentoFallidoCapacidad() throws FragmentosInsuficientesException{
        assertEquals(1,mundoTerrenal.getCapacidad());
        assertEquals(0, laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.aumentarCapacidad();
        });
    }

    //Test aumento capacidad y checkear la capacidad
    @Test
    @DisplayName("Test aumento de capacidad")
    void aumentoCapacidad() throws FragmentosInsuficientesException{
        laMuerte.addFragAlmas(1600);
        assertEquals(1600, laMuerte.getFragAlmas());
        mausoleo.aumentarCapacidad();
        assertEquals(2,mundoTerrenal.getCapacidad());
        assertEquals(100, laMuerte.getFragAlmas());
    }

    //test aumento poder con dinero insuficiente
    @Test
    @DisplayName("Test mejora de poder con fragmentos insuficientes")
    void aumentoFallidoPoder() throws FragmentosInsuficientesException{
        assertEquals(0, laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.aumentarPoder();
        });
    }

    //Test aumento poder y checkear el poder
    @Test
    @DisplayName("Test aumento de poder")
    void aumentoPoder() throws FragmentosInsuficientesException{
        laMuerte.addFragAlmas(3000);
        assertEquals(3000, laMuerte.getFragAlmas());
        mausoleo.aumentarPoder();
        assertEquals(2,laMuerte.getPoder());
        assertEquals(1000, laMuerte.getFragAlmas());
    }

    //Test reparar el puente
    //Test reparar el puente con dinero insuficiente
    @Test
    @DisplayName("Test reparar puente con fragmentos insuficientes")
    void reparacionFallidaPuente() throws FragmentosInsuficientesException{
        puente.setFuncional(false);
        laMuerte.addFragAlmas(1000);
        assertEquals(1000, laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.repararPuente(puente);
        });
    }

    @Test
    @DisplayName("Test reparar puente")
    void reparacionPuente() throws FragmentosInsuficientesException{
        puente.setFuncional(false);
        laMuerte.addFragAlmas(10000);
        assertEquals(10000, laMuerte.getFragAlmas());
        mausoleo.repararPuente(puente);
        assertTrue(puente.getFuncional());
        assertEquals(0, laMuerte.getFragAlmas());
    }

    //Test repara la barca con dinero insuficiente
    @Test
    @DisplayName("Test reparar barca con fragmentos insuficientes")
    void reparacionFallidaBarca() throws FragmentosInsuficientesException{
        mausoleo.getBarca().setFuncional(false);
        laMuerte.addFragAlmas(2000);
        assertEquals(2000, laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.repararBarca();
        });
    }

    //Test reparar la barca y checkearlo
    @Test
    @DisplayName("Test reparar barca")
    void reparacionBarca() throws FragmentosInsuficientesException{
        mausoleo.getBarca().setFuncional(false);
        laMuerte.addFragAlmas(5000);
        assertEquals(5000, laMuerte.getFragAlmas());
        mausoleo.repararBarca();
        assertTrue(mausoleo.getBarca().getFuncional());
        assertEquals(0, laMuerte.getFragAlmas());
    }
}
