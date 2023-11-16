package Factories;

import Logica.*;
import java.awt.*;

public class LuciferFactory extends DemoniosFactory{
    public Demonio crearLucifer(int maldad, Color color){
        return new Lucifer(maldad,color);
    }
}
