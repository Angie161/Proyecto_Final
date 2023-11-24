package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelSalidaDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 100);
    private Point ubicacion;
    private DepSobre depSobre;
    public PanelSalidaDepSobre(int x, int y, DepSobre depSobre) {
        super();
        this.depSobre = depSobre;
        ubicacion = new Point(x, y);
        setBounds(x,y,size.width, size.height);
        new Hitbox(ubicacion.x ,ubicacion.y,size.width - 60,size.height,0);
    }

    public DepSobre getDepSobre() {
        return depSobre;
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 100, 200));
        g.fillRect(0, 0, 60, 100);
    }
}
