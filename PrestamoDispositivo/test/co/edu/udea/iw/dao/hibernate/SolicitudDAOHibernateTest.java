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

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre la solicitud
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class SolicitudDAOHibernateTest {
	
	/*
	 * dao de la solicitud
	 */
	@Autowired
	SolicitudDAO solicitudDao;
	@Autowired
	
	/*
	 * dao del usuario
	 */
	UsuarioDAO usuarioDao;
	
	/*
	 * dao del dispositivo
	 */
	@Autowired
	DispositivoDAO dispositivoDao;
	
	/**
	 * Metodo que permite obtener un listado de solicitudes de la BD
	 */
	@Test
	public void testObtener() {
		
		List<Solicitud> solicitudes = null;
		
		try{
			solicitudes = solicitudDao.obtener();
			
			for(Solicitud solicitud : solicitudes){
				System.out.println("Usuario: " + solicitud.getUsuarioAprueba().getLogin());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite insertar una solicitud en la BD
	 */
	@Test
	public void testInsertar() {
		
		Solicitud solicitud=new Solicitud();
		solicitud.setIdSolicitud(124);
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioDao.obtenerLogin("danielAS");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		solicitud.setUsuarioSolicita(usuario);
				
		Usuario usuario2 = new Usuario();
		try {
			usuario2 = usuarioDao.obtenerLogin("jtrujillog");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		solicitud.setUsuarioSolicita(usuario2);
		
		Dispositivo dispositivo=new Dispositivo();
		try {
			dispositivo = dispositivoDao.obtenerId(123);
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}
		solicitud.setDispositivo(dispositivo);		
		
		try{
			solicitudDao.insertar(solicitud);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite actualizar una solicitud de la BD
	 */
	@Test
	public void testModificar() {
		
		Solicitud solicitud=new Solicitud();
		solicitud.setIdSolicitud(123);
		
		Usuario usuario = new Usuario();
		try {
			usuario = usuarioDao.obtenerLogin("jtrujillog");
		} catch (IWDaoException e1) {			
			e1.printStackTrace();
			fail(e1.getMessage());
		}		
		solicitud.setUsuarioSolicita(usuario);		
		
		try{
			solicitudDao.modificar(solicitud);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite obtener una solicitud por medio de us Id
	 */
	@Test
	public void testObtenerId() {
		Solicitud solicitud;
				
		try{
			solicitud= solicitudDao.obtenerId(123456);
			System.out.println(solicitud.getUsuarioSolicita());
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite eliminar una solicitud de la BD
	 */
	@Test
	public void testEliminar() {
				
		try{
			solicitudDao.borrar(123456);			
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}


}
