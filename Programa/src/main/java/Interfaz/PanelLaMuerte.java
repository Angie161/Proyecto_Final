package Interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelLaMuerte extends JPanel {
    private Dimension size = new Dimension(30,50);
    private Point velocidad = new Point(0, 0);
    private final int aceleracion = 1;
    private final Point ubicacionInicial = new Point(635,375);
    //private Hitbox hitbox;
    public PanelLaMuerte() {
        super();

        //hitbox = new Hitbox(new Rectangle(ubicacionInicial, tamaño), this);

        setSize(size);
        setLocation(ubicacionInicial);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(PanelMapa.class.getClassLoader().getResource("laMuerte.png"));
            g.drawImage(imageIcon.getImage(), 0, 0, null);
        } catch (Exception e) {
            System.err.println("Error al cargar a la muerte");
            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, 0, size.width, size.height);
        }
    }

}
