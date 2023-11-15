package Interfaz;

import GameTools.Hitbox;

import javax.swing.*;

public class PanelAlma extends JPanel {
    private Hitbox hitbox;
    public PanelAlma() {
        super();
        setBounds(200 + Hitbox.getTodasLasHitbox().size()*70 ,350,60,100);
        hitbox = new Hitbox(getBounds(), this);
    }
}
