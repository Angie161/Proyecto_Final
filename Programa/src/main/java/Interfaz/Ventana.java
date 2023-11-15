package Interfaz;

import javax.swing.*;

public class Ventana extends JFrame {
    private static Ventana instancia = new Ventana();
    private Ventana() {
        super();
        instancia = this;

        PanelMapa panelMapa = new PanelMapa();
        add(panelMapa);

        pack();

        setTitle("DeathsMission");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static Ventana getInstancia() {
        return instancia;
    }

    public static void repintar() {
        instancia.repaint();
    }
}
