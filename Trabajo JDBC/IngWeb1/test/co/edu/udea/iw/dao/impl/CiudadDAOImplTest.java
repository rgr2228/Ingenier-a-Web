package co.edu.udea.iw.dao.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.DriverException;

/**
 * 
 * @author raul.gomezr
 *
 */

class CiudadDAOImplTest {

	@Test
	void testObtener() {
		CiudadDAO dao = null;
		List<Ciudad> lista = null;
		try {
			dao = new CiudadDAOImpl();
			lista = dao.obtener();
			assertTrue(lista.size()>0);
		}catch(DriverException e)
		{
			fail("Not yet implemented");
		}
	}

}
