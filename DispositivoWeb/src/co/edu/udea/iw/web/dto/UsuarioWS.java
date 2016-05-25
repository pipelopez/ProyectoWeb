package co.edu.udea.iw.web.dto;

import javax.xml.bind.annotation.XmlRootElement;

import co.edu.udea.iw.dto.Rol;

/**
 * Clase dto para los datos de los usuarios
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
@XmlRootElement
public class UsuarioWS {
	
	
	
	public UsuarioWS() {}

	/**
	 * login del usuario
	 */
	private String login;
	
	/**
	 * contraseña del usuario
	 */
	private String contrasena;
	
	/**
	 * rol del usuario
	 */
	private Rol rol;
	
	/**
	 * estado del usuario
	 */
	private String estadoUsuario;
	
	/**
	 * Metodo que retorna el login del usuario
	 * @return login del usuario
	 */
	public String getLogin() {
		return login;
	}
	
	/**
	 * Metodo que permite asignar un login al usuario
	 * @param login que se asignara al usuario
	 */
	public void setLogin(String login) {
		this.login = login;
	}
	
	/**
	 * Metodo que retorna la contraseña del usuario
	 * @return contrasena del usuario
	 */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * Metodo que permite asignar la contraseña al usuario
	 * @param contrasena que se asignara al usuario
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	/**
	 * Metodo que retorna el rol del usuario
	 * @return rol del usuario
	 */
	public Rol getRol() {
		return rol;
	}
	
	/**
	 * Metodo que permite asignar un rol al usuario
	 * @param rol que se asignara al usuario
	 */
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	/**
	 * Metodo que retorna el estado del usuario
	 * @return estadoUsuario
	 */
	public String getEstadoUsuario() {
		return estadoUsuario;
	}
	
	/**
	 * Metodo que permite cambiar el estado del usuario
	 * @param estadoUsuario
	 */
	public void setEstadoUsuario(String estadoUsuario) {
		this.estadoUsuario = estadoUsuario;
	}
	
}