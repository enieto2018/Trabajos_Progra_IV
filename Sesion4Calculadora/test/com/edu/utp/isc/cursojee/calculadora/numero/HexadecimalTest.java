/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.numero;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DiazOspina
 */
public class HexadecimalTest {

    public HexadecimalTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of validar method, of class Hexadecimal.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroNulo() {
        String numero = null;
        Hexadecimal instance = new Hexadecimal();
        instance.validar(numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarNumeroVacio() {
        String numero = "";
        Hexadecimal instance = new Hexadecimal();
        instance.validar(numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidarCaracteresInvalidos() {
        String numero = "GA1";
        Hexadecimal instance = new Hexadecimal();
        instance.validar(numero);
    }

    @Test
    public void testValidarNumeroBueno() {
        String numero = "10";
        Hexadecimal instance = new Hexadecimal();
        instance.validar(numero);
    }

}
