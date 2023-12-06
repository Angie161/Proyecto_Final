package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAnuncio extends JPanel {
    private JLabel[] label = new JLabel[2];
    private static boolean[] comoEstaban = new boolean[2];
    private static int demEnviados = 0;
    private Font fuentePersonalizada;
    public PanelAnuncio(PanelMapa panelMapa){
        super();
        setOpaque(true);
        setLayout(null);
        setBounds(PanelMapa.getTam().width,PanelMapa.getTam().height-150,300, 150);
        setBackground(new Color(180, 180, 180, 180));
        setVisible(true);
        label[0] = new JLabel();
        label[1] = new JLabel();
        label[0].setBounds(25,30,250,50);
        label[1].setBounds(25,70,250,50);
        comoEstaban[0] = false; //barca
        comoEstaban[1] = false; //puente
        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fuentes/Angiesfont.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 40f);
            fuentePersonalizada = fuentePersonalizada.deriveFont(Font.BOLD);
            label[0].setFont(fuentePersonalizada);
            label[1].setFont(fuentePersonalizada);
        } catch (Exception e) {}
        add(label[0]);
        add(label[1]);
        Thread revisarEventos = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    if(!panelMapa.getMausoleo().getBarca().getFuncional() && comoEstaban[0]) {
                        invocar("  Se a roto     tu barca");
                        comoEstaban[0] = false;
                    } else if (!PanelPuente.getPuente().getFuncional() && comoEstaban[1]) {
                        invocar("  Se a roto     el puente");
                        comoEstaban[1] = false;
                    } else if (panelMapa.getMausoleo().getTierra().getCantDemEnviados() < demEnviados) {
                        invocar("Te exorcizaron  un demonio");
                        demEnviados--;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        });
        revisarEventos.start();
        tutorial();
    }
    public void tutorial() {
        String texto = "   Bienvenido a Deaths Mission";
        label[0].setText(texto.substring(0,15));
        label[1].setText(texto.substring(15));
        Timer timer3 = new Timer(10, new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x < 150) {
                    setLocation(getLocation().x - 2, getLocation().y);
                }
                else if(300 < x) {
                    setLocation(getLocation().x + 2, getLocation().y);
                }
                if(x > 450) {
                    label[0].setText("");
                    label[1].setText("");
                    label[0].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 1.15f));
                    label[1].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 1.15f));
                    ((Timer) e.getSource()).stop();
                    invocar("    ¡Mucha           Suerte!");
                }
                x++;
            }
        });
        Timer timer2 = new Timer(10, new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x < 150) {
                    setLocation(getLocation().x - 2, getLocation().y);
                }
                else if(300 < x) {
                    setLocation(getLocation().x + 2, getLocation().y);
                }
                if(x > 450) {
                    label[0].setText("  Acercate al Mausoleo");
                    label[1].setText(" y ve tus estadisticas");
                    label[0].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 0.7f));
                    label[1].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 0.7f));
                    ((Timer) e.getSource()).stop();
                    timer3.start();
                }
                x++;
            }
        });
        Timer timer1 = new Timer(10, new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x < 150) {
                    setLocation(getLocation().x - 2, getLocation().y);
                }
                else if(300 < x) {
                    setLocation(getLocation().x + 2, getLocation().y);
                }
                if(x > 450) {
                    label[0].setText("Empuja las almas al");
                    label[1].setText("infierno por frags");
                    label[0].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 0.8f));
                    label[1].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 0.8f));
                    ((Timer) e.getSource()).stop();
                    timer2.start();
                }
                x++;
            }
        });
        Timer timer = new Timer(10, new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x < 150) {
                    setLocation(getLocation().x - 2, getLocation().y);
                }
                else if(300 < x) {
                    setLocation(getLocation().x + 2, getLocation().y);
                }
                if(x > 450) {
                    label[0].setText("  Utiliza W, A, S y D");
                    label[1].setText("    para moverte ");
                    label[0].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 0.8f));
                    label[1].setFont(fuentePersonalizada.deriveFont(fuentePersonalizada.getSize() * 0.8f));
                    ((Timer) e.getSource()).stop();
                    timer1.start();
                }
                x++;
            }
        });
        timer.start();
    }
    public void invocar(String texto) {
        label[0].setText(texto.substring(0,15));
        label[1].setText(texto.substring(15));
        Timer timer = new Timer(5, new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                if(x < 150) {
                    setLocation(getLocation().x - 2, getLocation().y);
                }
                else if(300 < x) {
                    setLocation(getLocation().x + 2, getLocation().y);
                }
                if(x > 450) {
                    label[0].setText(" ");
                    label[1].setText(" ");
                    ((Timer) e.getSource()).stop();
                }
                x++;
            }
        });
        timer.start();
    }
    public static void setComoEstaban(int cual) {
        if(cual == 0) {
            comoEstaban[0] = true;
        } else {
            comoEstaban[1] = true;
        }
    }
    public static void addDemEnviados(){
        demEnviados++;
    }
}
