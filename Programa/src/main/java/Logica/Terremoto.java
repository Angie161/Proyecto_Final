package Logica;

import java.util.Random;

/**
 * Esta clase es utilizada para que aleatoriamente suceda un terremoto y destruya el puente.
 */
public class Terremoto {
    public Terremoto(Puente puente) {
        terremoto(puente);
    }
    private void terremoto(Puente puente) {
        Thread tiempo = new Thread(new Runnable() {

            /**
             * Esto se realiza siempre y es para agregar eventos aleatorios.
             */
            @Override
            public void run() {
                while(true) {
                    if((new Random()).nextInt(1000) == 1) {
                        puente.setFuncional(false);
                    }
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        });
        tiempo.start();
    }
}
