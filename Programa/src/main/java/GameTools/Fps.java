package GameTools;

import Interfaz.Ventana;

import java.util.ArrayList;
import java.util.Random;

/**
 * Clase con la que se establece cada cuanto tiempo se repintará la ventana del juego.
 */
public class Fps extends Thread {
    private final int FPS = 60;

    /**
     * Constructor de Fps.
     */
    public Fps() {
        super();
        start();
    }

    /**
     * Método para ejecutar el repintado de la ventana.
     */
    @Override
    public void run() {
        while(true) {
            Ventana.repintar();
            try {
                Thread.sleep(1000/FPS);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
