package GameTools;

import Interfaz.PanelLaMuerte;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Hitbox {
    private static ArrayList<Hitbox> todasLasHitbox = new ArrayList<Hitbox>();
    private static int noMovibleHitboxs = 1;
    private JPanel panelAsociado;
    private Rectangle hitbox;
    private Point velocidad = new Point(0, 0);
    private boolean movible = true;
    private boolean traspasableForHitbox = false;
    private boolean traspasableForPlayer = false;
    public Hitbox(Rectangle rectangle, JPanel panelAsociado) {
        this.panelAsociado = panelAsociado;
        hitbox = new Rectangle(rectangle);
        todasLasHitbox.add(this);
    }
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

    public Rectangle getHitbox(){
        return hitbox;
    }


    public void setTraspasableForHitbox(boolean traspasableForHitbox) {
        this.traspasableForHitbox = traspasableForHitbox;
    }

    public void setTraspasableForPlayer(boolean traspasableForPlayer) {
        this.traspasableForPlayer = traspasableForPlayer;
    }

    public static int NoMovibleHitboxs() {
        return noMovibleHitboxs;
    }

    public boolean isMovible() {
        return movible;
    }

    public boolean isTraspasableForHitbox() {
        return traspasableForHitbox;
    }

    public boolean isTraspasableForPlayer() {
        return traspasableForPlayer;
    }

    public Point getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Point velocidad) {
        this.velocidad = velocidad;
    }
    public void setVelocidad(int x, int y) {
        velocidad = new Point(x, y);
    }

    public JPanel getPanelAsociado() {
        return panelAsociado;
    }
    public static void eliminarHitbox(Hitbox hitbox) {
        todasLasHitbox.remove(hitbox);
    }

    public static ArrayList<Hitbox> getTodasLasHitbox() {
        return todasLasHitbox;
    }
    public void setLocation(Point point) {
        hitbox.setLocation(point);
    }
    public void setLocation(int x, int y) {
        hitbox.setLocation(x, y);
    }
    public Point getLocation() {
        return hitbox.getLocation();
    }
}
