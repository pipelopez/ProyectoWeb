package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface con las firmas de los metodos que 
 * va a proveer el dao de solicitud
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public interface SolicitudDAO {
	
	/**
	 * Firma del metodo que permite insertar una solicitud en la BD
	 * @param solicitud que se va a insertar en la BD
	 * @return solicitud sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Solicitud insertar (Solicitud solicitud) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite actualizar una solicitud en la BD
	 * @param solicitud que se va a actualizar en la BD
	 * @return solicitud sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Solicitud modificar(Solicitud solicitud) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite listar las solicitudes que hay en la BD
	 * @return List<Solicitud> lista de solicitudes halladas en la busqueda
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public List<Solicitud> obtener() throws IWDaoException;
	
	/**
	 * Firma del metodo que permite eliminar una solicitud en la BD
	 * @param solicitud que se va a eliminar en la BD
	 * @return solicitud sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public void borrar (Integer idSolicitud) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite obtener una solicitud haciendo uso de su id
	 * @param idSsolicitud que se va a buscar en la BD
	 * @return solicitud sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Solicitud obtenerId (Integer idSolicitud) throws IWDaoException;

}
