package Logica;

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
        return (5 + mundoTerrenal.getCantDemEnviados() * 5);
    }

    /**
     * Obtendrá la cantidad de fragmentos de alma que requerirá el envío de demonios al Mundo Terrenal en base de sus estadisticas actuales.
     *
     * @param mundoTerrenal el mundo terrenal donde se quiera realizar el envío.
     * @return la cantidad de fragmentos que se necesitará para realizar el siguiente envío.
     */
    public int getPrecioFragEnvio(MundoTerrenal mundoTerrenal) {
        return mundoTerrenal.getCantDemEnviados() * laMuerte.getPoder() * 100 + 500 * laMuerte.getPoder();
    }

    /**
     * Obtendrá el precio que requerirá cada mejora de la capacidad del Mundo Terrenal.
     *
     * @param mundoTerrenal el mundo terrenal al que se le quiere aumentar la capacidad.
     * @return el precio necesario para aumentar la capacidad del Mundo Terrenal.
     */
    public int getPrecioMejoraCapacidad(MundoTerrenal mundoTerrenal) {
        return mundoTerrenal.getCapacidad() * 1500;
    }

    /**
     * Obtendrá el precio que se requerirá para aumentar el poder de LaMuerte.
     *
     * @return el precio necesario para aumentar el poder de LaMuerte.
     */
    public int getPrecioMejoraPoder() {
        return (int) Math.pow(laMuerte.getPoder(), 2) * 2000;
    }
    
    /**
     * Obtendrá el precio que se requerirá para reparar la barca.
     *
     * @return el precio necesario para reparar la barca.
     */
    public int getPrecioRepararBarca() {
        return laMuerte.getPoder() * 5000;
    }

    /**
     * Obtendrá el precio que se requerirá para reparar el puente.
     *
     * @return el precio necesario para reparar el puente.
     */
    public int getPrecioRepararaPuente() {
        return laMuerte.getPoder() * 10000;
    }
}