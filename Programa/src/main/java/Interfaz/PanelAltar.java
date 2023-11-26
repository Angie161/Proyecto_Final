package Interfaz;

import Factories.AlmasFactory;
import Factories.AngelesFactory;
import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelAltar extends JPanel {
    private PanelAlma panelAlma;
    public PanelAltar(int x, int y) {
        super();
        setOpaque(false);
        setLocation(x,y);
        setSize(119, 199);
        panelAlma = null;
    }

    public PanelAlma getPanelAlma() {
        return panelAlma;
    }

    public void quitarAlma(PanelMapa panelMapa, int cual) {
        System.out.println("se eliminaron las almasde los altares");
        panelMapa.remove(panelMapa.getPanelAltar()[cual].getPanelAlma());
        Hitbox.eliminarHitbox(panelMapa.getPanelAltar()[cual].getPanelAlma().getHitbox());
        panelAlma = null;
    }

    public void ingresarAlma(Hitbox h) {
        if(this.getBounds().contains(h.getHitbox()) && panelAlma == null) {
            System.out.println("se ingresaron almas a los altares");
            h.setLocation(getLocation().x + (getSize().width - h.getPanelAsociado().getSize().width)/2,getLocation().y + (getSize().height - h.getPanelAsociado().getSize().height)/2);
            panelAlma = ((PanelAlma) h.getPanelAsociado());
        } else if(!this.getBounds().contains(h.getHitbox()) && panelAlma != null && h == panelAlma.getHitbox()) {
            System.out.println("Salio alma del altar");
            panelAlma = null;
        }
    }
    public void fucionarAlmas(PanelMapa panelMapa) {
        Almas almas1 = panelMapa.getPanelAltar()[0].getPanelAlma().getAlma();
        Almas almas2 = panelMapa.getPanelAltar()[1].getPanelAlma().getAlma();
        PanelAlma almas3 = panelMapa.getPanelAltar()[2].getPanelAlma();
        if(almas1 != null && almas2 != null && almas3 == null) {
            System.out.println("nueva fusion");
            PanelAlma nuevaAlma = new PanelAlma(AlmasFactory.fusionarAlmas(panelMapa.getPanelLaMuerte().getLaMuerte(), almas1, almas2));
            nuevaAlma.setLocation(this.getX() + (this.getWidth() - nuevaAlma.getWidth())/2, this.getY() +(this.getHeight() - nuevaAlma.getHeight())/2);
            nuevaAlma.getHitbox().setLocation(nuevaAlma.getLocation());
            panelMapa.add(nuevaAlma);
            panelMapa.setComponentZOrder(nuevaAlma, 1);
            panelMapa.getPanelAltar()[0].quitarAlma(panelMapa, 0);
            panelMapa.getPanelAltar()[1].quitarAlma(panelMapa, 1);
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(0xDDDDDD));
        g.fillRect(0,0,getWidth(), getHeight());
    }
}