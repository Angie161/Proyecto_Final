package Interfaz;

import GameTools.Hitbox;
import Logica.Almas;

import javax.swing.*;
import java.awt.*;

public class PanelAlma extends JPanel {
    private final Almas alma;
    private Hitbox hitbox;
    public PanelAlma(Almas alma) {
        super();
        setSize(60,100);
        hitbox = new Hitbox(getBounds(), this);
        this.alma = alma;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public Almas getAlma() {
        return alma;
    }
    public PanelAlma purificar() {
        Hitbox.eliminarHitbox(hitbox);
        return this;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(alma.getColor());
        g.fillOval(40,80,15,15);
    }
}
