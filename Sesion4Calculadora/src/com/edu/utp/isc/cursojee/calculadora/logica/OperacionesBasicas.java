/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.logica;

/**
 *
 * @author DiazOspina
 */
public class OperacionesBasicas {

    /**
     * Realiza la suma de los numeros ingresados
     * @param numero1 Primer sumando
     * @param numero2 Secundo sumando
     * @return
     */
    public static double suma(double numero1, double numero2) {
        return numero1 + numero2;
    }

    /**
     * Realiza la resta de los numeros ingresados
     * @param numero1 minuendo
     * @param numero2 sustraendo
     * @return
     */
    public static double resta(double numero1, double numero2) {
        return numero1 - numero2;
    }

    /**
     * Realiza la multiplicacion de los numeros ingresados
     * @param numero1 multiplicando
     * @param numero2 multiplicador
     * @return
     */
    public static double multiplicacion(double numero1, double numero2) {
        return numero1 * numero2;
    }

    /**
     * Realiza la division de los numeros ingresados
     * @param numero1 dividendo
     * @param numero2 divisor
     * @return
     * @throws IllegalArgumentException
     */
    public static double division(double numero1, double numero2) throws IllegalArgumentException {
        if(numero2 == 0d){
            throw new IllegalArgumentException("Los parametros generan una division por cero");
        }
        return numero1 / numero2;
    }

    /**
     * Calcula el valor inverso del numero ingresados
     * @param numero divisor
     * @return
     * @throws IllegalArgumentException 
     */
    public static double invertido(double numero) throws IllegalArgumentException  {
        if(numero == 0d){
            throw new IllegalArgumentException("El parametro genera una division por cero");
        }
        return 1 / numero;
    }
}
