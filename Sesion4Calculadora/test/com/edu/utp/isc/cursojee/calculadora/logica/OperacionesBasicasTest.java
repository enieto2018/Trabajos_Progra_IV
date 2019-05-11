/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.logica;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author DiazOspina
 */
public class OperacionesBasicasTest {
    
    public OperacionesBasicasTest() {
    }

    /**
     * Test of suma method, of class OperacionesBasicas.
     */
    @Test
    public void testSuma() {
        System.out.println("suma");
        double numero1 = 1.0;
        double numero2 = 2.0;
        double expResult = 3.0;
        double result = OperacionesBasicas.suma(numero1, numero2);
        assertEquals(expResult, result, 0.0001);
    }

    /**
     * Test of resta method, of class OperacionesBasicas.
     */
    @Test
    public void testResta() {
        System.out.println("resta");
        double numero1 = 0.0;
        double numero2 = 0.0;
        double expResult = 0.0;
        double result = OperacionesBasicas.resta(numero1, numero2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of multiplicacion method, of class OperacionesBasicas.
     */
    @Test
    public void testMultiplicacion() {
        System.out.println("multiplicacion");
        double numero1 = 0.0;
        double numero2 = 0.0;
        double expResult = 0.0;
        double result = OperacionesBasicas.multiplicacion(numero1, numero2);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of division method, of class OperacionesBasicas.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDivision() {
        System.out.println("division");
        double numero1 = 0.0;
        double numero2 = 0.0;
        double expResult = 0.0;
        double result = OperacionesBasicas.division(numero1, numero2);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of invertido method, of class OperacionesBasicas.
     */
    @Test
    public void testInvertido() {
        System.out.println("invertido");
        double numero = 0.0;
        double expResult = 0.0;
        double result = OperacionesBasicas.invertido(numero);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
