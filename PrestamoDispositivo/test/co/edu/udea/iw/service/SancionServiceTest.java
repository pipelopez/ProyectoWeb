package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre sancion
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SancionServiceTest {
	
	@Autowired
	SancionService sancionService;

	@Test
	public void testGuardarSancion() {
		
		try{
			sancionService.guardarSancion(23, "Retardo", 2345678, "Entrega el dispositivo tarde", "jtrujillog");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarSancion() {
		
		try{
			sancionService.actualizarSancion(12, "Daño", 2345678, "Entrega el dispositivo en mal estado", "jtrujillog");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testEliminarSancion() {
		
		try{
			sancionService.eliminarSancion(12);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testListarSanciones() {
		
		try{
			sancionService.obtener();
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testObtenerSancion() {
		
		try{
			Sancion san;			
			san=sancionService.obtenerSancion(12);
			System.out.println(san.getDescripcion());
			
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
}
