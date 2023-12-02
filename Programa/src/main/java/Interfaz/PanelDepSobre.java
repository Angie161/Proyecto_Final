package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 130);
    private Point ubicacion;
    private DepSobre depSobre;
    private ImageIcon imagenDepSobre;
    public PanelDepSobre(int x, int y, int cual, LaMuerte laMuerte, String rutaASuImagen) {
        super();
        if(cual == 0) {
            depSobre = laMuerte.getDepSobre()[0];
        } else if(cual == 1) {
            depSobre = laMuerte.getDepSobre()[1];
        } else if(cual == 2) {
            depSobre = laMuerte.getDepSobre()[2];
        }
        ubicacion = new Point(x, y);
        setBounds(x,y,size.width, size.height);
        setBackground(new Color(0,0,0,0));
        new Hitbox(ubicacion.x ,ubicacion.y,size.width - 60,size.height,0);
        try {
            imagenDepSobre = new ImageIcon(getClass().getClassLoader().getResource(rutaASuImagen));
        } catch (Exception e) {
            imagenDepSobre = null;
        }
    }

    public DepSobre getDepSobre() {
        return depSobre;
    }

    @Override
    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(imagenDepSobre.getImage(), 0, 0, null);
        } catch (Exception e) {
            g.setColor(new Color(100, 100, 200));
            g.fillRect(0, 0, 60, 100);
        }
    }
}
