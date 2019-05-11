/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class DireccionDAO extends AbstractDAO<Direccion, Integer> {

    private final CiudadDAO ciudadDAO;

    public DireccionDAO() {
        PREPARED_INSERT = "INSERT INTO DIRECCION (ID, NOMENCLATURA, BARRIO, ID_CIUDAD) VALUES (?, ?, ?, ?)";
        PREPARED_UPDATE = "UPDATE DIRECCION SET NOMENCLATURA = ?, BARRIO = ?, ID_CIUDAD = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM DIRECCION";

        PREPARED_SELECT = "SELECT ID, NOMENCLATURA, BARRIO, ID_CIUDAD FROM DIRECCION";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY BARRIO, NOMENCLATURA";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM DIRECCION";

        ciudadDAO = new CiudadDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Direccion dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getNomenclatura());
            pstmt.setString(3, dto.getBarrio());
            pstmt.setInt(4, dto.getCiudad().getId());
        } else {
            pstmt.setString(1, dto.getNomenclatura());
            pstmt.setString(2, dto.getBarrio());
            pstmt.setInt(3, dto.getCiudad().getId());
            pstmt.setInt(4, dto.getId());
        }
    }

    @Override
    protected Direccion crearEntidad(ResultSet rset) throws Exception {
        Direccion respuesta = new Direccion();
        respuesta.setId(rset.getInt(1));
        respuesta.setNomenclatura(rset.getString(2));
        respuesta.setBarrio(rset.getString(3));
        respuesta.setCiudad(ciudadDAO.buscarPorID(rset.getInt(4)));
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
    protected String obtenerCondiciones(Direccion filtro) {
        StringBuilder query = new StringBuilder();
        if (filtro != null) {
            boolean isWhere = true;
            if (filtro.getId() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID = ").append(filtro.getId());
                isWhere = false;
            }
            if (filtro.getNomenclatura() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" NOMENCLATURA = '").append(filtro.getNomenclatura()).append("'");
                isWhere = false;
            }
            if (filtro.getBarrio() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" BARRIO = '").append(filtro.getBarrio()).append("'");
                isWhere = false;
            }
            if (filtro.getCiudad() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_CIUDAD = ").append(filtro.getCiudad().getId());
            }
        }
        return query.toString();
    }
}
