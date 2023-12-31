package Interfaz;

import GameTools.*;
import Logica.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa visualmente el Mapa del juego, y el cuál contiene a todos los componentes visuales del juego.
 */
public class PanelMapa extends JPanel {
    private static Dimension size = new Dimension(1300, 800);
    private PanelLaMuerte panelLaMuerte;
    private PanelPuente panelPuente;
    private Mausoleo mausoleo;
    private Hitbox[] bordes = new Hitbox[4];
    private PanelDepSobre[] panelDepSobres = new PanelDepSobre[3];
    private PanelSalidaDepSobre[] panelSalidaDepSobres = new PanelSalidaDepSobre[4];
    private PanelMenuMausoleo panelMenuMausoleo;
    private PanelAnuncio panelAnuncio;
    private PanelError panelError;
    private PanelAltar[] panelAltar = new PanelAltar[3];
    private Tick tick;
    private Thread spawn;
    private Spawner runeable;
    private Controles controles;
    private ImageIcon[] imageMapa = new ImageIcon[3];
    private ImageIcon[] imageAlmas = new ImageIcon[4];
    private Font fuentePersonalizada;

    /**
     * Constructor de PanelMapa, el cual establece las configuraciones iniciales para que se muestre en pantalla.
     */
    public PanelMapa() {
        panelLaMuerte           = new PanelLaMuerte();
        controles               = new Controles(panelLaMuerte);
        mausoleo                = new Mausoleo(panelLaMuerte.getLaMuerte(), new MundoTerrenal());
        runeable                = new Spawner(this, new Point(120, 200), new Dimension(550, 506), panelLaMuerte.getSize());
        spawn                   = new Thread(runeable);
        bordes[0]               = new Hitbox(0, -1, size.width, 1, 0);
        bordes[1]               = new Hitbox(size.width, 0, 1, size.height,0);
        bordes[2]               = new Hitbox(0, size.height, size.width, 1,0);
        bordes[3]               = new Hitbox(-1, 0, 1, size.height,0);
        Hitbox mausoleoHitbox   = new Hitbox(0, 0, 710, 100,0);
        Hitbox infierno1        = new Hitbox(720, 0, 150, 240,2);
        Hitbox infierno2        = new Hitbox(720, 500, 150, 300,2);
        panelDepSobres[0]       = new PanelDepSobre(15, 290, 2, panelLaMuerte.getLaMuerte(),"Imagenes/Mapa/CofreAbAngel.png");
        panelDepSobres[1]       = new PanelDepSobre(15, 430, 0, panelLaMuerte.getLaMuerte(),"Imagenes/Mapa/CofreAbDem.png");
        panelDepSobres[2]       = new PanelDepSobre(15, 570, 1, panelLaMuerte.getLaMuerte(),"Imagenes/Mapa/CofreAbPer.png");
        panelSalidaDepSobres[0] = new PanelSalidaDepSobre(885,20,panelDepSobres[1].getDepSobre(),"Imagenes/Mapa/CofreCerPer.png");
        panelSalidaDepSobres[1] = new PanelSalidaDepSobre(885,150,panelDepSobres[0].getDepSobre(),"Imagenes/Mapa/CofreCerAngel.png");
        panelSalidaDepSobres[2] = new PanelSalidaDepSobre(885,540,panelDepSobres[2].getDepSobre(),"Imagenes/Mapa/CofreCerDem.png");
        panelSalidaDepSobres[3] = new PanelSalidaDepSobre(885,670,panelDepSobres[1].getDepSobre(),"Imagenes/Mapa/CofreCerPer.png");
        panelPuente             = new PanelPuente(670,300);
        panelError              = new PanelError();
        panelMenuMausoleo       = new PanelMenuMausoleo(this);
        panelAnuncio            = new PanelAnuncio(this);
        panelAltar[0]           = new PanelAltar(1165, 60,"Imagenes/Mapa/Altar1.png");
        panelAltar[1]           = new PanelAltar(1165, 531,"Imagenes/Mapa/Altar3.png");
        panelAltar[2]           = new PanelAltar(1150, 270,"Imagenes/Mapa/Altar2.png");

        setLayout(null);

        add(panelPuente);
        add(panelLaMuerte);
        add(panelAltar[0]);
        add(panelAltar[1]);
        add(panelAltar[2]);
        add(controles);
        add(panelDepSobres[0]);
        add(panelDepSobres[1]);
        add(panelDepSobres[2]);
        add(panelSalidaDepSobres[0]);
        add(panelSalidaDepSobres[1]);
        add(panelSalidaDepSobres[2]);
        add(panelSalidaDepSobres[3]);
        add(panelError);
        add(panelMenuMausoleo);
        add(panelAnuncio);

        setComponentZOrder(panelPuente,1);
        setComponentZOrder(panelAltar[0],1);
        setComponentZOrder(panelAltar[1],1);
        setComponentZOrder(panelAltar[2],1);
        setComponentZOrder(panelMenuMausoleo,2);

        setComponentZOrder(panelAnuncio,1);
        setComponentZOrder(panelError,1);

        setBackground(new Color(0,0,0,0));
        setPreferredSize(size);
        setLocation(0, 0);
        try {
            imageMapa[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/Fondo.png"));
            imageMapa[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/MausoleoOk.png"));
            imageMapa[2] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/MausoleoNotOk.png"));
            imageAlmas[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconFragmento.png"));
            imageAlmas[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconAngel.png"));
            imageAlmas[2] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconDem.png"));
            imageAlmas[3] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconPersona.png"));
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fuentes/Angiesfont.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(fuentePersonalizada.getSize()*30f);
            fuentePersonalizada = fuentePersonalizada.deriveFont(Font.BOLD);
        } catch (Exception e) {
            imageMapa[0] = null;
            imageMapa[1] = null;
            imageMapa[2] = null;
            fuentePersonalizada = null;
        }

        new Fps();
        new Terremoto(PanelPuente.getPuente());
        tick = new Tick(controles, this);
        spawn.start();
    }

    /**
     * Getter del tamaño del panelMapa.
     * @return Dimension con el tamaño del mapa.
     */
    public static Dimension getTam() {
        return size;
    }

    /**
     * Getter del conjunto de paneles de altares contenido en el mapa.
     * @return PanelAltar[].
     */
    public PanelAltar[] getPanelAltar() {
        return panelAltar;
    }

    /**
     * Getter del panel de la muerte que se encuentra en el mapa.
     * @return PanelLaMuerte.
     */
    public PanelLaMuerte getPanelLaMuerte() {
        return panelLaMuerte;
    }

    /**
     * Getter del Mausoleo que se encuentra en el mapa.
     * @return Mausoleo.
     */
    public Mausoleo getMausoleo() {
        return mausoleo;
    }

    /**
     * Getter del conjunto de paneles de depósitos que se encuentran en el mapa.
     * @return PanelDepSobre[].
     */
    public PanelDepSobre[] getPanelDepSobres() {
        return panelDepSobres;
    }

    /**
     * Getter del conjunto de paneles de depósitos de salida que se encuentran en el mapa.
     * @return PanelSalidaDepSobre[].
     */
    public PanelSalidaDepSobre[] getPanelSalidaDepSobres() {
        return panelSalidaDepSobres;
    }

    /**
     * Getter del panel del menú del mausoleo que se encuentra en el mapa.
     * @return PanelMenuMausoleo.
     */
    public PanelMenuMausoleo getPanelMenuMausoleo() {
        return panelMenuMausoleo;
    }

    /**
     * Getter del panel de error que se encuentra en el mapa.
     * @return PanelError.
     */
    public PanelError getPanelError(){
        return panelError;
    }


    /**
     * Override del método paint() para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paint(Graphics g) {
        try {
            g.drawImage(imageMapa[0].getImage(), 0, 0, null);
            if (mausoleo.getBarca().getFuncional()) {
                g.drawImage(imageMapa[1].getImage(), 0, 0, null);
            } else {
                g.drawImage(imageMapa[2].getImage(), 0, 0, null);
            }
            super.paint(g);
            g.setColor(Color.BLACK);
            g.setFont(fuentePersonalizada);
            g.drawImage(imageAlmas[0].getImage(),5,8,null);
            g.drawString(panelLaMuerte.getLaMuerte().getFragAlmas().toString(), 40, 30);
            g.drawImage(imageAlmas[2].getImage(),1110,8,null);
            g.drawString(Long.toString(panelLaMuerte.getLaMuerte().getDepSobre()[1].getTam()), 1140, 30);
            g.drawImage(imageAlmas[1].getImage(),1010,8,null);
            g.drawString(Long.toString(panelLaMuerte.getLaMuerte().getDepSobre()[2].getTam()), 1040, 30);
            g.drawImage(imageAlmas[3].getImage(),1210,8,null);
            g.drawString(Long.toString(panelLaMuerte.getLaMuerte().getDepSobre()[0].getTam()), 1240, 30);
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

            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN,20));
            g.drawString(panelLaMuerte.getLaMuerte().getFragAlmas().toString(), 10, 30);
        }
    }
}
