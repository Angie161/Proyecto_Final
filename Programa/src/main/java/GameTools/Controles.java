package GameTools;

import Interfaz.PanelLaMuerte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase que implementa los controles para que el usuario pueda mover al personaje principal.
 */
public class Controles extends JPanel {
    private final int[] teclas = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D};
    private final PanelLaMuerte jugador;
    
    /**
     * Constructor para inicializar los controles, empleando KeyListeners para declarar el movimiento a realizar al presionar las teclas a,w,s,d.
     *
     * @param jugador al cual se le asignará el movimiento, es decir, al personaje de la Muerte.
     */
    public Controles(PanelLaMuerte jugador) {
        this.jugador = jugador;

        setOpaque(false);
        setFocusable(true);
        setSize(jugador.getSize());
        setLocation(jugador.getLocation());
        addKeyListener(new KeyListener() {

            /**
             * Método de KeyListener no empleado.
             */
            @Override
            public void keyTyped(KeyEvent e) {
            }

            /**
             * Reconoce la tecla presionada y cambia la dirección, junto con la velocidad en el movimiento de la Muerte mientras la tecla esté presionada.
             *
             * @param e, el KeyEvent registrado.
             */
            @Override
            public void keyPressed(KeyEvent e) {
                for(int i = 0; i < 4; i++) {
                    if (e.getKeyCode() == teclas[i]) {
                        if(i == 0) {
                            jugador.setVelocidad(new Point(jugador.getVelocidad().x, -jugador.getAceleracion()));
                        } else if(i == 1) {
                            jugador.setVelocidad(new Point(-jugador.getAceleracion(), jugador.getVelocidad().y));
                        } else if(i == 2) {
                            jugador.setVelocidad(new Point(jugador.getVelocidad().x, jugador.getAceleracion()));
                        } else {
                            jugador.setVelocidad(new Point(jugador.getAceleracion(), jugador.getVelocidad().y));
                        }
                    }
                }
            }

            /**
             * Reconoce cuando una tecla de movimiento deja de ser presionada, llevando la velocidad de la Muerte a 0.
             *
             * @param e, el KeyEvent registrado.
             */
            @Override
            public void keyReleased(KeyEvent e) {
                for(int i = 0; i < 4; i++) {
                    if(e.getKeyCode() == teclas[0]) {
                        if(jugador.getVelocidad().y < 0) {
                            jugador.setVelocidad(new Point(jugador.getVelocidad().x, 0));
                        }
                    } if(e.getKeyCode() == teclas[2]) {
                        if(jugador.getVelocidad().y > 0) {
                            jugador.setVelocidad(new Point(jugador.getVelocidad().x, 0));
                        }
                    } if(e.getKeyCode() == teclas[1]) {
                        if(jugador.getVelocidad().x < 0) {
                            jugador.setVelocidad(new Point(0, jugador.getVelocidad().y));
                        }
                    } if(e.getKeyCode() == teclas[3]) {
                        if(jugador.getVelocidad().x > 0) {
                            jugador.setVelocidad(new Point(0, jugador.getVelocidad().y));
                        }
                    }
                }
            }
        });
    }

    /**
     * Getter de el jugador.
     * 
     * @return PanelLaMuerte el cuál representa visualmente a la muerte.
     */
    public PanelLaMuerte getJugador() {
        return jugador;
    }
}
