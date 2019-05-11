/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.negocio;

import co.edu.utp.isc.cursojee.agenda.dao.CiudadDAO;
import co.edu.utp.isc.cursojee.agenda.dao.DepartamentoDAO;
import co.edu.utp.isc.cursojee.agenda.dao.PaisDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Pais;
import java.util.List;

/**
 *
 * @author DiazOspina
 */
public class ConfiguracionBean {
    private final PaisDAO paisDAO;
    private final DepartamentoDAO departamentoDAO;
    private final CiudadDAO ciudadDAO;

    public ConfiguracionBean() {
        paisDAO = new PaisDAO();
        departamentoDAO = new DepartamentoDAO();
        ciudadDAO = new CiudadDAO();
    }
    
    public Pais guardarPais(Pais pais) throws Exception{
        return paisDAO.guardar(pais);
    }

    public List<Pais> listaPaises() throws Exception {
        return paisDAO.listarTodo();
    }

    public void eliminarPais(Pais pais) throws Exception {
        paisDAO.eliminar(pais.getId());
    }

}
