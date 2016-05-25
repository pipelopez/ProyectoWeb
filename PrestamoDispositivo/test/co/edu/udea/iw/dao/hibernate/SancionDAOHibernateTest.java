package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mysql.jdbc.UpdatableResultSet;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dao.SancionDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre la sancion
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SancionDAOHibernateTest {
	
	/*
	 * dao de la sancion
	 */
	@Autowired
	SancionDAO sancionesDao;
	
	/*
	 * dao del usuario
	 */
	@Autowired
	UsuarioDAO usuarioDao;
	
	/*
	 * dao del prestamo
	 */
	@Autowired
	PrestamoDAO prestamoDao;
	
	/**
	 * Metodo que permite obtener un listado de sanciones de la BD
	 */
	@Test
	public void testObtener() {
		
		List<Sancion> sanciones = null;
		
		try{
			sanciones =sancionesDao.obtener();			
			for(Sancion sancion : sanciones){
				System.out.println("Login usuario que sanciona: " + sancion.getUsuarioSanciona().getLogin());
			}			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite insertar una sancion en la BD
	 */
	@Test
	public void testInsertar() {
		Sancion sancion =new Sancion();
		sancion.setDescripcion("");
		sancion.setIdSancion(124);
		sancion.setTipoSancion("Daño");
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioDao.obtenerLogin("jtrujillog");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		sancion.setUsuarioSanciona(usuario);
		
		Prestamo prestamo = new Prestamo();
		try {
			prestamo = prestamoDao.obtenerId(123);
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		sancion.setPrestamo(prestamo);
		
		try{
			sancionesDao.insertar(sancion);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite actualizar un dispositivo de la BD
	 */
	@Test
	public void testModificar() {
		Sancion sancion =new Sancion();
		sancion.setDescripcion("Mal trato");
		sancion.setIdSancion(123);
				
		try{
			sancionesDao.modificar(sancion);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite obtener un dispositivo por medio de su Id
	 */
	@Test
	public void testObtenerId() {
		Sancion sancion;				
		try{
			sancion= sancionesDao.obtenerId(12);
			System.out.println(sancion.getTipoSancion());
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite eliminar un dispositivo de la BD
	 */
	@Test
	public void testEliminar() {	
				
		try{
			sancionesDao.borrar(12);			
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}

}
