package co.edu.udea.iw.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que permite realizar las 
 * operaciones sobre el usuario
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@Transactional
public class UsuarioService {
	
	/**
	 * dao de persona
	 */
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Getter de usuarioDAO
	 * @return usuarioDao
	 */
	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}
	
	/**
	 * Setter de usuarioDAO
	 * @param usuarioDao
	 */
	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	/**
	 * Metodo que permite validar un usuario en la BD
	 * @param login del usuario
	 * @param contrasena del usuario
	 * @return true si el login y contraseña son validos, false de lo contrario
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public Boolean validar(String login, String contrasena) throws IWDaoException, IWServiceException{
		
		Cifrar cifrar = new Cifrar();/**Se crea un objeto para cifrar la contraseña*/
		
		if(Validaciones.isTextoVacio(login)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El login del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(Validaciones.isTextoVacio(contrasena)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La contraseña del usuario no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		Usuario usuario = usuarioDAO.obtenerLogin(login);
		if(usuario == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("Usuario o contraseña no válidos");
		}
				
		if(!cifrar.encrypt(contrasena).equals(usuario.getContrasena())){/**Se cifra la contraseña*/
			throw new IWServiceException("Usuario o contraseña no válidos");
		}
		
		
		return Boolean.TRUE;/**Se retorna el valor del booleano*/
	}
	
	/**
	 * Metodo que permite guardar un usuario en la BD
	 * @param login del usuario
	 * @param contrasena del usuario
	 * @param rol del usuario
	 * @param estadoUsuario 
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void guardarUsuario(String login, String contrasena, String rol, 
			String estadoUsuario) throws IWDaoException, IWServiceException{
		
		Usuario usuario = null;/**Se crea un usuario*/
		
		if(Validaciones.isTextoVacio(login)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El login del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(contrasena)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La contraseña del usuario no pueden ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(rol)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El rol del usuario no pueden ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(estadoUsuario)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El estado del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(usuarioDAO.obtenerLogin(login) != null){/**Valida que el parametro no exista en el sistema*/
			throw new IWServiceException("Ya existe una persona con login " + login +  " en el sistema");
		}
		
		if(contrasena.length()<8){/**Valida que el parametro no sea menor a 8 caracteres*/
			throw new IWServiceException("La contraseña del usuario debe ser de minimo 8 caracteres");
		}
		
		Rol rolUsuario= new Rol();/**Se crea un nuevo rol*/
		usuario = new Usuario();/**Se crea un nuevo usuario*/
		
		rolUsuario.setIdRol(rol);/**Se asigna el rol*/
		Cifrar cifrar=new Cifrar();
		contrasena = cifrar.encrypt(contrasena);
		/**Se asignan los parametros al usuario*/
		usuario.setLogin(login);
		usuario.setContrasena(contrasena);
		usuario.setRol(rolUsuario);
		usuario.setEstadoUsuario(estadoUsuario);
		
		usuarioDAO.insertar(usuario);/**se inserta el usuario*/	
	}
	
	/**
	 * Metodo que permite eliminar un usuario en la BD
	 * @param login del usuario 
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void eliminarUsuario(String login) throws IWDaoException, IWServiceException{
		
		Usuario usuario = null;/**Se crea un usuario*/
		
		if(Validaciones.isTextoVacio(login)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El login del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		usuario = usuarioDAO.obtenerLogin(login);
		if(usuario == null){/**Valida que el parametro exista en el sistema*/
			throw new IWServiceException("No existe un usaurio con login " + login +  " en el sistema");
		}
		
		usuarioDAO.borrar(login);/**se elimina el usuario*/	
	}
	
	/**
	 * Metodo que permite modificar la contrase�a de un usuario en la BD
	 * @param login del usuario
	 * @param contrasena del usuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void actualizarContrasena(String login, String contrasena,String nuevaContrasena) throws IWDaoException, IWServiceException{
		
		Usuario usuario = null;/**Se crea un usuario*/
		
		if(Validaciones.isTextoVacio(login)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El login del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(Validaciones.isTextoVacio(contrasena)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La contraseña del usuario no pueden ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nuevaContrasena)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La contraseña del usuario no pueden ser nula, ni una cadena de caracteres vacia");
		}
		usuario=usuarioDAO.obtenerLogin(login);
		if(usuario == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario a modificar no existe en el sistema");
		}

		Cifrar cifrar =new Cifrar();
		if(!cifrar.encrypt(contrasena).equals(usuario.getContrasena())){/**Se cifra la contraseña*/
			throw new IWServiceException("Usuario o contraseña no válidos");
		}
		contrasena = cifrar.encrypt(contrasena);
		nuevaContrasena = cifrar.encrypt(nuevaContrasena);
		
		/**Se le asignan los atributos al usuario*/
		usuario.setContrasena(contrasena);
		
		usuarioDAO.modificar(usuario);/**Se actualiza el usuario*/
		
	}
	
	/**
	 * Metodo que permite modificar el estado de un usuario en la BD
	 * @param login del usuario
	 * @param estadoUsuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void actualizarUsuario(String login, String estadoUsuario) throws IWDaoException, IWServiceException{
		
		Usuario usuario = null;/**Se crea un usuario*/
		
		if(Validaciones.isTextoVacio(login)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El login del usuario no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(Validaciones.isTextoVacio(estadoUsuario)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El estado del usuario no pueden ser nulo, ni una cadena de caracteres vacia");
		}
				
		if(usuarioDAO.obtenerLogin(login) == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario a modificar no existe en el sistema");
		}
		/**Se crea un nuevo usuario*/
		usuario=usuarioDAO.obtenerLogin(login);
		/**Se le asignan los atributos al usuario*/
		usuario.setEstadoUsuario(estadoUsuario);
		
		usuarioDAO.modificar(usuario);/**Se actualiza el usuario*/
		
	}
	
	/**
	 * Metodo que permite obtener una lista de usuarios
	 * @return lista de usuarios
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public List<Usuario> obtener() throws IWDaoException{
		return usuarioDAO.obtener();
	}
	
	/**
	 * Metodo que permite buscar un usuario por medio del login
	 * @param login del usuario
	 * @return un usuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public Usuario obtenerLogin(String login) throws IWDaoException, IWServiceException{
		if(login == null && "".equals(login)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El login del usuario a buscar no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		return usuarioDAO.obtenerLogin(login);/**Retorna el usuario*/
	}

}
