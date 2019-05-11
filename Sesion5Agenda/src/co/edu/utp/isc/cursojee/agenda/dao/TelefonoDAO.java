/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Telefono;
import co.edu.utp.isc.cursojee.agenda.modelo.Tipo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class TelefonoDAO extends AbstractDAO<Telefono, Integer> {

    private final RegistroDAO registroDAO;

    public TelefonoDAO() {
        PREPARED_INSERT = "INSERT INTO TELEFONO (ID, NUMERO, TIPO, ID_REGISTRO) VALUES (?, ?, ?, ?)";
        PREPARED_UPDATE = "UPDATE TELEFONO SET NUMERO = ?, TIPO = ?, ID_REGISTRO = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM TELEFONO";

        PREPARED_SELECT = "SELECT ID, NUMERO, TIPO, ID_REGISTRO FROM TELEFONO";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY ID_REGISTRO, NUMERO";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM TELEFONO";

        registroDAO = new RegistroDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Telefono dto, boolean isInsert) throws Exception {
        pstmt.setInt(isInsert ? 1 : 4, dto.getId());
        pstmt.setString(isInsert ? 2 : 1, dto.getNumero());
        pstmt.setString(isInsert ? 3 : 2, dto.getTipo().toString());
        pstmt.setInt(isInsert ? 4 : 3, dto.getRegistro().getId());
    }

    @Override
    protected Telefono crearEntidad(ResultSet rset) throws Exception {
        Telefono respuesta = new Telefono();
        respuesta.setId(rset.getInt(1));
        respuesta.setNumero(rset.getString(2));
        respuesta.setTipo(Tipo.valueOf(rset.getString(3)));
        respuesta.setRegistro(registroDAO.buscarPorID(rset.getInt(4)));
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
    protected String obtenerCondiciones(Telefono filtro) {
        StringBuilder query = new StringBuilder();
        if (filtro != null) {
            boolean isWhere = true;
            if (filtro.getId() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID = ").append(filtro.getId());
                isWhere = false;
            }
            if (filtro.getNumero() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" NUMERO = '").append(filtro.getNumero()).append("'");
                isWhere = false;
            }
            if (filtro.getTipo() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" TIPO = '").append(filtro.getTipo()).append("'");
                isWhere = false;
            }
            if (filtro.getRegistro() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_REGISTRO = ").append(filtro.getRegistro().getId());
            }
        }
        return query.toString();
    }

}
