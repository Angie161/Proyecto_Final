package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelSalidaDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 130);
    private Point ubicacion;
    private DepSobre depSobre;
    private ImageIcon imageDepSobre;
    public PanelSalidaDepSobre(int x, int y, DepSobre depSobre, String rutaASuImagen) {
        super();
        this.depSobre = depSobre;
        ubicacion = new Point(x, y);
        setBounds(x,y,size.width, size.height);
        setBackground(new Color(0,0,0,0));
        new Hitbox(ubicacion.x ,ubicacion.y,size.width - 60,size.height - 75,0);
        try {
            imageDepSobre = new ImageIcon(getClass().getClassLoader().getResource(rutaASuImagen));
        } catch (Exception e) {
            imageDepSobre = null;
        }
    }

    public DepSobre getDepSobre() {
        return depSobre;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(imageDepSobre.getImage(), 0, 0, null);
        } catch (Exception e) {
            g.setColor(new Color(100, 100, 200));
            g.fillRect(0, 0, 60, 100);
        }
    }
}
