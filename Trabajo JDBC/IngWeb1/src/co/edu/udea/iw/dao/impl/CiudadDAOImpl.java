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
 * Esta clase es la encargada de implementar los métodos de la interfaz
 * Realiza las consultas necesarias a la base de datos
 * @author Raúl Andrés Gómez Ramírez - raul.gomezr
 */

public class CiudadDAOImpl implements CiudadDAO {

	public CiudadDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * Método encargado de realizar las inserciones de ciudades en la base de datos
	 * @param el parámetro ciudad define el objeto que se va a insertar en la tabla ciudades 
	 */
	@Override
	public void insertar(Ciudad ciudad) throws DriverException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO ciudades(codigo,Nombre,CodigoArea) VALUES (?,?,?)"; //String de consulta sql
		DataSource ds = DataSource.getInstance();
		try {
			con = ds.getConnection(); //Se realiza conexión con BD
			ps = con.prepareStatement(sql); //Prepara consulta
			ps.setInt(1,ciudad.getCodigo()); //Se agrega parámetro a al consulta
			ps.setString(2,ciudad.getNombre()); //Se agrega parámetro a al consulta
			ps.setString(3,ciudad.getCodigoArea()); //Se agrega parámetro a al consulta
			ps.execute(); //Ejecuta consulta
		}catch(SQLException e)
		{
			throw new DriverException("Ha ocurrido un error al conectarse a la BD",e); //Mensaje de excepción
		}
		finally {
			try {
				ps.close();
				con.close(); //Se cierra conexión con BD
			}catch(SQLException e)
			{
				throw new DriverException("Ha ocurrido un error al desconectarse a la BD",e); //Mensaje de excepción
			}
		}
	}
	
	/**
	 * Método encargado de realizar una actualzación de un dato de la tabla ciudades
	 * @param el parámetro ciudad contiene el objeto el cual posee los atributos que modificarán 
	 * un registro de la tabla ciudades
	 */
	@Override
	public void actualizar(Ciudad ciudad) throws DriverException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE ciudades SET Nombre=?, CodigoArea=? WHERE codigo=?"; //String de consulta sql
		DataSource ds = DataSource.getInstance(); 
		try {
			con = ds.getConnection(); //Se realiza conexión con BD
			ps = con.prepareStatement(sql); //Prepara consulta
			ps.setString(1, ciudad.getNombre()); //Se agrega parámetro a al consulta
			ps.setString(2, ciudad.getCodigoArea()); //Se agrega parámetro a al consulta
			ps.setInt(3, ciudad.getCodigo()); //Se agrega parámetro a al consulta
			ps.execute(); //Ejecuta consulta
		}catch(SQLException e) {
			throw new DriverException("Ha ocurrido un error al conectarse a la BD"); //Mensaje de excepción
		}
		finally {
			try {
				ps.close();
				con.close(); //Se cierra conexión con BD
			}catch(SQLException e)
			{
				throw new DriverException("Ha ocurrido un error al desconectarse a la BD",e); //Mensaje de excepción
			}
		}
	}

	/**
	 * Método encargado de realizar el borrado de ciudades en la base de datos
	 * @param el parámetro ciudad define el objeto que se va a eliminar de la tabla ciudades 
	 */
	@Override
	public void eliminar(Ciudad ciudad) throws DriverException {
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM ciudades WHERE codigo=?"; //String de consulta sql
		DataSource ds = DataSource.getInstance(); 
		try {
			con = ds.getConnection(); //Se realiza conexión con BD
			ps = con.prepareStatement(sql); //Prepara consulta
			ps.setInt(1,ciudad.getCodigo()); //Se agrega parámetro a al consulta
			ps.execute(); //Ejecuta consulta
		}catch(SQLException e) {
			throw new DriverException("Ha ocurrido un error al conectarse a la BD"); //Mensaje de excepción
		}
		finally {
			try {
				ps.close();
				con.close(); //Se cierra conexión con BD
			}catch(SQLException e)
			{
				throw new DriverException("Ha ocurrido un error al desconectarse a la BD",e); //Mensaje de excepción
			}
		}
	}
	
	/**
	 * Método encargado de retornar todos las ciudades que hay en la tabla ciudades de la base de datos
	 * @return Una lista de objetos de tipo Ciudad
	 */
	@Override
	public List<Ciudad> obtener() throws DriverException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "Select * From ciudades"; //String de consulta sql
		List<Ciudad> ciudades = new ArrayList<Ciudad>(); //Lista que contendrá los objetos devueltos en la consulta
		DataSource ds = DataSource.getInstance();
		try {
			con = ds.getConnection(); //Se realiza conexión con la BD
			ps = con.prepareStatement(sql); //Se prepara la consulta
			rs = ps.executeQuery();//Ejecuta consulta
			while(rs.next()) { //Se recorre cada uno de los datos obtenidos
				Ciudad ciudad = new Ciudad();
				ciudad.setCodigo(rs.getInt("codigo"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudades.add(ciudad); //Se agrega el objeto a la lista
			}
		}catch(SQLException e)
		{
			throw new DriverException("Ha ocurrido un error al conectarse a la BD",e); //Mensaje de excepción
		}finally {
			try{
				rs.close();
				ps.close();
				con.close(); //Se cierra conexión con la BD
			}catch(SQLException e) {
				throw new DriverException("Ha ocurrido un error al cerrar la BD",e); //Mensaje de excepción
			}
		}
		return ciudades;
	}

}
