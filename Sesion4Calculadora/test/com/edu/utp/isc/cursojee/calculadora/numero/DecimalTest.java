/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.numero;

import org.junit.Test;

/**
 *
 * @author DiazOspina
 */
public class DecimalTest {
    
    public DecimalTest() {
    }

    /**
     * Test of validar method, of class Decimal.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroNulo() {
        String numero = null;
        Decimal instance = new Decimal();
        instance.validar(numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroVacio() {
        String numero = "";
        Decimal instance = new Decimal();
        instance.validar(numero);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidarCaracteresInvalidos() {
        String numero = "A1";
        Decimal instance = new Decimal();
        instance.validar(numero);
    }
    
    @Test
    public void testValidarNumeroBueno() {
        String numero = "10";
        Decimal instance = new Decimal();
        instance.validar(numero);
    }

    /**
     * Test of deNumber method, of class Decimal.
     */
//    @Test
//    public void testDeNumber() {
//        Number numero = null;
//        Decimal instance = new Decimal();
//        NumeroCalculadora expResult = null;
//        NumeroCalculadora result = instance.deNumber(numero);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of aNumber method, of class Decimal.
     */
//    @Test
//    public void testANumber() {
//        Decimal instance = new Decimal();
//        Number expResult = null;
//        Number result = instance.aNumber();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
