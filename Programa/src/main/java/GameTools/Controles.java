package GameTools;

import Interfaz.PanelLaMuerte;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controles extends JPanel {
    private final int[] teclas = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D};
    private final PanelLaMuerte jugador;
    public Controles(PanelLaMuerte jugador) {
        super();
        this.jugador = jugador;

        setFocusable(true);
        setSize(jugador.getSize());
        setLocation(jugador.getLocation());
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

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

    public PanelLaMuerte getJugador() {
        return jugador;
    }
}
