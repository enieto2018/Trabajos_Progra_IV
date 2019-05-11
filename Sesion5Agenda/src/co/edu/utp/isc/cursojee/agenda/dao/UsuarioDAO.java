/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class UsuarioDAO extends AbstractDAO<Usuario, String> {

    private final DireccionDAO direccionDAO;
    private final CorreoElectronicoDAO correoElectronicoDAO;
    private final DirectorioDAO directorioDAO;

    public UsuarioDAO() {
        PREPARED_INSERT = "INSERT INTO USUARIO (NOMBRE_USUARIO, CONTRASENA, NOMBRE, APELLIDO, FECHA_NACIMIENTO, ID_DIRECCION, ID_CORREO_ELECTRONICO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PREPARED_UPDATE = "UPDATE USUARIO SET CONTRASENA = ?, NOMBRE = ?, APELLIDO = ?, FECHA_NACIMIENTO = ?, ID_DIRECCION = ?, ID_CORREO_ELECTRONICO = ? WHERE NOMBRE_USUARIO = ?";
        PREPARED_DELETE = "DELETE FROM USUARIO";

        PREPARED_SELECT = "SELECT NOMBRE_USUARIO, CONTRASENA, NOMBRE, APELLIDO, FECHA_NACIMIENTO, ID_DIRECCION, ID_CORREO_ELECTRONICO";
        PREPARED_WHEREID = " WHERE NOMBRE_USUARIO = ?";
        PREPARED_ORDERBY = " ORDER BY NOMBRE, APELLIDO";

        direccionDAO = new DireccionDAO();
        correoElectronicoDAO = new CorreoElectronicoDAO();
        directorioDAO = new DirectorioDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, String id) throws Exception {
        pstmt.setString(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Usuario dto, boolean isInsert) throws Exception {
        int pos = isInsert ? 0 : 6;
        pstmt.setString((pos++ % 7) + 1, dto.getNombreUsuario());
        pstmt.setString((pos++ % 7) + 1, dto.getContrasena());
        pstmt.setString((pos++ % 7) + 1, dto.getNombre());
        pstmt.setString((pos++ % 7) + 1, dto.getApellido());
        pstmt.setDate((pos++ % 7) + 1, dto.getFechaNacimiento() == null ? null : java.sql.Date.valueOf(dto.getFechaNacimiento()));
        pstmt.setInt((pos++ % 7) + 1, dto.getDireccion().getId());
        pstmt.setInt((pos++ % 7) + 1, dto.getCorreoElectronico().getId());
    }

    @Override
    protected Usuario crearEntidad(ResultSet rset) throws Exception {
        int pos = 1;
        Usuario respuesta = new Usuario();
        respuesta.setNombreUsuario(rset.getString(pos++));
        respuesta.setContrasena(rset.getString(pos++));
        respuesta.setNombre(rset.getString(pos++));
        respuesta.setApellido(rset.getString(pos++));
        respuesta.setFechaNacimiento(rset.getString(pos++) == null ? null : rset.getDate(pos - 1).toLocalDate());
        respuesta.setDireccion(direccionDAO.buscarPorID(rset.getInt(pos++)));
        respuesta.setCorreoElectronico(correoElectronicoDAO.buscarPorID(rset.getInt(pos++)));
        
        respuesta.setDirectorio(directorioDAO.buscarPorID(respuesta));
        
        return respuesta;
    }

    @Override
    protected String generarId() throws Exception {
        return null;
    }

    @Override
    protected String obtenerCondiciones(Usuario filtro) {
        StringBuilder query = new StringBuilder();
        if (filtro != null) {
            boolean isWhere = true;
            if (filtro.getNombreUsuario() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" NOMBRE_USUARIO = '").append(filtro.getNombreUsuario()).append("'");
                isWhere = false;
            }
            if (filtro.getContrasena() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" CONTRASENA = '").append(filtro.getContrasena()).append("'");
                isWhere = false;
            }
            if (filtro.getNombre() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" NOMBRE = '").append(filtro.getNombre()).append("'");
                isWhere = false;
            }
            if (filtro.getApellido() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" APELLIDO = '").append(filtro.getApellido()).append("'");
                isWhere = false;
            }
//            if (filtro.getFechaNacimiento() != null) {
//                query.append(isWhere ? " WHERE" : " AND")
//                        .append(" FECHA_NACIMIENTO = '").append(filtro.getFechaNacimiento()).append("'");
//                isWhere = false;
//            }
            if (filtro.getDireccion() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_DIRECCION = ").append(filtro.getDireccion());
                isWhere = false;
            }
            if (filtro.getCorreoElectronico() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_CORREO_ELECTRONICO = ").append(filtro.getCorreoElectronico().getId());
            }
        }
        return query.toString();
    }

}
