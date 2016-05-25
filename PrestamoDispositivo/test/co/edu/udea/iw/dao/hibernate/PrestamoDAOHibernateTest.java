package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre el prestamo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PrestamoDAOHibernateTest {
	
	/*
	 * dao del prestamo
	 */
	@Autowired
	PrestamoDAO prestamosDao;
	
	/*
	 * dao de la solicitud
	 */
	@Autowired
	SolicitudDAO solicitudDao;
	
	/*
	 * dao del usuario
	 */
	@Autowired
	UsuarioDAO usuarioDao;
	
	/**
	 * Metodo que permite obtener un listado de prestamos de la BD
	 */
	@Test
	public void testObtener() {
		
		List<Prestamo> prestamos = null;
		
		try{
			prestamos = prestamosDao.obtener();
			
			for(Prestamo prestamo : prestamos){
				System.out.println("Login usuario entrega: " + prestamo.getUsuarioEntrega().getLogin());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite insertar un prestamos en la BD
	 */
	@Test
	public void testInsertar() {
		
		Prestamo prestamo =new Prestamo();
		prestamo.setIdPrestamo(124);
		Date date=new Date();
		prestamo.setHoraFin(date);
		prestamo.setHoraInicio(date);
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioDao.obtenerLogin("jtrujillog");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		prestamo.setUsuarioEntrega(usuario);
				
		Solicitud solicitud=new Solicitud();
		try {
			solicitud = solicitudDao.obtenerId(123);
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		prestamo.setSolicitud(solicitud);		
		
		try{
			prestamosDao.insertar(prestamo);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite actualizar un prestamo en la BD
	 */
	@Test
	public void testModificar() {
		Prestamo prestamo =new Prestamo();
		prestamo.setIdPrestamo(123);
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioDao.obtenerLogin("danielAS");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		prestamo.setUsuarioEntrega(usuario);
		
		try{
			prestamosDao.modificar(prestamo);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite obtener un prestamo por medio de us Id
	 */
	@Test
	public void testObtenerId() {
		Prestamo prestamo;
				
		try{
			prestamo= prestamosDao.obtenerId(1234567);
			System.out.println(prestamo.getUsuarioEntrega());
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite eliminar un prestamo de la BD
	 */
	@Test
	public void testEliminar() {	
				
		try{
			prestamosDao.borrar(1234567);			
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}

	

}
