package Logica;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.awt.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase de tipo Test Unitario para probar el correcto comportamiento de los métodos de la clase DepSobre.
 */
public class TestDepSobre {
    private DepSobre<Angel> depositoAngeles;
    private Color colorAngel;
    private Arcangel arcangel;
    private Querubin querubin;
    private Serafin serafin;

    /**
     * Inicializa las variables que se emplearán en todas las pruebas.
     */
    @BeforeEach
    void setup(){
        depositoAngeles = new DepSobre<>();
        colorAngel = new Color(255,255,255);

        arcangel = new Arcangel(50, colorAngel);
        querubin = new Querubin(60,colorAngel);
        serafin = new Serafin(70, colorAngel);
    }

    /**
     * Prueba del método add() y getTam(), que permiten añadir y ver el tamaño del depósito.
     */
    @Test
    @DisplayName("Test ingreso Almas")
    void ingresoAlmasMismoTipo(){
        assertEquals(0, depositoAngeles.getTam());
        depositoAngeles.add(arcangel);
        assertEquals(1, depositoAngeles.getTam());
        depositoAngeles.add(querubin);
        assertEquals(2, depositoAngeles.getTam());
        depositoAngeles.add(serafin);
        assertEquals(3, depositoAngeles.getTam());
        //Correcto ingreso de almas y tamaño al depósito
    }

    /**
     * Prueba del método get(), que permite sacar las almas del depósito.
     */
    @Test
    @DisplayName("Test egreso Almas del mismo tipo")
    void egresoAlmasMismoTipo(){
        depositoAngeles.add(arcangel);
        depositoAngeles.add(querubin);
        assertNotNull(depositoAngeles);

        assertNotNull(depositoAngeles.get());
        assertNotNull(depositoAngeles.get());
        assertNull(depositoAngeles.get());
        //Correcta salida de almas y tamaño del depósito
    }

    /**
     * Prueba del método see(), que permite ver el alma que se encuentra en la posición dada.
     */
    @Test
    @DisplayName("Test verificación de Alma")
    void verificadoAlma(){
        depositoAngeles.add(arcangel);
        depositoAngeles.add(querubin);

        assertSame(depositoAngeles.see(0),arcangel);
        assertSame(depositoAngeles.see(1),querubin);
    }
}
