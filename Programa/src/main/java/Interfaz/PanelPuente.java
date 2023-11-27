package Interfaz;

import GameTools.Hitbox;
import Logica.Puente;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class PanelPuente extends JPanel {
    private static Dimension size = new Dimension(250, 200);
    private static Point ubicacion;
    private static Puente puente = new Puente();
    private Hitbox hitbox;
    public PanelPuente(int x, int y) {
        ubicacion = new Point(x, y);
        setBounds(x,y,size.width, size.height);
        hitbox = new Hitbox(ubicacion.x + size.width/3,ubicacion.y,size.width - 2*size.width/3,size.height,2);
    }

    public static Puente getPuente() {
        return puente;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public static Point getUbicacion() {
        return ubicacion;
    }

    public static Dimension getPuenteSize() {
        return size;
    }
    public void acutalizarHitbox() {
        if(puente.getFuncional()) {
            hitbox.setTraspasableForPlayer(true);
        } else {
            hitbox.setTraspasableForPlayer(false);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(200, 150, 0));
        if(puente.getFuncional()) {
            g.fillRect(0, 0, size.width, size.height);
        } else {
            g.fillRect(0, 0, size.width/3, size.height);
            g.fillRect(2*size.width/3, 0, size.width/3 + 1, size.height);
        }
    }
}
