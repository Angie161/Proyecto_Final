package GameTools;

import Interfaz.*;
import Logica.Almas;
import Logica.Angel;
import Logica.Demonio;
import Logica.Persona;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Tick extends Thread {
    private static final int tick = 5;
    private Controles controles;
    private PanelMapa panelMapa;
    public Tick(Controles controles, PanelMapa panelMapa){
        super();
        this.controles = controles;
        this.panelMapa = panelMapa;
        start();
    }

    @Override
    public void run() {
        while(true) {
            ArrayList<Hitbox> hitboxes = Hitbox.getTodasLasHitbox();
            entrarAlMenu(hitboxes.get(0));
            for(int i = 1; i < hitboxes.size(); i++) {
                if(hitboxes.get(0).getHitbox().intersects(hitboxes.get(i).getHitbox())) {
                    moverHitbox(hitboxes.get(i));
                }
            }
            sacarAlma(hitboxes.get(0));
            jugadorSigueAControles();
            if((new Random()).nextInt(100) == 0) {
                 controles.getJugador().getLaMuerte().addFragAlmas(panelMapa.getMausoleo().getTierra().muertes());
            }
            try {
                Thread.sleep(Tick.tick);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void moverHitbox(Hitbox hitbox) {
        if (hitbox.isMovible()) {
            hitbox.setVelocidad(Hitbox.getTodasLasHitbox().get(0).getVelocidad());
            hitbox.setLocation(hitbox.getLocation().x + hitbox.getVelocidad().x, hitbox.getLocation().y + hitbox.getVelocidad().y);
            quemarAlma(hitbox);
            guardarAlma(hitbox);
            panelMapa.getPanelAltar()[0].ingresarAlma(hitbox);
            panelMapa.getPanelAltar()[1].ingresarAlma(hitbox);
            for (int i = 1; i < Hitbox.getTodasLasHitbox().size(); i++) {
                if (Hitbox.getTodasLasHitbox().get(i) != hitbox && Hitbox.getTodasLasHitbox().get(i).getHitbox().intersects(hitbox.getHitbox())) {
                    moverHitbox(Hitbox.getTodasLasHitbox().get(i));
                }
            }
        } else {
            if (!hitbox.isTraspasableForHitbox() && !hitbox.isTraspasableForPlayer()) {
                for (int i = Hitbox.NoMovibleHitboxs(); i < Hitbox.getTodasLasHitbox().size(); i++) {
                    Hitbox.getTodasLasHitbox().get(i).setLocation(Hitbox.getTodasLasHitbox().get(i).getLocation().x - Hitbox.getTodasLasHitbox().get(i).getVelocidad().x, Hitbox.getTodasLasHitbox().get(i).getLocation().y - Hitbox.getTodasLasHitbox().get(i).getVelocidad().y);
                }
                controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
                controles.getJugador().setVelocidad(new Point(0, 0));
            } else if (hitbox.isTraspasableForHitbox() && !hitbox.isTraspasableForPlayer() && hitbox.getHitbox().intersects(Hitbox.getTodasLasHitbox().get(0).getHitbox())) {
                controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
                controles.getJugador().setVelocidad(new Point(0, 0));
            }
        }
    }

    private void jugadorSigueAControles() {
        controles.setLocation(controles.getLocation().x + controles.getJugador().getVelocidad().x, controles.getLocation().y + controles.getJugador().getVelocidad().y);
        controles.getJugador().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setVelocidad(controles.getJugador().getVelocidad());
    }
    private void quemarAlma(Hitbox h) {
        if((h.getLocation().x > 749 && h.getLocation().x < 901 - h.getHitbox().width) && (h.getLocation().y > 499 || h.getLocation().y < (301 - h.getHitbox().height))) {
            int valorDelAlma = ((PanelAlma) h.getPanelAsociado()).getAlma().calcValor(controles.getJugador().getLaMuerte());
            controles.getJugador().getLaMuerte().addFragAlmas(valorDelAlma);
            panelMapa.remove(((PanelAlma) h.getPanelAsociado()).purificar());
            Spawner.unAlmaMenos();
            System.out.println("Alma quemada");
        }
    }
    private void guardarAlma(Hitbox h) {
        if(((PanelAlma) h.getPanelAsociado()).getAlma() instanceof Angel && (h.getLocation().x >= 75 && h.getLocation().x <= 137 - h.getHitbox().width) && (h.getLocation().y > 280 && h.getLocation().y < (400 - h.getHitbox().height))) {
            panelMapa.getPanelDepSobres()[0].getDepSobre().add(((PanelAlma) h.getPanelAsociado()).getAlma());
            panelMapa.remove(h.getPanelAsociado());
            Hitbox.eliminarHitbox(h);
        } else if(((PanelAlma) h.getPanelAsociado()).getAlma() instanceof Demonio && (h.getLocation().x >= 75 && h.getLocation().x <= 137 - h.getHitbox().width) && (h.getLocation().y > 420 && h.getLocation().y < (540 - h.getHitbox().height))) {
            panelMapa.getPanelDepSobres()[2].getDepSobre().add(((PanelAlma) h.getPanelAsociado()).getAlma());
            panelMapa.remove(h.getPanelAsociado());
            Hitbox.eliminarHitbox(h);
        } else if(((PanelAlma) h.getPanelAsociado()).getAlma() instanceof Persona && (h.getLocation().x >= 75 && h.getLocation().x <= 137 - h.getHitbox().width) && (h.getLocation().y > 560 && h.getLocation().y < (680 - h.getHitbox().height))) {
            panelMapa.getPanelDepSobres()[1].getDepSobre().add(((PanelAlma) h.getPanelAsociado()).getAlma());
            panelMapa.remove(h.getPanelAsociado());
            Hitbox.eliminarHitbox(h);
        }
    }
    private void sacarAlma(Hitbox h) {
        if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 20 && h.getLocation().y < (140 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[0].getDepSobre().see(0) != null) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[0].getDepSobre().get());
                pa.setLocation(1060, 30);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
            }
        } else if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 150 && h.getLocation().y < (270 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[1].getDepSobre().see(0) != null) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[1].getDepSobre().get());
                pa.setLocation(1060, 160);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
            }
        } else if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 530 && h.getLocation().y < (650 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[2].getDepSobre().see(0) != null) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[2].getDepSobre().get());
                pa.setLocation(1060, 540);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
            }
        } else if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 660 && h.getLocation().y < (780 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[3].getDepSobre().see(0) != null) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[3].getDepSobre().get());
                pa.setLocation(1060, 670);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
            }
        }
    }
    private void entrarAlMenu(Hitbox h) {
        if((h.getLocation().x >= 325 && h.getLocation().x <= 565 ) && (h.getLocation().y > 75 && h.getLocation().y < 100)) {
            panelMapa.setComponentZOrder(panelMapa.getPanelMenuMausoleo(), 0);
            panelMapa.getPanelMenuMausoleo().setVisible(true);
            panelMapa.getPanelMenuMausoleo().actualizarValores();
            controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
            controles.getJugador().setVelocidad(new Point(0, 0));
        }
    }
}
