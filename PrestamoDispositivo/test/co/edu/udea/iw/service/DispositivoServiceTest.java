package co.edu.udea.iw.service;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;

/**
 * Clase que permite realizar las 
 * operaciones sobre el service de dispositivo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion.xml")
public class DispositivoServiceTest {
	
	@Autowired
	DispositivoService dispositivoService;

	@Test
	public void testGuardarDispositivo() {
		
		try{
			dispositivoService.guardarDispositivo(125,"Probeta","Disponible",10000);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testActualizarDispositivo() {
		
		try{
			dispositivoService.actualizarDispositivo(123, "Probeta", "Prestamo", 10000);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testEliminarDispositivo() {
		
		try{
			dispositivoService.eliminarDispositivo(1234);
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testListarDispositivos() {
		List<Dispositivo> dispositivos = null;
		try{
			dispositivos=dispositivoService.obtener();
			for(Dispositivo dispositivo : dispositivos){
				System.out.println("Nombre: " + dispositivo.getNombre());
			}
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void testListarDispositivosDisponibles() {
		List<Dispositivo> dispositivos = null;
		try{			
			dispositivos=dispositivoService.obtenerDisponibles();
			for(Dispositivo dispositivo : dispositivos){
				System.out.println("Nombre: " + dispositivo.getNombre());
			}
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}

	
	@Test
	public void testObtenerDispositivo() {
		
		try{
			Dispositivo disp;
			disp=dispositivoService.obtenerId(1234);
			System.out.println(disp.getNombre());
			
		}catch(IWDaoException e){
			e.printStackTrace();
			fail(e.getMessage());
		}catch(IWServiceException e){
			e.printStackTrace();
			fail(e.getMessage());
		}	
	}
}
