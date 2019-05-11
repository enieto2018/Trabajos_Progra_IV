/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Departamento;
import co.edu.utp.isc.cursojee.agenda.modelo.Pais;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class PaisDAO extends AbstractDAO<Pais, Integer> {

//    private final DepartamentoDAO departamentoDAO;

    public PaisDAO() {
        PREPARED_INSERT = "INSERT INTO PAIS (ID, NOMBRE) VALUES (?, ?)";
        PREPARED_UPDATE = "UPDATE PAIS SET NOMBRE = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM PAIS";

        PREPARED_SELECT = "SELECT ID, NOMBRE FROM PAIS";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY NOMBRE";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM PAIS";

//        departamentoDAO = new DepartamentoDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Pais dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getNombre());
        } else {
            pstmt.setString(1, dto.getNombre());
            pstmt.setInt(2, dto.getId());
        }
    }

    @Override
    protected Pais crearEntidad(ResultSet rset) throws Exception {
        Pais respuesta = new Pais();
        respuesta.setId(rset.getInt(1));
        respuesta.setNombre(rset.getString(2));
        respuesta = cargarDepartamentos(respuesta);
        return respuesta;
    }

    @Override
    protected Integer generarId() throws Exception {
        Integer respuesta;
        
        try (PreparedStatement pstmt = getConnection().prepareStatement(PREPARED_GENERAR); 
                ResultSet rset = pstmt.executeQuery()) {
            respuesta = 1;
            if (rset.next()) {
                respuesta += rset.getInt(1);
            }
        }
        return respuesta;
    }

    @Override
    protected String obtenerCondiciones(Pais filtro) {
        StringBuilder query = new StringBuilder();
        if (filtro != null) {
            boolean isWhere = true;
            if (filtro.getId() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID = ").append(filtro.getId());
                isWhere = false;
            }
            if (filtro.getNombre() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" NOMBRE LIKE '%").append(filtro.getNombre()).append("%'");
            }
        }
        return query.toString();
    }

    private Pais cargarDepartamentos(Pais dto) throws Exception {
        if (dto.getDepartamentos() == null) {
            Departamento ddto = new Departamento();
            ddto.setPais(dto);
//            dto.setDepartamentos(departamentoDAO.listar(ddto));
        }

        return dto;
    }

}
