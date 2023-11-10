package Logica;

/**
 * Esta clase representa el puente que se utiliza para ir al cielo desde el limbo.
 */
public class Puente {
    private boolean funcional;

    /**
     * Constructor personalizado en el que se inicializan las variables.
     */
    public Puente() {
        funcional = false;
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
