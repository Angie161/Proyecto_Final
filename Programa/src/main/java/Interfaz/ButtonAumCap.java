package Interfaz;

import Logica.FragmentosInsuficientesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonAumCap extends JButton {
    public ButtonAumCap(PanelMapa panelMapa){
        super();
        setBounds(600,185,450,95);
        setBackground(new Color(0,0,0,0));
        setBorder(null);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().aumentarCapacidad();
                }catch (FragmentosInsuficientesException ex){
                    System.out.println("No tienes suficientes fragmentos");
                    panelMapa.getPanelError().setVisible(true);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {setBackground(new Color(0,0,0,100));}

            @Override
            public void mouseExited(MouseEvent e) {setBackground(new Color(0,0,0,0));}
        });
    }
}
