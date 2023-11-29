package Interfaz;

import javax.swing.*;
import java.awt.*;

public class PanelError extends JPanel {
    public PanelError(){
        super();
        setOpaque(true);
        setLayout(null);
        setBounds((PanelMapa.getTam().width - 300)/2,0,300, 150);
        setBackground(new Color(10, 10, 10));
        setVisible(false);
    }
}
