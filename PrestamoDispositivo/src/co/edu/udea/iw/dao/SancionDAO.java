package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface con las firmas de los metodos que 
 * va a proveer el dao de sancion
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public interface SancionDAO {
	
	/**
	 * Firma del metodo que permite insertar una sancion en la BD
	 * @param sancion que se va a insertar en la BD
	 * @return sancion sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Sancion insertar (Sancion sancion) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite actualizar una sancion en la BD
	 * @param sancion que se va a actualizar en la BD
	 * @return sancion sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Sancion modificar (Sancion sancion) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite listar las sanciones que hay en la BD
	 * @return List<Sancion> lista de sanciones hallados en la busqueda
	 * @return sancion sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public List<Sancion> obtener() throws IWDaoException;
	
	/**
	 * Firma del metodo que permite eliminar una sancion en la BD
	 * @param sancion que se va a eliminar en la BD
	 * @return sancion sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public void borrar (Integer idSancion) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite obtener una sancion haciendo uso de su id
	 * @param idSancion que se va a buscar en la BD
	 * @return sancion sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Sancion obtenerId (Integer idSancion) throws IWDaoException;

}
