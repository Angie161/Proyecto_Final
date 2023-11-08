package Logica;

public class LaMuerte {
    private int fragAlmas;
    private int poder;
    private DepSobre[] depSobre;

    public LaMuerte(){
        fragAlmas=0;
        poder=0;
        depSobre = new DepSobre[3];

        depSobre[0] = new DepSobre<Persona>(0);
        depSobre[0] = new DepSobre<Demonio>(0);
        depSobre[0] = new DepSobre<Angel>(0);
    }

    private int getFragAlmas(){
        return fragAlmas;
    }

    private void addFragAlmas(int fragAlmasObtenido){
        fragAlmas+=fragAlmasObtenido;
    }

    private int getPoder(){
        return poder;
    }

    private void setPoder(int poderActual){
        poder=poderActual;
    }

    /**
     * Obtiene los depósitos de almas de personas, demonios y angeles.
     * @return
     */
    private DepSobre[] getDepSobre(){
        return depSobre;
    }

}
