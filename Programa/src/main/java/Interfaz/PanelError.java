package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelError extends JPanel {
    private JLabel label;
    public PanelError(){
        setOpaque(true);
        setLayout(null);
        setBounds((PanelMapa.getTam().width -550)/2,-150,550, 55);
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
    public void invocar(String texto) {
        if(label.getText().equals(" ")) {
            label.setText(texto);
            Timer timer = new Timer(3, new ActionListener() {
                int x = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    if (x < 150) {
                        setLocation(getLocation().x, getLocation().y + 1);
                    } else if (300 < x) {
                        setLocation(getLocation().x, getLocation().y - 1);
                    }
                    if (x > 450) {
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