package GameTools;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Clase que establece un área de detección de colisiones en cada elemento interactuable en el mapa del juego.
 */
public class Hitbox {
    private static ArrayList<Hitbox> todasLasHitbox = new ArrayList<Hitbox>();
    private static int noMovibleHitboxs = 1;
    private JPanel panelAsociado;
    private Rectangle hitbox;
    private Point velocidad = new Point(0, 0);
    private boolean movible = true;
    private boolean traspasableForHitbox = false;
    private boolean traspasableForPlayer = false;

    /**
     * Primer constructor de Hitbox el cual define las dimensiones de la hitbox y las agrega al conjunto total de hitbox.
     * @param rectangle que tendrá las dimensiones para la hitbox.
     * @param panelAsociado Al cuál se le asignará la hitbox.
     */
    public Hitbox(Rectangle rectangle, JPanel panelAsociado) {
        this.panelAsociado = panelAsociado;
        hitbox = new Rectangle(rectangle);
        todasLasHitbox.add(this);
    }

    /**
     * Segundo Constructor de la Hitbox, el cual además de asignar dimensiones, establece si la hitbox es traspasable por otras hitbox o no.
     * @param x1 primera componente x para el rectangulo que se le asignará a la hitbox.
     * @param y1 primera componente y para el rectangulo que se le asignará a la hitbox.
     * @param x2 segunda componente x para el rectangulo que se le asignará a la hitbox.
     * @param y2 segunda componente y para el rectangulo que se le asignará a la hitbox.
     * @param traspasable que determinará si es transpasable y por quienes.
     */
    public Hitbox(int x1, int y1, int x2, int y2, int traspasable){
        if(traspasable == 1) {
            traspasableForPlayer = true;
        } else if(traspasable == 2) {
            traspasableForHitbox = true;
        } else if(traspasable == 3){
            traspasableForHitbox = true;
            traspasableForPlayer = true;
        }
        movible = false;
        panelAsociado = null;
        hitbox = new Rectangle(x1, y1, x2, y2);
        todasLasHitbox.add(this);
        noMovibleHitboxs++;
    }

    /**
     * Getter de Hitbox.
     * @return Rectangle con las dimensiones de la hitbox.
     */
    public Rectangle getHitbox(){
        return hitbox;
    }

    /**
     * Setter de transpasableForPlayer. Define si la hitbox puede ser traspasable por el jugador.
     * @param traspasableForPlayer estado al cual se desea cambiar.
     */
    public void setTraspasableForPlayer(boolean traspasableForPlayer) {
        this.traspasableForPlayer = traspasableForPlayer;
    }

    /**
     * Otorga la cantidad de hitbox que son movibles en el mapa del juego.
     * @return int con la cantidad.
     */
    public static int NoMovibleHitboxs() {
        return noMovibleHitboxs;
    }

    /**
     * Verifica si la hitbox se puede mover.
     * @return boolean con el estado de movilidad de la hitbox.
     */
    public boolean isMovible() {
        return movible;
    }

    /**
     * Verifica si la hitbox es traspasable por otras.
     * @return boolean con el estado de la hitbox.
     */
    public boolean isTraspasableForHitbox() {
        return traspasableForHitbox;
    }

    /**
     * Verifica si la hitbox es traspasable por el jugador.
     * @return boolean con el estado de la hitbox.
     */
    public boolean isTraspasableForPlayer() {
        return traspasableForPlayer;
    }

    /**
     * Getter de la velocidad de la Hitbox.
     * @return Point.
     */
    public Point getVelocidad() {
        return velocidad;
    }

    /**
     * Setter de la velocidad de la Hitbox.
     * @param velocidad a la que se quiere cambiar.
     */
    public void setVelocidad(Point velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * Overload de setter de la velocidad de la Hitbox.
     * @param x para la cual se definirá la velocidad.
     * @param y para la cual se definirá la velocidad.
     */
    public void setVelocidad(int x, int y) {
        velocidad = new Point(x, y);
    }

    /**
     * Getter del panel asociado a la hitbox.
     * @return JPanel asociado.
     */
    public JPanel getPanelAsociado() {
        return panelAsociado;
    }

    /**
     * Elimina la hitbox de las hitbox almacenadas.
     * @param hitbox que se desea eliminar.
     */
    public static void eliminarHitbox(Hitbox hitbox) {
        todasLasHitbox.remove(hitbox);
    }

    /**
     * Getter de las hitbox almacenadas.
     * @return ArrayList con las hitbox del mapa.
     */
    public static ArrayList<Hitbox> getTodasLasHitbox() {
        return todasLasHitbox;
    }

    /**
     * Setter de la posición de la Hitbox.
     * @param point con la posición a la cual se desea colocar.
     */
    public void setLocation(Point point) {
        hitbox.setLocation(point);
        panelAsociado.setLocation(point);
    }

    /**
     * Overload del setter para la posición de la hitbox.
     * @param x Posición horizontal donde se quiere ubicar.
     * @param y Posición vertical donde se quiere ubicar.
     */
    public void setLocation(int x, int y) {
        hitbox.setLocation(x, y);
        panelAsociado.setLocation(x,y);
    }

    /**
     * Getter de la ubicación de la hitbox.
     * @return Point con dicha ubicación.
     */
    public Point getLocation() {
        return hitbox.getLocation();
    }
}
