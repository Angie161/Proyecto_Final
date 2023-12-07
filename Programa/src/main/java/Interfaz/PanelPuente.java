package Interfaz;

import GameTools.Hitbox;
import Logica.Puente;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * Representa un puente en la interfaz, y con el cual se podrá acceder al cielo.
 */
public class PanelPuente extends JPanel {
    private static Dimension size = new Dimension(260, 220);
    private static Point ubicacion;
    private static Puente puente = new Puente();
    private Hitbox hitbox;
    private ImageIcon[] imagePuente = new ImageIcon[2];

    /**
     * Constructor de PanelPuente, que añade su hitbox y establece las imágenes asociadas a este.
     * @param x Establece la ubicación horizontal del cofre en la pantalla.
     * @param y Establece la ubicación vertical del cofre en la pantalla.
     */
    public PanelPuente(int x, int y) {
        ubicacion = new Point(x, y);
        setBounds(x,y,size.width, size.height);
        hitbox = new Hitbox(ubicacion.x + size.width/3,ubicacion.y,size.width - 2*size.width/3,size.height,2);
        imagePuente[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/PuenteOk.png"));
        imagePuente[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/PuenteNotOk.png"));
    }

    /**
     * Getter del puente que está asociado al panelPuente.
     * @return Puente.
     */
    public static Puente getPuente() {
        return puente;
    }

    /**
     * Getter de la hitbox asociada al panelPuente.
     * @return
     */
    public Hitbox getHitbox() {
        return hitbox;
    }

    /**
     * Getter de la ubicación del puente dentro de la interfaz.
     * @return Point con la ubicación.
     */
    public static Point getUbicacion() {
        return ubicacion;
    }

    /**
     * Getter del tamaño del puente.
     * @return Dimension.
     */
    public static Dimension getPuenteSize() {
        return size;
    }

    /**
     * Actualiza el estado de la hitbox del puente, es decir, si el jugador puede estar encima de este cuando se encuentra reparado o si, por el contrario, no puede pasar al estar roto.
     */
    public void acutalizarHitbox() {
        if(puente.getFuncional()) {
            hitbox.setTraspasableForPlayer(true);
        } else {
            hitbox.setTraspasableForPlayer(false);
        }
    }

    /**
     * Override del método paintComponent(g) para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        acutalizarHitbox();
        try {
            if (puente.getFuncional()) {
                g.drawImage(imagePuente[0].getImage(), 0, 0, null);
            } else {
                g.drawImage(imagePuente[1].getImage(), 0, 0, null);
            }
        }catch (Exception e) {
            g.setColor(new Color(200, 150, 0));
            if (puente.getFuncional()) {
                g.fillRect(0, 0, size.width, size.height);
            } else {
                g.fillRect(0, 0, size.width / 3, size.height);
                g.fillRect(2 * size.width / 3, 0, size.width / 3 + 1, size.height);
            }
        }
    }
}
