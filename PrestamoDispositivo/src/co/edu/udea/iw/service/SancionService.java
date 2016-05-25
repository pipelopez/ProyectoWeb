package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dao.SancionDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.encode.Cifrar;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que permite realizar las 
 * operaciones sobre sanción
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@Transactional
public class SancionService {
	
	/**
	 * dao de sancion
	 */
	private SancionDAO sancionDAO;
	
	/**
	 * dao de prestamo
	 */
	private PrestamoDAO prestamoDAO;
	
	/**
	 * dao de usuario
	 */
	private UsuarioDAO usuarioDAO;
	
	/**Getters and Setters de sancionDAO, prestamoDAO y usuarioDAO*/
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

	public SancionDAO getSancionDAO() {
		return sancionDAO;
	}
	
	public void setSancionDAO(SancionDAO sancionDAO) {
		this.sancionDAO = sancionDAO;
	}
	
	/**
	 * Metodo que permite guardar una sancion en la BD
	 * @param idSancion de la sancion
	 * @param tipoSancion
	 * @param prestamo
	 * @param descripcion de la sancion
	 * @param usuarioSanciona
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void guardarSancion(Integer idSancion, String tipoSancion, Integer prestamo, 
			String descripcion, String usuarioSanciona) throws IWDaoException, IWServiceException{
		
		Sancion sancion = null;/**sancion que se va a guardar*/
		
		String stdId=Integer.toString(idSancion);
		if(Validaciones.isTextoVacio(stdId)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El id de la sancion no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(tipoSancion)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El tipo de la sancion no pueden ser nulo, ni una cadena de caracteres vacia");
		}
		
		String stdPre=Integer.toString(prestamo);
		if(Validaciones.isTextoVacio(stdPre)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El id del prestamo de la sancion no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(descripcion)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La descripcion de la sancion no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioSanciona)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario que sanciona no puede ser nulo, ni una cadena de caracteres vacia");
		}
			
		if(sancionDAO.obtenerId(idSancion) != null){/**Valida que el parametro no exista en la BD*/
			throw new IWServiceException("Ya existe una sancion con id " + idSancion +  " en el sistema");
		}
		
		Prestamo prestamoS = prestamoDAO.obtenerId(prestamo);
		if(prestamoS == null){/**Valida que el prestamo exista en el sistema*/
			throw new IWServiceException("El prestamo de la sancion debe ser un prestamo del sistema");
		}
		
		Usuario usuarioS = usuarioDAO.obtenerLogin(usuarioSanciona);
		if(usuarioS == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que sanciona a la persona debe ser un usuario del sistema");
		}
		if(usuarioS.getRol().getNombre().equals("Investigador")){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que sanciona a la persona debe tener el rol de Administrador");
		}
		
		
		sancion = new Sancion();/**Se crea una nueva sancion*/
		/**Se le asignan los atributos a la sancion*/
		sancion.setIdSancion(idSancion);
		sancion.setTipoSancion(tipoSancion);
		sancion.setPrestamo(prestamoS);
		sancion.setDescripcion(descripcion);
		sancion.setUsuarioSanciona(usuarioS);
		
		sancionDAO.insertar(sancion);/**Se inserta la sancion*/
		
	}
	
	/**
	 * Metodo que permite modificar una sancion en la BD
	 * @param idSancion de la sancion
	 * @param tipoSancion
	 * @param prestamo
	 * @param descripcion de la sancion
	 * @param usuarioSanciona
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void actualizarSancion(Integer idSancion, String tipoSancion, Integer prestamo, 
			String descripcion, String usuarioSanciona) throws IWDaoException, IWServiceException{
		
		Sancion sancion = null;/**sancion que se va a modificar*/
		
		String stdId=Integer.toString(idSancion);
		if(Validaciones.isTextoVacio(stdId)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El id de la sancion no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(tipoSancion)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El tipo de la sancion no pueden ser nulo, ni una cadena de caracteres vacia");
		}
		
		String stdPre=Integer.toString(prestamo);
		if(Validaciones.isTextoVacio(stdPre)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El id del prestamo de la sancion no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(descripcion)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La descripcion de la sancion no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioSanciona)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario que sanciona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		Prestamo prestamoS = prestamoDAO.obtenerId(prestamo);
		if(prestamoS == null){/**Valida que el prestamo exista en el sistema*/
			throw new IWServiceException("El prestamo de la sancion a modificar debe ser un prestamo del sistema");
		}
		
		Usuario usuarioS = usuarioDAO.obtenerLogin(usuarioSanciona);
		if(usuarioS == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que sanciona a modificar debe ser un usuario del sistema");
		}
		if(usuarioS.getRol().getNombre().equals("Investigador")){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que sanciona a la persona debe tener el rol de Administrador");
		}
		
		sancion = sancionDAO.obtenerId(idSancion);
		
		if(sancion == null){/**Valida que la sancion exista en el sistema*/
			throw new IWServiceException("La sancion a modificar no existe en el sistema");
		}
		
		/**Se le asignan los atributos a la sancion*/
		sancion.setTipoSancion(tipoSancion);
		sancion.setDescripcion(descripcion);
		sancion.setUsuarioSanciona(usuarioS);
		
		sancionDAO.modificar(sancion);/**Se actualiza la sancion*/
		
	}
	
	/**
	 * Metodo que permite eliminar una sancion en la BD
	 * @param idSancion de la sancion
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void eliminarSancion(Integer idSancion) throws IWDaoException, IWServiceException{
		
		Sancion sancion = null;/**sancion que se va a eliminar*/
		
		String stdId=Integer.toString(idSancion);
		if(Validaciones.isTextoVacio(stdId)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El id de la sancion no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		sancion = sancionDAO.obtenerId(idSancion);
		
		if(sancion == null){/**Valida que la sancion exista en el sistema*/
			throw new IWServiceException("La sancion a eliminar no existe en el sistema");
		}
		
		
		sancionDAO.borrar(idSancion);;/**Se elimina la sancion*/
		
	}
	
	
	/**
	 * Metodo que permite obtener una lista de sanciones
	 * @return lista de sanciones
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public List<Sancion> obtener() throws IWDaoException{
		return sancionDAO.obtener();
	}
	
	/**
	 * Metodo que permite buscar una sancion por medio de su id
	 * @param idSancion de la sancion
	 * @return una sancion
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public Sancion obtenerSancion(Integer idSancion) throws IWDaoException, IWServiceException{
		String strId=Integer.toString(idSancion);
		if(strId == null && "".equals(strId)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La cedula de la persona a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return sancionDAO.obtenerId(idSancion);/**Retorna la Sancion*/
		
	}
}
