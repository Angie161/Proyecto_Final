package Interfaz;

import Logica.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ButtonEnviarDem extends JButton {
    public ButtonEnviarDem(PanelMapa panelMapa){
        super();
        setBounds(600,350,550,100);

        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}

            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    panelMapa.getMausoleo().enviarDemonio();
                    panelMapa.getPanelMenuMausoleo().actualizarValores();
                }catch (FragmentosInsuficientesException ex){
                    System.out.println("No tienes suficientes fragmentos");
                } catch (DemonioNullException ex) {
                    System.out.println("No Demonios para enviar");
                } catch (BarcaRotaException ex) {
                    System.out.println("Tu barca está rota");
                } catch (SinCapPermitidaException ex) {
                    System.out.println("No tienes capacidad");
                } catch (AngelesInsuficienteException ex) {
                    System.out.println("Angeles insuficientes");
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {}

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(new Color(100, 135, 220));
        g.fillRect(0, 0,550,100);
    }
}
