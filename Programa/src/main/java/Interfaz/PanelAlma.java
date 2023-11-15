package Interfaz;

import GameTools.Hitbox;
import Logica.Almas;

import javax.swing.*;

public class PanelAlma extends JPanel {
    private final Almas alma = null;
    private Hitbox hitbox;
    public PanelAlma() {
        super();
        setBounds(200 + Hitbox.getTodasLasHitbox().size()*70 ,350,60,100);
        hitbox = new Hitbox(getBounds(), this);
    }

    public Almas getAlma() {
        return alma;
    }
}
