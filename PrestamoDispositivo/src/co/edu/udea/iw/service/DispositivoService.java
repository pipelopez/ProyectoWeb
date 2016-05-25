package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;

import javax.xml.bind.ParseConversionEvent;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class DispositivoService {
	
	private DispositivoDAO dispositivoDAO;
	
	public void guardarDispositivo(Integer idDispositivo, String nombre, String estado, 
			 Integer valor) throws IWDaoException, IWServiceException{
		
		Dispositivo dispositivo = null;
		String strId=Integer.toString(idDispositivo);
		if(Validaciones.isTextoVacio(strId)){
			throw new IWServiceException("El id del dsipositivo no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new IWServiceException("El nombre del dispositivo no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(estado)){
			throw new IWServiceException("El estado del dispositivo no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		String strValor=Integer.toString(valor);
		if(Validaciones.isTextoVacio(strValor)){
			throw new IWServiceException("El correo electr�nico de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(dispositivoDAO.obtenerId(idDispositivo)!= null){
			throw new IWServiceException("Ya existe un dispositivo con id" + idDispositivo +  " en el sistema");
		}
		if (estado.equals("Disponible")||estado.equals("Prestamo")||estado.equals("Mantenimiento")) {			
		}else {
			throw new IWServiceException("El estado "+estado+ " no es valido");	
		}
		
		dispositivo = new Dispositivo();
		dispositivo.setEstadoDispositivo(estado);
		dispositivo.setIdDispositivo(idDispositivo);
		dispositivo.setNombre(nombre);
		dispositivo.setValor(valor);
		
	}
	
	public void actualizarDispositivo(Integer idDispositivo, String nombre, String estado, 
			Integer valor) throws IWDaoException, IWServiceException{
		
		Dispositivo dispositivo = null;
		
		String strId=Integer.toString(idDispositivo);
		if(Validaciones.isTextoVacio(strId)){
			throw new IWServiceException("El id del dsipositivo no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombre)){
			throw new IWServiceException("El nombre del dispositivo no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(estado)){
			throw new IWServiceException("El estado del dispositivo no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		String strValor=Integer.toString(valor);
		if(Validaciones.isTextoVacio(strValor)){
			throw new IWServiceException("El correo electr�nico de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if (estado.equals("Disponible")||estado.equals("Prestamo")||estado.equals("Mantenimiento")) {			
		}else {
			throw new IWServiceException("El estado "+estado+ " no es valido");	
		}
		dispositivo = dispositivoDAO.obtenerId(idDispositivo);
		if(dispositivo == null){
			throw new IWServiceException("El dispositivo no existe en el sistema");
		}		
		
		dispositivo.setIdDispositivo(idDispositivo); 
		dispositivo.setEstadoDispositivo(estado);
		dispositivo.setNombre(nombre);
		dispositivo.setValor(valor);
		
		dispositivoDAO.modificar(dispositivo);
		
	}
	
	public void eliminarDispositivo(Integer idDispositivo) throws IWDaoException, IWServiceException{
		
		Dispositivo dispositivo=null;
		
		String strId=Integer.toString(idDispositivo);
		if(Validaciones.isTextoVacio(strId)){
			throw new IWServiceException("El id del dipositivo no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		dispositivo = dispositivoDAO.obtenerId(idDispositivo);		
		if(dispositivo == null){
			throw new IWServiceException("El dispositivo a eliminar no existe en el sistema");
		}
		
		dispositivoDAO.borrar(idDispositivo);
		
	}
	
	
	public List<Dispositivo> obtener() throws IWDaoException{
		return dispositivoDAO.obtener();
	}
	
	public List<Dispositivo> obtenerDisponibles() throws IWDaoException{
		return dispositivoDAO.obtenerDisponibles();
	}
	
	public Dispositivo obtenerId(Integer idDispositivo) throws IWDaoException, IWServiceException{
		String strId=Integer.toString(idDispositivo);
		if(strId == null && "".equals(strId)){
			throw new IWServiceException("El id del dispositivo a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}		
		return dispositivoDAO.obtenerId(idDispositivo);
	}


	public DispositivoDAO getPersonaDAO() {
		return dispositivoDAO;
	}


	public void setDispositivoDAO(DispositivoDAO dispositivoDAO) {
		this.dispositivoDAO = dispositivoDAO;
	}


	
}
