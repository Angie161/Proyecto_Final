package Factories;

import Logica.*;
import java.awt.*;

public class SerafineFactory extends AngelesFactory{

    public Serafin crearSerafine(int bondad, Color color){
        return new Serafin(bondad, color);
    }
}