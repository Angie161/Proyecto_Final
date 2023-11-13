package Logica;

/**
 * Esta clase representa la "casa" de la muerte y es la que permite hacer mejoras.
 */
public class Mausoleo {
    private Barca barca;
    private LaMuerte propietario;

    /**
     * Constructor personalizado en donde inicializamos las variables y asignamos al propietario.
     *
     * @param laMuerte el "propietario" del mausoleo.
     */
    public Mausoleo(LaMuerte laMuerte) {
        propietario = laMuerte;
        barca       = new Barca();
    }

    /**
     * Método para enviar un demonio desde el mausoleo.
     *
     * @param mundoTerrenal a donde sera enviado.
     * @param demonio       el que será enviado.
     * @throws SinCapPermitidaException si es que no se puede enviar el demonio.
     */
    public void enviarDemonio(MundoTerrenal mundoTerrenal, Demonio demonio) throws SinCapPermitidaException, BarcaRotaException {
        try {
            barca.traslado(mundoTerrenal, demonio);
        }catch (BarcaRotaException b){
            throw b;
        }catch (SinCapPermitidaException s){
            throw s;
        }
    }

    /**
     * Método para subir el nivel de la barca lo que permitirá enviar más demonios al mismo tiempo al mundo terrenal.
     *
     * @param mundoTerrenal el mundo en el que se le mejorara la capacidad.
     */
    public void aumentarCapacidad(MundoTerrenal mundoTerrenal) {
        mundoTerrenal.setCapacidad(mundoTerrenal.getCapacidad() + 1);
    }

    /**
     * Método para aumentar el poder el propietario.
     */
    public void aumentarPoder() {
        propietario.setPoder(propietario.getPoder() + 1);
    }

    /**
     * Método para reparar el puente si es que está roto.
     *
     * @param puente el puente que se quiere reparar.
     */
    public void repararPuente(Puente puente) {
        puente.setFuncional(true);
    }

    /**
     * Método para reparar la barca del mausoleo si es que está rota.
     */
    public void repararBarca() {
        barca.setFuncional(true);
    }
}
