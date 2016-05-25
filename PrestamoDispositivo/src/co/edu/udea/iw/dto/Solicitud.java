package co.edu.udea.iw.dto;

/**
 * Clase dto para los datos de la solicitud
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class Solicitud {
	
	/**
	 * id de la solicitud
	 */
	private Integer idSolicitud;
	
	/**
	 * usuario que hace la solicitud
	 */
	private Usuario usuarioSolicita;
	
	/**
	 * usuario que aprueba la solicitud
	 */
	private Usuario usuarioAprueba;
	
	/**
	 * dispositivo asociado a la solicitud
	 */
	private Dispositivo dispositivo;
	
	/**
	 * estado de la solicitud
	 */
	private String estadoSolicitud;
	
	/**
	 * Metodo que retorna el id de una solicitud
	 * @return idSolicitud 
	 */
	public Integer getIdSolicitud() {
		return idSolicitud;
	}
	
	/**
	 * Metodo que permite asignar un id a la solicitud
	 * @param idSolicitud es el identificador que se va a asignar a la solicitud
	 */
	public void setIdSolicitud(Integer idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	
	/**
	 * Metodo que retorna el usuario que hace la solicitud
	 * @return usuarioSolita el prestamo 
	 */
	public Usuario getUsuarioSolicita() {
		return usuarioSolicita;
	}
	
	/**
	 * Metodo que permite asociar el usuario que realiza la solicitud
	 * @param usuarioSolita un dispositivo en prestamo
	 */
	public void setUsuarioSolicita(Usuario usuarioSolicita) {
		this.usuarioSolicita = usuarioSolicita;
	}
	
	/**
	 * Metodo que retorna el usuario que aprueba la solicitud
	 * @return usuariAprueba la solicitud 
	 */
	public Usuario getUsuarioAprueba() {
		return usuarioAprueba;
	}
	
	/**
	 * Metodo que permite asociar el usuario que aprueba la solicitud
	 * @param usuarioAprueba la solicitud
	 */
	public void setUsuarioAprueba(Usuario usuarioAprueba) {
		this.usuarioAprueba = usuarioAprueba;
	}
	
	/**
	 * Metodo que retorna el dispositivo asociado a una solicitud
	 * @return dispositivo que se solicita en prestamo 
	 */
	public Dispositivo getDispositivo() {
		return dispositivo;
	}
	
	/**
	 * Metodo que permite asociar el dispositivo asociado a la solicitud
	 * @param dispositivo que se esta solicitando en prestamo
	 */
	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}
	
	/**
	 * Metodo que retorna el estado de la solicitud
	 * @return estadoSolicitud 
	 */
	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}
	
	/**
	 * Metodo que permite el estado de la solicitud
	 * @param estadoSolicitud 
	 */
	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}
	
}
