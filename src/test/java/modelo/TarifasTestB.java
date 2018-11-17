/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Manuel
 */
@RunWith(Parameterized.class)
public class TarifasTestB {

    private final Caja caja;
    private final int inPutNumber;
    private final int outPutNumber;
    
    //Necesito hacer que para cada prueba se utilice el mismo objeto (?)
    public TarifasTestB(int a, int b) {
        this.caja = new Caja(25);
        this.inPutNumber = a;
        this.outPutNumber = b;
    }
    
    @Parameterized.Parameters
    public static Collection cargarDatos() {

        return Arrays.asList(
                new Object[][]{
                    {10, 250},
                    {20, 250+500},//acumulado+nuevo
                    {30, 750+750},
                    {45, 1500+1125},
                    {60, 2750+1500},
                    {90, 4250+2250},
                    {120, 6500+3000},
                    {140, 9500+3500},
                    {170, 13000+4250},
                    {200, 17250+5000}
                }
        );
    }
    
    @Test
    public void probarTarifas() {
        
        caja.calcularTarifa(inPutNumber);
        
        assertEquals(this.outPutNumber,this.caja.getTotalDinero());
        
    }

}


