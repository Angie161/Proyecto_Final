package Interfaz;

import GameTools.Hitbox;

import javax.swing.*;

public class PanelAltar extends JPanel {
    private PanelAlma panelAlma;
    public PanelAltar(int x, int y) {
        super();
        setOpaque(false);
        setLocation(x,y);
        setSize(119, 199);
    }
    public void ingresarAlma(Hitbox h) {
        if(this.getBounds().contains(h.getHitbox()) && panelAlma == null) {
            h.setLocation(getLocation().x + (getSize().width - h.getPanelAsociado().getSize().width)/2,getLocation().y + (getSize().height - h.getPanelAsociado().getSize().height)/2);
            panelAlma = (PanelAlma) h.getPanelAsociado();
        }
    }
}