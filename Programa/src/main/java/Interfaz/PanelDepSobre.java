package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 100);
    private Point ubicacion;
    private DepSobre depSobre;
    public PanelDepSobre(int x, int y, int cual) {
        super();
        if(cual == 0) {
            depSobre = new DepSobre<Persona>();
        } else if(cual == 1) {
            depSobre = new DepSobre<Demonio>();
        } else if(cual == 2) {
            depSobre = new DepSobre<Angel>();
        }
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
        g.fillRect(ubicacion.x, ubicacion.y, 60, 100);
    }
}
