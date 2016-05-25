package co.edu.udea.iw.dto;

/**
 * Clase dto para los datos de los dispositivos
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class Rol {
	

	/**
	 * id del rol
	 */
	private String idRol;
	

	/**
	 * nombre del rol
	 */
	private String nombre;
	
	/**
	 * Metodo que retorna el id de un rol
	 * @return idRol del dispositivo
	 */	
	public String getIdRol() {
		return idRol;
	}
	
	/**
	 * Metodo que permite asignar un id al rol
	 * @param idRiol
	 */
	public void setIdRol(String idRol) {
		this.idRol = idRol;
	}
	
	/**
	 * Metodo que retorna el nombre de un rol
	 * @return nombre del dispositivo
	 */	
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Metodo que permite asignar un nombre al rol
	 * @param nombre del rol
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
