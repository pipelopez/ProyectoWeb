package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre el usuario
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class UsuarioDAOHibernateTest {
	
	/*
	 * dao del usuario
	 */
	@Autowired
	UsuarioDAO usuarioDao;
	
	/**
	 * Metodo que permite obtener un listado de usuarios de la BD
	 */
	@Test
	public void testObtener() {
		
		List<Usuario> usuarios = null;
		
		try{
			usuarios = usuarioDao.obtener();
			
			for(Usuario usuario : usuarios){
				System.out.println("Login usuario: " + usuario.getLogin());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite eliminar un usuario de la BD
	 */
	@Test
	public void testEliminar() {	
				
		try{
			usuarioDao.borrar("danielAS");			
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite obtener un usuario por medio de su login
	 */
	@Test
	public void testObtenerLogin() {
		Usuario usuario;
				
		try{
			usuario= usuarioDao.obtenerLogin("danielAS");
			System.out.println(usuario.getEstadoUsuario());
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite insertar un usuario en la BD
	 */
	@Test
	public void testInsertar() {
		Usuario usuario=new Usuario();
		usuario.setContrasena("0000");
		usuario.setEstadoUsuario("Habilitado");
		usuario.setLogin("Felipe2");
		Rol rol =new Rol();
		rol.setIdRol("INV");
		rol.setNombre("Investigador");
		usuario.setRol(rol);
		
		try{
			usuarioDao.insertar(usuario);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite actualizar un usuario de la BD
	 */
	@Test
	public void testModificar() {
		
		Usuario usuario=new Usuario();
		usuario.setContrasena("0000");
		usuario.setEstadoUsuario("Habilitado");
		usuario.setLogin("danielAS");
		Rol rol =new Rol();
		rol.setIdRol("INV");
		rol.setNombre("Investigador");
		usuario.setRol(rol);		
		try{
			usuarioDao.modificar(usuario);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}

}
