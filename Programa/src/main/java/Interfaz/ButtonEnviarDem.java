package Interfaz;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonEnviarDem extends JButton {
    public ButtonEnviarDem(PanelMapa panelMapa){
        super();
        setBounds(600,335,550,95);
        setBackground(new Color(0,0,0,0));
        setBorder(null);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().enviarDemonio();
                    PanelAnuncio.addDemEnviados();
                }catch (FragmentosInsuficientesException ex){
                    panelMapa.getPanelError().invocar("No tienes suficientes fragmentos");
                    System.out.println("No tienes suficientes fragmentos");
                } catch (DemonioNullException ex) {
                    panelMapa.getPanelError().invocar("No hay demonios para enviar");
                    System.out.println("No Demonios para enviar");
                } catch (BarcaRotaException ex) {
                    panelMapa.getPanelError().invocar(" Tu barca está rota");
                    System.out.println("Tu barca está rota");
                } catch (SinCapPermitidaException ex) {
                    panelMapa.getPanelError().invocar("  No tienes capacidad");
                    System.out.println("No tienes capacidad");
                } catch (AngelesInsuficienteException ex) {
                    panelMapa.getPanelError().invocar("   Angeles insuficientes");
                    System.out.println("Angeles insuficientes");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(0,0,0,100));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(0,0,0,0));
            }
        });
    }
}
