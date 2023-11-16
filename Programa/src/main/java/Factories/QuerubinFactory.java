package Factories;

import Logica.*;
import java.awt.*;

public class QuerubinFactory extends AngelesFactory{

    public Angel crearQuerubin(int bondad, Color color){
        return new Querubin(bondad,color);
    }
}
