/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.negocio;

import co.edu.utp.isc.cursojee.agenda.dao.UsuarioDAO;

/**
 *
 * @author DiazOspina
 */
public class SeguridadBean {
    
    private final UsuarioDAO usuarioDAO;

    public SeguridadBean() {
        usuarioDAO = new UsuarioDAO();
    }

}
