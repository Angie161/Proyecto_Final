package Logica;

import java.util.ArrayList;

public class MundoTerrenal {
    private DepSobre demEnviados;

    public MundoTerrenal(){}

    public void agregarDemonio(Demonio demonio, int capacidad) throws SinCapPermitidaException {
        if(demEnviados.getTam()<capacidad){
            demEnviados.add(demonio);
        }
        else{
            System.out.println("No tienes permitido enviar más demonios");
            throw new SinCapPermitidaException();
        }
    }

    public int muertes(){
        //Por definir
        return 0;
    }

    public void exorcizar(int probExorcismo){
        //Valor de probabilidad provicional (333 es el num Sagrado)
        if(probExorcismo==333 && demEnviados.getTam()!=0){
            demEnviados.get();
        }
    }

    /**
     * Destruirá la barca si esta se encuentra reparada.
     * @param probDestruccionBarca entero con un número al azar.
     * @param funcional booleano con el estado de la barca.
     * @return booleano destinado a cambiar el estado de la barca.
     */
    public boolean destruccionBarca(int probDestruccionBarca, boolean funcional){
        //Valor de probabilidad provicional
        if(probDestruccionBarca==111 && funcional==true){
            return false;
        }
    }
}
