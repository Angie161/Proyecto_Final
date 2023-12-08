package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.InputStream;

/**
 * Clase que representa visualmente al menú del mausoleo.
 */
public class PanelMenuMausoleo extends JPanel {
    private PanelMapa panelMapa;
    private ButtonVolver buttonVolver;
    private ButtonAumPoder buttonAumPoder;
    private ButtonAumCap buttonAumCap;
    private ButtonEnviarDem buttonEnviarDem;
    private ButtonRepBarca buttonRepBarca;
    private ButtonRepPuente buttonRepPuente;
    private ImageIcon[] imageAlmas = new ImageIcon[4];
    private ImageIcon imageMenu;

    private Font fuentePersonalizadaNegr;
    private Font fuenteNoNegr;
    private JLabel[] texto;

    /**
     * Constructor de PanelMenuMausoleo en el cual se configura los tamaños, buttons y texto que se encontrará en él.
     * @param Mapa al cual está asociado el menú.
     */
    public PanelMenuMausoleo(PanelMapa Mapa) {
        super();
        setOpaque(true);
        setLayout(null);
        setBounds(50,50,PanelMapa.getTam().width - 100, PanelMapa.getTam().height - 100);
        setBackground(new Color(220, 220, 220));
        setVisible(false);

        this.panelMapa = Mapa;

        buttonVolver = new ButtonVolver(this);
        buttonAumPoder = new ButtonAumPoder(panelMapa);
        buttonAumCap = new ButtonAumCap(panelMapa);
        buttonEnviarDem = new ButtonEnviarDem(panelMapa);
        buttonRepBarca = new ButtonRepBarca(panelMapa);
        buttonRepPuente = new ButtonRepPuente(panelMapa);
        texto = new JLabel[14];

        for(int i = 0; i < 14; i++) {
            texto[i] = new JLabel();
        }
        texto[7].setText("La Muerte");
        texto[8].setText("Mundo Terrenal");

        try {
            imageMenu = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Menu/MenuMausoleo.png"));
            imageAlmas[0] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconFragmento.png"));
            imageAlmas[1] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconAngel.png"));
            imageAlmas[2] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconDem.png"));
            imageAlmas[3] = new ImageIcon(getClass().getClassLoader().getResource("Imagenes/Mapa/IconPersona.png"));


            fuentePersonalizadaNegr = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fuentes/Angiesfont.ttf"));
            fuentePersonalizadaNegr = fuentePersonalizadaNegr.deriveFont(fuentePersonalizadaNegr.getSize()*40f);
            fuentePersonalizadaNegr = fuentePersonalizadaNegr.deriveFont(Font.BOLD);

            fuenteNoNegr = Font.createFont(Font.TRUETYPE_FONT, getClass().getClassLoader().getResourceAsStream("Fuentes/Angiesfont.ttf"));
            fuenteNoNegr = fuenteNoNegr.deriveFont(fuenteNoNegr.getSize()*30f);
            fuenteNoNegr = fuenteNoNegr.deriveFont(Font.BOLD);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error al cargar la fuente personalizada. Se usará una fuente predeterminada.");
            fuentePersonalizadaNegr = new Font("Arial", Font.PLAIN, 16);
            fuenteNoNegr = new Font("Arial", Font.PLAIN, 12);
        }
        texto[0].setBounds(50,125,275,50);
        texto[1].setBounds(50,175,275,50);
        texto[2].setBounds(50, 225, 275,50);
        texto[3].setBounds(50, 275, 275,50);
        texto[4].setBounds(50, 325, 460,50);
        texto[5].setBounds(50, 550, 275,50);
        texto[6].setBounds(50, 600, 275,50);
        texto[7].setBounds(50, 50, 250, 50);
        texto[8].setBounds(50, 475, 250,50);

        texto[9].setBounds(600, 125, 500,50);
        texto[10].setBounds(600, 275, 550, 50);
        texto[11].setBounds(600, 425, 550, 50);
        texto[12].setBounds(600, 630, 350, 50);
        texto[13].setBounds(900, 630, 350, 50);

        for(int i = 0; i<9; i++){
            if (fuentePersonalizadaNegr != null) {
                texto[i].setFont(fuentePersonalizadaNegr);
                add(texto[i]);
            } else {
                // Manejar el caso en el que customFont sea null
                System.out.println("La fuente personalizada no se cargó correctamente.");
            }
        }
        for(int i = 13; i>8 ; i--){
            if (fuenteNoNegr != null) {
                texto[i].setFont(fuenteNoNegr);
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

    /**
     * Actualiza los Jlabels que contienen los precios o estadisticas de la Muerte cada vez que se realiza una compra o cambia algún valor numérico relacionado con las almas o fragmentos de almas.
     */
    public void actualizarValores(){
        texto[0].setText("Poder: " + panelMapa.getPanelLaMuerte().getLaMuerte().getPoder());
        texto[1].setText("Ángeles: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[2].getTam());
        texto[2].setText("Demonios: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[1].getTam());
        texto[3].setText("Personas: " + panelMapa.getPanelLaMuerte().getLaMuerte().getDepSobre()[0].getTam());
        texto[4].setText("Frag: " + panelMapa.getPanelLaMuerte().getLaMuerte().getFragAlmas());
        texto[5].setText("Capacidad: " + panelMapa.getMausoleo().getTierra().getCapacidad());
        texto[6].setText("Dem. Enviados: " + panelMapa.getMausoleo().getTierra().getCantDemEnviados());

        texto[9].setText("Requiere:     " + panelMapa.getMausoleo().getPrecios().getPrecioMejoraPoder());
        texto[10].setText("Requiere:     " + panelMapa.getMausoleo().getPrecios().getPrecioMejoraCapacidad(panelMapa.getMausoleo().getTierra()));
        texto[11].setText("Requiere:  " + panelMapa.getMausoleo().getPrecios().getCantAngelesEnvio(panelMapa.getMausoleo().getTierra()) + "       y     " + panelMapa.getMausoleo().getPrecios().getPrecioFragEnvio(panelMapa.getMausoleo().getTierra()));
        texto[12].setText("Requiere:     " + panelMapa.getMausoleo().getPrecios().getPrecioRepararBarca());
        texto[13].setText("Requiere:     " + panelMapa.getMausoleo().getPrecios().getPrecioRepararaPuente());
    }

    /**
     * Override del método paintComponent(g) para dibujar personalizadamente.
     *
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    protected void paintComponent(Graphics g) {
        actualizarValores();
        super.paintComponent(g);
        try {
            g.drawImage(imageMenu.getImage(), 0, 0, null);
            g.drawImage(imageAlmas[0].getImage(),716,134,null);
            g.drawImage(imageAlmas[0].getImage(),716,284,null);
            g.drawImage(imageAlmas[1].getImage(),760,434,null);
            g.drawImage(imageAlmas[0].getImage(),806,434,null);
            g.drawImage(imageAlmas[0].getImage(),716,639,null);
            g.drawImage(imageAlmas[0].getImage(),1016,639,null);

        } catch(Exception e) {

            //Retrato Muerte
            g.setColor(new Color(50, 50, 50));
            g.fillRect(350, 50, 150, 250);

            //Foto MundoTerrenal
            g.setColor(new Color(50, 100, 50));
            g.fillRect(350, 500, 150, 100);

            g.setColor(new Color(100, 100, 40));
            //g.fillRect(50, 325, 450,50);

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
}
