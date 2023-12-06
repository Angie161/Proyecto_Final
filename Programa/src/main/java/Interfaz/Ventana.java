package Interfaz;

import javax.swing.*;

/**
 * Clase singleton que contiene el frame del programa.
 */
public class Ventana extends JFrame {
    private static Ventana instancia = new Ventana();
    
    /**
     * Constructor personalizado.
     */
    private Ventana() {
        super();
        instancia = this;

        PanelMapa panelMapa = new PanelMapa();
        add(panelMapa);

        pack();

        setIconImage((new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Aplicacion/IconJuego.png"))).getImage());
        setTitle("DeathsMission");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Método para obtener la instancia de la ventana.
     *
     * @return Ventana, la cual es la instancia de la ventana.
     */
    public static Ventana getInstancia() {
        return instancia;
    }

    /**
     * Método para repintar la ventana.
     */
    public static void repintar() {
        instancia.repaint();
    }
}
