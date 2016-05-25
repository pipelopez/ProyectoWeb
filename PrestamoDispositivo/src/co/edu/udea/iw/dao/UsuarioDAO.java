package co.edu.udea.iw.dao;

import java.util.List;

import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Interface con las firmas de los metodos  que 
 * va a proveer el dao de usuario
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public interface UsuarioDAO {
	
	/**
	 * Firma del metodo que permite insertar un usuario en la BD
	 * @param usuario que se va a insertar en la BD
	 * @return usuario sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Usuario insertar (Usuario usuario) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite actualizar un usuario en la BD
	 * @param usuario que se va a actualizar en la BD
	 * @return usuario sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Usuario modificar (Usuario usuario) throws IWDaoException;
	
	/**
	 * Firma del metodo que permite listar los usuarios que hay en la BD
	 * @return List<Usuario> lista de usuarios hallados en la busqueda
	 * @return usuario sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public List<Usuario> obtener() throws IWDaoException;
	
	/**
	 * Firma del metodo que permite eliminar un usuario en la BD
	 * @param usuario que se va a eliminar en la BD
	 * @return usuario sobre el cual se ejecuta la accion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public void borrar (String usuario) throws IWDaoException;
	
	/**
	 * Entrega los datos de un usuario dado su login
	 * @param login del usuario a consultar
	 * @return una instancia de los datos del usuario obtenido, si no existe
	 * un usuario con el login dado retorna null
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	public Usuario obtenerLogin (String login) throws IWDaoException;

}
