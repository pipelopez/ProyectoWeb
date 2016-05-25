package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PrestamoDAO;
import co.edu.udea.iw.dto.Prestamo;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que impelementa y sobreescribe 
 * los métodos del dao de Prestamo
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class PrestamoDAOHibernate extends HibernateDaoSupport implements PrestamoDAO{
	
	/**
	 * Metodo que permite insertar un prestamo en la BD
	 * @param prestamo que se va a insertar en la BD
	 * @return una instancia de un prestamo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Prestamo insertar(Prestamo prestamo) throws IWDaoException {
		Session session = null;/**Sesion del usuario*/
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			session.save(prestamo);/**Se guarda el prestamo en la sesion*/
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/

		}
		return prestamo;/**Se retorna el prestamo*/
	}
	
	/**
	 * Metodo que permite modificar un prestamo en la BD
	 * @param prestamo que se va a modificar en la BD
	 * @return una instancia de un prestamo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Prestamo modificar(Prestamo prestamo) throws IWDaoException {
		
		Session session = null;/**Sesion del usuario*/
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			session.update(prestamo);/**Se actualiza el prestamo en la sesion*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return prestamo;/**Se retorna el prestamo*/
	}
	
	/**
	 * Metodo que permite obtener un listado de prestamos
	 * @return una lista de prestamos
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public List<Prestamo> obtener() throws IWDaoException {
		
		List<Prestamo> prestamos = new ArrayList<Prestamo>();/**Lista que almacenara los prestamos*/
		Session session = null;/**Sesion del usuario*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Prestamo.class);/**se crea el criterio para la consulta*/
			prestamos = criteria.list();/**se llevan las personas a la lista*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return prestamos;/**Se retorna el prestamo*/
	}
	
	/**
	 * Metodo que permite eliminar un prestamo en la BD
	 * @param prestamo que se va a eliminar en la BD
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	
	@Override
	public void borrar(Integer idPrestamo) throws IWDaoException {
		Session session=null;
		Prestamo prestamo=null;
		
		try {
			prestamo=obtenerId(idPrestamo);
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.delete(prestamo);
		} catch (HibernateException e) {
			throw new IWDaoException(e);
			}
	}
	
	/**
	 * Metodo que permite obetener un prestamo por medio de su id
	 * @param prestamo que se va a buscar en la BD
	 * @return una instancia de un prestamo
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Prestamo obtenerId(Integer idPrestamo) throws IWDaoException {
		
		Prestamo prestamo = null;/**Prestamo que se retornara*/
		Session session = null;/**Sesion del usuario*/
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			prestamo = (Prestamo)session.get(Prestamo.class, idPrestamo);/**se busca el prestamo y se guarda en el objeto prestamo*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return prestamo;/**Se retorna el prestamo*/
	}

}
