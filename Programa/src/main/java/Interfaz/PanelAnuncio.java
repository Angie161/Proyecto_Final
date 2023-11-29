package Interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelAnuncio extends JPanel {
    public PanelAnuncio(){
        super();
        setOpaque(true);
        setLayout(null);
        setBounds(PanelMapa.getTam().width - 300,PanelMapa.getTam().height - 150,300, 150);
        setBackground(new Color(10, 10, 10));
        setVisible(true);
    }
}
