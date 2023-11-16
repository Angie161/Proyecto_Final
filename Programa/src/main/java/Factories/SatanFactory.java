package Factories;

import Logica.*;
import java.awt.*;

public class SatanFactory extends DemoniosFactory{
    public Demonio crearSatan(int maldad, Color color){
        return new Leviathan(maldad,color);
    }
}
