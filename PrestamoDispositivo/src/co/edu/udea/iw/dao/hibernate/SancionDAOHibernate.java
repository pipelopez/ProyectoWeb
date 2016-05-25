package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.SancionDAO;
import co.edu.udea.iw.dto.Sancion;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que implementa y sobreescribe 
 * los métodos del dao de Sancion
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class SancionDAOHibernate extends HibernateDaoSupport implements SancionDAO {
	
	/**
	 * Metodo que permite insertar una sancion en la BD
	 * @param sancion que se va a insertar en la BD
	 * @return una instancia de una sancion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	
	@Override
	public Sancion insertar(Sancion sancion) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(sancion);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return sancion;
	}
	
	/**
	 * Metodo que permite modificar una sancion en la BD
	 * @param sancion que se va a insertar en la BD
	 * @return una instancia de una sancion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Sancion modificar(Sancion sancion) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(sancion);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return sancion;
	}
	
	/**
	 * Metodo que permite obtener un listado de sanciones
	 * @return una lista de sanciones
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public List<Sancion> obtener() throws IWDaoException {
		List<Sancion> sanciones = new ArrayList<Sancion>();/**Lista que almacenara las sanciones*/
		Session session = null;/**Sesion del usuario*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Sancion.class);/**se crea el criterio para la consulta*/
			sanciones = criteria.list();/**se llevan las sanciones a la lista*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return sanciones;/**se retorna la lista*/
	}
	
	/**
	 * Metodo que permite eliminar una sancion en la BD
	 * @param sancion que se va a eliminar en la BD
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public void borrar(Integer idSancion) throws IWDaoException {
		Session session=null;
		Sancion sancion=null;		
		try {
			sancion=obtenerId(idSancion);
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.delete(sancion);
		} catch (HibernateException e) {
			throw new IWDaoException(e);
			}
	}

	
	/**
	 * Metodo que permite obtener una sancion por medio de su id
	 * @param idSancion de la sancion que se va a buscar en la BD
	 * @return una instancia de una sancion
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Sancion obtenerId(Integer idSancion) throws IWDaoException {
		Session session = null;
		Sancion sancion = null;
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			sancion = (Sancion)session.get(Sancion.class, idSancion);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return sancion;	
	}
}
