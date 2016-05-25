package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre una persona
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PersonaDAOHIbernateTest {
	
	/*
	 * dao de la persona
	 */
	@Autowired
	PersonaDAO personaDao;
	
	/*
	 * dao del usuario
	 */
	@Autowired
	UsuarioDAO usuarioDao;
	
	/**
	 * Metodo que permite obtener un listado de personas de la BD
	 */
	@Test
	public void testObtener() {
		
		List<Persona> personas = null;
		
		try{
			personas = personaDao.obtener();
			
			for(Persona persona : personas){
				System.out.println("Nombre: " + persona.getNombres());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite insertar una persona en la BD
	 */
	@Test
	public void testInsertar()  {
		
		Persona persona=new Persona();
		persona.setCedula("12345678");
		persona.setApellidos("Lopez");
		persona.setNombres("Juan");
		persona.setCorreo("fl@gmail.com");
		persona.setTelefono("123456");
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioDao.obtenerLogin("danielAS");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		persona.setUsuario(usuario);
		
		Date date=new Date();
		persona.setFechaCreacion(date);
		
		Usuario usuario2 = new Usuario();
		try {
			usuario2 = usuarioDao.obtenerLogin("danielAS");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		persona.setUsuarioCrea(usuario2);
		
		try{
			personaDao.insertar(persona);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite actualziar una persona en la BD
	 */
	@Test
	public void testModificar()  {
		
		Persona persona=new Persona();
		persona.setCedula("1234567890");
		persona.setApellidos("Lopez");
		persona.setNombres("Juan");
		persona.setCorreo("fl@gmail.com");
		persona.setTelefono("123456");
	
		try{
			personaDao.modificar(persona);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite obtenre una persona por medio de su cedula
	 */
	@Test
	public void testObtenerId() {
		Persona persona;
				
		try{
			persona= personaDao.obtenerCedula("1234567890");
			System.out.println(persona.getNombres());
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite eliminar una persona en la BD
	 */
	@Test
	public void testEliminar() {	
				
		try{
			personaDao.borrar("1234567890");			
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}

}
