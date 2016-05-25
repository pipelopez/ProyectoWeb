package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Clase que permite realizar las 
 * operaciones sobre prestamo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class PrestamoServiceTest {
	
	@Autowired
	PrestamoService prestamoService;

	@Test
	public void testGuardarPrestamo() throws ParseException {
		Date date1=new Date();
		Date date2=new Date();
		try{
			prestamoService.guardarPrestamo(125,"jtrujillog", date1, date2 , 123);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarPrestamo() {
		Date date1=new Date();
		Date date2=new Date();
		try{
			prestamoService.modificarPrestamo(123, "jtrujillog", date1, date2, 123);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testEliminarPrestamo() {
		
		try{
			prestamoService.eliminarPrestamo(123);;
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testListarPrestamo() {
		
		try{
			prestamoService.obtener();
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testObtenerSolicitud() {		
						
			try{
			Prestamo presta;
			presta=prestamoService.obtenerId(123);
			System.out.println(presta.getUsuarioEntrega());
			
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
}
