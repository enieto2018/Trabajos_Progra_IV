/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora;

import com.edu.utp.isc.cursojee.calculadora.logica.BaseNumerica;
import com.edu.utp.isc.cursojee.calculadora.logica.ConvertidorDeNumero;
import com.edu.utp.isc.cursojee.calculadora.logica.OperacionesBasicas;
import com.edu.utp.isc.cursojee.calculadora.numero.NumeroCalculadora;

/**
 *
 * @author DiazOspina
 */
public class Calculadora {

    /**
     *
     * @param base
     * @param numero1
     * @param numero2
     * @return
     */
    public String suma(BaseNumerica base, String numero1, String numero2) throws IllegalArgumentException {
        NumeroCalculadora num1 = ConvertidorDeNumero.convertir(base, numero1);
        NumeroCalculadora num2 = ConvertidorDeNumero.convertir(base, numero2);
        return ConvertidorDeNumero.convertir(base, 
                OperacionesBasicas.suma(num1.doubleValue(), num2.doubleValue())).toString();
    }

    /**
     *
     * @param base
     * @param numero1
     * @param numero2
     * @return
     */
    public String resta(BaseNumerica base, String numero1, String numero2) throws IllegalArgumentException {
        NumeroCalculadora num1 = ConvertidorDeNumero.convertir(base, numero1);
        NumeroCalculadora num2 = ConvertidorDeNumero.convertir(base, numero2);
        return ConvertidorDeNumero.convertir(base, 
                OperacionesBasicas.resta(num1.doubleValue(), num2.doubleValue())).toString();
    }

    /**
     *
     * @param base
     * @param numero1
     * @param numero2
     * @return
     */
    public String multiplicacion(BaseNumerica base, String numero1, String numero2) throws IllegalArgumentException {
        NumeroCalculadora num1 = ConvertidorDeNumero.convertir(base, numero1);
        NumeroCalculadora num2 = ConvertidorDeNumero.convertir(base, numero2);
        return ConvertidorDeNumero.convertir(base, 
                OperacionesBasicas.multiplicacion(num1.doubleValue(), num2.doubleValue())).toString();
    }

    /**
     *
     * @param base
     * @param numero1
     * @param numero2
     * @return
     */
    public String division(BaseNumerica base, String numero1, String numero2) throws IllegalArgumentException {
        NumeroCalculadora num1 = ConvertidorDeNumero.convertir(base, numero1);
        NumeroCalculadora num2 = ConvertidorDeNumero.convertir(base, numero2);
        return ConvertidorDeNumero.convertir(base, 
                OperacionesBasicas.division(num1.doubleValue(), num2.doubleValue())).toString();
    }

    /**
     *
     * @param base
     * @param numero
     * @return
     */
    public String invertido(BaseNumerica base, String numero) throws IllegalArgumentException {
        NumeroCalculadora num = ConvertidorDeNumero.convertir(base, numero);
        return ConvertidorDeNumero.convertir(base, 
                OperacionesBasicas.invertido(num.doubleValue())).toString();
    }

}
