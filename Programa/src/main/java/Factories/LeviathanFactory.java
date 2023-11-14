package Factories;

import Logica.*;
import java.awt.*;

public class LeviathanFactory extends DemoniosFactory{
    public Demonio crearLeviathan(int maldadRandom, Color selectColor){
        return new Leviathan(maldadRandom,selectColor());
    }
}
