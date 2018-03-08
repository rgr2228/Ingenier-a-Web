package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ciudad {

	public static void main2(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //Cargar driver
			Connection con = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/ingweb", 
					"root", "root"); //Realizar conexión con sql
			PreparedStatement ps = con.prepareStatement("select * from ciudades"); //Prepara consulta
			ResultSet rs = ps.executeQuery(); //Ejecuta consulta
			while(rs.next()){ //Se recorre la tabla ciudades
				System.out.println(rs.getString("Nombre")); //Se obtiene el nombre de la ciudad
			}
			rs.close();
			ps.close();
			con.close();//Cerrar conexión con base de datos
		}catch(ClassNotFoundException e){
			System.out.println("No se ha encontrado el driver de conexión");	//Mensaje de excepción
		}catch(SQLException e)
		{
			System.out.println(e.getMessage()); //Mensaje de excepción
		}
	}
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver"); //Cargar driver
			Connection con = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/ingweb", 
					"root", "root"); //Realizar conexión con sql
			PreparedStatement ps = 
			con.prepareStatement("INSERT INTO ciudades(codigo,Nombre,CodigoArea) VALUES ('11','Sabaneta','4')"); //Prepara consulta
			ps.execute(); //Ejecuta consulta
			ps.close();
			con.close();//Cerrar conexión con base de datos
		}catch(ClassNotFoundException e){
			System.out.println("No se ha encontrado el driver de conexión");	//Mensaje de excepción
		}catch(SQLException e)
		{
			System.out.println(e.getMessage()); //Mensaje de excepción
		}
	}
	
}
