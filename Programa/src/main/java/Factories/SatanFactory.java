package Factories;

import Logica.*;
import java.awt.*;

public class SatanFactory extends DemoniosFactory{
    public Demonio crearSatan(int maldadRandom, Color selectColor){
        return new Satan(maldadRandom,selectColor());
    }
}
