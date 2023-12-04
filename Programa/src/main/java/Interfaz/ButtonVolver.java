package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que genera un botón para salir del panel menú del Mausoleo.
 */
public class ButtonVolver extends JButton {
    
    /**
     * Constructor de ButtonVolver, configura los parámetros iniciales para que se muestren en pantalla.
     *
     * @param panelMenuMausoleo con el cual se configura la visibilidad de este.
     */
    public ButtonVolver(JPanel panelMenuMausoleo){
        super();
        setBorder(null);
        setBounds(1120,20,60,50);
        setBackground(new Color(0,0,0,0));

        addMouseListener(new MouseListener() {
            /**
             * Método no empleado.
             */
            @Override
            public void mouseClicked(MouseEvent e) {}

            /**
             * Evento ejecutado al presionar el botón. Convierte la visibilidad del MenuMausoleo.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mousePressed(MouseEvent e) {
                panelMenuMausoleo.setVisible(false);
            }

            /**
             * Método no empleado.
             */
            @Override
            public void mouseReleased(MouseEvent e) {
            }

            /**
             * Evento ejecutado al entrar al botón. Oscurece el fondo del botón para generar el efecto de activación.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(0,0,0,100));
            }

            /**
             * Evento ejecutado al salir del botón. Vuelve el botón a su color original.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(0,0,0,0));
            }
        });
    }
}

