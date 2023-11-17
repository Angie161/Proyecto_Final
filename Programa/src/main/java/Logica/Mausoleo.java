package Logica;

/**
 * Esta clase representa la "casa" de la muerte y es la que permite hacer mejoras.
 */
public class Mausoleo {
    private Barca barca;
    private LaMuerte propietario;
    private MundoTerrenal tierra;
    private Precios precios;

    /**
     * Constructor personalizado en donde inicializamos las variables y asignamos al propietario.
     *
     * @param laMuerte el "propietario" del mausoleo.
     */
    public Mausoleo(LaMuerte laMuerte, MundoTerrenal mundoTerrenal) {
        propietario = laMuerte;
        tierra      = mundoTerrenal;
        barca       = new Barca();
        precios     = new Precios(propietario);
    }

    public MundoTerrenal getTierra() {
        return tierra;
    }
    public Barca getBarca() {
        return barca;
    }

    /**
     * Método para enviar un demonio desde el mausoleo.
     *
     * @throws SinCapPermitidaException Cuando no se pueden enviar más demonios porque ya se envió el máximo.
     * @throws BarcaRotaException Cuando la barca está rota y se intenta manda un demonio.
     * @throws AngelesInsuficienteException cuando no hay suficientes angeles en los depósitos para enviar el demonio.
     * @throws FragmentosInsuficientesException cuando no hay suficientes fragmentos de almas para enviar el demonio.
     */
    public void enviarDemonio() throws SinCapPermitidaException, BarcaRotaException, AngelesInsuficienteException, FragmentosInsuficientesException {
        if(propietario.getDepSobre()[2].getTam() >= precios.getCantAngelesEnvio(tierra) && propietario.getFragAlmas() >= precios.getPrecioFragEnvio(tierra)) {
            for(int i = 0; i < precios.getCantAngelesEnvio(tierra); i++) {
                barca.traslado(tierra, (Demonio) propietario.getDepSobre()[1].get());
            }
            propietario.addFragAlmas(-precios.getPrecioFragEnvio(tierra));
        } else if(propietario.getDepSobre()[2].getTam() < precios.getCantAngelesEnvio(tierra)) {
            throw new AngelesInsuficienteException();
        } else if(propietario.getFragAlmas() < precios.getPrecioFragEnvio(tierra)) {
            throw new FragmentosInsuficientesException();
        }
    }

    /**
     * Método para subir el nivel de la barca lo que permitirá enviar más demonios al mismo tiempo al mundo terrenal.
     *
     * @throws FragmentosInsuficientesException Cuando no hay Fragmentos de alma suficientes.
     */
    public void aumentarCapacidad() throws FragmentosInsuficientesException {
        if(propietario.getFragAlmas() >= precios.getPrecioMejoraCapacidad(tierra) && propietario.getPoder() * 2 >= tierra.getCapacidad()) {
            propietario.addFragAlmas(-precios.getPrecioMejoraCapacidad(tierra));
            tierra.setCapacidad(tierra.getCapacidad() + 1);
        } else {
            throw new FragmentosInsuficientesException();
        }
    }

    /**
     * Método para aumentar el poder el propietario.
     *
     * @throws FragmentosInsuficientesException Cuando no hay Fragmentos de alma suficientes.
     */
    public void aumentarPoder() throws FragmentosInsuficientesException {
        if(propietario.getFragAlmas() >= precios.getPrecioMejoraPoder()) {
            propietario.addFragAlmas(-precios.getPrecioMejoraPoder());
            propietario.setPoder(propietario.getPoder() + 1);
        } else {
            throw new FragmentosInsuficientesException();
        }
    }

    /**
     * Método para reparar el puente si es que está roto.
     *
     * @param puente el puente que se quiere reparar.
     * @throws FragmentosInsuficientesException Cuando no hay Fragmentos de alma suficientes.
     */
    public void repararPuente(Puente puente) throws FragmentosInsuficientesException {
        if(propietario.getFragAlmas() >= precios.getPrecioRepararaPuente() && !puente.getFuncional()) {
            puente.setFuncional(true);
            propietario.addFragAlmas(-precios.getPrecioRepararaPuente());
        } else {
            throw new FragmentosInsuficientesException();
        }
    }

    /**
     * Método para reparar la barca del mausoleo si es que está rota.
     *
     * @throws FragmentosInsuficientesException Cuando no hay Fragmentos de alma suficientes.
     */
    public void repararBarca() throws FragmentosInsuficientesException {
        if(propietario.getFragAlmas() >= precios.getPrecioRepararBarca() && !barca.getFuncional()) {
            barca.setFuncional(true);
            propietario.addFragAlmas(-precios.getPrecioRepararBarca());
        } else {
            throw new FragmentosInsuficientesException();
        }
    }
}
