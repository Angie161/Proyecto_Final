package Logica;

/**
 * Excepción para representar cuando no se puede efectuar algún envío o interacción
 * específica con la Barca, pues esta se encuentra rota.
 */
public class BarcaRotaException extends Exception{

    /**
     * Constructor por defecto.
     */
    public  BarcaRotaException() {
        super();
    }
}
