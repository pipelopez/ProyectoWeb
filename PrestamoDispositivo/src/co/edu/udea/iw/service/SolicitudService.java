package co.edu.udea.iw.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que permite realizar las 
 * operaciones sobre la solicitud
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@Transactional
public class SolicitudService {
	
	private SolicitudDAO solicitudDAO;
	private DispositivoDAO dispositivoDAO;
	private UsuarioDAO usuarioDAO;
	
	
	public void guardarSolicitud(Integer idSolicitud , String usuarioSolicita, String usuarioAprueba, 
			Integer idDispositivo, String estadoSolicitud) throws IWDaoException, IWServiceException{
		
		Solicitud solicitud=null;
		
		String strIdS=Integer.toString(idSolicitud);
		if(Validaciones.isTextoVacio(strIdS)){
			throw new IWServiceException("El id de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioSolicita)){
			throw new IWServiceException("El usuario que solicita no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioAprueba)){
			throw new IWServiceException("El usuario que aprueba no pueden ser nulos, ni una cadena de caracteres vacia");
		}		
		String strIdD=Integer.toString(idDispositivo);		
		if(Validaciones.isTextoVacio(strIdD)){
			throw new IWServiceException("El id del dispositivo no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(estadoSolicitud)){
			throw new IWServiceException("El estado de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(solicitudDAO.obtenerId(idSolicitud)!= null){
			throw new IWServiceException("Ya existe una solicitud con id " + idSolicitud +  " en el sistema");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuarioSolicita);
		if(usuarioP == null){
			throw new IWServiceException("El usuario que aprueba la solicitud debe ser un usuario del sistema");
		}
		
		Usuario usuarioC = usuarioDAO.obtenerLogin(usuarioAprueba);
		if(usuarioC == null){
			throw new IWServiceException("El usuario que de la persona que realizo la solicitud debe ser un usuario del sistema");
		}
		if (estadoSolicitud.equals("Aprobado")||estadoSolicitud.equals("Rechazado")||estadoSolicitud.equals("Espera")) {			
		}else {
			throw new IWServiceException("El estado "+estadoSolicitud+ " no es valido");	
		}	
		Dispositivo dispositivoP = dispositivoDAO.obtenerId(idDispositivo);
		if(dispositivoP == null){
			throw new IWServiceException("El dispositivo de la solicitud que realizo debe ser un dispositivo del sistema");
		}
		if (usuarioC.getRol().getNombre().equals("Investigador")) {
			throw new IWServiceException("El usuario debe tener el rol de investigador");
		}
		if (usuarioP.getRol().getNombre().equals("Administrador")) {
			throw new IWServiceException("El usuario que aprueba la solicitud debe tener el rol de administrador");
		}
		solicitud = new Solicitud();		
		solicitud.setIdSolicitud(idSolicitud);
		solicitud.setEstadoSolicitud(estadoSolicitud);
		solicitud.setUsuarioSolicita(usuarioP);
		solicitud.setUsuarioAprueba(usuarioC);
		solicitud.setDispositivo(dispositivoP);
		
		solicitudDAO.insertar(solicitud);
		
	}
	
	public void actualizarSolicitud(Integer idSolicitud , String usuarioSolicita, String usuarioAprueba, 
			Integer idDispositivo, String estadoSolicitud) throws IWDaoException, IWServiceException{
		
		Solicitud solicitud=null;
		
		String strIdS=Integer.toString(idSolicitud);
		if(Validaciones.isTextoVacio(strIdS)){
			throw new IWServiceException("El id de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioSolicita)){
			throw new IWServiceException("El usuario que solicita no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioAprueba)){
			throw new IWServiceException("El usuario que aprueba no pueden ser nulos, ni una cadena de caracteres vacia");
		}		
		String strIdD=Integer.toString(idDispositivo);		
		if(Validaciones.isTextoVacio(strIdD)){
			throw new IWServiceException("El id del dispositivo no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(estadoSolicitud)){
			throw new IWServiceException("El estado de la solicitud no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuarioSolicita);
		if(usuarioP == null){
			throw new IWServiceException("El usuario de la persona que realizo la solicitud debe ser un usuario del sistema");
		}
		
		Usuario usuarioC = usuarioDAO.obtenerLogin(usuarioAprueba);
		if(usuarioC == null){
			throw new IWServiceException("El usuario que aprueba  la solicitud debe ser un usuario del sistema");
		}
		if (estadoSolicitud.equals("Aprobado")||estadoSolicitud.equals("Rechazado")||estadoSolicitud.equals("Espera")) {			
		}else {
			throw new IWServiceException("El estado "+estadoSolicitud+ " no es valido");	
		}	
		if(usuarioP.getRol().getNombre().equals("Administrador")){
			throw new IWServiceException("El usuario que realizo  la solicitud debe tener el rol de Investigador");
		}
		
		if(usuarioC.getRol().getNombre().equals("Investigador")){
			throw new IWServiceException("El usuario que acepta  la solicitud debe tener el rol de Adminstrador");
		}
		
		solicitud=solicitudDAO.obtenerId(idSolicitud);
		if (solicitud==null) {					
			throw new IWServiceException("La solicitud no existe");	
		}
		Dispositivo dispositivoP = dispositivoDAO.obtenerId(idDispositivo);
		if(dispositivoP == null){
			throw new IWServiceException("El dispositivo de la solicitud que realizo debe ser un dispositivo del sistema");
		}
				
		solicitud.setIdSolicitud(idSolicitud);
		solicitud.setEstadoSolicitud(estadoSolicitud);
		solicitud.setUsuarioSolicita(usuarioP);
		solicitud.setUsuarioAprueba(usuarioC);
		solicitud.setDispositivo(dispositivoP);
		
		solicitudDAO.modificar(solicitud);
		
	}
	
	public void eliminarSolicitud(Integer idSolicitud) throws IWDaoException, IWServiceException{
		
		Solicitud solicitud=null;
		
		String strId=Integer.toString(idSolicitud);
		if(Validaciones.isTextoVacio(strId)){
			throw new IWServiceException("El id de la solicitud no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		solicitud = solicitudDAO.obtenerId(idSolicitud);		
		if(solicitud == null){
			throw new IWServiceException("El la solicitud a eliminar no existe en el sistema");
		}
		
		solicitudDAO.borrar(idSolicitud);
		
	}
	
	
	public List<Solicitud> obtener() throws IWDaoException{
		return solicitudDAO.obtener();
	}
	
	public Solicitud obtenerId(Integer idSolicitud) throws IWDaoException, IWServiceException{
		String strId=Integer.toString(idSolicitud);
		if(idSolicitud == null && "".equals(strId)){
			throw new IWServiceException("El id de la soliitud a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return solicitudDAO.obtenerId(idSolicitud);
	}

	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	public DispositivoDAO getDispositivoDAO() {
		return dispositivoDAO;
	}

	public void setDispositivoDAO(DispositivoDAO dispositivoDAO) {
		this.dispositivoDAO = dispositivoDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}


}
