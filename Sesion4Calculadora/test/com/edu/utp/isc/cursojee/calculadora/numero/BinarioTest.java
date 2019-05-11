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
public class BinarioTest {
    
    public BinarioTest() {
    }
    
    /**
     * Test of validar method, of class Binario.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroNulo() {
        String numero = null;
        Binario instance = new Binario();
        instance.validar(numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroVacio() {
        String numero = "";
        Binario instance = new Binario();
        instance.validar(numero);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testValidarCaracteresInvalidos() {
        String numero = "21";
        Binario instance = new Binario();
        instance.validar(numero);
    }
    
    @Test
    public void testValidarNumeroBueno() {
        String numero = "10101";
        Binario instance = new Binario();
        instance.validar(numero);
    }
    
}
