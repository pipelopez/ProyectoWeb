package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.encode.Cifrar;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre el service de usuario
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioServiceTest {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Test
	public void testValidarUsuario() {
		
		try{
			usuarioService.validar("hola","12335678");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testGuardarUsuario() {
		
		try{
			usuarioService.guardarUsuario("cualquiera", "probando1", "ADM", "Activo");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarContrasena() {
		
		try{
			usuarioService.actualizarContrasena("hola", "12335678","87654321");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarUsuario() {
		
		try{
			usuarioService.actualizarUsuario("estefelipe89", "Habilitado");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testEliminarUsuario() {
		
		try{
			usuarioService.eliminarUsuario("jtrujillog");
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testListarUsuarios() {
		
		try{
			usuarioService.obtener();
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testObtenerPersona() {
		
		try{
			Usuario us;
			
			us=usuarioService.obtenerLogin("estefelipe89");
			System.out.println("El Usuario "+us+" si existe en la BD");
			
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
}