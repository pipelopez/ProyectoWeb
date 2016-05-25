package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

@Transactional
public class PrestamoService {
	

	/**
	 * dao de solicitud
	 */
	private SolicitudDAO solicitudDAO;

	/**
	 * dao de prestamo
	 */
	private PrestamoDAO prestamoDAO;

	/**
	 * dao de usuario
	 */
	private UsuarioDAO usuarioDAO;
	

	/**
	 * Metodo que permite guardar un Prestamo en la BD
	 * @param idPrestamo
	 * @param usuarioEntrega el dispositivo
	 * @param horaInicio del prestamo
	 * @param horaFin del prestamo
	 * @param solicitud del prestamo
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void guardarPrestamo(Integer idPrestamo , String usuarioEntrega, Date horaInicio, 
			Date horaFin,Integer idSolicitud) throws IWDaoException, IWServiceException{
		
		Prestamo prestamo=null;
		
		String strIdS=Integer.toString(idSolicitud);
		if(Validaciones.isTextoVacio(strIdS)){
			throw new IWServiceException("El id del Prestamo no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioEntrega)){
			throw new IWServiceException("El usuario que entrega el prestamo no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		Solicitud solicitud=solicitudDAO.obtenerId(idSolicitud);
		if(solicitud== null){
			throw new IWServiceException("La solicitud del prestamo no existe");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuarioEntrega);
		if(usuarioP == null){
			throw new IWServiceException("El usuario de la persona que entregara el prestamo  debe ser un usuario del sistema");
		}	
		Prestamo prestamoP= prestamoDAO.obtenerId(idPrestamo);
		if(prestamoP != null){
			throw new IWServiceException("El prestamo ya existema en el sistema");
		}	
		if(usuarioP.getRol().getNombre().equals("Investigador")){
			throw new IWServiceException("El usuario de la persona que entregara el prestamo  debe ser un administrador");
		}
		prestamo = new Prestamo();	
		prestamo.setHoraFin(horaFin);
		prestamo.setHoraInicio(horaInicio);
		prestamo.setIdPrestamo(idPrestamo);
		prestamo.setSolicitud(solicitud);
		prestamo.setUsuarioEntrega(usuarioP);
	
		prestamoDAO.insertar(prestamo);
		
	}

	/**
	 * Metodo que permite modificar un Prestamo en la BD
	 * @param idPrestamo
	 * @param usuarioEntrega el dispositivo
	 * @param horaInicio del prestamo
	 * @param horaFin del prestamo
	 * @param solicitud del prestamo
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void modificarPrestamo (Integer idPrestamo , String usuarioEntrega, Date horaInicio, 
			Date horaFin,Integer idSolicitud) throws IWDaoException, IWServiceException{
		
		Prestamo prestamo=null;
		
		String strIdS=Integer.toString(idSolicitud);
		if(Validaciones.isTextoVacio(strIdS)){
			throw new IWServiceException("El id del Prestamo no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioEntrega)){
			throw new IWServiceException("El usuario que entrega el prestamo no puede ser nulo, ni una cadena de caracteres vacia");
		}
			
		String strIdD=Integer.toString(idSolicitud);		
		if(Validaciones.isTextoVacio(strIdD)){
			throw new IWServiceException("El id de la solicitud asociada no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		Solicitud solicitud=solicitudDAO.obtenerId(idSolicitud);
		if(solicitud== null){
			throw new IWServiceException("La solicitud del prestamo no existe");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuarioEntrega);
		if(usuarioP == null){
			throw new IWServiceException("El usuario de la persona que entregara el prestamo  debe ser un usuario del sistema");
		}	
			
		prestamo=prestamoDAO.obtenerId(idPrestamo);
		if(prestamo == null){
			throw new IWServiceException("El prestamo no exite");
		}
		
		prestamo.setHoraFin(horaFin);
		prestamo.setHoraInicio(horaInicio);
		prestamo.setIdPrestamo(idPrestamo);
		prestamo.setSolicitud(solicitud);
		prestamo.setUsuarioEntrega(usuarioP);
	
		prestamoDAO.insertar(prestamo);
		
	}
	
	public void eliminarPrestamo(Integer idPrestamo) throws IWDaoException, IWServiceException{
		
		Prestamo prestamo=null;
		
		String strId=Integer.toString(idPrestamo);
		if(Validaciones.isTextoVacio(strId)){
			throw new IWServiceException("El id del prestamo no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		prestamo = prestamoDAO.obtenerId(idPrestamo);		
		if(prestamo == null){
			throw new IWServiceException("El la solicitud a eliminar no existe en el sistema");
		}
		
		prestamoDAO.borrar(idPrestamo);
	}
	

	/**
	 * Metodo que permite obtener una lista de prestamos
	 * @return lista de prestamos
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public List<Prestamo> obtener() throws IWDaoException{
		return prestamoDAO.obtener();
	}

	/**
	 * Metodo que permite buscar un prestamo por medio su id
	 * @param id del prestamo
	 * @return prestamo
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public Prestamo obtenerId(Integer idPrestamo) throws IWDaoException, IWServiceException{
		String strId=Integer.toString(idPrestamo);
		if(idPrestamo == null && "".equals(strId)){
			throw new IWServiceException("El id de la soliitud a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return prestamoDAO.obtenerId(idPrestamo);
	}

	//Getters and setters para los DAO
	public SolicitudDAO getSolicitudDAO() {
		return solicitudDAO;
	}

	public void setSolicitudDAO(SolicitudDAO solicitudDAO) {
		this.solicitudDAO = solicitudDAO;
	}

	public PrestamoDAO getPrestamoDAO() {
		return prestamoDAO;
	}

	public void setPrestamoDAO(PrestamoDAO prestamoDAO) {
		this.prestamoDAO = prestamoDAO;
	}

	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}



}
