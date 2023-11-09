package Logica;

import java.util.ArrayList;

public class DepSobre<Almas> {
    private ArrayList<Almas> contSobre;

    /**
     * Constructor personalizado en donde se inicializa el ArrayList.
     */
    public DepSobre() {
        contSobre = new ArrayList<Almas>();
    }

    /**
     * Método para ver la cantidad de almas que hay adentro.
     *
     * @return el largo del deposito.
     */
    public int getTam() {
        return contSobre.size();
    }

    /**
     * Método para agregar un alma al deposito.
     *
     * @param alma el alma que se desea agregar.
     */
    public void add(Almas alma) {
        contSobre.add(alma);
    }

    /**
     * Método para sacar la primera alma colocada.
     *
     * @return
     */
    public Almas get() {
        if(contSobre.size() != 0) {
            return contSobre.remove(0);
        }
        else{
            return null;
        }
    }

    /**
     * Revisa la última alma almacenada en el depósito sobrenatural.
     *
     * @return Objeto genérico obtenido del contenedor.
     */
    public Almas see(int cual){
        return contSobre.get(cual);
    }
}
