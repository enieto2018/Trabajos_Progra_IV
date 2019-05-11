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
public class Octal extends NumeroCalculadora {

    private static final String CARACTERES_VALIDOS = "-01234567";

    /**
     *
     */
    public Octal() {
        super(8);
    }

    /**
     *
     * @param valor
     * @throws NumberFormatException
     */
    public Octal(String valor) throws NumberFormatException {
        super(valor, 8);
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
