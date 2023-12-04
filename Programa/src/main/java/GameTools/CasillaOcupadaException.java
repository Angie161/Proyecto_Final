package GameTools;

/**
 * Excepción arrojada cuando se intenta colocar una nueva hitbox encima de un espacio que ya se encuentra ocupado por otra hitbox.
 */
public class CasillaOcupadaException extends Exception {
    public CasillaOcupadaException() {
     /**
     * Constructor por defecto.
     */
        super();
    }
}
