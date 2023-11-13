package Logica;

public class Precios {
    private int precioMejoraCapacidad;
    private int precioMejoraPoder;
    private int precioFragEnvio;
    private int precioAlmasEnvio;
    private LaMuerte laMuerte;
    private MundoTerrenal mundoTerrenal;

    public Precios(LaMuerte laMuerte, MundoTerrenal mundoTerrenal){
        precioMejoraCapacidad = 1000;
        precioMejoraPoder = 1000;
        precioFragEnvio = 500;
        precioAlmasEnvio = 5;
        this.laMuerte=laMuerte;
        this.mundoTerrenal= mundoTerrenal;
    }

    public int getPrecioAlmasEnvio() {
        return precioAlmasEnvio;
    }

    public int getPrecioFragEnvio() {
        return precioFragEnvio;
    }

    public int getPrecioMejoraCapacidad() {
        return precioMejoraCapacidad;
    }

    public int getPrecioMejoraPoder() {
        return precioMejoraPoder;
    }

    public void actualPrecioCapacidad(int tiempoTranscurrido){
        try {
            precioMejoraCapacidad = (int) (mundoTerrenal.getCapacidad() * 1000 + (tiempoTranscurrido * 2) * Math.pow(laMuerte.getPoder(), 2));
        }catch (NullPointerException e){
            return;
        }
    }

    public void actualPrecioPoder(int tiempoTranscurrido){
        precioMejoraPoder = (int)((tiempoTranscurrido*2) * laMuerte.getPoder() * 1000 * Math.pow(mundoTerrenal.getCapacidad(),2));
    }

    public void actualPrecioEnvio(int tiempoTranscurrido){
        precioFragEnvio = (int)((tiempoTranscurrido*2) * mundoTerrenal.getCantDemEnviados()*1000);
        precioAlmasEnvio=(int)((tiempoTranscurrido) + mundoTerrenal.getCantDemEnviados()*10);
    }
}
