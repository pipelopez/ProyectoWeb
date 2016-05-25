package co.edu.udea.iw.dto;

/**
 * Clase dto para los datos de los dispositivos
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class Dispositivo {
	

	/**
	 * id del dispositivo
	 */
	private Integer idDispositivo;

	/**
	 * nombre del dispositivo
	 */
	private String nombre;

	/**
	 * estado del dispositivo
	 */
	private String estadoDispositivo;

	/**
	 * valor del dispositivo
	 */
	private Integer valor;
	

	/**
	 * Metodo que retorna el id de un dispositivo
	 * @return id del dispositivo
	 */	
	public Integer getIdDispositivo() {
		return idDispositivo;
	}

	/**
	 * Metodo que permite asignar un id al dispositivo
	 * @param idDispositivo es el identificador que se va a asignar al dispositivo
	 */
	public void setIdDispositivo(Integer idDispositivo) {
		this.idDispositivo = idDispositivo;
	}

	/**
	 * Metodo que permite obtener el nombre de un dispositivo
	 * @return nombre del dispositivo
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Metodo que permite asignar un nombre al dispositivo
	 * @param nombre que se le asignara al dispositivo
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Metodo que permite obtener el estado de un dispositivo
	 * @return estado del dispositivo
	 */
	public String getEstadoDispositivo() {
		return estadoDispositivo;
	}

	/**
	 * Metodo que permite cambiar el estado de un dispostivo
	 * @param estadoDispositivo, es el nuevo estado que se asignara
	 */
	public void setEstadoDispositivo(String estadoDispositivo) {
		this.estadoDispositivo = estadoDispositivo;
	}

	/**
	 * Metodo para obtener el valor de un dispositivo
	 * @return valor del dispositivo
	 */
	public Integer getValor() {
		return valor;
	}

	/**
	 * Metodo que permite asignar un valor al dispositivo
	 * @param valor a asignar
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}
	
}
