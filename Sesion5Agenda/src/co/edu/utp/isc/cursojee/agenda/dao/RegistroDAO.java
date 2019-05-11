/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Registro;
import co.edu.utp.isc.cursojee.agenda.modelo.Telefono;
import co.edu.utp.isc.cursojee.agenda.modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class RegistroDAO extends AbstractDAO<Registro, Integer> {

    private final UsuarioDAO usuarioDAO;
    private final DireccionDAO direccionDAO;
    private final CorreoElectronicoDAO correoElectronicoDAO;
    private final TelefonoDAO telefonoDAO;
    private final DirectorioDAO directorioDAO;
    private final GrupoDAO grupoDAO;

    public RegistroDAO() {
        PREPARED_INSERT = "INSERT INTO REGISTRO (ID, NOMBRE, APELLIDO, ALIAS, FECHA_NACIMIENTO, CARGO, CARRERA, FOTO, ID_DIRECTORIO, ID_DIRECCION, ID_CORREO_ELECTRONICO) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PREPARED_UPDATE = "UPDATE REGISTRO SET NOMBRE = ?, APELLIDO = ?, ALIAS = ?, FECHA_NACIMIENTO = ?, CARGO = ?, CARRERA = ?, FOTO = ?, ID_DIRECTORIO = ?, ID_DIRECCION = ?, ID_CORREO_ELECTRONICO = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM REGISTRO";

        PREPARED_SELECT = "SELECT ID, NOMBRE, APELLIDO, ALIAS, FECHA_NACIMIENTO, CARGO, CARRERA, FOTO, ID_DIRECTORIO, ID_DIRECCION, ID_CORREO_ELECTRONICO FROM REGISTRO";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY ID_DIRECTORIO, NOMBRE, APELLIDO";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM REGISTRO";

        usuarioDAO = new UsuarioDAO();
        direccionDAO = new DireccionDAO();
        correoElectronicoDAO = new CorreoElectronicoDAO();
        telefonoDAO = new TelefonoDAO();
        directorioDAO = new DirectorioDAO();
        grupoDAO = new GrupoDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Registro dto, boolean isInsert) throws Exception {
        int pos = isInsert ? 0 : 10;
        pstmt.setInt((pos++ % 11) + 1, dto.getId());
        pstmt.setString((pos++ % 11) + 1, dto.getNombre());
        pstmt.setString((pos++ % 11) + 1, dto.getApellido());
        pstmt.setString((pos++ % 11) + 1, dto.getAlias());
        pstmt.setDate((pos++ % 11) + 1, dto.getFechaNacimiento() == null ? null : java.sql.Date.valueOf(dto.getFechaNacimiento()));
        pstmt.setString((pos++ % 11) + 1, dto.getCargo());
        pstmt.setString((pos++ % 11) + 1, dto.getCarrera());
        pstmt.setString((pos++ % 11) + 1, dto.getFoto());
        pstmt.setString((pos++ % 11) + 1, dto.getDirectorio().getId().getId());
        pstmt.setInt((pos++ % 11) + 1, dto.getDireccion().getId());
        pstmt.setInt((pos++ % 11) + 1, dto.getCorreoElectronico().getId());
    }

    @Override
    protected Registro crearEntidad(ResultSet rset) throws Exception {
        //ID, NOMBRE, APELLIDO, ALIAS, FECHA_NACIMIENTO, CARGO, CARRERA, FOTO, ID_DIRECTORIO, ID_DIRECCION, ID_CORREO_ELECTRONICO
        int pos = 1;
        Registro respuesta = new Registro();
        respuesta.setId(rset.getInt(pos++));
        respuesta.setNombre(rset.getString(pos++));
        respuesta.setApellido(rset.getString(pos++));
        respuesta.setAlias(rset.getString(pos++));
        respuesta.setFechaNacimiento(rset.getString(pos++) == null ? null : rset.getDate(pos - 1).toLocalDate());
        respuesta.setCargo(rset.getString(pos++));
        respuesta.setCarrera(rset.getString(pos++));
        respuesta.setFoto(rset.getString(pos++));

        Usuario id = usuarioDAO.buscarPorID(rset.getString(pos++));
        respuesta.setDirectorio(directorioDAO.buscarPorID(id));

        respuesta.setDireccion(direccionDAO.buscarPorID(rset.getInt(pos++)));
        respuesta.setCorreoElectronico(correoElectronicoDAO.buscarPorID(rset.getInt(pos++)));

        respuesta = cargarTelefonos(respuesta);
        respuesta = cargarGrupos(respuesta);

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
    protected String obtenerCondiciones(Registro filtro) {
        //ID, NOMBRE, APELLIDO, ALIAS, FECHA_NACIMIENTO, CARGO, CARRERA, FOTO, ID_DIRECTORIO, ID_DIRECCION, ID_CORREO_ELECTRONICO
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
            if (filtro.getApellido() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" APELLIDO = '").append(filtro.getApellido()).append("'");
                isWhere = false;
            }
            if (filtro.getAlias() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ALIAS = '").append(filtro.getAlias()).append("'");
                isWhere = false;
            }
//            if (filtro.getFechaNacimiento() != null) {
//                query.append(isWhere ? " WHERE" : " AND")
//                        .append(" FECHA_NACIMIENTO = '").append(filtro.getFechaNacimiento()).append("'");
//                isWhere = false;
//            }
            if (filtro.getCargo() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" CARGO = '").append(filtro.getCargo()).append("'");
                isWhere = false;
            }
            if (filtro.getCarrera() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" CARRERA = '").append(filtro.getCarrera()).append("'");
                isWhere = false;
            }
            if (filtro.getFoto() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" FOTO = '").append(filtro.getFoto()).append("'");
                isWhere = false;
            }
            if (filtro.getDirectorio() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_DIRECTORIO = '").append(filtro.getDirectorio().getUsuario().getId()).append("'");
                isWhere = false;
            }
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

    private Registro cargarTelefonos(Registro dto) throws Exception {
        if (dto.getTelefonos() == null) {
            Telefono ddto = new Telefono();
            ddto.setRegistro(dto);
            dto.setTelefonos(telefonoDAO.listar(ddto));
        }

        return dto;
    }

    private Registro cargarGrupos(Registro dto) throws Exception {
        if (dto.getGrupos() == null) {
            //TODO Falta la consulta en la tabla intermedia
//            Grupo ddto = new Grupo();
//            ddto.set(dto);
//            dto.setGrupos(departamentoDAO.listar(ddto));
        }

        return dto;
    }
}
