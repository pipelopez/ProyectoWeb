package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.DispositivoDAO;
import co.edu.udea.iw.dto.Dispositivo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que impelementa y sobreescribe 
 * los métodos del dao de dispositivo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class DispositivoDAOHibernate extends HibernateDaoSupport implements DispositivoDAO{
	
	/**
	 * Metodo que permite insertar un dispositivo en la BD
	 * @param dispositivo que se va a insertar en la BD
	 * @return una instancia de un dispositivo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Dispositivo insertar(Dispositivo dispositivo) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(dispositivo);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return dispositivo;
	}
	
	/**
	 * Metodo que permite actualizar un dispositivo en la BD
	 * @param dispositivo que se va a actualizar en la BD
	 * @return una instancia de un dispositivo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Dispositivo modificar(Dispositivo dispositivo) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();			
			session.update(dispositivo);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return dispositivo;
		
	}

	
	/**
	 * Metodo que permite obtener un listado de dispositivos
	 * @return List<Dispositivo> lista de dispositivos hallados en la busqueda
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public List<Dispositivo> obtener() throws IWDaoException {

		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();/**Lista que almacena los dispositivos*/
		Session session = null;/**Sesion del usuario*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Dispositivo.class);/**se crea el criterio para la consulta*/
			dispositivos = criteria.list();/**se llevan los dispositivos a la lista*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return dispositivos;/**se retorna la lista*/
	}
	
	/**
	 * Metodo que permite borrar un dispositivo 
	 * @param dispositivo que se va a eliminar en la BD
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public void borrar(Integer idDispositivo) throws IWDaoException {
		Session session=null;
		Dispositivo dispositivo =null;
		try {
			dispositivo=obtenerId(idDispositivo);
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.delete(dispositivo);
		} catch (HibernateException e) {
			throw new IWDaoException(e);
			}		
		
	}
	
	/**
	 * Metodo que permite obtener un dispositivo haciendo uso de id
	 * @param dispositivo que se va a buscar en la BD
	 * @return una instancia de un dispositivo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Dispositivo obtenerId(Integer idDispositivo) throws IWDaoException {
		Session session = null;/**Sesion del usuario*/
		Dispositivo dispositivo = null;/**se crea un dispositivo*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/			
			dispositivo = (Dispositivo)session.get(Dispositivo.class, idDispositivo);/**se crea el criterio para la consulta*/
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return dispositivo;/**se retorna la lista*/
	}
	
	/**
	 * Metodo que permite obtener un dispositivo haciendo uso de su nombre
	 * @param dispositivo que se va a buscar en la BD
	 * @return una instancia de un dispositivo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Dispositivo obtenerNombre(String nombre) throws IWDaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dispositivo> obtenerDisponibles() throws IWDaoException {
		List<Dispositivo> dispositivos = new ArrayList<Dispositivo>();/**Lista que almacena los dispositivos*/

		List<Dispositivo> dispositivosDisponibles=new ArrayList<Dispositivo>();
		Session session = null;/**Sesion del usuario*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Dispositivo.class);/**se crea el criterio para la consulta*/
			dispositivos = criteria.list();/**se llevan los dispositivos a la lista*/
			
			for (int i = 0; i < dispositivos.size(); i++) {
				if (dispositivos.get(i).getEstadoDispositivo().equals("Disponible")) {
					dispositivosDisponibles.add(dispositivos.get(i));
				}
			}
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return dispositivosDisponibles;/**se retorna la lista*/
	}
	
}
