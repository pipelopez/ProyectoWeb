package co.edu.udea.iw.dto;

import java.util.Date;

/**
 * Clase dto para los datos de los prestamos
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class Prestamo {

	/**
	 * id del prestamo
	 */
	private Integer idPrestamo;

	/**
	 * usuario que entrega el dispositivo
	 */
	private Usuario usuarioEntrega;

	/**
	 * hora de inicio del prestamo
	 */
	private Date horaInicio;

	/**
	 * hora de devolucion del prestamo
	 */
	private Date horaFin;

	/**
	 * identificador de la solicitud asociada al prestamo
	 */
	private Solicitud solicitud;
	
	/**
	 * Metodo que retorna el id del prestamo
	 * @return idPrestamo del prestamo
	 */	
	public Integer getIdPrestamo() {
		return idPrestamo;
	}
	
	/**
	 * Metodo que permite asignar el id del prestamo
	 * @param idPrestamo
	 */
	public void setIdPrestamo(Integer idPrestamo) {
		this.idPrestamo = idPrestamo;
	}
	
	/**
	 * Metodo que retorna el usuario que estrega el dispositivo
	 * @return usuarioEntrega el dispositivo
	 */	
	public Usuario getUsuarioEntrega() {
		return usuarioEntrega;
	}
	
	/**
	 * Metodo que permite asignar el usuario que entrega el dispositivo
	 * @param usuarioEntrega el dispositivo
	 */
	public void setUsuarioEntrega(Usuario usuarioEntrega) {
		this.usuarioEntrega = usuarioEntrega;
	}
	
	/**
	 * Metodo que retorna la hora de inicio del prestamo
	 * @return horaInicio del prestamo
	 */	
	public Date getHoraInicio() {
		return horaInicio;
	}
	
	/**
	 * Metodo que permite asignar la hora de inicio de un prestamo
	 * @param horaInicio del prestamo
	 */
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	
	/**
	 * Metodo que retorna la hora de fin del prestamo
	 * @return horaFin del prestamo
	 */	
	public Date getHoraFin() {
		return horaFin;
	}

	/**
	 * Metodo que permite asignar la hora de fin de un prestamo
	 * @param horaFin del prestamo
	 */
	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}
	
	/**
	 * Metodo que retorna la solicitud asociada al prestamo
	 * @return solicitud asociada al prestamo
	 */	
	public Solicitud getSolicitud() {
		return solicitud;
	}

	/**
	 * Metodo que permite asignar la solicitud asociada a un prestamo
	 * @param solicitud asociada a un prestamo
	 */
	public void setSolicitud(Solicitud solicitud) {
		this.solicitud = solicitud;
	}
	
}
