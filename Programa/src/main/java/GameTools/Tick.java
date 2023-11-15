package GameTools;

public class Tick extends Thread {
    private static final int tick = 10;
    private Controles controles;
    public Tick(Controles controles){
        super();
        this.controles = controles;
        start();
    }

    @Override
    public void run() {
        while(controles.hayMovimiento()) {
            jugadorSigueAControles();
            try {
                Thread.sleep(Tick.tick);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
    private void jugadorSigueAControles() {
        controles.setLocation(controles.getLocation().x + controles.getJugador().getVelocidad().x, controles.getLocation().y + controles.getJugador().getVelocidad().y);
        controles.getJugador().setLocation(controles.getLocation());
        //controles.getJugador().getHitbox().setLocation(controles.getLocation());
        //controles.getJugador().getHitbox().setVelocidad(controles.getJugador().getVelocidad());
    }
}
