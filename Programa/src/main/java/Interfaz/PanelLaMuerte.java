package Interfaz;

import GameTools.Hitbox;
import Logica.LaMuerte;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa visualmente a la muerte dentro del juego, el personaje que el usuario podrá mover.
 */
public class PanelLaMuerte extends JPanel {
    private final LaMuerte laMuerte;
    private Dimension size = new Dimension(60,100);
    private Point velocidad = new Point(0, 0);
    private final int aceleracion = 1;
    private final Point ubicacionInicial = new Point(635,375);
    private Hitbox hitbox;
    private ImageIcon[] iamgeMuerte = new ImageIcon[2];

    /**
     * Constructor de PanelLaMuerte.
     */
    public PanelLaMuerte() {
        laMuerte = new LaMuerte();
        hitbox = new Hitbox(new Rectangle(ubicacionInicial, size), this);

        setOpaque(false);
        setSize(size);
        setLocation(ubicacionInicial);
        try {
            iamgeMuerte[0] = new ImageIcon(PanelMapa.class.getClassLoader().getResource("Imagenes/Mapa/LaMuerte.png"));
            iamgeMuerte[1] = new ImageIcon(PanelMapa.class.getClassLoader().getResource("Imagenes/Mapa/LaMuerteLeft.png"));
        }catch (Exception e) {
            iamgeMuerte[0] = null;
            iamgeMuerte[1] = null;
        }
    }

    /**
     * Getter de la muerte asociada al panel.
     * @return LaMuerte asociada.
     */
    public LaMuerte getLaMuerte() {
        return laMuerte;
    }

    /**
     * Getter de la velocidad asociada al panel.
     * @return Point asociado.
     */
    public Point getVelocidad() {
        return velocidad;
    }

    /**
     * Getter de la aceleración asociada al panel.
     * @return entero de la aceleración asociada.
     */
    public int getAceleracion() {
        return aceleracion;
    }

    /**
     * Setter de la velocidad del panel.
     * @param velocidad a la que se quiere modificar.
     */
    public void setVelocidad(Point velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * getter del hitbox asociado al panel.
     * @return Hitbox.
     */
    public Hitbox getHitbox() {
        return hitbox;
    }

    /**
     * Override del método paintComponent(g) para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            if(velocidad.x < 0) {
                g.drawImage(iamgeMuerte[1].getImage(), 0, 0, null);
            } else {
                g.drawImage(iamgeMuerte[0].getImage(), 0, 0, null);
            }
        } catch (Exception e) {
            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, 0, size.width, size.height);
        }
    }

}
