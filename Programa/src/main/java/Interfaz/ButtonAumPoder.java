package Interfaz;

import Logica.FragmentosInsuficientesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonAumPoder extends JButton {
    public ButtonAumPoder(PanelMapa panelMapa){
        super();
        setBounds(600,35,350,95);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().aumentarPoder();
                    panelMapa.getPanelMenuMausoleo().actualizarValores();
                }catch (FragmentosInsuficientesException ex){
                    System.out.println("No tienes suficientes fragmentos");
                }
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
        g.fillRect(0, 0,350,100);
    }
}
