package GameTools;

import Interfaz.PanelLaMuerte;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Hitbox {
    private static ArrayList<Hitbox> todasLasHitbox = new ArrayList<Hitbox>();
    private JPanel panelAsociado;
    private Rectangle hitbox;
    private Point velocidad = new Point(0, 0);
    private boolean movible = true;
    public Hitbox(Rectangle rectangle, JPanel panelAsociado) {
        this.panelAsociado = panelAsociado;
        hitbox = new Rectangle(rectangle);
        todasLasHitbox.add(this);
    }
    public Hitbox(int x1, int y1, int x2, int y2){
        panelAsociado = null;
        movible = false;
        hitbox = new Rectangle(x1, y1, x2, y2);
        todasLasHitbox.add(this);
    }

    public Rectangle getHitbox(){
        return hitbox;
    }

    public void setMovible(boolean movible) {
        this.movible = movible;
    }

    public boolean isMovible() {
        return movible;
    }

    public Point getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Point velocidad) {
        this.velocidad = velocidad;
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
