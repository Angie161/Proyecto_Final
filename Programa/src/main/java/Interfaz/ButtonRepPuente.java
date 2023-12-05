package Interfaz;

import Logica.FragmentosInsuficientesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que genera un botón de "Reparar puente" en el panel menú del Mausoleo, el cual al presionarlo permite repara el puente del limbo.
 */
public class ButtonRepPuente extends JButton {
    /**
     * Constructor de ButtonRepPuente, configura los parámetros iniciales para que se muestren en pantalla.
     *
     * @param panelMapa con el cual se accede a Mausoleo para modificar el estado del puente.
     */
    public ButtonRepPuente(PanelMapa panelMapa){
        super();
        setBorder(null);
        setBounds(903,500,247,133);
        setBackground(new Color(0,0,0,0));

        addMouseListener(new MouseListener() {
            /**
             * Método no empleado.
             */
            @Override
            public void mouseClicked(MouseEvent e) {}

            /**
             * Evento ejecutado al presionar el botón. Repara el puente.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().repararPuente(PanelPuente.getPuente());
                    PanelAnuncio.setComoEstaban(1);
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
