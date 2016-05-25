package co.edu.udea.iw.dto;

import java.util.Date;
/**
 * Clase dto para los datos de las personas
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class Persona {
	
	/**
	 * cedula de la persona
	 */
	private String cedula;
	
	/**
	 * nombres de la persona
	 */
	private String nombres;

	/**
	 * apellidos de la persona
	 */
	private String apellidos;

	/**
	 * correo de la persona
	 */
	private String correo;

	/**
	 * telefono de la persona
	 */
	private String telefono;

	/**
	 * usuario de la persona
	 */
	private Usuario usuario;

	/**
	 * usuario que crea el perfil de la persona
	 */
	private Usuario usuarioCrea;

	/**
	 * usuario que modifica el perfil de la persona
	 */
	private Usuario usuarioModifica;

	/**
	 * usuario que cambia el estado del perfil de la persona
	 */
	private Usuario usuarioElimina;

	/**
	 * fecha de creacion del perfil de la persona
	 */
	private Date fechaCreacion;

	/**
	 * fecha de modificacion del perfil de la persona
	 */
	private Date fechaModificacion;

	/**
	 * fecha de cambio de estado del perfil de la persona
	 */
	private Date fechaEliminacion;

	/**
	 * variable que especifica la actividad o inactividad del perfil de la persona
	 */
	private Boolean eliminado;
	

	/**
	 * Metodo que permite conocer la cedula de la persona
	 * @param cedula de la persona
	 */
	public String getCedula() {
		return cedula;
	}
	
	/**
	 * Metodo que permite asignar una cedula a la persona
	 * @param cedula que se le asignara a la persona
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	/**
	 * Metodo que permite conocer los nombres de la persona
	 * @param nombres de la persona
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Metodo que permite asignar los nombres a la persona
	 * @param nombres de la persona
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Metodo que permite conocer los apellidos de la persona
	 * @param apellidos de la persona
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * Metodo que permite asignar los apellidos de la persona
	 * @param apellidos de la persona
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * Metodo que permite conocer el correo de la persona
	 * @param correo de la persona
	 */
	public String getCorreo() {
		return correo;
	}
	
	/**
	 * Metodo que permite asignar el correo de la persona
	 * @param correo de la persona
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Metodo que permite conocer el telefono de la persona
	 * @param telefono de la persona
	 */
	public String getTelefono() {
		return telefono;
	}
	
	/**
	 * Metodo que permite asignar el telefono de la persona
	 * @param telefono de la persona
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Metodo que permite conocer el usuario de la persona
	 * @param usuario de la persona
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	
	/**
	 * Metodo que permite asignar el usuario de la persona
	 * @param usuario de la persona
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * Metodo que permite conocer el usuario que crea el perfil de la persona
	 * @param usuarioCrea perfil de la persona
	 */
	public Usuario getUsuarioCrea() {
		return usuarioCrea;
	}
	
	/**
	 * Metodo que permite asignar el usuario que crea el perfil de la persona
	 * @param usuarioCrea el perfil de la persona
	 */
	public void setUsuarioCrea(Usuario usuarioCrea) {
		this.usuarioCrea = usuarioCrea;
	}
	
	/**
	 * Metodo que permite conocer el usuario que modifica el perfil de la persona
	 * @param usuarioModifica perfil de la persona
	 */
	public Usuario getUsuarioModifica() {
		return usuarioModifica;
	}
	
	/**
	 * Metodo que permite asignar el usuario que modifica el perfil de la persona
	 * @param usuarioModifica el perfil de la persona
	 */
	public void setUsuarioModifica(Usuario usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}
	
	/**
	 * Metodo que permite conocer el usuario que cambia el estado del perfil de la persona
	 * @param usuarioElimina perfil de la persona
	 */
	public Usuario getUsuarioElimina() {
		return usuarioElimina;
	}
	
	/**
	 * Metodo que permite asignar los apellidos de la persona
	 * @param apellidos de la persona
	 */
	public void setUsuarioElimina(Usuario usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}
	
	/**
	 * Metodo que permite conocer la fecha de creacion de la persona
	 * @param fechaCreacion de la persona
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * Metodo que permite asignar la fecha de creacion del perfil de la persona
	 * @param fechaCreacion el perfil de la persona
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	/**
	 * Metodo que permite conocer la fecha de modificacion del perfil de la persona
	 * @param fechaModificacion del perfil de la persona
	 */
	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * Metodo que permite asignar la fecha de modificacion del perfil de la persona
	 * @param fechaModificacion del perfil de la persona
	 */
	public void setFechaModificacion(Date fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}
	
	/**
	 * Metodo que permite conocer la fecha de eliminacion del perfil de la persona
	 * @param fechaEliminacion del perfil de la persona
	 */
	public Date getFechaEliminacion() {
		return fechaEliminacion;
	}

	/**
	 * Metodo que permite asignar la fecha de cambio de estado del perfil de la persona
	 * @param fechaElimiancion del perfil de la persona
	 */
	public void setFechaEliminacion(Date fechaEliminacion) {
		this.fechaEliminacion = fechaEliminacion;
	}
	
	/**
	 * Metodo que permite conocer el estado del perfil de la persona
	 * @return eliminado del perfil de la persona
	 */
	public Boolean getEliminado() {
		return eliminado;
	}

	/**
	 * Metodo que permite asignar el estado del perfil de la persona
	 * @param eliminado del perfil de la persona
	 */
	public void setEliminado(Boolean eliminado) {
		this.eliminado = eliminado;
	}

}
