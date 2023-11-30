package Interfaz;

import GameTools.Hitbox;
import Logica.*;

import javax.swing.*;
import java.awt.*;

public class PanelAlma extends JPanel {
    private final Almas alma;
    private Hitbox hitbox;
    public PanelAlma(Almas alma) {
        super();
        setSize(60,100);
        hitbox = new Hitbox(getBounds(), this);
        this.alma = alma;
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    public Almas getAlma() {
        return alma;
    }
    public PanelAlma purificar() {
        Hitbox.eliminarHitbox(hitbox);
        return this;
    }

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

    @Override
    public void paintComponent(Graphics g) {
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
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaSatan.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Lucifer) {
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaLucifer.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Leviathan) {
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaLeviathan.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            } else if(alma instanceof Persona) {
                ImageIcon imageIcon = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/AlmaPersona.png"));
                g.drawImage(imageIcon.getImage(), 0, 0, null);
            }
        } catch (Exception e) {
            g.setColor(alma.getColor());
            g.fillOval(40, 80, 15, 15);
        }
    }
}
