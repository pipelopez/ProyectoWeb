package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface con las firmas de los metodos que 
 * va a proveer el dao de prestamo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public interface PrestamoDAO {
	
	/**
	 * Firma del metodo que permite insertar un prestamo en la BD
	 * @param prestamo que se va a insertar en la BD
	 * @return prestamo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Prestamo insertar (Prestamo prestamo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite actualizar un prestamo en la BD
	 * @param prestamo que se va a actualizar en la BD
	 * @return prestamo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Prestamo modificar(Prestamo prestamo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite listar los prestamos que hay en la BD
	 * @return List<Prestamo> lista de prestamos hallados en la busqueda
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public List<Prestamo> obtener() throws IWDaoException;
	
	/**
	 * Firma del metodo que permite eliminar un prestamo en la BD
	 * @param prestamo que se va a eliminar en la BD
	 * @return prestamo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public void borrar (Integer idPrestamo) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite obtener un prestamo haciendo uso de su id
	 * @param idPrestamo que se va a buscar en la BD
	 * @return prestamo sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Prestamo obtenerId (Integer idPrestamo) throws IWDaoException;

}
