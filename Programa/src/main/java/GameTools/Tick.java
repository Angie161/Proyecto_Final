package GameTools;

import Interfaz.PanelAlma;
import Interfaz.PanelLaMuerte;
import Interfaz.PanelMapa;
import Interfaz.Ventana;

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
            jugadorSigueAControles();
            ArrayList<Hitbox> hitboxes = Hitbox.getTodasLasHitbox();
            for(int i = 1; i < hitboxes.size(); i++) {
                if(hitboxes.get(0).getHitbox().intersects(hitboxes.get(i).getHitbox())) {
                    moverHitbox(hitboxes.get(i));
                }
            }
            if((new Random()).nextInt(100) == 0) {
                 controles.getJugador().getLaMuerte().addFragAlmas(panelMapa.getMausoleo().getTierra().muertes());
            }
            Ventana.repintar();
            try {
                Thread.sleep(Tick.tick);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void moverHitbox(Hitbox hitbox) {
        //if(hitbox.isMovible()) {
            quemarAlma(hitbox);
            hitbox.setVelocidad(Hitbox.getTodasLasHitbox().get(0).getVelocidad());
            hitbox.setLocation(hitbox.getLocation().x + hitbox.getVelocidad().x, hitbox.getLocation().y + hitbox.getVelocidad().y);
            for (int i = 1; i < Hitbox.getTodasLasHitbox().size(); i++) {
                if (Hitbox.getTodasLasHitbox().get(i) != hitbox && Hitbox.getTodasLasHitbox().get(i).getHitbox().intersects(hitbox.getHitbox())) {
                    moverHitbox(Hitbox.getTodasLasHitbox().get(i));
                }
            }
            hitbox.setVelocidad(new Point(0, 0));
            hitbox.getPanelAsociado().setLocation(hitbox.getLocation());
        //} else {
          //  controles.getJugador().setVelocidad(new Point(0,0));
        //}
    }

    private void jugadorSigueAControles() {
        controles.setLocation(controles.getLocation().x + controles.getJugador().getVelocidad().x, controles.getLocation().y + controles.getJugador().getVelocidad().y);
        controles.getJugador().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setVelocidad(controles.getJugador().getVelocidad());
    }
    private void quemarAlma(Hitbox h) {
        if((h.getLocation().x > 750 && h.getLocation().x < 900) && (h.getLocation().y > 500 || h.getLocation().y < (300 - h.getHitbox().height))) {
            int valorDelAlma = ((PanelAlma) h.getPanelAsociado()).getAlma().calcValor(controles.getJugador().getLaMuerte());
            controles.getJugador().getLaMuerte().addFragAlmas(valorDelAlma);
            panelMapa.remove(((PanelAlma) h.getPanelAsociado()).purificar());
            Spawner.unAlmaMenos();
            System.out.println("Alma quemada");
        }
    }
}
