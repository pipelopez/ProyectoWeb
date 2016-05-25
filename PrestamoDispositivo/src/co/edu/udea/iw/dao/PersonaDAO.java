package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface con las firmas de los metodos que 
 * va a proveer el dao de persona
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public interface PersonaDAO {
	
	/**
	 * Firma del metodo que permite insertar una persona en la BD
	 * @param persona que se va a insertar en la BD
	 * @return persona sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Persona insertar (Persona persona) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite actualizar una persona en la BD
	 * @param persona que se va a actualizar en la BD
	 * @return persona sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Persona modificar (Persona persona) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite listar las personas que hay en la BD
	 * @return List<Persona> lista de personas hallados en la busqueda
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public List<Persona> obtener() throws IWDaoException;
	
	/**
	 * Firma del metodo que permite eliminar una persona en la BD
	 * @param persona que se va a eliminar en la BD
	 * @return persona sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public void borrar (String cedula) throws IWDaoException;
	/**
	 * Firma del metodo que permite obtener una persona haciendo uso de su cedula
	 * @param cedula que se va a buscar en la BD
	 * @return persona sobre la cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Persona obtenerCedula (String cedula) throws IWDaoException;

}
