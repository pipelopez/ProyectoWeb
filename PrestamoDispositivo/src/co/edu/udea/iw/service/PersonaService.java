package co.edu.udea.iw.service;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;
import co.edu.udea.iw.exception.IWServiceException;
import co.edu.udea.iw.util.validations.Validaciones;

/**
 * Clase que permite realizar las 
 * operaciones sobre la persona
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@Transactional
public class PersonaService {
	
	/**
	 * dao de persona
	 */
	private PersonaDAO personaDAO;
	
	/**
	 * dao de usuario
	 */
	private UsuarioDAO usuarioDAO;
	
	/**
	 * Metodo que permite guardar una persona en la BD
	 * @param cedula de la persona
	 * @param nombres de la persona
	 * @param apellidos de la persona
	 * @param correo de la persona
	 * @param telefono de la persona
	 * @param usuario de la persona
	 * @param usuarioCrea 
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void guardarPersona(String cedula, String nombres, String apellidos, 
			String correo, String telefono,String usuario, String usuarioCrea) throws IWDaoException, IWServiceException{
		
		Persona persona = null;/**persona que se va a guardar*/
		
		if(Validaciones.isTextoVacio(cedula)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La cedula de la persona no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("Los nombres de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("Los apellidos de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correo)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El correo electronico de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(telefono)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El telefono de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuario)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioCrea)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario que crea a la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(!Validaciones.isEmail(correo)){/**Valida que el parametro sea valido*/
			throw new IWServiceException("El correo electronico de la persona debe ser valido");
		}
		
		if(personaDAO.obtenerCedula(cedula) != null){/**Valida que el parametro no exista en la BD*/
			throw new IWServiceException("Ya existe una persona con cedula " + cedula +  " en el sistema");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuario);
		if(usuarioP == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario de la persona debe ser un usuario del sistema");
		}
		
		Usuario usuarioC = usuarioDAO.obtenerLogin(usuarioCrea);
		if(usuarioC == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que crea a la persona debe ser un usuario del sistema");
		}
		
		persona = new Persona();/**Se crea una nueva persona*/
		/**Se le asignan los atributos a la persona*/
		persona.setCedula(cedula);
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		persona.setUsuario(usuarioP);
		persona.setUsuarioCrea(usuarioC);
		persona.setFechaCreacion(new Date());
		persona.setEliminado(Boolean.FALSE);
		
		personaDAO.insertar(persona);/**Se inserta la persona*/
		
	}
	
	/**
	 * Metodo que permite modificar una persona en la BD
	 * @param cedula de la persona
	 * @param nombres de la persona
	 * @param apellidos de la persona
	 * @param correo de la persona
	 * @param telefono de la persona
	 * @param usuario de la persona
	 * @param usuarioCrea 
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void actualizarPersona(String cedula, String nombres, String apellidos, 
			String correo, String telefono, String usuario, String usuarioModifica) throws IWDaoException, IWServiceException{
		
		Persona persona = null;/**persona que se va a modificar*/
		
		if(Validaciones.isTextoVacio(cedula)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La cédula de la persona no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(nombres)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("Los nombres de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(apellidos)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("Los apellidos de la persona no pueden ser nulos, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(correo)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El correo electrónico de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(telefono)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El teléfono de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuario)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario de la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioModifica)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario que modifica a la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		if(!Validaciones.isEmail(correo)){/**Valida que el parametro sea valido*/
			throw new IWServiceException("El correo electrónico de la persona debe ser válido");
		}
		
		Usuario usuarioP = usuarioDAO.obtenerLogin(usuario);
		if(usuarioP == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario de la persona debe ser un usuario del sistema");
		}
		Usuario usuarioM = usuarioDAO.obtenerLogin(usuarioModifica);
		if(usuarioM == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que modifica a la Persona debe ser un usuario del sistema");
		}
		
		persona = personaDAO.obtenerCedula(cedula);
		
		if(persona == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("La persona a modificar no existe en el sistema");
		}
		
		/**Se le asignan los atributos a la persona*/
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		persona.setCorreo(correo);
		persona.setTelefono(telefono);
		persona.setUsuario(usuarioP);
		persona.setUsuarioModifica(usuarioM);
		persona.setFechaModificacion(new Date());
		
		personaDAO.modificar(persona);/**Se actualiza la persona*/
		
	}
	
	/**
	 * Metodo que permite modificar (eliminar) una persona en la BD
	 * @param cedula de la persona
	 * @param usuarioElimina la persona
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public void eliminarPersona(String cedula, String usuarioElimina) throws IWDaoException, IWServiceException{
		
		Persona persona = null;/**persona que se va a eliminar*/
		
		if(Validaciones.isTextoVacio(cedula)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La cédula del persona no puede ser nula, ni una cadena de caracteres vacia");
		}
		if(Validaciones.isTextoVacio(usuarioElimina)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("El usuario que elimina a la persona no puede ser nulo, ni una cadena de caracteres vacia");
		}
		
		Usuario usuarioE = usuarioDAO.obtenerLogin(usuarioElimina);
		if(usuarioE == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("El usuario que elimina a la Persona debe ser un usuario del sistema");
		}
		
		persona = personaDAO.obtenerCedula(cedula);
		
		if(persona == null){/**Valida que el usuario exista en el sistema*/
			throw new IWServiceException("La persona a eliminar no existe en el sistema");
		}
		
		/**Se le asignan los atributos a la persona*/
		persona.setEliminado(Boolean.TRUE);
		persona.setUsuarioElimina(usuarioE);
		persona.setFechaEliminacion(new Date());
		
		personaDAO.modificar(persona);/**Se actualiza la persona*/
		
	}
	
	
	/**
	 * Metodo que permite obtener una lista de personas
	 * @return lista de personas
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public List<Persona> obtener() throws IWDaoException{
		return personaDAO.obtener();
	}
	
	/**
	 * Metodo que permite buscar una persona por medio de la cedula
	 * @param cedula de la persona
	 * @return una persona
	 * @throws IWDaoException ocurre un error con la base de datos
	 * @throws IWServiceException ocurre un error
	 */
	public Persona obtenerCedula(String cedula) throws IWDaoException, IWServiceException{
		if(cedula == null && "".equals(cedula)){/**Valida que el parametro no sea nulo*/
			throw new IWServiceException("La cedula de la persona a buscar no puede ser nula, ni una cadena de caracteres vacia");
		}
		
		return personaDAO.obtenerCedula(cedula);/**Retorna la persona*/
	}
	
	/**Getters and Setters de personaDAO y usuarioDAO*/
	public PersonaDAO getPersonaDAO() {
		return personaDAO;
	}


	public void setPersonaDAO(PersonaDAO personaDAO) {
		this.personaDAO = personaDAO;
	}


	public UsuarioDAO getUsuarioDAO() {
		return usuarioDAO;
	}


	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

}
