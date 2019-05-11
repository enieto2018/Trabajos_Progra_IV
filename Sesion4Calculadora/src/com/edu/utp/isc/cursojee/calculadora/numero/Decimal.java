/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.numero;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;

/**
 *
 * @author DiazOspina
 */
public class Decimal extends NumeroCalculadora {

    private NumberFormat formato;

    /**
     *
     */
    public Decimal() {
        super(10);
    }

    /**
     *
     * @param valor
     * @throws NumberFormatException
     */
    public Decimal(String valor) throws NumberFormatException {
        super(valor, 10);
    }
    
    private NumberFormat getFormato(){
        if(formato == null){
            formato = new DecimalFormat("###0.###");
        }
        return formato;
    }

    /**
     *
     * @param numero
     * @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    @Override
    public void validar(String numero) throws NumberFormatException, IllegalArgumentException {
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        try {
            getFormato().parse(numero);
        } catch (ParseException ex) {
            throw new NumberFormatException("El numero no tiene un formato válido");
        }
    }

    /**
     *
     * @param numero
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public NumeroCalculadora deNumber(Number numero) throws IllegalArgumentException {
        if (numero == null) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        setValor(getFormato().format(numero.doubleValue()));
        return this;
    }

    /**
     *
     * @return @throws NumberFormatException
     * @throws IllegalArgumentException
     */
    @Override
    public Number aNumber() throws NumberFormatException, IllegalArgumentException {
        if (valor == null) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        try {
            return formato.parse(valor);
        } catch (ParseException ex) {
            throw new NumberFormatException("El numero no tiene un formato válido");
        }
    }

}
