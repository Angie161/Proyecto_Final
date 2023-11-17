package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

public class TestDepSobre {
    private DepSobre<Angel> depositoAngeles;
    private Color colorAngel;
    private Arcangel arcangel;
    private Querubin querubin;
    private Serafin serafin;

    @BeforeEach
    void setup(){
        depositoAngeles = new DepSobre<>();
        colorAngel = new Color(255,255,255);

        arcangel = new Arcangel(50, colorAngel);
        querubin = new Querubin(60,colorAngel);
        serafin = new Serafin(70, colorAngel);
    }

    @Test
    @DisplayName("Test ingreso Almas del mismo tipo")
    void IngresoAlmasMismoTipo(){
        assertEquals(0, depositoAngeles.getTam());
        depositoAngeles.add(arcangel);
        assertEquals(1, depositoAngeles.getTam());
        depositoAngeles.add(querubin);
        assertEquals(2, depositoAngeles.getTam());
        depositoAngeles.add(serafin);
        assertEquals(3, depositoAngeles.getTam());
        //Correcto ingreso de almas y tamaño al depósito
    }

    @Test
    @DisplayName("Test egreso Almas del mismo tipo")
    void EgresoAlmasMismoTipo(){
        depositoAngeles.add(arcangel);
        depositoAngeles.add(querubin);
        assertNotNull(depositoAngeles);

        assertNotNull(depositoAngeles.get());
        assertNotNull(depositoAngeles.get());
        assertNull(depositoAngeles.get());
        //Correcta salida de almas y tamaño del depósito
    }

    @Test
    @DisplayName("Test verificación de Alma")
    void VerificadoAlma(){
        depositoAngeles.add(arcangel);
        depositoAngeles.add(querubin);

        assertSame(depositoAngeles.see(0),arcangel);
        assertSame(depositoAngeles.see(1),querubin);
    }
}
