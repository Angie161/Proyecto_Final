package Interfaz;

import GameTools.*;
import Logica.Barca;
import Logica.Mausoleo;
import Logica.MundoTerrenal;

import javax.swing.*;
import java.awt.*;

public class PanelMapa extends JPanel {
    private static Dimension size = new Dimension(1300, 800);
    private PanelLaMuerte panelLaMuerte;
    private Mausoleo mausoleo;
    private Hitbox[] bordes = new Hitbox[4];
    private Hitbox[] bordesParaAlmas = new Hitbox[4];
    private Tick tick;

    public PanelMapa() {
        super();

        panelLaMuerte = new PanelLaMuerte();
        Controles controles = new Controles(panelLaMuerte);
        mausoleo = new Mausoleo(panelLaMuerte.getLaMuerte(), new MundoTerrenal());
        Spawner runeable = new Spawner(this, new Point(120, 200), new Dimension(550, 506), panelLaMuerte.getSize());
        Thread spawn = new Thread(runeable);

        bordes[0] = new Hitbox(0, -1, size.width, 1, 0);
        bordes[1] = new Hitbox(size.width, 0, 1, size.height,0);
        bordes[2] = new Hitbox(0, size.height, size.width, 1,0);
        bordes[3] = new Hitbox(-1, 0, 1, size.height,0);

        Hitbox mausoleoHitbox = new Hitbox(0, 0, 650, 100,0);
        Hitbox infierno1 =new Hitbox(750, 0, 150, 300,2);
        Hitbox infierno2 =new Hitbox(750, 500, 150, 300,2);


        add(panelLaMuerte);
        add(controles);

        new Fps();
        tick = new Tick(controles, this);
        spawn.start();

        setPreferredSize(size);
        setLocation(0, 0);
        setLayout(null);
    }


    public static Dimension getTam() {
        return size;
    }

    public PanelLaMuerte getPanelLaMuerte() {
        return panelLaMuerte;
    }

    public Mausoleo getMausoleo() {
        return mausoleo;
    }
    public void stopTick() {
        tick.interrupt();
    }
    public void reanudeTick() {
        tick.start();
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
            g.fillRect(120, 200, 550, 506);

            // infierno
            g.setColor(Color.RED);
            g.fillRect(750, 0, 150, size.height);

            //Mausoleo
            g.setColor(new Color(180, 100, 0));
            g.fillRect(0, 0, 650, 100);

            g.setColor(new Color(100, 100, 0));
            g.fillRect(350, 100, 300, 50);

            //puente
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
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN,20));
            g.drawString(Integer.toString(panelLaMuerte.getLaMuerte().getFragAlmas()), 10, 30);
        }
    }
}
