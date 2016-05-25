package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.SolicitudDAO;
import co.edu.udea.iw.dto.Persona;
import co.edu.udea.iw.dto.Solicitud;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que implementa y sobreescribe 
 * los métodos del dao de Persona
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class SolicitudDAOHibernate extends HibernateDaoSupport implements SolicitudDAO{
	
	/**
	 * Metodo que permite insertar una solicitud en la BD
	 * @param solicitud que se va a insertar en la BD
	 * @return una instancia de una solicitud
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Solicitud insertar(Solicitud solicitud) throws IWDaoException {
		Session session = null;/**Sesion del usuario*/
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			session.save(solicitud);/**Se guarda la persona en la sesion*/
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		return solicitud;/**Se retorna la solicitud*/
	}
	
	/**
	 * Metodo que permite actualizar una solicitud en la BD
	 * @param solicitud que se va a actualizar en la BD
	 * @return una instancia de una solicitud
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Solicitud modificar(Solicitud solicitud) throws IWDaoException {
		Session session = null;/**Sesion del usuario*/
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			session.update(solicitud);/**Se guarda la persona en la sesion*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return solicitud;/**Se retorna la solicitud*/
	}
	
	/**
	 * Metodo que permite obtener un listado de solicitudes
	 * @return una lista de solicitudes
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public List<Solicitud> obtener() throws IWDaoException {
		List<Solicitud> solicitudes = new ArrayList<Solicitud>();/**Lista que almacenara las solicitudes*/
		Session session = null;/**Sesion del usuario*/
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Solicitud.class);/**se crea el criterio para la consulta*/
			solicitudes = criteria.list();/**se llevan las solicitudes a la lista*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return solicitudes;/**Se retornan las solicitudes*/
	}
	
	/**
	 * Metodo que permite eliminar una solicitud en la BD
	 * @param solicitud que se va a eliminar en la BD
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public void borrar(Integer idSolicitud) throws IWDaoException {
		Session session=null;
		Solicitud solicitud=null;		
		try {
			solicitud=obtenerId(idSolicitud);
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.delete(solicitud);
		} catch (HibernateException e) {
			throw new IWDaoException(e);
			}
	}

	
	/**
	 * Metodo que permite obtener una solicitud por medio de su id
	 * @param idSolicitud que se va a buscar en la BD
	 * @return una instancia de una solicitud
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Solicitud obtenerId(Integer idSolicitud) throws IWDaoException {
		Solicitud solicitud = null;/**Solicitud que se retornara*/
		Session session = null;/**Sesion del usuario*/
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			solicitud = (Solicitud)session.get(Solicitud.class, idSolicitud);/**se busca la persona y se guarda en el objeto persona*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return solicitud;/**Se retorna la solicitud*/
	}

}
