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
        hitbox = new Hitbox(ubicacion.x + 60,ubicacion.y,size.width - 120,size.height,3);
        puente.setFuncional(true);
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

    @Override
    public void paint(Graphics g) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(200, 150, 0));
        if(puente.getFuncional()) {
            g.fillRect(700, 300, size.width, size.height);
        } else {
            g.fillRect(700, 300, size.width/3, size.height);
            g.fillRect(700 + 2*size.width/3, 300, size.width/3, size.height);
        }
    }
}
