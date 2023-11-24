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
    private PanelPuente panelPuente;
    private Mausoleo mausoleo;
    private Hitbox[] bordes = new Hitbox[4];
    private PanelDepSobre[] panelDepSobres = new PanelDepSobre[3];
    private PanelSalidaDepSobre[] panelSalidaDepSobres = new PanelSalidaDepSobre[4];
    private PanelAltar[] panelAltar = new PanelAltar[2];
    private Tick tick;
    private Thread spawn;
    private Spawner runeable;
    private Controles controles;

    public PanelMapa() {
        super();

        panelLaMuerte = new PanelLaMuerte();
        controles = new Controles(panelLaMuerte);
        mausoleo = new Mausoleo(panelLaMuerte.getLaMuerte(), new MundoTerrenal());
        runeable = new Spawner(this, new Point(120, 200), new Dimension(550, 506), panelLaMuerte.getSize());
        spawn = new Thread(runeable);

        bordes[0] = new Hitbox(0, -1, size.width, 1, 0);
        bordes[1] = new Hitbox(size.width, 0, 1, size.height,0);
        bordes[2] = new Hitbox(0, size.height, size.width, 1,0);
        bordes[3] = new Hitbox(-1, 0, 1, size.height,0);
        Hitbox mausoleoHitbox = new Hitbox(0, 0, 650, 100,0);
        Hitbox infierno1 =new Hitbox(750, 0, 150, 300,2);
        Hitbox infierno2 =new Hitbox(750, 500, 150, 300,2);

        panelDepSobres[0] = new PanelDepSobre(15, 290, 2);
        panelDepSobres[1] = new PanelDepSobre(15, 430, 0);
        panelDepSobres[2] = new PanelDepSobre(15, 570, 1);
        panelSalidaDepSobres[0] = new PanelSalidaDepSobre(915,30,panelDepSobres[1].getDepSobre());
        panelSalidaDepSobres[1] = new PanelSalidaDepSobre(915,160,panelDepSobres[0].getDepSobre());
        panelSalidaDepSobres[2] = new PanelSalidaDepSobre(915,540,panelDepSobres[2].getDepSobre());
        panelSalidaDepSobres[3] = new PanelSalidaDepSobre(915,670,panelDepSobres[1].getDepSobre());
        panelPuente = new PanelPuente(700,300);
        add(panelPuente);
        setComponentZOrder(panelPuente,0);
        add(panelLaMuerte);
        setComponentZOrder(panelPuente,1);
        panelAltar[0] = new PanelAltar(1181, 50);
        panelAltar[1] = new PanelAltar(1181, 551);
        add(panelAltar[0]);
        add(panelAltar[1]);
        add(controles);
        add(panelDepSobres[0]);
        add(panelDepSobres[1]);
        add(panelDepSobres[2]);
        add(panelSalidaDepSobres[0]);
        add(panelSalidaDepSobres[1]);
        add(panelSalidaDepSobres[2]);
        add(panelSalidaDepSobres[3]);
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

    public PanelAltar[] getPanelAltar() {
        return panelAltar;
    }

    public PanelLaMuerte getPanelLaMuerte() {
        return panelLaMuerte;
    }

    public Mausoleo getMausoleo() {
        return mausoleo;
    }

    public PanelDepSobre[] getPanelDepSobres() {
        return panelDepSobres;
    }

    public PanelSalidaDepSobre[] getPanelSalidaDepSobres() {
        return panelSalidaDepSobres;
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

            g.setColor(new Color(200, 200, 200));
            g.fillRect(1181, 50, 119, 199);
            g.fillRect(1181, 551, 119, 199);
            g.fillRect(1150, 315, 150, 170);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN,20));
            g.drawString(Integer.toString(panelLaMuerte.getLaMuerte().getFragAlmas()), 10, 30);
        }
    }
}
