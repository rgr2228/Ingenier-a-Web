package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.DriverException;

/**	
 * Define la interfaz del DAO correspondiente a ciudad
 * @author  Raúl Andrés Gómez Ramírez - raul.gomezr
 */

public interface CiudadDAO {
	
	public void insertar(Ciudad ciudad) throws DriverException;
	public void actualizar(Ciudad ciudad) throws DriverException;
	public void eliminar(Ciudad ciudad) throws DriverException;
	public List<Ciudad> obtener()throws DriverException;
}
