package GameTools;

import java.awt.*;
import java.util.ArrayList;

public class Tick extends Thread {
    private static final int tick = 5;
    private Controles controles;
    public Tick(Controles controles){
        super();
        this.controles = controles;
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
            try {
                Thread.sleep(Tick.tick);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    private void moverHitbox(Hitbox hitbox) {
        hitbox.setVelocidad(Hitbox.getTodasLasHitbox().get(0).getVelocidad());
        hitbox.setLocation(hitbox.getLocation().x + hitbox.getVelocidad().x, hitbox.getLocation().y + hitbox.getVelocidad().y);
        hitbox.setVelocidad(new Point(0, 0));
        hitbox.getPanelAsociado().setLocation(hitbox.getLocation());
    }

    private void jugadorSigueAControles() {
        controles.setLocation(controles.getLocation().x + controles.getJugador().getVelocidad().x, controles.getLocation().y + controles.getJugador().getVelocidad().y);
        controles.getJugador().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setLocation(controles.getLocation());
        controles.getJugador().getHitbox().setVelocidad(controles.getJugador().getVelocidad());
    }
}
