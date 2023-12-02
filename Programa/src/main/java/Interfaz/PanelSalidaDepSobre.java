package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelSalidaDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 130);
    private Point ubicacion;
    private DepSobre depSobre;
    public PanelSalidaDepSobre(int x, int y, DepSobre depSobre) {
        super();
        this.depSobre = depSobre;
        ubicacion = new Point(x, y);
        setBounds(x,y,size.width, size.height);
        setBackground(new Color(0,0,0,0));
        new Hitbox(ubicacion.x ,ubicacion.y,size.width - 60,size.height,0);
    }

    public DepSobre getDepSobre() {
        return depSobre;
    }

    protected void paintComponent(Graphics g, String ruta) {
        try {
            ImageIcon imageIcon1 = new ImageIcon(getClass().getClassLoader().getResource(ruta));
            g.drawImage(imageIcon1.getImage(), ubicacion.x, ubicacion.y, null);
        } catch (Exception e) {
            g.setColor(new Color(100, 100, 200));
            g.fillRect(0, 0, 60, 100);
        }
    }
}
