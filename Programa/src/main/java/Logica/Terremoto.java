package Logica;

import java.util.Random;

/**
 * Esta clase es utilizada para que aleatoriamente suceda un terremoto y destruya el puente.
 */
public class Terremoto {
    /**
     * Constructor por defecto.
     *
     * @param puente afectado por el terremoto.
     */
    public Terremoto(Puente puente) {
        terremoto(puente);
    }

    /**
    * Genera un terremoto de manera aleatoria a través de un hilo, el cual afectará el estado de la barca.
    *
    * @param puente el cuál se verá afectado por el terremoto.
    */
    private void terremoto(Puente puente) {
        Thread tiempo = new Thread(new Runnable() {

            /**
             * Esto se realiza siempre y es para agregar eventos aleatorios.
             */
            @Override
            public void run() {
                while(true) {
                    if((new Random()).nextInt(1000) == 1 && puente.getFuncional()==true) {
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
