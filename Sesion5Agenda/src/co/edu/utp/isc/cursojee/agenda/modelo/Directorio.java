/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.modelo;

import co.edu.utp.isc.cursojee.agenda.base.AbstractModelo;
import java.util.List;

/**
 *
 * @author DiazOspina
 */
public class Directorio implements AbstractModelo<Usuario> {

    private String nombre;
    private Usuario usuario;
    private List<Registro> registros;
    private List<Grupo> grupos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    @Override
    public void setId(Usuario id) {
        setUsuario(usuario);
    }

    @Override
    public Usuario getId() {
        return usuario;
    }
}
