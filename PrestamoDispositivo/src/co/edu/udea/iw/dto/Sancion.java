package co.edu.udea.iw.dto;

/**
 * Clase dto para los datos de las sanciones
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class Sancion {
	
	/**
	 * id de la sancion
	 */
	private Integer idSancion;
	
	/**
	 * tipo de sancion
	 */
	private String tipoSancion;
	
	/**
	 * Prestamo asociado a la sancion
	 */
	private Prestamo prestamo;
	
	/**
	 * descripcion de la sancion
	 */
	private String descripcion;
	
	/**
	 * usuario que hace la sancion
	 */
	private Usuario usuarioSanciona;
	
	/**
	 * Metodo que retorna el id de una sancion
	 * @return idSancion
	 */
	public Integer getIdSancion() {
		return idSancion;
	}
	
	/**
	 * Metodo que permite asignar un id a la sancion
	 * @param idSancion es el identificador que se va a asignar a la sancion
	 */
	public void setIdSancion(Integer idSancion) {
		this.idSancion = idSancion;
	}
		
	/**
	 * Metodo que retorna el tipo de sancion
	 * @return tipoSancion
	 */
	public String getTipoSancion() {
		return tipoSancion;
	}
	
	/**
	 * Metodo que permite asignar un tipo de sancion
	 * @param tipoSancion que se va a asignar
	 */
	public void setTipoSancion(String tipoSancion) {
		this.tipoSancion = tipoSancion;
	}
		
	/**
	 * Metodo que retorna el prestamo asociado a una sancion
	 * @return prestamo
	 */
	public Prestamo getPrestamo() {
		return prestamo;
	}
	
	/**
	 * Metodo que permite asociar un prestamo a la sancion
	 * @param prestamo asociado a la sancion
	 */
	public void setPrestamo(Prestamo prestamo) {
		this.prestamo = prestamo;
	}
		
	/**
	 * Metodo que retorna la descripcion de una sancion
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	
	/**
	 * Metodo que permite asignar una descripcion a la sancion
	 * @param descripcion de la sancion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
		
	/**
	 * Metodo que retorna el usuario que crea la sancion
	 * @return usuarioSanciona
	 */
	public Usuario getUsuarioSanciona() {
		return usuarioSanciona;
	}
	
	/**
	 * Metodo que permite asignar el usuario que crea la sancion
	 * @param usuarioSanciona es el usuario que crea la sancion
	 */
	public void setUsuarioSanciona(Usuario usuarioSanciona) {
		this.usuarioSanciona = usuarioSanciona;
	}
	
}
