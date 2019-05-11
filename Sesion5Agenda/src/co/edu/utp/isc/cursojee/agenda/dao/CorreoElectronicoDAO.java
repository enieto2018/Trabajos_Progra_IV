/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.CorreoElectronico;
import co.edu.utp.isc.cursojee.agenda.modelo.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class CorreoElectronicoDAO extends AbstractDAO<CorreoElectronico, Integer> {

    public CorreoElectronicoDAO() {
        PREPARED_INSERT = "INSERT INTO CORREO_ELECTRONICO (ID, DIRECCION, TIPO) VALUES (?, ?, ?)";
        PREPARED_UPDATE = "UPDATE CORREO_ELECTRONICO SET DIRECCION = ?, TIPO = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM CORREO_ELECTRONICO";

        PREPARED_SELECT = "SELECT ID, DIRECCION, TIPO FROM CORREO_ELECTRONICO";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY TIPO, DIRECCION";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM CORREO_ELECTRONICO";
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, CorreoElectronico dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getDireccion());
            pstmt.setString(3, dto.getTipo().toString());
        } else {
            pstmt.setString(1, dto.getDireccion());
            pstmt.setString(2, dto.getTipo().toString());
            pstmt.setInt(3, dto.getId());
        }
    }

    @Override
    protected CorreoElectronico crearEntidad(ResultSet rset) throws Exception {
        CorreoElectronico respuesta = new CorreoElectronico();
        respuesta.setId(rset.getInt(1));
        respuesta.setDireccion(rset.getString(2));
        respuesta.setTipo(Tipo.valueOf(rset.getString(3)));
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
    protected String obtenerCondiciones(CorreoElectronico filtro) {
        StringBuilder query = new StringBuilder();
        if (filtro != null) {
            boolean isWhere = true;
            if (filtro.getId() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID = ").append(filtro.getId());
                isWhere = false;
            }
            if (filtro.getDireccion() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" DIRECCION = '").append(filtro.getDireccion()).append("'");
                isWhere = false;
            }
            if (filtro.getTipo() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" TIPO = '").append(filtro.getTipo()).append("'");
            }
        }
        return query.toString();
    }

}
