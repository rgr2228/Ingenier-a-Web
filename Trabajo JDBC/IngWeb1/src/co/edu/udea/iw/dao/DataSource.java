package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.DriverException;

/**
 * 
 * @author Raúl Andrés Gómez Ramírez - raul.gomezr
 *
 */

public class DataSource{
	
	private static DataSource dataSource=null;
	
	private final String CLASSNAME = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/ingweb";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	private DataSource() {}
	
	public static DataSource getInstance(){
		if(dataSource==null)
		{
			dataSource = new DataSource();
		}
		return dataSource;
	}

	public Connection getConnection() throws DriverException{
		Connection con = null;
		try {
			Class.forName(CLASSNAME); //Cargar driver
			con = DriverManager.getConnection(URL,USER,PASSWORD); //Realizar conexión con sql
		}catch(ClassNotFoundException e)
		{
			throw new DriverException("No ha encontrado el driver de la BD",e);//Mensaje de excepción
		}catch(SQLException e)
		{
			throw new DriverException("Ha ocurrido un error al conectarse a la BD",e);//Mensaje de excepción
		}
		return con;
	}
	
}
