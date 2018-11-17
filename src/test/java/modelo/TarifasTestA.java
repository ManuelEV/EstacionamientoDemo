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
public class TarifasTestA {
    
    private final Caja caja;
    private final int inPutNumber;
    private final int outPutNumber;

    public TarifasTestA(int a, int b) {
        this.caja = new Caja(25);
        this.inPutNumber = a;
        this.outPutNumber = b;
    }
    
    @Parameterized.Parameters
    public static Collection cargarDatos() {
        return Arrays.asList(
                new Object[][]{
                    {10, 250},
                    {20, 500},
                    {30, 750},
                    {45, 1225},//esta prueba arroja "failure" pero el resultado es correcto(??)
                    {60, 1500},
                    {90, 2250},
                    {120, 3000},
                    {140, 3500},//extra para alcanzar las 10 pruebas
                    {170, 4250},//extra para alcanzar las 10 pruebas
                    {200, 5000}//extra para alcanzar las 10 pruebas
                }
        );
    }
    
    @Test
    public void probarTarifas() {
        caja.calcularTarifa(inPutNumber);
        assertEquals(this.outPutNumber,this.caja.getTotalDinero());
    }
    
    
}
