package GameTools;

import Factories.AlmasFactory;
import Interfaz.PanelAlma;
import Interfaz.PanelMapa;
import Interfaz.Ventana;

import java.awt.*;
import java.util.Random;

/**
 * Clase que establece el área donde podrán aparecer almas con sus respectivas hitbox en el mapa.
 */
public class Spawner implements Runnable {
    private static int almasActuales = 0;
    private final Point ubicacion;
    private final Dimension size;
    private final Dimension entidadSize;
    private final PanelMapa panelMapa;
    private final int[] spawner;
    private final int maxCajas = 10;
    private AlmasFactory almasFactory = new AlmasFactory();

    /**
     * Constructor de Spawner, el cual establece las dimensiones del spawner.
     * @param panelMapa en el cual se encontrará el spawner.
     * @param ubicacion en la cual se ubicará el spawner en el mapa.
     * @param size, tamaño que tendrá el spawner.
     * @param entidadSize tamaño de las entidades que aparecerán en esta área.
     */
    public Spawner(PanelMapa panelMapa, Point ubicacion, Dimension size, Dimension entidadSize) {
        this.ubicacion = ubicacion;
        this.panelMapa = panelMapa;
        this.size = size;
        this.entidadSize = entidadSize;

        spawner = new int[(int) size.height/entidadSize.height * ((int) size.width/entidadSize.width)];
    }

    /**
     * Establece el tiempo en que aparecerán las almas dentro de ella.
     */
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

    /**
     * Crea las almas dentro de ella.
     * @param i posición x en la cuál aparecerá el alma.
     * @param u posición y en la cuál aparecerá el alma.
     * @throws CasillaOcupadaException en caso de que se intente generar una alma en un espacio que ya se encuentra ocupada por otra.
     */
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

    /**
     * Setter de una casilla que se encuentra ocupada.
     * @param i posición del arreglo spawner.
     * @param o valor para definir el estado de la casilla en la posición i.
     */
    public void setCastillaOcupada(int i, int o) {
        spawner[i] = o;
    }

    /**
     * Setter para establecer todas las casillas desocupadas.
     */
    public void setTodasLasCasillasDesocupadas() {
        for(int i = 0; i < spawner.length; i++) {
            spawner[i] = 0;
        }
    }

    /**
     * Elimina un alma del contador de almas que se encuentran actualmente en el mapa.
     */
    public static void unAlmaMenos() {
        almasActuales--;
    }

    /**
     * Agrega un alma al contador de almas que se encuentran actualmente en el mapa.
     */
    public static void unAlmaMas() {
        almasActuales++;
    }

    /**
     * Establece el tamaño de la casilla.
     * @param j entero que definirá las dimensiones de la casilla.
     * @return Rentangle con las dimensiones de la casilla.
     */
    public Rectangle casilla(int j) {
        int i = j/(((int) size.width/entidadSize.width));
        int u = j%(((int) size.width/entidadSize.width));
        return new Rectangle(ubicacion.x + u * entidadSize.width + u + 1, ubicacion.y + i * entidadSize.height + i + 1, entidadSize.width, entidadSize.height);
    }

    /**
     * Actualiza la cantidad de casillas que se encuentran ocupadas.
     * @param h hitbox que se desea agregar al área del spawner.
     */
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
