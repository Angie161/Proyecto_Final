package Logica;

/**
 * Esta clase representa la barca que usan los demonios para ir del limbo al mundo terrenal.
 */
public class Barca {
    private boolean funcional;

    /**
     * Constructor personalizado en el que se inicializan las variables.
     */
    public Barca() {
        funcional = false;
    }

    /**
     * Método para trasladar un demonio al mundo terrenal.
     *
     * @param mundoTerrenal el mundo terrenal al cual se le quiere trasladar.
     * @param demonio       el demonio que quiere ser trasladado.
     * @throws SinCapPermitidaException  la excepción que puede saltar si es que no se permiten más demonios.
     */
    public void traslado(MundoTerrenal mundoTerrenal, Demonio demonio) throws SinCapPermitidaException, BarcaRotaException {
        if(funcional==false){
            System.out.println("No puedes enviar demonios, tu barca está rota");
            throw new BarcaRotaException();
        }
        else {
            mundoTerrenal.agregarDemonio(demonio);
        }
    }

    /**
     * Getter de la variable funcional.
     *
     * @return el valor de la variable.
     */
    public boolean getFuncional() {
        return funcional;
    }

    /**
     * Setter de la variable funcional.
     *
     * @param funcional  el valor que se le quiere asignar a la variable.
     */
    public void setFuncional(boolean funcional) {
        this.funcional = funcional;
    }
}
