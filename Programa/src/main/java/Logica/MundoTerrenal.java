package Logica;

import java.util.Random;

/**
 * Esta clase representa el mundo real, donde fallece la gente y donde los demonios son enviados.
 */
public class MundoTerrenal {
    private DepSobre demEnviados;
    private int capacidad;

    /**
     * Constructor personalizado en el que inicializamos las variables e iniciamos los eventos aleatorios.
     *
     * @param barca la barca que se puede destruir.
     */
    public MundoTerrenal(Barca barca) {
        demEnviados = new DepSobre<Demonio>();
        capacidad   = 1;
        eventosAleatorios(barca);
    }

    /**
     * Método para que aleatoriamente los demonios sean exorcizados.
     */
    private void eventosAleatorios(Barca barca) {
        Thread tiempo = new Thread(new Runnable() {

            /**
             * Esto se realiza siempre y es para agregar eventos aleatorios.
             */
            @Override
            public void run() {
                while(true) {
                    exorcizar((new Random().nextInt(5000)));
                    destruccionBarca((new Random().nextInt(5000)), barca);
                    try {
                        Thread.sleep(500/demEnviados.getTam());
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        });
        tiempo.start();
    }

    /**
     * Método para agregar un demonio al mundo terrenal.
     *
     * @param demonio el demonio que se quiere agregar.
     * @throws SinCapPermitidaException se lanza cuando no se permiten más demonios.
     */
    public void agregarDemonio(Demonio demonio) throws SinCapPermitidaException {
        if(demEnviados.getTam() < capacidad) {
            demEnviados.add(demonio);
        } else {
            System.out.println("No tienes permitido enviar más demonios");
            throw new SinCapPermitidaException();
        }
    }

    /**
     * Setter para la variable capacidad.
     *
     * @param capacidad la cantidad que se le desea asignar.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * La cantidad de gente que muere en el mundo terrenal.
     *
     * @return la cantidad de gente que murió.
     */
    public int muertes(){
        int muertes = 1;
        for(int i = 0; i < demEnviados.getTam(); i++) {
            muertes += ((Demonio) demEnviados.see(i)).matar();
        }
        return muertes;
    }

    /**
     * Método que determina si se exorciza o no a un demonio.
     *
     * @param probExorcismo el valor aleatorio que se comparará.
     */
    private void exorcizar(int probExorcismo) {
        //Valor de probabilidad provicional (333 es el número Sagrado)
        if(probExorcismo == 333 && demEnviados.getTam() != 0){
            demEnviados.get();
        }
    }

    /**
     * Destruirá la barca si esta se encuentra reparada.
     *
     * @param probDestruccionBarca entero con un número al azar.
     * @param barca la barca que se quiere destruir.
     */
    private void destruccionBarca(int probDestruccionBarca, Barca barca) {
        if(probDestruccionBarca == 111 && barca.getFuncional() == true){
            barca.setFuncional(false);
        }
    }
}
