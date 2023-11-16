package Factories;

import Logica.*;
import java.awt.*;

public class LeviathanFactory extends DemoniosFactory{
    public Demonio crearLeviathan(int maldad, Color color){
        return new Leviathan(maldad,color);
    }
}
