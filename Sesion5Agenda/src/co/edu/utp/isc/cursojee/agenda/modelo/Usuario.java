/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.modelo;

import co.edu.utp.isc.cursojee.agenda.base.AbstractModelo;

/**
 *
 * @author DiazOspina
 */
public class Usuario extends Persona implements AbstractModelo<String> {

    private String nombreUsuario;
    private String contrasena;
    private Directorio directorio;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Directorio getDirectorio() {
        return directorio;
    }

    public void setDirectorio(Directorio directorio) {
        this.directorio = directorio;
    }

    @Override
    public String getId() {
        return getNombreUsuario();
    }

    @Override
    public void setId(String id) {
        setNombreUsuario(id);
    }
    
    

}
