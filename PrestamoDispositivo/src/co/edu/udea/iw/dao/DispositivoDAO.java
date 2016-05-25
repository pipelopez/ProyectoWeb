package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface con las firmas de los metodos que que 
 * va a proveer el dao de dispositivo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public interface DispositivoDAO {
	
	/**
	 * Firma del metodo que permite insertar un dispositivo en la BD
	 * @param dispositivo que se va a insertar en la BD
	 * @return dispositivo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Dispositivo insertar (Dispositivo dispositivo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite actualizar un dispositivo en la BD
	 * @param dispositivo que se va a actualizar en la BD
	 * @return dispositivo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Dispositivo modificar (Dispositivo dispositivo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite listar los dispositivos que hay en la BD
	 * @return List<Dispositivo> lista de dispositivos hallados en la busqueda
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public List<Dispositivo> obtener() throws IWDaoException;
	public List<Dispositivo> obtenerDisponibles() throws IWDaoException;
	
	/**
	 * Firma del metodo que permite eliminar un dispositivo en la BD
	 * @return dispositivo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @param dispositivo que se va a eliminar en la BD
	 */
	public void borrar (Integer dispositivo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite obtener un dispositivo haciendo uso de su id
	 * @param idDispositivo que se va a buscar en la BD
	 * @return dispositivo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Dispositivo obtenerId (Integer idDispositivo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite obtener un dispositivo haciendo uso de su nombre
	 * @param nombre del dispositivo que se va a buscar en la BD
	 * @return dispositivo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Dispositivo obtenerNombre (String nombre) throws IWDaoException;

}
