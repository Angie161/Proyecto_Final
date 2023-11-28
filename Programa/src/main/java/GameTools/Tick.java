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
    private boolean interactuar = false;
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
            jugadorSigueAControles();
            entrarAlMenu(hitboxes.get(0));
            for(int i = 1; i < hitboxes.size(); i++) {
                if(hitboxes.get(0).getHitbox().intersects(hitboxes.get(i).getHitbox())) {
                    moverHitbox(hitboxes.get(i));
                }
                try {
                    panelMapa.getPanelAltar()[0].ingresarAlma(hitboxes.get(i));
                    panelMapa.getPanelAltar()[1].ingresarAlma(hitboxes.get(i));
                    panelMapa.getPanelAltar()[2].ingresarAlma(hitboxes.get(i));
                    panelMapa.getPanelAltar()[2].fucionarAlmas(panelMapa);
                } catch(Exception e) {}
            }
            sacarAlma(hitboxes.get(0));
            if((new Random()).nextInt((int)400/(panelMapa.getMausoleo().getTierra().getCantDemEnviados() + 1)) == 0) {
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
                controles.setLocation(controles.getLocation().x - (controles.getJugador().getVelocidad().x), controles.getLocation().y - (controles.getJugador().getVelocidad().y));
                controles.getJugador().setVelocidad(new Point(0, 0));
            } else if (hitbox.isTraspasableForHitbox() && !hitbox.isTraspasableForPlayer() && hitbox.getHitbox().intersects(Hitbox.getTodasLasHitbox().get(0).getHitbox())) {
                controles.setLocation(controles.getLocation().x - (controles.getJugador().getVelocidad().x), controles.getLocation().y - (controles.getJugador().getVelocidad().y));
                controles.getJugador().setVelocidad(new Point(0, 0));
            }
        }
        hitbox.setVelocidad(0,0);
    }

    private void jugadorSigueAControles() {
        controles.setLocation(controles.getLocation().x + controles.getJugador().getVelocidad().x, controles.getLocation().y + controles.getJugador().getVelocidad().y);
        controles.getJugador().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setVelocidad(controles.getJugador().getVelocidad());
    }
    private void quemarAlma(Hitbox h) {
        if((h.getLocation().x > 749 && h.getLocation().x < 901 - h.getHitbox().width) && (h.getLocation().y > 499 || h.getLocation().y < (301 - h.getHitbox().height)) && PanelPuente.getPuente().getFuncional()) {
            int valorDelAlma = ((PanelAlma) h.getPanelAsociado()).getAlma().calcValor(controles.getJugador().getLaMuerte());
            controles.getJugador().getLaMuerte().addFragAlmas(valorDelAlma);
            panelMapa.remove(((PanelAlma) h.getPanelAsociado()).purificar());
            Spawner.unAlmaMenos();
            System.out.println("Alma quemada");
        } else if (((h.getLocation().x > 749 && h.getLocation().x < 901 - h.getHitbox().width) && (h.getLocation().y > 499 || h.getLocation().y < (301 - h.getHitbox().height)) || (h.getLocation().x > (PanelPuente.getUbicacion().x + PanelPuente.getPuenteSize().width/3) && h.getLocation().x < (PanelPuente.getUbicacion().x + 2 * PanelPuente.getPuenteSize().width/3) - h.getHitbox().width + 1)) && (h.getLocation().y < 499 || h.getLocation().y > (301 - h.getHitbox().height)) && !PanelPuente.getPuente().getFuncional()) {
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
            Spawner.unAlmaMenos();
        } else if(((PanelAlma) h.getPanelAsociado()).getAlma() instanceof Demonio && (h.getLocation().x >= 75 && h.getLocation().x <= 137 - h.getHitbox().width) && (h.getLocation().y > 420 && h.getLocation().y < (540 - h.getHitbox().height))) {
            panelMapa.getPanelDepSobres()[2].getDepSobre().add(((PanelAlma) h.getPanelAsociado()).getAlma());
            panelMapa.remove(h.getPanelAsociado());
            Hitbox.eliminarHitbox(h);
            Spawner.unAlmaMenos();
        } else if(((PanelAlma) h.getPanelAsociado()).getAlma() instanceof Persona && (h.getLocation().x >= 75 && h.getLocation().x <= 137 - h.getHitbox().width) && (h.getLocation().y > 560 && h.getLocation().y < (680 - h.getHitbox().height))) {
            panelMapa.getPanelDepSobres()[1].getDepSobre().add(((PanelAlma) h.getPanelAsociado()).getAlma());
            panelMapa.remove(h.getPanelAsociado());
            Hitbox.eliminarHitbox(h);
            Spawner.unAlmaMenos();
        }
    }
    private void sacarAlma(Hitbox h) {
        if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 20 && h.getLocation().y < (140 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[0].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[0].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[0].getDepSobre().get());
                pa.setLocation(1190, 60);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                Spawner.unAlmaMas();
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            } else if(panelMapa.getPanelSalidaDepSobres()[0].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[1].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[0].getDepSobre().get());
                pa.setLocation(1190, 560);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            }
        } else if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 150 && h.getLocation().y < (270 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[1].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[0].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[1].getDepSobre().get());
                pa.setLocation(1190, 140);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                Spawner.unAlmaMas();
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            } else if(panelMapa.getPanelSalidaDepSobres()[1].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[1].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[1].getDepSobre().get());
                pa.setLocation(1190, 560);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            }
        } else if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 530 && h.getLocation().y < (650 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[2].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[1].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[2].getDepSobre().get());
                pa.setLocation(1190, 560);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                Spawner.unAlmaMas();
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            } else if(panelMapa.getPanelSalidaDepSobres()[2].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[0].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[2].getDepSobre().get());
                pa.setLocation(1190, 140);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            }
        } else if((h.getLocation().x >= 975 && h.getLocation().x <= 990) && (h.getLocation().y > 660 && h.getLocation().y < (780 - h.getHitbox().height))) {
            if(panelMapa.getPanelSalidaDepSobres()[3].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[1].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[3].getDepSobre().get());
                pa.setLocation(1190, 650);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                Spawner.unAlmaMas();
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            } else if(panelMapa.getPanelSalidaDepSobres()[3].getDepSobre().see(0) != null && panelMapa.getPanelAltar()[0].getPanelAlma() == null && !interactuar) {
                PanelAlma pa = new PanelAlma((Almas) panelMapa.getPanelSalidaDepSobres()[3].getDepSobre().get());
                pa.setLocation(1190, 140);
                pa.getHitbox().setLocation(pa.getLocation());
                panelMapa.add(pa);
                panelMapa.setComponentZOrder(pa,0);
                interactuar = true;
            }
        } else {
            interactuar = false;
        }
    }
    private void entrarAlMenu(Hitbox h) {
        if((h.getLocation().x >= 325 && h.getLocation().x <= 565 ) && (h.getLocation().y > 75 && h.getLocation().y < 100)) {
            panelMapa.setComponentZOrder(panelMapa.getPanelMenuMausoleo(), 0);
            panelMapa.getPanelMenuMausoleo().setVisible(true);
            controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
            controles.getJugador().setVelocidad(new Point(0, 0));
        }
    }
}
