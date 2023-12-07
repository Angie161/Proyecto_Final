package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

/**
 * Representan los depósitos sobrenaturales que se encuentran en la interfaz, con los cuales se pueden almacenar almas de angeles, demonios o personas.
 * Solo sirven de almacenamiento, no es posible sacar almas de estos.
 */
public class PanelDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 130);
    private Point ubicacion;
    private DepSobre depSobre;
    private ImageIcon imagenDepSobre;

    /**
     * Constructor de PanelDepSobre. Establece el tipo de alma a guardar, la ubicación y su imagen asociada.
     * @param x Establece la ubicación horizontal del cofre en la pantalla.
     * @param y Establece la ubicación vertical del cofre en la pantalla.
     * @param cual Establece el tipo de alma que almacenará.
     * @param laMuerte Establece al personaje al que le pertenece el cofre.
     * @param rutaASuImagen Establece la imagen con la que se representará.
     */
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

    /**
     * Getter de DepSobre asociado al panelDepSobre.
     *
     * @return DepSobre solicitado.
     */
    public DepSobre getDepSobre() {
        return depSobre;
    }

    /**
     * Override del método paintComponent(g) para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
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
