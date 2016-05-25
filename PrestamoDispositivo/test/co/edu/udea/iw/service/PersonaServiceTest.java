package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre el service de persona
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PersonaServiceTest {
	
	/*
	 * persona service
	 */
	@Autowired
	PersonaService personaService;
	
	/**
	 * Metodo que permite guardar una persona en la BD
	 */
	@Test
	public void testGuardarPersona() {
		
		try{
			personaService.guardarPersona("2222222", "Cliente", "Prueba", "mal@correo.com", "12345", "danielAS","jtrujillog");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Metodo que permite actualizar una persona en la BD
	 */
	@Test
	public void testActualizarPersona() {
		
		try{
			personaService.actualizarPersona("1234567890", "Cliente", "Prueba", "mal@correo.com", "12345", "danielAS","jtrujillog");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Metodo que permite eliminar una persona en la BD
	 */
	@Test
	public void testEliminarPersona() {
		
		try{
			personaService.eliminarPersona("1234567890", "jtrujillog");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Metodo que permite listar las personas de la BD
	 */
	@Test
	public void testListarPersonas() {
		
		try{
			personaService.obtener();
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	/**
	 * Metodo que permite obtener una persona por su cedula
	 */
	@Test
	public void testObtenerPersona() {
		
		try{
			Persona pr;
			
			pr=personaService.obtenerCedula("1152187679");
			System.out.println(pr.getNombres());
			
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
}
