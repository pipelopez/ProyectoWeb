package co.edu.udea.iw.dao.hibernate;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Clase que permite realizar las 
 * operaciones de prueba sobre el dispositivo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class DispositivoDAOHibernateTest {
	/*
	 * dao del dispositivo
	 */
	@Autowired
	DispositivoDAO dispositivoDao;
	
	/**
	 * Metodo que permite obtener un listado de dispositivos de la BD
	 */
	@Test
	public void testObtener() {
		
		List<Dispositivo> dispositivos = null;
		
		try{
			dispositivos = dispositivoDao.obtener();
			
			for(Dispositivo dispositivo : dispositivos){
				System.out.println("Nombre: " + dispositivo.getNombre());
			}
			
			assertTrue(true);
		}catch(IWDaoException e){
			fail(e.getMessage());
		}
	}
	
	/**
	 * Metodo que permite insertar un dispositivo en la BD
	 */
	@Test
	public void testInsertar() {
		Dispositivo dispositivo=new Dispositivo();
		dispositivo.setEstadoDispositivo("Disponible");
		dispositivo.setIdDispositivo(12345);
		dispositivo.setNombre("Tableta");
		dispositivo.setValor(250000);
		
		try{
			dispositivoDao.insertar(dispositivo);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite actualizar un dispositivo
	 */
	@Test
	public void testModificar() {
		Dispositivo dispositivo=new Dispositivo();
		dispositivo.setEstadoDispositivo("Disponible");
		dispositivo.setIdDispositivo(123);
		dispositivo.setNombre("Microscopio4");
		dispositivo.setValor(200000);		
		try{
			dispositivoDao.modificar(dispositivo);
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite buscar un dispositivo por id
	 */
	@Test
	public void testObtenerId() {
		Dispositivo dispositivo;
				
		try{
			dispositivo= dispositivoDao.obtenerId(1234);
			System.out.println(dispositivo.getNombre());
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}
	
	/**
	 * Metodo que permite borrar un dispositivo
	 */
	@Test
	public void testEliminar() {	
				
		try{
			dispositivoDao.borrar(1234);			
			assertTrue(true);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}		
		
	}

}
