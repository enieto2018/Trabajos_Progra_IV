/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.utp.isc.cursojee.calculadora.numero;

/**
 *
 * @author DiazOspina
 */
public class Binario extends NumeroCalculadora {

    private static final String CARACTERES_VALIDOS = "-01";

    /**
     *
     */
    public Binario() {
        super(2);
    }

    /**
     *
     * @param numero
     * @throws NumberFormatException
     */
    public Binario(String numero) throws NumberFormatException {
        super(numero, 2);
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
        for (char caracter : numero.toUpperCase().toCharArray()) {
            if (CARACTERES_VALIDOS.indexOf(caracter) == -1) {
                throw new NumberFormatException("El caracter '" + caracter + "' no es un caracter válido");
            }
        }
    }

    

}
