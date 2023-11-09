package Logica;

/**
 * Esta clase es el protagonista de nuestro juego y representa al personaje utilizado por el jugador.
 */
public class LaMuerte {
    private int fragAlmas;
    private int poder;
    private DepSobre[] depSobre;

    /**
     * Constructor personalizado en el que se inicializan las variables.
     */
    public LaMuerte() {
        fragAlmas = 0;
        poder     = 0;

        depSobre    = new DepSobre[3];
        depSobre[0] = new DepSobre<Persona>();
        depSobre[1] = new DepSobre<Demonio>();
        depSobre[2] = new DepSobre<Angel>();
    }

    /**
     * Getter de la variable fragAlmas.
     *
     * @return la cantidad de fragmentos de alma que tenga el jugador.
     */
    public int getFragAlmas() {
        return fragAlmas;
    }

    /**
     * Método para agregar o quitar (colocando un parámetro negativo) fragmentos del alma.
     *
     * @param fragAlmasObtenido la cantidad que se quiere agregar o quitar.
     */
    public void addFragAlmas(int fragAlmasObtenido) {
        fragAlmas += fragAlmasObtenido;
    }

    /**
     * Getter de la variable poder.
     *
     * @return el poder del personaje.
     */
    public int getPoder() {
        return poder;
    }

    /**
     * Setter para la variable poder.
     *
     * @param poderActual el poder que se le desea asignar al jugador.
     */
    public void setPoder(int poderActual) {
        poder = poderActual;
    }

    /**
     * Obtiene los depósitos de almas de personas, demonios y angeles.
     *
     * @return un arreglo con las referencias a los depósitos que posee la muerte (el jugador).
     */
    public DepSobre[] getDepSobre() {
        return depSobre;
    }

}
