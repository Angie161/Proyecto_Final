package Interfaz;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Clase que genera un botón de "Enviar 1° demonio del dep." en el panel menú del Mausoleo, el cual al presionarlo permite enviar el primer demonio almacenado en el depósito de demonios hacia el mundo terrenal.
 */
public class ButtonEnviarDem extends JButton {
    
    /**
     * Constructor de ButtonEnviarDem, configura los parámetros iniciales para que se muestren en pantalla.
     *
     * @param panelMapa con el cual se accede al Mausoleo para ejecutar la compra.
     */
    public ButtonEnviarDem(PanelMapa panelMapa){
        super();
        setBounds(600,335,550,95);
        setBackground(new Color(0,0,0,0));
        setBorder(null);

        addMouseListener(new MouseListener() {
            /**
             * Método no empleado.
             */
            @Override
            public void mouseClicked(MouseEvent e) {}

             /**
             * Evento ejecutado al presionar el botón. Envía un demonio si se tiene suficientes fragmentos, angeles y demonios.
             *
             * @param e evento a ser procesado.
             */
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().enviarDemonio();
                    PanelAnuncio.addDemEnviados();
                }catch (FragmentosInsuficientesException ex){
                    panelMapa.getPanelError().invocar("No tienes suficientes fragmentos");
                    System.out.println("No tienes suficientes fragmentos");
                } catch (DemonioNullException ex) {
                    panelMapa.getPanelError().invocar("No hay demonios para enviar");
                    System.out.println("No hay Demonios para enviar");
                } catch (BarcaRotaException ex) {
                    panelMapa.getPanelError().invocar("Tu barca está rota");
                    System.out.println("Tu barca está rota");
                } catch (SinCapPermitidaException ex) {
                    panelMapa.getPanelError().invocar("  No tienes capacidad");
                    System.out.println("No tienes capacidad");
                } catch (AngelesInsuficienteException ex) {
                    panelMapa.getPanelError().invocar("   Angeles insuficientes");
                    System.out.println("Angeles insuficientes");
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
