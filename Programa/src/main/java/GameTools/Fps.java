package GameTools;

import Interfaz.Ventana;

import java.util.ArrayList;
import java.util.Random;

public class Fps extends Thread {
    private final int FPS = 60;
    public Fps() {
        super();
        start();
    }

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
