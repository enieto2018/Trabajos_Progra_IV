/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Grupo;
import co.edu.utp.isc.cursojee.agenda.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class GrupoDAO extends AbstractDAO<Grupo, Integer> {

    private final UsuarioDAO usuarioDAO;
    private final DirectorioDAO directorioDAO;
    //TODO Falta el DAO de la tabla intermedia
    private final RegistroDAO registroDAO;

    public GrupoDAO() {
        PREPARED_INSERT = "INSERT INTO GRUPO (ID, NOMBRE, ID_DIRECTORIO) VALUES (?, ?)";
        PREPARED_UPDATE = "UPDATE GRUPO SET NOMBRE = ?, ID_DIRECTORIO = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM GRUPO";

        PREPARED_SELECT = "SELECT ID, NOMBRE, ID_DIRECTORIO FROM GRUPO";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY NOMBRE";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM GRUPO";

        usuarioDAO = new UsuarioDAO();
        directorioDAO = new DirectorioDAO();
        //TODO Falta el DAO de la tabla intermedia
        registroDAO = new RegistroDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Grupo dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getNombre());
            pstmt.setString(3, dto.getDirectorio().getId().getId());
        } else {
            pstmt.setString(1, dto.getNombre());
            pstmt.setString(2, dto.getDirectorio().getId().getId());
            pstmt.setInt(3, dto.getId());
        }
    }

    @Override
    protected Grupo crearEntidad(ResultSet rset) throws Exception {
        Grupo respuesta = new Grupo();
        respuesta.setId(rset.getInt(1));
        respuesta.setNombre(rset.getString(2));

        Usuario id = usuarioDAO.buscarPorID(rset.getString(3));
        respuesta.setDirectorio(directorioDAO.buscarPorID(id));

        respuesta = cargarRegistros(respuesta);
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
    protected String obtenerCondiciones(Grupo filtro) {
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
            if (filtro.getDirectorio() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_DIRECTORIO = '").append(filtro.getDirectorio().getId().getId()).append("'");
            }
        }
        return query.toString();
    }

    private Grupo cargarRegistros(Grupo dto) throws Exception {
        if (dto.getRegistros() == null) {
            //TODO Falta la consulta en la tabla intermedia
//            Registro ddto = new Registro();
//            ddto.set(dto);
//            dto.setDepartamentos(departamentoDAO.listar(ddto));
        }

        return dto;
    }

}
