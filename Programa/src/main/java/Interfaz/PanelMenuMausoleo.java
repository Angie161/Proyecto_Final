package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.InputStream;

public class PanelMenuMausoleo extends JPanel {
    private PanelMapa panelMapa;
    private ButtonVolver buttonVolver;
    private ButtonAumPoder buttonAumPoder;
    private ButtonAumCap buttonAumCap;
    private ButtonEnviarDem buttonEnviarDem;
    private ButtonRepBarca buttonRepBarca;
    private ButtonRepPuente buttonRepPuente;

    private Font customFont;
    private Font fuentePersonalizada;
    private JLabel[] texto;

    public PanelMenuMausoleo(PanelMapa Mapa) {
        super();
        setOpaque(true);
        setLayout(null);
        setBounds(50,50,PanelMapa.getTam().width - 100, PanelMapa.getTam().height - 100);
        setBackground(new Color(220, 220, 220));
        //setVisible(false);

        this.panelMapa = Mapa;

        buttonVolver = new ButtonVolver(this);
        buttonAumPoder = new ButtonAumPoder(panelMapa);
        buttonAumCap = new ButtonAumCap(panelMapa);
        buttonEnviarDem = new ButtonEnviarDem(panelMapa);
        buttonRepBarca = new ButtonRepBarca(panelMapa);
        buttonRepPuente = new ButtonRepPuente(panelMapa);
        texto = new JLabel[10];

        // 0: Poder, 1:CantAngeles, 2:CantDemonios, 3:CantPersonas, 4:cantFragAlmas, 5:Capacidad, 6:DemoniosEnviados.
        texto[0] = new JLabel("Poder: " + panelMapa.getPanelLaMuerte().getLaMuerte().getPoder());
        texto[1] = new JLabel("Ángeles: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[2].getTam());
        texto[2] = new JLabel("Demonios: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[1].getTam());
        texto[3] = new JLabel("Personas: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[0].getTam());
        texto[4] = new JLabel("Frag: " + panelMapa.getPanelLaMuerte().getLaMuerte().getFragAlmas());
        texto[5] = new JLabel("Capacidad: " + panelMapa.getMausoleo().getTierra().getCapacidad());
        texto[6] = new JLabel("Dem. enviados: " + panelMapa.getMausoleo().getTierra().getCantDemEnviados());
        texto[7] = new JLabel("Requiere: " + panelMapa.getMausoleo().getPrecios().getCantAngelesEnvio(panelMapa.getMausoleo().getTierra()) + " angeles y " + panelMapa.getMausoleo().getPrecios().getPrecioFragEnvio(panelMapa.getMausoleo().getTierra()) + " frag");
        texto[8] = new JLabel("La Muerte");
        texto[9] = new JLabel("Mundo Terrenal");

        try {
            fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fuentes/Angiesfont.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(fuentePersonalizada.getSize()*40f);
            fuentePersonalizada = fuentePersonalizada.deriveFont(Font.BOLD);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al cargar la fuente personalizada. Se usará una fuente predeterminada.");
            fuentePersonalizada = new Font("Arial", Font.PLAIN, 16);
        }
        texto[0].setBounds(50,125,275,50);
        texto[1].setBounds(50,175,275,50);
        texto[2].setBounds(50, 225, 275,50);
        texto[3].setBounds(50, 275, 275,50);
        texto[4].setBounds(50, 325, 275,50);
        texto[5].setBounds(50, 550, 275,50);
        texto[6].setBounds(50, 600, 275,50);
        texto[7].setBounds(600, 450, 550,50);
        texto[8].setBounds(50, 50, 250,50);
        texto[9].setBounds(50, 475, 300,50);

        for(int i = 0; i<texto.length; i++){
            if (fuentePersonalizada != null) {
                texto[i].setFont(fuentePersonalizada);
                add(texto[i]);
            } else {
                // Manejar el caso en el que customFont sea null
                System.out.println("La fuente personalizada no se cargó correctamente.");
            }
        }

        add(buttonVolver);
        add(buttonAumPoder);
        add(buttonAumCap);
        add(buttonEnviarDem);
        add(buttonRepBarca);
        add(buttonRepPuente);
    }

    public void actualizarValores(){
        texto[0].setText("Poder: " + panelMapa.getPanelLaMuerte().getLaMuerte().getPoder());
        texto[1].setText("Ángeles: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[2].getTam());
        texto[2].setText("Demonios: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[1].getTam());
        texto[3].setText("Personas: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[0].getTam());
        texto[4].setText("Frag: " + panelMapa.getPanelLaMuerte().getLaMuerte().getFragAlmas());
        texto[5].setText("Capacidad: " + panelMapa.getMausoleo().getTierra().getCapacidad());
        texto[6].setText("Dem. Enviados: " + panelMapa.getMausoleo().getTierra().getCantDemEnviados());
        texto[7].setText("Requiere: " + panelMapa.getMausoleo().getPrecios().getCantAngelesEnvio(panelMapa.getMausoleo().getTierra()) + " angeles y " + panelMapa.getMausoleo().getPrecios().getPrecioFragEnvio(panelMapa.getMausoleo().getTierra()) + " frag");

    }

    @Override
    protected void paintComponent(Graphics g) {
        actualizarValores();
        super.paintComponent(g);
        //Retrato Muerte
        g.setColor(new Color(50, 50, 50));
        g.fillRect(350, 50, 150, 250);

        //Foto MundoTerrenal
        g.setColor(new Color(50, 100, 50));
        g.fillRect(350, 500, 150, 100);

        g.setColor(new Color(100, 100, 40));
        //g.fillRect(325, 75, 250,25);

        Graphics2D g2d = (Graphics2D) g;

        // Configura el patrón de la línea punteada
        float[] dashPattern = {5.0f}; // Ajusta el patrón según sea necesario
        g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dashPattern, 0.0f));

        // Dibuja la línea punteada
        g2d.setColor(Color.BLACK);
        g2d.drawLine(0, 425, 550, 425);

        float[] dashPattern2 = {5.0f}; // Ajusta el patrón según sea necesario
        g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1.0f, dashPattern2, 0.0f));

        g2d.setColor(Color.BLACK);
        g2d.drawLine(550, 0, 550, 800);
    }
}
