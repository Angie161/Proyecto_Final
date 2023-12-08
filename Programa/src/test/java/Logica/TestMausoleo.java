package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase del tipo test unitario para probar el correcto funcionamiento de las mejoras y reparaciones en el Mausoleo.
 */
public class TestMausoleo {
    private Mausoleo mausoleo;
    private LaMuerte laMuerte;
    private MundoTerrenal mundoTerrenal;
    private Puente puente;

    /**
     * Inicializa las variables que se emplearán en todas las pruebas.
     */
    @BeforeEach
    void setup(){
        laMuerte = new LaMuerte();
        mundoTerrenal = new MundoTerrenal();
        mausoleo = new Mausoleo(laMuerte,mundoTerrenal);
        puente = new Puente();
    }

    /**
     * Se intenta aumentar la capacidad con una cantidad de fragmentos de alma insuficientes.
     * Se busca corroborar el correcto funcionamiento de la excepción FragmentosInsuficienteException.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test mejora de capacidad con fragmentos insuficientes")
    void aumentoFallidoCapacidad() throws FragmentosInsuficientesException{
        assertEquals(1,mundoTerrenal.getCapacidad());
        assertEquals(BigInteger.valueOf(0), laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.aumentarCapacidad();
        });
    }

    /**
     * Se realiza un aumento de capacidad, con los requisitos correctos y corroborando el estado final de la capacidad y los fragmentos de almas restantes.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test aumento de capacidad")
    void aumentoCapacidad() throws FragmentosInsuficientesException{
        laMuerte.addFragAlmas(new BigInteger("1600"));
        assertEquals(BigInteger.valueOf(1600), laMuerte.getFragAlmas());
        mausoleo.aumentarCapacidad();
        assertEquals(2,mundoTerrenal.getCapacidad());
        assertEquals(BigInteger.valueOf(100), laMuerte.getFragAlmas());
    }

    /**
     * Se intenta aumentar el poder de la muerte con una cantidad de fragmentos de alma insuficientes.
     * Se busca corroborar el correcto funcionamiento de la excepción FragmentosInsuficienteException.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test mejora de poder con fragmentos insuficientes")
    void aumentoFallidoPoder() throws FragmentosInsuficientesException{
        assertEquals(BigInteger.valueOf(0), laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.aumentarPoder();
        });
    }

    /**
     * Se realiza un aumento de poder, con los requisitos correctos y corroborando el estado final del poder y los fragmentos de almas restantes.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test aumento de poder")
    void aumentoPoder() throws FragmentosInsuficientesException, NivelMaximoException{
        laMuerte.addFragAlmas(BigInteger.valueOf(3000));
        assertEquals(BigInteger.valueOf(3000), laMuerte.getFragAlmas());
        mausoleo.aumentarPoder();
        assertEquals(2,laMuerte.getPoder());
        assertEquals(BigInteger.valueOf(1000), laMuerte.getFragAlmas());
    }

    /**
     * Se intenta reparar el puente con una cantidad de fragmentos de alma insuficientes.
     * Se busca corroborar el correcto funcionamiento de la excepción FragmentosInsuficienteException.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test reparar puente con fragmentos insuficientes")
    void reparacionFallidaPuente() throws FragmentosInsuficientesException{
        puente.setFuncional(false);
        laMuerte.addFragAlmas(BigInteger.valueOf(1000));
        assertEquals(BigInteger.valueOf(1000), laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.repararPuente(puente);
        });
    }

    /**
     * Se realiza una correcta reparación del puente, con los requisitos correctos y corroborando el estado final del puente y los fragmentos de almas restantes.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test reparar puente")
    void reparacionPuente() throws FragmentosInsuficientesException{
        puente.setFuncional(false);
        laMuerte.addFragAlmas(BigInteger.valueOf(20000));
        assertEquals(BigInteger.valueOf(20000), laMuerte.getFragAlmas());
        mausoleo.repararPuente(puente);
        assertTrue(puente.getFuncional());
        assertEquals(BigInteger.valueOf(10000), laMuerte.getFragAlmas());
    }

    /**
     * Se intenta reparar la barca con una cantidad de fragmentos de alma insuficientes.
     * Se busca corroborar el correcto funcionamiento de la excepción FragmentosInsuficienteException.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test reparar barca con fragmentos insuficientes")
    void reparacionFallidaBarca() throws FragmentosInsuficientesException{
        mausoleo.getBarca().setFuncional(false);
        laMuerte.addFragAlmas(BigInteger.valueOf(1000));
        assertEquals(BigInteger.valueOf(1000), laMuerte.getFragAlmas());
        assertThrows(FragmentosInsuficientesException.class, () -> {
            mausoleo.repararBarca();
        });
    }

    /**
     * Se realiza una correcta reparación de la barca, con los requisitos correctos y corroborando el estado final de la barca y los fragmentos de almas restantes.
     *
     * @throws FragmentosInsuficientesException En caso de que la cantidad de fragmentos sea insuficiente para la compra.
     */
    @Test
    @DisplayName("Test reparar barca")
    void reparacionBarca() throws FragmentosInsuficientesException{
        mausoleo.getBarca().setFuncional(false);
        laMuerte.addFragAlmas(BigInteger.valueOf(2000));
        assertEquals(BigInteger.valueOf(2000), laMuerte.getFragAlmas());
        mausoleo.repararBarca();
        assertTrue(mausoleo.getBarca().getFuncional());
        assertEquals(BigInteger.valueOf(0), laMuerte.getFragAlmas());
    }
}
