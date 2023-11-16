package Interfaz;

import GameTools.Hitbox;
import Logica.Almas;

import javax.swing.*;

public class PanelAlma extends JPanel {
    private final Almas alma = null;
    private Hitbox hitbox;
    public PanelAlma() {
        super();
        setSize(60,100);
        hitbox = new Hitbox(getBounds(), this);
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public Almas getAlma() {
        return alma;
    }
}
