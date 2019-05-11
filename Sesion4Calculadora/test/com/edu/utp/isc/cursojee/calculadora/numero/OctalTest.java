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
public class OctalTest {
    
    public OctalTest() {
    }
    
    /**
     * Test of validar method, of class Octal.
     */
@Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroNulo() {
        String numero = null;
        Octal instance = new Octal();
        instance.validar(numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroVacio() {
        String numero = "";
        Octal instance = new Octal();
        instance.validar(numero);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidarCaracteresInvalidos() {
        String numero = "A1";
        Octal instance = new Octal();
        instance.validar(numero);
    }
    
    @Test
    public void testValidarNumeroBueno() {
        String numero = "10";
        Octal instance = new Octal();
        instance.validar(numero);
    }    
}
