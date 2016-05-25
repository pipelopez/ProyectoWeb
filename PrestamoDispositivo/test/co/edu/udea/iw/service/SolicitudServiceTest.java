package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre solicitud
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudServiceTest {
	
	@Autowired
	SolicitudService solicitudService;

	@Test
	public void testGuardarSolicitud() {
		
		try{
			solicitudService.guardarSolicitud(125, "danielAS", "jtrujillog", 123, "Espera");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarSolicitud() {
		
		try{
			solicitudService.actualizarSolicitud(123, "danielAS", "jtrujillog",123, "Espera");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testEliminarSolicitud() {
		
		try{
			solicitudService.eliminarSolicitud(123);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testListarSolicitudes() {
		
		try{
			solicitudService.obtener();
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testObtenerSolicitud() {
		
		try{
			Solicitud soli;			
			soli=solicitudService.obtenerId(123);
			System.out.println(soli.getEstadoSolicitud());
			
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
}
