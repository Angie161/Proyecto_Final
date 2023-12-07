package Interfaz;

import Factories.AlmasFactory;
import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

/**
 * Representa visualmente los altares que se encuentran en el cielo, con los que se podrán fusionar almas.
 */
public class PanelAltar extends JPanel {
    private PanelAlma panelAlma;
    private ImageIcon imageAltar;

    /**
     * Contructor de PanelAltar, el cuál establecerá su ubicación en la pantalla y su imagen asociada.
     * @param x Componente horizontal donde se dibujará.
     * @param y Componente vertical donde se dibujará.
     * @param rutaASuImagen
     */
    public PanelAltar(int x, int y, String rutaASuImagen) {
        super();
        setOpaque(false);
        setLocation(x,y);
        setSize(175, 255);
        setBackground(new Color(0,0,0,0));
        panelAlma = null;
        try {
            imageAltar = new ImageIcon(getClass().getClassLoader().getResource(rutaASuImagen));
        } catch (Exception e) {
            imageAltar = null;
        }
    }

    /**
     * Getter del panelAlma el cuál contendrá una vez el usuario coloque un alma sobre el altar.
     * @return PanelAlma solicitado.
     */
    public PanelAlma getPanelAlma() {
        return panelAlma;
    }

    /**
     * Elimina el alma del mapa al momento de fusionar dos almas.
     * @param panelMapa donde se encuentra el altar y con las que se podrá acceder a los paneles de las almas.
     * @param cual para saber en cuál de sus altares se encuentra el alma a quitar.
     */
    public void quitarAlma(PanelMapa panelMapa, int cual) {
        panelMapa.remove(panelMapa.getPanelAltar()[cual].getPanelAlma());
        Hitbox.eliminarHitbox(panelMapa.getPanelAltar()[cual].getPanelAlma().getHitbox());
        panelAlma = null;
    }

    /**
     * Hace que el panel del alma se establezca al centro del altar.
     * @param h la hitbox asociada al panel del alma que se introduce.
     */
    public void ingresarAlma(Hitbox h) {
        if(this.getBounds().contains(h.getHitbox()) && panelAlma == null && !Hitbox.getTodasLasHitbox().get(0).getHitbox().intersects(this.getBounds())) {
            h.setLocation(getLocation().x + (getSize().width - 110),getLocation().y + (getSize().height - h.getPanelAsociado().getSize().height)/2 - 25);
            panelAlma = ((PanelAlma) h.getPanelAsociado());
        } else if(!this.getBounds().intersects(h.getHitbox()) && panelAlma != null && h == panelAlma.getHitbox()) {
            panelAlma = null;
        }
    }

    /**
     * Fusiona las almas que se encuentran en los altares de fusión.
     * @param panelMapa con el cual se accede a los paneles que se encuentran en él.
     */
    public void fucionarAlmas(PanelMapa panelMapa) {
        Almas almas1 = panelMapa.getPanelAltar()[0].getPanelAlma().getAlma();
        Almas almas2 = panelMapa.getPanelAltar()[1].getPanelAlma().getAlma();
        PanelAlma almas3 = panelMapa.getPanelAltar()[2].getPanelAlma();
        if(almas1 != null && almas2 != null && almas3 == null && !panelMapa.getPanelLaMuerte().getHitbox().getHitbox().intersects(this.getBounds())) {
            PanelAlma nuevaAlma = new PanelAlma(AlmasFactory.fusionarAlmas(almas1, almas2));
            nuevaAlma.setLocation(this.getX() + (this.getWidth() - nuevaAlma.getWidth())/2, this.getY() +(this.getHeight() - nuevaAlma.getHeight())/2);
            nuevaAlma.getHitbox().setLocation(nuevaAlma.getLocation());
            panelMapa.add(nuevaAlma);
            panelMapa.setComponentZOrder(nuevaAlma, 1);
            panelMapa.getPanelAltar()[0].quitarAlma(panelMapa, 0);
            panelMapa.getPanelAltar()[1].quitarAlma(panelMapa, 1);
        }
    }

    /**
     * Override del método paintComponent(g) para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(imageAltar.getImage(), 0, 0, null);
        } catch (Exception e) {
            super.paintComponent(g);
            g.setColor(new Color(0xDDDDDD));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
