package co.edu.udea.iw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.DataSource;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.DriverException;

/**
 * 
 * @author Raúl Andrés Gómez Ramírez - raul.gomezr
 *
 */

public class CiudadDAOImpl implements CiudadDAO {

	public CiudadDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insertar(Ciudad ciudad) throws DriverException {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizar(Ciudad ciudad) throws DriverException {
		// TODO Auto-generated method stub

	}

	@Override
	public void eliminar(Ciudad ciudad) throws DriverException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Ciudad> obtener() throws DriverException {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Ciudad> ciudades = new ArrayList<Ciudad>();
		DataSource ds = new DataSource();
		try {
			con = ds.getConnection(); 
			ps = con.prepareStatement("Select * From ciudades");
			rs = ps.executeQuery();
			while(rs.next()) {
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getInt("codigo"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudades.add(ciudad);
			}
		}catch(SQLException e)
		{
			throw new DriverException("Ha ocurrido un error al conectarse a la BD",e);
		}finally {
			try{
				rs.close();
				ps.close();
				con.close();
			}catch(SQLException e) {
				throw new DriverException("Ha ocurrido un error al cerrar la BD",e);
			}
		}
		return null;
	}

}
