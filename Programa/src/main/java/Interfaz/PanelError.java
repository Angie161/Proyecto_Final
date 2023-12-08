package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase que muestra en la interfaz un aviso para cuando se intenta realizar una compra en el Mausoleo y no se cumple algún requisito.
 */
public class PanelError extends JPanel {
    private JLabel label;

    /**
     * Constructor de PanelError, configura los parámetros iniciales para que se muestren en pantalla.
     */
    public PanelError(){
        setOpaque(true);
        setLayout(null);
        setBounds((PanelMapa.getTam().width -550)/2,-55,550, 55);
        setBackground(new Color(230, 180, 180, 190));
        setVisible(true);
        label = new JLabel(" ");
        label.setBounds(25,0,500,50);
        try {
            Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fuentes/Angiesfont.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 40f);
            fuentePersonalizada = fuentePersonalizada.deriveFont(Font.BOLD);
            label.setFont(fuentePersonalizada);
        } catch (Exception e) {}
        add(label);
    }

    /**
     * Muestra el anuncio del error por una cantidad de tiempo determinado.
     *
     * @param texto a mostrar en el anuncio.
     */
    public void invocar(String texto) {
        if(label.getText().equals(" ")) {
            label.setText(texto);
            Timer timer = new Timer(5, new ActionListener() {
                int x = 0;

                /**
                 * Establece la posición del texto.
                 *
                 * @param e the event to be processed
                 */
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (x < 55) {
                        setLocation(getLocation().x, getLocation().y + 1);
                    } else if (150 < x) {
                        setLocation(getLocation().x, getLocation().y - 1);
                    }
                    if (x > 205) {
                        label.setText(" ");
                        ((Timer) e.getSource()).stop();
                    }
                    x++;
                }
            });
            timer.start();
        }
    }
}