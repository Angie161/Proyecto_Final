package Interfaz;

import Logica.FragmentosInsuficientesException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que genera un botón de "Reparar Barca" en el panel menú del Mausoleo, el cual al presionarlo permite reparar la barca del Mausoleo.
 */
public class ButtonRepBarca extends JButton {

    /**
     * Constructor de ButtonRepBarca, configura los parámetros iniciales para que se muestren en pantalla.
     *
     * @param panelMapa con el cuál se accede a Mausoleo para reparar la barca.
     */
    public ButtonRepBarca(PanelMapa panelMapa){
        super();
        setBorder(null);
        setBackground(new Color(0,0,0,0));
        setBounds(601,500,249,130);

        addMouseListener(new MouseListener() {
            /**
             * Método no empleado.
             */
            @Override
            public void mouseClicked(MouseEvent e) {}

            /**
             * Evento ejecutado al presionar el botón. Repara el estado de la barca.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().repararBarca();
                    PanelAnuncio.setComoEstaban(0);
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
             * Evento ejecutado al presionar el botón. Envía un demonio si se tiene suficientes fragmentos, angeles y demonios.
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
