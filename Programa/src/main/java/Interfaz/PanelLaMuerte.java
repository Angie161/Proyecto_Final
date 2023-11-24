package Interfaz;

import GameTools.Hitbox;
import Logica.LaMuerte;

import javax.swing.*;
import java.awt.*;

public class PanelLaMuerte extends JPanel {
    private final LaMuerte laMuerte;
    private Dimension size = new Dimension(60,100);
    private Point velocidad = new Point(0, 0);
    private final int aceleracion = 1;
    private final Point ubicacionInicial = new Point(635,375);
    private Hitbox hitbox;
    public PanelLaMuerte() {
        laMuerte = new LaMuerte();
        hitbox = new Hitbox(new Rectangle(ubicacionInicial, size), this);

        setOpaque(false);
        setSize(size);
        setLocation(ubicacionInicial);
    }
    public LaMuerte getLaMuerte() {
        return laMuerte;
    }

    public Point getVelocidad() {
        return velocidad;
    }

    public int getAceleracion() {
        return aceleracion;
    }

    public void setVelocidad(Point velocidad) {
        this.velocidad = velocidad;
    }
    public void setVelocidad(int x, int y) {
        velocidad = new Point(x,y);
    }

    public Hitbox getHitbox() {
        return hitbox;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            ImageIcon imageIcon = new ImageIcon(PanelMapa.class.getClassLoader().getResource("LaMuerte.png"));
            g.drawImage(imageIcon.getImage(), 0, 0, null);
        } catch (Exception e) {
            //System.err.println("Error al cargar a la muerte");
            g.setColor(new Color(100, 100, 100));
            g.fillRect(0, 0, size.width, size.height);
        }
    }

}
