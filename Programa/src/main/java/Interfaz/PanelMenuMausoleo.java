package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelMenuMausoleo extends JPanel {
    private PanelMapa panelMapa;
    public PanelMenuMausoleo(PanelMapa panelMapa) {
        super();
        this.panelMapa = panelMapa;
        setBounds(50,50,PanelMapa.getTam().width - 100, PanelMapa.getTam().height - 100);
        setBackground(new Color(100, 100, 100, 128));
    }
}
