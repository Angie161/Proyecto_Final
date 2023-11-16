package Factories;

import Logica.*;
import java.awt.*;

public class ArcangelFactory extends AngelesFactory{

    public Arcangel crearArcangel(int bondad, Color color){
        return new Arcangel(bondad, color);
    }
}