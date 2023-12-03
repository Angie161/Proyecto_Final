package Interfaz;

import Logica.FragmentosInsuficientesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonAumPoder extends JButton {
    public ButtonAumPoder(PanelMapa panelMapa){
        super();
        setBounds(600,33,350,96);
        setBackground(new Color(0,0,0,0));
        setBorder(null);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().aumentarPoder();
                }catch (FragmentosInsuficientesException ex){
                    panelMapa.getPanelError().invocar("No tienes suficientes fragmentos");
                    System.out.println("No tienes suficientes fragmentos");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(0,0,0,100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(0,0,0,0));
            }
        });
    }
}
