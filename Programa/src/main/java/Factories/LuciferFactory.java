package Factories;

import Logica.*;
import java.awt.*;

public class LuciferFactory extends DemoniosFactory{
    public Demonio crearLucifer(int maldadRandom, Color selectColor){
        return new Lucifer(maldadRandom,selectColor());
    }
}
