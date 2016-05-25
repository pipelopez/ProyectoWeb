package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.IWDaoException;

/**
 * Clase que implementa y sobreescribe 
 * los métodos del dao de Usuario
 * @author Felipe Lopez
 * @author Daniel Alvarez
 * @author Julian Trujillo
 * @version 2016/05/07
 *
 */
public class UsuarioDAOHibernate extends HibernateDaoSupport implements UsuarioDAO {
	
	/**
	 * Metodo que permite insertar un usuario en la BD
	 * @param usuario que se va a insertar en la BD
	 * @return una instancia de un usuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Usuario insertar(Usuario usuario) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.save(usuario);
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		return usuario;
	}
	
	/**
	 * Metodo que permite modificar un usuario en la BD
	 * @param usuario que se va a modificar en la BD
	 * @return una instancia de un usuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Usuario modificar(Usuario usuario) throws IWDaoException {
		Session session = null;
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			
			session.update(usuario);
			
		}catch(HibernateException e){
			throw new IWDaoException(e);
		}
		
		return usuario;
	}
	
	/**
	 * Metodo que permite insertar un usuario en la BD
	 * @param usuario que se va a insertar en la BD
	 * @return una instancia de un usuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public List<Usuario> obtener() throws IWDaoException {
		List<Usuario> usuarios = new ArrayList<Usuario>();/**Lista que almacenara los usuarios*/
		Session session = null;/**Sesion del usuario*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Usuario.class);/**se crea el criterio para la consulta*/
			usuarios = criteria.list();/**se llevan los usuarios a la lista*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return usuarios;/**se retorna la lista*/
	}
	
	/**
	 * Metodo que permite eliminar un usuario en la BD
	 * @param usuario que se va a eliminar en la BD
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public void borrar(String login) throws IWDaoException {
		Session session=null;
		Usuario usuario =null;
		try {
			usuario =obtenerLogin(login);
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.delete(usuario);
		} catch (HibernateException e) {
			throw new IWDaoException(e);
			}
	}

	
	/**
	 * Metodo que permite obtener un usuario por medio de su login
	 * @param login que se va a buscar en la BD
	 * @return una instancia de un usuario
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Usuario obtenerLogin(String login) throws IWDaoException {
		
		Session session = null;/**Usuario que se retornara*/
		Usuario usuario = null;/**Sesion del usuario*/
		
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			usuario = (Usuario)session.get(Usuario.class, login);/**se busca el usuario y se guarda*/
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return usuario;/**Se retorna el usuario*/
	}

}
