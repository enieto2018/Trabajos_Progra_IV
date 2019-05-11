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
public class CorreoElectronico extends ModeloIdInteger {

    private String direccion;
    private Tipo tipo;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
