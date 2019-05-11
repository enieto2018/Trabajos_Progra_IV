/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import com.edu.utp.isc.cursojee.calculadora.Calculadora;
import com.edu.utp.isc.cursojee.calculadora.logica.BaseNumerica;

/**
 *
 * @author DiazOspina
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        imprimirOperaciones(BaseNumerica.BINARIO, "100101", "101");
        imprimirOperaciones(BaseNumerica.OCTAL, "100101", "101");
        imprimirOperaciones(BaseNumerica.DECIMAL, "100101", "101");
        imprimirOperaciones(BaseNumerica.HEXADECIMAL, "100101", "101");
    }

    public static void imprimirOperaciones(BaseNumerica base, String numero1, String numero2) {
        Calculadora calculadora = new Calculadora();
        System.out.printf("%s: %s + %s = %s\n", base, numero1, numero2,
                calculadora.suma(base, numero1, numero2));

        System.out.printf("%s: %s - %s = %s\n", base, numero1, numero2,
                calculadora.resta(base, numero1, numero2));

        System.out.printf("%s: %s x %s = %s\n", base, numero1, numero2,
                calculadora.multiplicacion(base, numero1, numero2));

        System.out.printf("%s: %s / %s = %s\n", base, numero1, numero2,
                calculadora.division(base, numero1, numero2));

        System.out.printf("%s: 1 / %s = %s\n", base, numero1,
                calculadora.invertido(base, numero1));

        System.out.printf("%s: 1 / %s = %s\n", base, numero2,
                calculadora.invertido(base, numero2));
    }

}
