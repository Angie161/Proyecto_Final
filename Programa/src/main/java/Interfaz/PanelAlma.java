package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

/**
 * Clase que representa visualmente las almas en el juego. Cada una con su hitbox implementada.
 */
public class PanelAlma extends JPanel {
    private final Almas alma;
    private Hitbox hitbox;

    /**
     * Constructor de PanelAlma, donde se configura su tamaño y se le asigna una hitbox.
     * @param alma a la cuál está asociado el PanelAlma.
     */
    public PanelAlma(Almas alma) {
        super();
        setSize(60,100);
        hitbox = new Hitbox(getBounds(), this);
        this.alma = alma;
    }

    /**
     * Getter de la hitbox asociada.
     * @return Hitbox asociada.
     */
    public Hitbox getHitbox() {
        return hitbox;
    }

    /**
     * Getter del alma asociada al panel.
     * @return Almas, alma asociada al panel.
     */
    public Almas getAlma() {
        return alma;
    }

    /**
     * Elimina la hitbox asociada al panel, para cuando se desea eliminar el alma de la interfaz.
     * @return PanelAlma.
     */
    public PanelAlma purificar() {
        Hitbox.eliminarHitbox(hitbox);
        return this;
    }

    /**
     * Establece la forma y ubicación de las aureolas de las almas de los ángeles en el panel.
     * @param n cantidad de puntos con los que se graficará la aureola.
     * @param a cuál de los dos poligonos que se emplean para dibujar la aureola completa se configurará.
     * @param b altura a la que se encuentra la aureola.
     * @return int[] arreglo de enteros que se usará para rellenar las aureolas en un paintComponent.
     */
    private int[] ubicarAreolas(int n, int a, int b) {
        int[] x = new int[2*n];
        int[] y = new int[2*n];

        if(a == 0 || a == 1) {
            for (int i = 0; i < n; i++) {
                x[i] = (int) (30 + 20 * Math.sin((Math.PI / (n - 1)) * i));
                y[i] = (int) (b + 7 * Math.cos((Math.PI / (n - 1)) * i));
            }
            for (int i = 0; i < n; i++) {
                x[i + n] = (int) (30 + 9 * Math.sin((Math.PI / (n - 1)) * i));
                y[i + n] = (int) (b-1 + 2 * -Math.cos((Math.PI / (n - 1)) * i));
            }
            if (a == 0) {
                return x;
            } else {
                return y;
            }
        }
        if(a == 2 || a == 3) {
            for (int i = 0; i < n; i++) {
                x[i] = (int) (30 + 20 * -Math.sin((Math.PI / (n - 1)) * i));
                y[i] = (int) (b + 7 * Math.cos((Math.PI / (n - 1)) * i));
            }
            for (int i = 0; i < n; i++) {
                x[i + n] = (int) (30 + 9 * -Math.sin((Math.PI / (n - 1)) * i));
                y[i + n] = (int) (b -1 + 2 * -Math.cos((Math.PI / (n - 1)) * i));
            }
            if (a == 2) {
                return x;
            } else {
                return y;
            }
        }
        return null;
    }

    /**
     * Override del método paintComponent(g) para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paint(Graphics g) {
        try{
            if(alma instanceof Serafin) {
                g.setColor(alma.getColor());
                g.fillPolygon(ubicarAreolas(20, 0,10),ubicarAreolas(20, 1,10),40);
                g.fillPolygon(ubicarAreolas(20, 2,10),ubicarAreolas(20, 3,10),40);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaSerafin.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Querubin) {
                g.setColor(alma.getColor());
                g.fillPolygon(ubicarAreolas(20, 0,14),ubicarAreolas(20, 1,14),40);
                g.fillPolygon(ubicarAreolas(20, 2,14),ubicarAreolas(20, 3,14),40);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaQuerubin.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Arcangel) {
                g.setColor(alma.getColor());
                g.fillPolygon(ubicarAreolas(20, 0,10),ubicarAreolas(20, 1,10),40);
                g.fillPolygon(ubicarAreolas(20, 2,10),ubicarAreolas(20, 3,10),40);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaArcangel.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Satan) {
                g.setColor(alma.getColor());
                int[] xpoint = {25,10,12,17,45,48,50,37};
                int[] ypoint = {17,1,20,23,23,20,1,17};
                g.fillPolygon(xpoint, ypoint, 8);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaSatan.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Lucifer) {
                g.setColor(alma.getColor());
                int[] xpoint = {25,8,12,17,44,47,49,35};
                int[] ypoint = {17,2,20,23,21,20,1,17};
                g.fillPolygon(xpoint, ypoint, 8);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaLucifer.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Leviathan) {
                g.setColor(alma.getColor());
                int[] xpoint = {25,10,13,17,45,50,52,37};
                int[] ypoint = {17,1,20,23,23,20,1,17};
                g.fillPolygon(xpoint, ypoint, 8);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaLeviathan.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Persona) {
                g.setColor(alma.getColor());
                g.fillRect(13,15,32,20);
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaPersona.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        } catch (Exception e) {
            g.setColor(alma.getColor());
            g.fillOval(40, 80, 15, 15);
        }
    }
}
