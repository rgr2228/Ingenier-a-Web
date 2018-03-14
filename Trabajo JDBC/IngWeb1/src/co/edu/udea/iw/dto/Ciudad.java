package co.edu.udea.iw.dto;

/**	
 * Clase para el almacenamiento y entrega de los atributos de una ciudad
 * @author Raúl Andrés Gómez Ramírez - raul.gomezr
 */

public class Ciudad {
	private int codigo;
	private String nombre;
	private String codigoArea;
	
	public Ciudad()
	{
		
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigoArea() {
		return codigoArea;
	}
	public void setCodigoArea(String codigoArea) {
		this.codigoArea = codigoArea;
	}
}
