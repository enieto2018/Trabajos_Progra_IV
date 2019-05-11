/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora;

import com.edu.utp.isc.cursojee.calculadora.logica.BaseNumerica;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author DiazOspina
 */
public class CalculadoraTest {

    private Calculadora calculadora;

    public CalculadoraTest() {
    }

    @Before
    public void setup() {
        calculadora = new Calculadora();
    }

    //--------------------------------------------------------------------------
    // Sumas
    //--------------------------------------------------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testSumaSinBaseDevuelveError() {
        BaseNumerica base = null;
        String numero1 = "10";
        String numero2 = "20";
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaPrimerParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = "1101";
        calculadora.suma(base, numero1, numero2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testSumaSegundoParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = null;
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaPrimerParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "1101";
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaSegundoParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "";
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaPrimerParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "AFJ";
        String numero2 = "1101";
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaSegundoParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "1101";
        String numero2 = "AFJ";
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaParametrosNulosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = null;
        calculadora.suma(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSumaParametrosVaciosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "";
        calculadora.suma(base, numero1, numero2);
    }

    @Test
    public void testSumaBinaria_5_y_13_es_18() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "1101";
        String respuesta = "10010";

        String result = calculadora.suma(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    @Test
    public void testSumaOctal_5_y_13_es_18() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero1 = "5";
        String numero2 = "15";
        String respuesta = "22";

        String result = calculadora.suma(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    @Test
    public void testSumaDecimal_5_y_13_es_18() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero1 = "5";
        String numero2 = "13";
        String respuesta = "18";

        String result = calculadora.suma(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    @Test
    public void testSumaHexadecimal_5_y_13_es_18() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero1 = "5";
        String numero2 = "D";
        String respuesta = "12";

        String result = calculadora.suma(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    //--------------------------------------------------------------------------
    // Restas
    //--------------------------------------------------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testRestaSinBaseDevuelveError() {
        BaseNumerica base = null;
        String numero1 = "10";
        String numero2 = "20";
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaPrimerParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = "1101";
        calculadora.resta(base, numero1, numero2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRestaPrimerParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "1101";
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaSegundoParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = null;
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaSegundoParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "";
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaParametrosNulosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = null;
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaParametrosVaciosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "";
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaPrimerParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "AFJ";
        String numero2 = "1101";
        calculadora.resta(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRestaSegundoParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "1101";
        String numero2 = "AFJ";
        calculadora.resta(base, numero1, numero2);
    }

    @Test
    public void testRestaBinaria_18_y_13_es_5() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "10010";
        String numero2 = "1101";
        String respuesta = "101";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaBinaria_5_y_13_es_menos_8() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "1101";
        String respuesta = "-1000";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaOctal_18_y_13_es_5() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero1 = "22";
        String numero2 = "15";
        String respuesta = "5";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaOctal_5_y_13_es_menos_8() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero1 = "5";
        String numero2 = "15";
        String respuesta = "-10";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaDecimal_18_y_13_es_5() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero1 = "18";
        String numero2 = "13";
        String respuesta = "5";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaDecimal_5_y_13_es_menos_8() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero1 = "5";
        String numero2 = "13";
        String respuesta = "-8";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaHexadecimal_18_y_13_es_5() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero1 = "12";
        String numero2 = "D";
        String respuesta = "5";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testRestaHexadecimal_5_y_13_es_menos_8() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero1 = "5";
        String numero2 = "D";
        String respuesta = "-8";

        String result = calculadora.resta(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    //--------------------------------------------------------------------------
    // Multiplicacion
    //--------------------------------------------------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionSinBaseDevuelveError() {
        BaseNumerica base = null;
        String numero1 = "10";
        String numero2 = "20";
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionPrimerParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = "1101";
        calculadora.multiplicacion(base, numero1, numero2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionPrimerParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "1101";
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionSegundoParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = null;
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionSegundoParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "";
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionParametrosNulosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = null;
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionParametrosVaciosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "";
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionPrimerParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "AFJ";
        String numero2 = "1101";
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplicacionSegundoParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "1101";
        String numero2 = "AFJ";
        calculadora.multiplicacion(base, numero1, numero2);
    }

    @Test
    public void testMultiplicacionBinaria_5_y_13_es_65() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "1101";
        String respuesta = "1000001";

        String result = calculadora.multiplicacion(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    @Test
    public void testMultiplicacionOctal_5_y_13_es_65() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero1 = "5";
        String numero2 = "15";
        String respuesta = "101";

        String result = calculadora.multiplicacion(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    @Test
    public void testMultiplicacionDecimal_5_y_13_es_18() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero1 = "5";
        String numero2 = "13";
        String respuesta = "65";

        String result = calculadora.multiplicacion(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    @Test
    public void testMultiplicacionHexadecimal_5_y_13_es_18() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero1 = "5";
        String numero2 = "D";
        String respuesta = "41";

        String result = calculadora.multiplicacion(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }
    
    //--------------------------------------------------------------------------
    // Division
    //--------------------------------------------------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionSinBaseDevuelveError() {
        BaseNumerica base = null;
        String numero1 = "10";
        String numero2 = "20";
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionPrimerParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = "1101";
        calculadora.division(base, numero1, numero2);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testDivisionPrimerParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "1101";
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionSegundoParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = null;
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionSegundoParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "";
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionParametrosNulosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = null;
        String numero2 = null;
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionParametrosVaciosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "";
        String numero2 = "";
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionSegundoParametroCeroDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "0";
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionPrimerParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "AFJ";
        String numero2 = "1101";
        calculadora.division(base, numero1, numero2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisionSegundoParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "1101";
        String numero2 = "AFJ";
        calculadora.division(base, numero1, numero2);
    }

    @Test
    public void testDivisionBinaria_18_y_13_es_1() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "10010";
        String numero2 = "1101";
        String respuesta = "1";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionBinaria_5_y_13_es_0() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero1 = "101";
        String numero2 = "1101";
        String respuesta = "0";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionOctal_18_y_13_es_1() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero1 = "22";
        String numero2 = "15";
        String respuesta = "1";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionOctal_5_y_13_es_0() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero1 = "5";
        String numero2 = "15";
        String respuesta = "0";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionDecimal_18_y_13_es_1_385() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero1 = "18";
        String numero2 = "13";
        String respuesta = "1,385";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionDecimal_5_y_13_es_0_385() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero1 = "5";
        String numero2 = "13";
        String respuesta = "0,385";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionHexadecimal_18_y_13_es_1() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero1 = "12";
        String numero2 = "D";
        String respuesta = "1";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testDivisionHexadecimal_5_y_13_es_0() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero1 = "5";
        String numero2 = "D";
        String respuesta = "0";

        String result = calculadora.division(base, numero1, numero2);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    //--------------------------------------------------------------------------
    // Invertido
    //--------------------------------------------------------------------------
    @Test(expected = IllegalArgumentException.class)
    public void testInvertidoSinBaseDevuelveError() {
        BaseNumerica base = null;
        String numero = "10";
        calculadora.invertido(base, numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvertidoParametroNuloDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = null;
        calculadora.invertido(base, numero);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvertidoParametroVacioDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "";
        calculadora.invertido(base, numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvertidoParametroCeroDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "0";
        calculadora.invertido(base, numero);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvertidoParametroCaracteresInvalidosDevuelveError() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "AFJ";
        calculadora.invertido(base, numero);
    }

    @Test
    public void testInvertidoBinario_18_es_0() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "10010";
        String respuesta = "0";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoBinario_1_es_1() {
        BaseNumerica base = BaseNumerica.BINARIO;
        String numero = "1";
        String respuesta = "1";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoOctal_18_es_0() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero = "22";
        String respuesta = "0";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoOctal_1_es_1() {
        BaseNumerica base = BaseNumerica.OCTAL;
        String numero = "1";
        String respuesta = "1";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoDecimal_18_es_0_056() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero = "18";
        String respuesta = "0,056";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoDecimal_1_es_1() {
        BaseNumerica base = BaseNumerica.DECIMAL;
        String numero = "1";
        String respuesta = "1";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoHexadecimal_18_es_0() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero = "12";
        String respuesta = "0";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }

    @Test
    public void testInvertidoHexadecimal_1_es_1() {
        BaseNumerica base = BaseNumerica.HEXADECIMAL;
        String numero = "1";
        String respuesta = "1";

        String result = calculadora.invertido(base, numero);
        assertNotNull(result);
        assertEquals(respuesta, result);
    }


}
