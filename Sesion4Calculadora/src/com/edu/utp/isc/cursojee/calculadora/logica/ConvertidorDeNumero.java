package com.edu.utp.isc.cursojee.calculadora.logica;

import com.edu.utp.isc.cursojee.calculadora.numero.Binario;
import com.edu.utp.isc.cursojee.calculadora.numero.Decimal;
import com.edu.utp.isc.cursojee.calculadora.numero.Hexadecimal;
import com.edu.utp.isc.cursojee.calculadora.numero.NumeroCalculadora;
import com.edu.utp.isc.cursojee.calculadora.numero.Octal;

/**
 *
 * @author DiazOspina
 */
public class ConvertidorDeNumero {

    public static NumeroCalculadora convertir(BaseNumerica base, String numero) throws IllegalArgumentException {
        if (base == null) {
            throw new IllegalArgumentException("La base dada no ha sido inicializado");
        }
        if (numero == null || numero.trim().isEmpty()) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        switch (base) {
            case BINARIO:
                return new Binario(numero);
            case OCTAL:
                return new Octal(numero);
            case HEXADECIMAL:
                return new Hexadecimal(numero);
        }
        return new Decimal(numero);
    }

    public static NumeroCalculadora convertir(BaseNumerica base, Number numero) throws IllegalArgumentException {
        if (base == null) {
            throw new IllegalArgumentException("La base dada no ha sido inicializado");
        }
        if (numero == null) {
            throw new IllegalArgumentException("El numero dado no ha sido inicializado");
        }
        switch (base) {
            case BINARIO:
                return new Binario().deNumber(numero);
            case OCTAL:
                return new Octal().deNumber(numero);
            case HEXADECIMAL:
                return new Hexadecimal().deNumber(numero);
        }
        return new Decimal().deNumber(numero);
    }
}
