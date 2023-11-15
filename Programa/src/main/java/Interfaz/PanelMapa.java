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

        PanelAlma panelAlma = new PanelAlma();
        PanelAlma panelAlma1 = new PanelAlma();
        PanelAlma panelAlma2 = new PanelAlma();
        PanelAlma panelAlma3 = new PanelAlma();

        add(panelLaMuerte);
        add(controles);
        add(panelAlma);
        add(panelAlma1);
        add(panelAlma2);
        add(panelAlma3);

        new Tick(controles);

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
            //System.err.println("Error al cargar el mapa");
            g.setColor(new Color(100, 200, 100));
            g.fillRect(0, 0, size.width, size.height);

            // Temporal para ubicarnos.
            g.setColor(new Color(120, 180, 120));
            g.fillRect(120, 200, 550, 500);
            g.setColor(Color.RED);
            g.fillRect(750, 0, 150, size.height);
            g.setColor(new Color(180, 100, 0));
            g.fillRect(0, 0, 650, 100);
            g.setColor(new Color(100, 100, 0));
            g.fillRect(350, 100, 300, 50);
            g.setColor(new Color(200, 150, 0));
            g.fillRect(700, 300, 250, 200);
            g.setColor(new Color(200, 200, 200));
            g.fillRect(1181, 50, 119, 199);
            g.fillRect(1181, 551, 119, 199);
            g.fillRect(1150, 315, 150, 170);
            g.setColor(new Color(100, 100, 200));
            g.fillRect(915, 30, 60, 100);
            g.fillRect(915, 160, 60, 100);
            g.fillRect(915, 540, 60, 100);
            g.fillRect(915, 670, 60, 100);
            g.fillRect(15, 290, 60, 100);
            g.fillRect(15, 430, 60, 100);
            g.fillRect(15, 570, 60, 100);
        }
    }
}
