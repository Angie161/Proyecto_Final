package Logica;

import java.math.BigInteger;

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
        tierra.eventosAleatorios(barca);
    }

    /**
     * Getter de la variable tierra.
     * @return el mundo terrenal relacionado con el Mausoleo.
     */
    public MundoTerrenal getTierra() {
        return tierra;
    }

    /**
     * Getter de la variable barca.
     * @return la barca perteneciente al Mausoleo.
     */
    public Barca getBarca() {
        return barca;
    }

    /**
     * Getter de la variable precios.
     * @return los precios correspondientes a cada compra del mausoleo.
     */
    public Precios getPrecios() { return precios; }

    /**
     * Método para enviar un demonio desde el mausoleo.
     *
     * @throws SinCapPermitidaException Cuando no se pueden enviar más demonios porque ya se envió el máximo.
     * @throws BarcaRotaException Cuando la barca está rota y se intenta manda un demonio.
     * @throws AngelesInsuficienteException cuando no hay suficientes angeles en los depósitos para enviar el demonio.
     * @throws FragmentosInsuficientesException cuando no hay suficientes fragmentos de almas para enviar el demonio.
     * @throws DemonioNullException cuando se intenta enviar un demonio nulo o no hay demonios en el depósito de demonios de la muerte.
     */
    public void enviarDemonio() throws SinCapPermitidaException, BarcaRotaException, AngelesInsuficienteException, FragmentosInsuficientesException, DemonioNullException {
        if(propietario.getDepSobre()[1].see(0)==null){
            throw new DemonioNullException();
        } else if(propietario.getDepSobre()[2].getTam() >= precios.getCantAngelesEnvio(tierra) && propietario.getFragAlmas().compareTo(precios.getPrecioFragEnvio(tierra)) >= 0) {
            BigInteger aux = precios.getPrecioFragEnvio(tierra);
            barca.traslado(tierra, (Demonio) propietario.getDepSobre()[1].see(0));
            propietario.getDepSobre()[1].get();
            propietario.addFragAlmas(aux.negate());
            for(int i = 0; i < precios.getCantAngelesEnvio(tierra); i++) {
                propietario.getDepSobre()[2].get();
            }
        } else if(propietario.getDepSobre()[2].getTam() < precios.getCantAngelesEnvio(tierra)) {
            throw new AngelesInsuficienteException();
        } else if(propietario.getFragAlmas().compareTo(precios.getPrecioFragEnvio(tierra)) < 0) {
            throw new FragmentosInsuficientesException();
        }
    }

    /**
     * Método para subir el nivel de la barca lo que permitirá enviar más demonios al mismo tiempo al mundo terrenal.
     *
     * @throws FragmentosInsuficientesException Cuando no hay Fragmentos de alma suficientes.
     */
    public void aumentarCapacidad() throws FragmentosInsuficientesException {
        if(propietario.getFragAlmas().compareTo(precios.getPrecioMejoraCapacidad(tierra)) >= 0 && propietario.getPoder() * 2 >= tierra.getCapacidad()) {
            propietario.addFragAlmas(precios.getPrecioMejoraCapacidad(tierra).negate());
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
    public void aumentarPoder() throws FragmentosInsuficientesException, NivelMaximoException{
        if(propietario.getFragAlmas().compareTo(precios.getPrecioMejoraPoder()) >= 0 && propietario.getPoder()<100) {
            propietario.addFragAlmas(precios.getPrecioMejoraPoder().negate());
            propietario.setPoder(propietario.getPoder() + 1);
        } else if (propietario.getPoder()>=100){
            throw new NivelMaximoException();
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
        if(propietario.getFragAlmas().compareTo(precios.getPrecioRepararaPuente()) >= 0 && !puente.getFuncional()) {
            puente.setFuncional(true);
            propietario.addFragAlmas(precios.getPrecioRepararaPuente().negate());
        } else if (puente.getFuncional()) {
            System.out.println("El puente no está roto");
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
        if(propietario.getFragAlmas().compareTo(precios.getPrecioRepararBarca()) >= 0 && !barca.getFuncional()) {
            barca.setFuncional(true);
            propietario.addFragAlmas(precios.getPrecioRepararBarca().negate());
        } else if (barca.getFuncional()) {
            System.out.println("La barca no está rota");
        } else {
            throw new FragmentosInsuficientesException();
        }
    }
}
