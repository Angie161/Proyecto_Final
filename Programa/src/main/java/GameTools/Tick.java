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
            ArrayList<Hitbox> hitboxes = Hitbox.getTodasLasHitbox();
            for(int i = 1; i < hitboxes.size(); i++) {
                if(hitboxes.get(0).getHitbox().intersects(hitboxes.get(i).getHitbox())) {
                    moverHitbox(hitboxes.get(i));
                }
            }
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
        if(hitbox.isMovible()) {
            hitbox.setVelocidad(Hitbox.getTodasLasHitbox().get(0).getVelocidad());
            hitbox.setLocation(hitbox.getLocation().x + hitbox.getVelocidad().x, hitbox.getLocation().y + hitbox.getVelocidad().y);
            quemarAlma(hitbox);
            for (int i = 1; i < Hitbox.getTodasLasHitbox().size(); i++) {
                if (Hitbox.getTodasLasHitbox().get(i) != hitbox && Hitbox.getTodasLasHitbox().get(i).getHitbox().intersects(hitbox.getHitbox())) {
                    moverHitbox(Hitbox.getTodasLasHitbox().get(i));
                }
            }
            hitbox.getPanelAsociado().setLocation(hitbox.getLocation());
        } else {
            if (!hitbox.isTraspasableForHitbox() && !hitbox.isTraspasableForPlayer()) {
                for (int i = Hitbox.NoMovibleHitboxs(); i < Hitbox.getTodasLasHitbox().size(); i++) {
                    Hitbox.getTodasLasHitbox().get(i).setLocation(Hitbox.getTodasLasHitbox().get(i).getLocation().x - Hitbox.getTodasLasHitbox().get(i).getVelocidad().x, Hitbox.getTodasLasHitbox().get(i).getLocation().y - Hitbox.getTodasLasHitbox().get(i).getVelocidad().y);
                    Hitbox.getTodasLasHitbox().get(i).setVelocidad(0, 0);
                }
                controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
                controles.getJugador().setVelocidad(new Point(0,0));
            } else if (hitbox.isTraspasableForHitbox() && !hitbox.isTraspasableForPlayer() && hitbox.getHitbox().intersects(Hitbox.getTodasLasHitbox().get(0).getHitbox())) {
                controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
                controles.getJugador().setVelocidad(new Point(0,0));
            }
        }
            /*
            hitbox.setVelocidad(Hitbox.getTodasLasHitbox().get(0).getVelocidad());
            hitbox.setLocation(hitbox.getLocation().x + hitbox.getVelocidad().x, hitbox.getLocation().y + hitbox.getVelocidad().y);
            quemarAlma(hitbox);
            for (int i = 1; i < Hitbox.getTodasLasHitbox().size(); i++) {
                if (Hitbox.getTodasLasHitbox().get(i) != hitbox && Hitbox.getTodasLasHitbox().get(i).getHitbox().intersects(hitbox.getHitbox()) && !Hitbox.getTodasLasHitbox().get(i).isTraspasableForHitbox() && !Hitbox.getTodasLasHitbox().get(i).isTraspasableForPlayer()) {
                    // Se puede mover y no es transpasable
                    moverHitbox(Hitbox.getTodasLasHitbox().get(i));
                } else if (Hitbox.getTodasLasHitbox().get(i) != hitbox && Hitbox.getTodasLasHitbox().get(i).getHitbox().intersects(hitbox.getHitbox()) && Hitbox.getTodasLasHitbox().get(i).isTraspasableForHitbox() && !Hitbox.getTodasLasHitbox().get(i).isTraspasableForPlayer()) {
                    // No se puede mover, es traspasable por las almas(hitbox), pero no por el jugador.
                } else if (Hitbox.getTodasLasHitbox().get(i) != hitbox && Hitbox.getTodasLasHitbox().get(i).getHitbox().intersects(hitbox.getHitbox()) && Hitbox.getTodasLasHitbox().get(i).isTraspasableForPlayer() && !Hitbox.getTodasLasHitbox().get(i).isTraspasableForHitbox()) {
                    // No se puede mover, no es traspasable por las almas(hitbox), pero si por el jugador.
                }
            }
            hitbox.getPanelAsociado().setLocation(hitbox.getLocation());
            */
            /*
            // No se puede mover y no es traspasable por ninguno.
            for (int i = Hitbox.NoMovibleHitboxs(); i < Hitbox.getTodasLasHitbox().size(); i++) {
                Hitbox.getTodasLasHitbox().get(i).setLocation(Hitbox.getTodasLasHitbox().get(i).getLocation().x - Hitbox.getTodasLasHitbox().get(i).getVelocidad().x, Hitbox.getTodasLasHitbox().get(i).getLocation().y - Hitbox.getTodasLasHitbox().get(i).getVelocidad().y);
                Hitbox.getTodasLasHitbox().get(i).setVelocidad(0, 0);
            }
            controles.setLocation(controles.getLocation().x - controles.getJugador().getVelocidad().x, controles.getLocation().y - controles.getJugador().getVelocidad().y);
            controles.getJugador().setVelocidad(new Point(0,0));
            */
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
}
