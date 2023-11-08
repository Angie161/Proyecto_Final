package Logica;
import java.util.ArrayList;

public class DepSobre<Almas> {
    private ArrayList<Almas> contSobre;
    private int tam;

    public DepSobre(int tam){
        contSobre=new ArrayList<Almas>();
        this.tam=tam;
    }

    public int getTam() {
        return tam;
    }

    public void add(Almas alma){
        contSobre.add(alma);
        tam+=1;
    }

    public Almas get(){
        if(contSobre.size()!=0){
            return contSobre.remove(0);
        }
        else{
            return null;
        }
    }

    /**
     * Revisa la última alma almacenada en el depósito sobrenatural.
     * @return Objeto genérico obtenido del contenedor.
     */
    public Almas see(){
        return contSobre.get(0);
    }
}
