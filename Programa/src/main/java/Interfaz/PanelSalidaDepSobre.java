package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa dentro de la interfaz a los depósitos sobrenaturales que almacenan almas que se encuentran en el cielo, y con los cuales se podrá sacar dichas almas.
 * Solo sirven para obtener las almas almacenadas, no para guardarlas.
 */
public class PanelSalidaDepSobre extends JPanel {
    private static Dimension size = new Dimension(120, 130);
    private Point ubicacion;
    private DepSobre depSobre;
    private ImageIcon imageDepSobre;

    /**
     * Constructor del PanelSalidaDepSobre con el cual se establecen los parámetros iniciales de visualización dentro del mapa.
     * @param x Establece la ubicación horizontal del cofre en la pantalla.
     * @param y Establece la ubicación vertical del cofre en la pantalla.
     * @param depSobre al cual está asociado.
     * @param rutaASuImagen, aspecto que tendrá el cofre.
     */
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

    /**
     * Getter del DepSobre al cual se encuentra asociado el panel-
     * @return DepSobre.
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
            g.drawImage(imageDepSobre.getImage(), 0, 0, null);
        } catch (Exception e) {
            g.setColor(new Color(100, 100, 200));
            g.fillRect(0, 0, 60, 100);
        }
    }
}
