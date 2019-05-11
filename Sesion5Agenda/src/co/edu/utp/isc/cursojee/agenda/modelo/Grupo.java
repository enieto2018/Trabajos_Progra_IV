/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.modelo;

import co.edu.utp.isc.cursojee.agenda.base.ModeloIdInteger;
import java.util.List;

/**
 *
 * @author DiazOspina
 */
public class Grupo extends ModeloIdInteger {

    private String nombre;
    private Directorio directorio;
    private List<Registro> registros;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Directorio getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Directorio directorio) {
        this.directorio = directorio;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

}
