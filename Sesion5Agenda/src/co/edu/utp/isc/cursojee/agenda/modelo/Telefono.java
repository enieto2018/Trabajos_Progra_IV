/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.modelo;

import co.edu.utp.isc.cursojee.agenda.base.ModeloIdInteger;

/**
 *
 * @author DiazOspina
 */
public class Telefono extends ModeloIdInteger {

    private String numero;
    private Tipo tipo;
    private Registro registro;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

}
