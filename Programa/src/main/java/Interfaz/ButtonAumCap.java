package Interfaz;

import Logica.FragmentosInsuficientesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que genera un botón de "Aumento de capacidad" en el panel menú del Mausoleo, el cual al presionarlo permite aumentar la capacidad de demonios alojados en el mundo terrenal.
 */
public class ButtonAumCap extends JButton {
    
    /**
     * Constructor de ButtonAumCap, configura los parámetros iniciales para que se muestren en pantalla.
     */
    public ButtonAumCap(PanelMapa panelMapa){
        super();
        setBounds(600,185,450,95);
        setBackground(new Color(0,0,0,0));
        setBorder(null);

        addMouseListener(new MouseListener() {
            /**
             * Método no empleado.
             */
            @Override
            public void mouseClicked(MouseEvent e) {}

            /**
             * Evento ejecutado al presionar el botón. Genera un aumento de capacidad si se tiene la cantidad de dinero requerida.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().aumentarCapacidad();
                }catch (FragmentosInsuficientesException ex){
                    panelMapa.getPanelError().invocar("No tienes suficientes fragmentos");
                    System.out.println("No tienes suficientes fragmentos");
                }
            }

            /**
             * Método no empleado.
             */
            @Override
            public void mouseReleased(MouseEvent e) {}

            /**
             * Evento ejecutado al entrar al botón. Oscurece el fondo del botón para generar el efecto de activación.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mouseEntered(MouseEvent e) {setBackground(new Color(0,0,0,100));}

            /**
             * Evento ejecutado al salir del botón. Vuelve el botón a su color original.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mouseExited(MouseEvent e) {setBackground(new Color(0,0,0,0));}
        });
    }
}
