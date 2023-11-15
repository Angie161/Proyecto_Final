package Interfaz;

import GameTools.Controles;
import GameTools.Tick;

import javax.swing.*;
import java.awt.*;

public class PanelMapa extends JPanel {
    private static Dimension size = new Dimension(1300, 800);

    public PanelMapa() {
        super();

        PanelLaMuerte panelLaMuerte = new PanelLaMuerte();
        Controles controles = new Controles(panelLaMuerte);
        add(panelLaMuerte);
        add(controles);

        Tick tick = new Tick(controles);

        setPreferredSize(size);
        setLocation(0, 0);
        setLayout(null);
    }


    public static Dimension getTam() {
        return size;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(PanelMapa.class.getClassLoader().getResource("mapa.png"));
            g.drawImage(imageIcon.getImage(), 0, 0, null);
        } catch (Exception e) {
            System.err.println("Error al cargar el mapa");
            g.setColor(new Color(100, 200, 100));
            g.fillRect(0, 0, size.width, size.height);
        }
    }
}
