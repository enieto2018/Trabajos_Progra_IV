/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.cursojee.agenda.dao;

import co.edu.utp.isc.cursojee.agenda.base.AbstractDAO;
import co.edu.utp.isc.cursojee.agenda.modelo.Ciudad;
import co.edu.utp.isc.cursojee.agenda.modelo.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author DiazOspina
 */
public class DepartamentoDAO extends AbstractDAO<Departamento, Integer> {

    private final PaisDAO paisDAO;
    private final CiudadDAO ciudadDAO;

    public DepartamentoDAO() {
        PREPARED_INSERT = "INSERT INTO DEPARTAMENTO (ID, NOMBRE, ID_PAIS) VALUES (?, ?, ?)";
        PREPARED_UPDATE = "UPDATE DEPARTAMENTO SET NOMBRE = ?, ID_PAIS = ? WHERE ID = ?";
        PREPARED_DELETE = "DELETE FROM DEPARTAMENTO";

        PREPARED_SELECT = "SELECT ID, NOMBRE, ID_PAIS FROM DEPARTAMENTO";
        PREPARED_WHEREID = " WHERE ID = ?";
        PREPARED_ORDERBY = " ORDER BY ID_PAIS, NOMBRE";

        PREPARED_GENERAR = "SELECT MAX(ID) FROM DEPARTAMENTO";

        paisDAO = new PaisDAO();
        ciudadDAO = new CiudadDAO();
    }

    @Override
    protected void agregarIdASentencia(PreparedStatement pstmt, Integer id) throws Exception {
        pstmt.setInt(1, id);
    }

    @Override
    protected void agregarEntidadASentencia(PreparedStatement pstmt, Departamento dto, boolean isInsert) throws Exception {
        if (isInsert) {
            pstmt.setInt(1, dto.getId());
            pstmt.setString(2, dto.getNombre());
            pstmt.setInt(3, dto.getPais().getId());
        } else {
            pstmt.setString(1, dto.getNombre());
            pstmt.setInt(2, dto.getPais().getId());
            pstmt.setInt(3, dto.getId());
        }
    }

    @Override
    protected Departamento crearEntidad(ResultSet rset) throws Exception {
        Departamento respuesta = new Departamento();
        respuesta.setId(rset.getInt(1));
        respuesta.setNombre(rset.getString(2));
        respuesta.setPais(paisDAO.buscarPorID(rset.getInt(3)));
        respuesta = cargarCiudades(respuesta);
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
    protected String obtenerCondiciones(Departamento filtro) {
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
            if (filtro.getPais() != null) {
                query.append(isWhere ? " WHERE" : " AND")
                        .append(" ID_PAIS = ").append(filtro.getPais().getId());
            }
        }
        return query.toString();
    }

    private Departamento cargarCiudades(Departamento dto) throws Exception {
        if (dto.getCiudades() == null) {
            Ciudad cdto = new Ciudad();
            cdto.setDepartamento(dto);
            dto.setCiudades(ciudadDAO.listar(cdto));
        }

        return dto;
    }

}
