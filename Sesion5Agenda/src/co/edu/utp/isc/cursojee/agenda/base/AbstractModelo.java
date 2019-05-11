/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.base;

import java.io.Serializable;

/**
 *
 * @author DiazOspina
 * @param <ID>
 */
public interface AbstractModelo<ID> extends Serializable {

    public ID getId();

    public void setId(ID id);

}
