package Logica;

import java.math.BigInteger;

/**
 * Clase que contendrá los precios de las mejoras y reparaciones en el Mausoleo.
 */
public class Precios {
    private LaMuerte laMuerte;
    
    /**
     * Constructor donde se asignan las variables.
     */
    public Precios(LaMuerte laMuerte) {
        this.laMuerte = laMuerte;
    }

    /**
     * Obtendrá la cantidad de ángeles que requerirá el envío de demonios al Mundo Terrenal en base de sus estadisticas actuales. 
     *
     * @param mundoTerrenal el mundo terrenal donde se quiera realizar el envío.
     * @return la cantidad de ángeles que se necesitarán para realizar el siguiente envío.
     */
    public int getCantAngelesEnvio(MundoTerrenal mundoTerrenal) {
        return ((int) Math.log(mundoTerrenal.getCantDemEnviados() * 3 + 3));
    }

    /**
     * Obtendrá la cantidad de fragmentos de alma que requerirá el envío de demonios al Mundo Terrenal en base de sus estadisticas actuales.
     *
     * @param mundoTerrenal el mundo terrenal donde se quiera realizar el envío.
     * @return la cantidad de fragmentos que se necesitará para realizar el siguiente envío.
     */
    public BigInteger getPrecioFragEnvio(MundoTerrenal mundoTerrenal) {
        return BigInteger.valueOf(mundoTerrenal.getCantDemEnviados() * laMuerte.getPoder() * 100 + 500 * laMuerte.getPoder());
    }

    /**
     * Obtendrá el precio que requerirá cada mejora de la capacidad del Mundo Terrenal.
     *
     * @param mundoTerrenal el mundo terrenal al que se le quiere aumentar la capacidad.
     * @return el precio necesario para aumentar la capacidad del Mundo Terrenal.
     */
    public BigInteger getPrecioMejoraCapacidad(MundoTerrenal mundoTerrenal) {
        return BigInteger.valueOf(mundoTerrenal.getCapacidad() * 1500);
    }

    /**
     * Obtendrá el precio que se requerirá para aumentar el poder de LaMuerte.
     *
     * @return el precio necesario para aumentar el poder de LaMuerte.
     */
    public BigInteger getPrecioMejoraPoder() {
        return BigInteger.valueOf((long) Math.pow(laMuerte.getPoder(), 5) * 2000);
    }
    
    /**
     * Obtendrá el precio que se requerirá para reparar la barca.
     *
     * @return el precio necesario para reparar la barca.
     */
    public BigInteger getPrecioRepararBarca() {
        return BigInteger.valueOf((long) Math.pow(laMuerte.getPoder(), 2.5) * 2000);
    }

    /**
     * Obtendrá el precio que se requerirá para reparar el puente.
     *
     * @return el precio necesario para reparar el puente.
     */
    public BigInteger getPrecioRepararaPuente() {
        return BigInteger.valueOf((long) Math.pow(laMuerte.getPoder(), 2.5) * 10000);
    }
}
