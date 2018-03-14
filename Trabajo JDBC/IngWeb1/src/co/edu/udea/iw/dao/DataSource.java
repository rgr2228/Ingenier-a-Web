package co.edu.udea.iw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.udea.iw.exception.DriverException;

/**
 * Esta clase es la encargada de realizar la conexión con la base de datos
 * @author Raúl Andrés Gómez Ramírez - raul.gomezr
 */

public class DataSource{
	
	private static DataSource dataSource=null;
	
	private final String CLASSNAME = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/ingweb";
	private final String USER = "root";
	private final String PASSWORD = "root";
	
	private DataSource() {}
	
	/**
	 * Método que restringe la creación de objetos DataSource a un único objeto, patrón singleton
	 * @return La única instancia de la clase DataSource
	 */
	public static DataSource getInstance(){
		if(dataSource==null)
		{
			dataSource = new DataSource(); //Realiza la única instancia posible de la clase
		}
		return dataSource;
	}

	/**
	 * Método que se encarga de realizar una conexión o sesión con una determinada base de datos
	 * @return La conexión establecida con una base de datos
	 * @throws DriverException
	 */
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
