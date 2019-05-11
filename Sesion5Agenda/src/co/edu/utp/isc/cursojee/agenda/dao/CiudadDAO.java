/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Ciudad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class CiudadDAO extends AbstractDAO<Ciudad, Integer> {

//    private final DepartamentoDAO departamentoDAO;

    public CiudadDAO() {
        PREPARED_INSERT = "INSERT INTO CIUDAD (ID, NOMBRE, ID_DEPARTAMENTO) VALUES (?, ?, ?)";
        PREPARED_UPDATE = "UPDATE CIUDAD SET NOMBRE = ?, ID_DEPARTAMENTO = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM CIUDAD";

        PREPARED_SELECT = "SELECT ID, NOMBRE, ID_DEPARTAMENTO FROM CIUDAD";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY ID_DEPARTAMENTO, NOMBRE";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM CIUDAD";

//        departamentoDAO = new DepartamentoDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Ciudad dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getNombre());
            pstmt.setInt(3, dto.getDepartamento().getId());
        } else {
            pstmt.setString(1, dto.getNombre());
            pstmt.setInt(2, dto.getDepartamento().getId());
            pstmt.setInt(3, dto.getId());
        }
    }

    @Override
    protected Ciudad crearEntidad(ResultSet rset) throws Exception {
        Ciudad respuesta = new Ciudad();
        respuesta.setId(rset.getInt(1));
        respuesta.setNombre(rset.getString(2));
//        respuesta.setDepartamento(departamentoDAO.buscarPorID(rset.getInt(3)));
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
    protected String obtenerCondiciones(Ciudad filtro) {
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
                        .append(" NOMBRE = '").append(filtro.getNombre()).append("'");
                isWhere = false;
            }
            if (filtro.getDepartamento() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_DEPARTAMENTO = ").append(filtro.getDepartamento().getId());
            }
        }
        return query.toString();
    }

}
