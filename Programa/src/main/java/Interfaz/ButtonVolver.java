package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonVolver extends JButton {
    public ButtonVolver(JPanel panelMenuMausoleo){
        super();
        setBounds(1120,20,60,50);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                panelMenuMausoleo.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 135, 220));
        g.fillRect(0, 0, 150, 150);
    }
}

