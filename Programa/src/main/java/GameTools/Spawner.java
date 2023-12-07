package GameTools;

import Factories.AlmasFactory;
import Interfaz.PanelAlma;
import Interfaz.PanelMapa;
import Interfaz.Ventana;

import java.awt.*;
import java.util.Random;

public class Spawner implements Runnable {
    private static int almasActuales = 0;
    private final Point ubicacion;
    private final Dimension size;
    private final Dimension entidadSize;
    private final PanelMapa panelMapa;
    private final int[] spawner;
    private final int maxCajas = 10;
    private AlmasFactory almasFactory = new AlmasFactory();
    public Spawner(PanelMapa panelMapa, Point ubicacion, Dimension size, Dimension entidadSize) {
        this.ubicacion = ubicacion;
        this.panelMapa = panelMapa;
        this.size = size;
        this.entidadSize = entidadSize;

        spawner = new int[(int) size.height/entidadSize.height * ((int) size.width/entidadSize.width)];
    }

    @Override
    public void run() {
        int timeSpawn = 3000;
        while(true) {
            try {
                crearAlmaEn((new Random()).nextInt((int) size.height / entidadSize.height), (new Random()).nextInt((int) size.width / entidadSize.width));
                timeSpawn = 3000;
            } catch (CasillaOcupadaException e) {
                if (timeSpawn > 1000) {
                    timeSpawn -= 500;
                }
            }
            try {
                Thread.sleep(timeSpawn);
            } catch (Exception e) {
                System.err.println("Hubo un errorcito en run() de Spawner");
                return;
            }
        }
    }

    private void crearAlmaEn(int i, int u) throws CasillaOcupadaException {
        setTodasLasCasillasDesocupadas();
        for(int j = 0; j < Hitbox.getTodasLasHitbox().size(); j++) {
            actualizarCasillasOcupadas(Hitbox.getTodasLasHitbox().get(j));
        }
        if(spawner[i * (int) size.width/entidadSize.width + u] == 0 && almasActuales < (maxCajas - 1)) {
            PanelAlma panelAlma = new PanelAlma(almasFactory.crearAlmas(panelMapa.getPanelLaMuerte().getLaMuerte()));
            panelAlma.setLocation(ubicacion.x + u * entidadSize.width + u + 1, ubicacion.y + entidadSize.height * i + i + 1);
            panelAlma.getHitbox().setLocation(ubicacion.x + u * entidadSize.width + u + 1, ubicacion.y + entidadSize.height * i + i + 1);
            panelMapa.add(panelAlma);
            panelMapa.setComponentZOrder(panelAlma, 1);
            almasActuales++;
          } else {
            throw new CasillaOcupadaException();
        }
    }
    public void setCastillaOcupada(int i, int o) {
        spawner[i] = o;
    }
    public void setTodasLasCasillasDesocupadas() {
        for(int i = 0; i < spawner.length; i++) {
            spawner[i] = 0;
        }
    }
    public static void unAlmaMenos() {
        almasActuales--;
    }
    public static void unAlmaMas() {
        almasActuales++;
    }
    public int[] getSpawner() {
        return spawner;
    }
    public Rectangle casilla(int j) {
        int i = j/(((int) size.width/entidadSize.width));
        int u = j%(((int) size.width/entidadSize.width));
        return new Rectangle(ubicacion.x + u * entidadSize.width + u + 1, ubicacion.y + i * entidadSize.height + i + 1, entidadSize.width, entidadSize.height);
    }
    private void actualizarCasillasOcupadas(Hitbox h) {
        int aux = 0;
        for(int i = 0; i < spawner.length; i++) {
            if(h.getHitbox().intersects(casilla(i))) {
                setCastillaOcupada(i, 1);
                aux++;
                if(aux == 4) {
                    return;
                }
            }
        }
    }
}
