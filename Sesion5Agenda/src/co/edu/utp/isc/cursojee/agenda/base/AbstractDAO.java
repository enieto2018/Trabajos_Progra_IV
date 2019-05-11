/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.base;

import co.edu.utp.isc.cursojee.agenda.db.UtilidadBaseDatos;
import co.edu.utp.isc.cursojee.agenda.modelo.Hoja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DiazOspina
 * @param <ENTITY>
 * @param <ID>
 */
public abstract class AbstractDAO<ENTITY extends AbstractModelo<ID>, ID> {

    protected String PREPARED_INSERT;
    protected String PREPARED_UPDATE;
    protected String PREPARED_DELETE;

    protected String PREPARED_SELECT;
    protected String PREPARED_WHEREID;
    protected String PREPARED_ORDERBY;

    protected String PREPARED_GENERAR;

    private Connection conn;

    protected Connection getConnection() throws Exception {
        if (conn == null) {
            conn = UtilidadBaseDatos.obtenerConexion();
        }
        return conn;
    }

    public ENTITY guardar(ENTITY dto) throws Exception {
        PreparedStatement pstmt;
        if (dto.getId() == null) {
            pstmt = getConnection().prepareStatement(PREPARED_INSERT);
            dto.setId(generarId());

            agregarEntidadASentencia(pstmt, dto, true);
        } else {
            pstmt = getConnection().prepareStatement(PREPARED_UPDATE);

            agregarEntidadASentencia(pstmt, dto, false);
        }
        pstmt.executeUpdate();
        pstmt.close();

        return dto;
    }

    public int eliminar(ID id) throws Exception {
        int respuesta;
        try (PreparedStatement pstmt = getConnection().prepareStatement(PREPARED_DELETE 
                + PREPARED_WHEREID)) {
            agregarIdASentencia(pstmt, id);

            respuesta = pstmt.executeUpdate();
        }
        return respuesta;
    }

    public ENTITY buscar(ENTITY filtro) throws Exception {
        ENTITY respuesta = null;
        String query = PREPARED_SELECT
                + obtenerCondiciones(filtro)
                + PREPARED_ORDERBY;

        try (Statement pstmt = getConnection().createStatement();
                ResultSet rset = pstmt.executeQuery(query)) {
            if (rset.next()) {
                respuesta = crearEntidad(rset);
            }
        }
        return respuesta;
    }

    public ENTITY buscarPorID(ID id) throws Exception {
        ENTITY respuesta = null;
        String sentencia = PREPARED_SELECT
                + PREPARED_WHEREID
                + PREPARED_ORDERBY;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sentencia)) {
            agregarIdASentencia(pstmt, id);

            try (ResultSet rset = pstmt.executeQuery()) {
                if (rset.next()) {
                    respuesta = crearEntidad(rset);
                }
            }
        }
        return respuesta;
    }

    public List<ENTITY> listarTodo() throws Exception {
        List<ENTITY> respuesta;
        String sentencia = PREPARED_SELECT
                + PREPARED_ORDERBY;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sentencia);
                ResultSet rset = pstmt.executeQuery()) {
            respuesta = new ArrayList<>();
            while (rset.next()) {
                ENTITY entidad = crearEntidad(rset);
                respuesta.add(entidad);
            }
        }
        return respuesta;
    }

    public List<ENTITY> listar(ENTITY filtro) throws Exception {
        List<ENTITY> respuesta;
        String sentencia = PREPARED_SELECT
                + obtenerCondiciones(filtro)
                + PREPARED_ORDERBY;
        try (PreparedStatement pstmt = getConnection().prepareStatement(sentencia);
                ResultSet rset = pstmt.executeQuery()) {
            respuesta = new ArrayList<>();
            while (rset.next()) {
                ENTITY entidad = crearEntidad(rset);
                respuesta.add(entidad);
            }
        }
        return respuesta;
    }

    protected abstract void agregarIdASentencia(PreparedStatement pstmt, ID id) throws Exception;

    protected abstract void agregarEntidadASentencia(PreparedStatement pstmt, ENTITY dto, boolean isInsert) throws Exception;

    protected abstract ENTITY crearEntidad(ResultSet rset) throws Exception;

    protected abstract ID generarId() throws Exception;

    protected abstract String obtenerCondiciones(ENTITY filtro);

}
