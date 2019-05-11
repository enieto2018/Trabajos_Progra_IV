/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.logica;

import com.edu.utp.isc.cursojee.calculadora.numero.NumeroCalculadora;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DiazOspina
 */
public class ConvertidorDeNumeroTest {

    public ConvertidorDeNumeroTest() {
    }

    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test of convertir method, of class ConvertidorDeNumero.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_BaseNumerica_Null() {
        BaseNumerica base = null;
        String numero = "";
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Binario_String_Null() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = null;
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Binario_String_Vacio() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "";
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Binario_String_Caracteres_Invalidos() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "21";
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test
    public void testConvertir_Binario_String_11101_es_29() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "11101";
        long expResult = 29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test
    public void testConvertir_Binario_String_menos_11101_es_menos_29() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "-11101";
        long expResult = -29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Octal_String_Caracteres_Invalidos() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero = "81";
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test
    public void testConvertir_Octal_String_35_es_29() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero = "35";
        long expResult = 29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test
    public void testConvertir_Octal_String_menos_35_es_menos_29() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero = "-35";
        long expResult = -29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Decimal_String_Caracteres_Invalidos() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero = "A1";
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test
    public void testConvertir_Decimal_String_29_es_29() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero = "29";
        long expResult = 29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test
    public void testConvertir_Decimal_String_menos_29_es_menos_29() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero = "-29";
        long expResult = -29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Hexadecimal_String_Caracteres_Invalidos() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero = "G1";
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test
    public void testConvertir_Hexadecimal_String_1D_es_29() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero = "1D";
        long expResult = 29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    @Test
    public void testConvertir_Binario_String_menos_1D_es_menos_29() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero = "-1D";
        long expResult = -29L;
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.aNumber().longValue());
    }

    /**
     * Test of convertir method, of class ConvertidorDeNumero.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConvertir_Binario_Number_Null() {
        BaseNumerica base = BaseNumerica.BINARIO;
        Number numero = null;
        ConvertidorDeNumero.convertir(base, numero);
    }

    @Test
    public void testConvertir_Binario_Number_29_es_11101() {
        BaseNumerica base = BaseNumerica.BINARIO;
        Number numero = 29L;
        String expResult = "11101";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Binario_Number_menos_29_es_menos_11101() {
        BaseNumerica base = BaseNumerica.BINARIO;
        Number numero = -29L;
        String expResult = "-11101";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Octal_Number_29_es_35() {
        BaseNumerica base = BaseNumerica.OCTAL;
        Number numero = 29L;
        String expResult = "35";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Octal_menos_29_es_menos_35() {
        BaseNumerica base = BaseNumerica.OCTAL;
        Number numero = -29L;
        String expResult = "-35";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Decimal_Number_29_es_29() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        Number numero = 29L;
        String expResult = "29";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Decimal_Number_menos_29_es_menos_29() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        Number numero = -29L;
        String expResult = "-29";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Hexadecimal_Number_29_es_1D() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        Number numero = 29L;
        String expResult = "1D";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testConvertir_Hexadecimal_Number_menos_29_es_menos_1D() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        Number numero = -29L;
        String expResult = "-1D";
        NumeroCalculadora result = ConvertidorDeNumero.convertir(base, numero);
        assertNotNull(result);
        assertEquals(expResult, result.toString());
    }

}
