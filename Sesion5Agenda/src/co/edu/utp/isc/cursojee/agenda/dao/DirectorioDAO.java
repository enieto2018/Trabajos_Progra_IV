/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Directorio;
import co.edu.utp.isc.cursojee.agenda.modelo.Grupo;
import co.edu.utp.isc.cursojee.agenda.modelo.Registro;
import co.edu.utp.isc.cursojee.agenda.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class DirectorioDAO extends AbstractDAO<Directorio, Usuario> {

    private final UsuarioDAO usuarioDAO;
    private final RegistroDAO registroDAO;
    private final GrupoDAO grupoDAO;

    public DirectorioDAO() {
        PREPARED_INSERT = "INSERT INTO DIRECTORIO (ID, NOMBRE) VALUES (?, ?)";
        PREPARED_UPDATE = "UPDATE DIRECTORIO SET NOMBRE = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM DIRECTORIO";

        PREPARED_SELECT = "SELECT ID, NOMBRE FROM DIRECTORIO";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY BARRIO, NOMENCLATURA";

        usuarioDAO = new UsuarioDAO();
        registroDAO = new RegistroDAO();
        grupoDAO = new GrupoDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Usuario id) throws Exception {
        pstmt.setString(1, id.getId());
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Directorio dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setString(1, dto.getId().getId());
            pstmt.setString(2, dto.getNombre());
        } else {
            pstmt.setString(1, dto.getNombre());
            pstmt.setString(2, dto.getId().getId());
        }
    }

    @Override
    protected Directorio crearEntidad(ResultSet rset) throws Exception {
        Directorio respuesta = new Directorio();
        respuesta.setId(usuarioDAO.buscarPorID(rset.getString(1)));
        respuesta.setNombre(rset.getString(2));
        respuesta = cargarRegistros(respuesta);
        respuesta = cargarGrupos(respuesta);

        return respuesta;
    }

    @Override
    protected Usuario generarId() throws Exception {
        return null;
    }

    @Override
    protected String obtenerCondiciones(Directorio filtro) {
        StringBuilder query = new StringBuilder();
        if (filtro != null) {
            boolean isWhere = true;
            if (filtro.getId() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append("ID = '").append(filtro.getId().getId()).append("'");
                isWhere = false;
            }
            if (filtro.getNombre() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" NOMBRE = '").append(filtro.getNombre()).append("'");
            }
        }
        return query.toString();
    }

    private Directorio cargarRegistros(Directorio dto) throws Exception {
        if (dto.getRegistros() == null) {
            Registro ddto = new Registro();
            ddto.setDirectorio(dto);
            dto.setRegistros(registroDAO.listar(ddto));
        }

        return dto;
    }

    private Directorio cargarGrupos(Directorio dto) throws Exception {
        if (dto.getGrupos() == null) {
            Grupo ddto = new Grupo();
            ddto.setDirectorio(dto);
            dto.setGrupos(grupoDAO.listar(ddto));
        }

        return dto;
    }

}
