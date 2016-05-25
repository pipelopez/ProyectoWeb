package co.edu.udea.iw.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import co.edu.udea.iw.dao.PersonaDAO;
import co.edu.udea.iw.dto.Persona;
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
public class PersonaDAOHibernate extends HibernateDaoSupport implements PersonaDAO {
	
	/**
	 * Metodo que permite insertar una persona en la BD
	 * @param persona que se va a insertar en la BD
	 * @return una instancia de una persona
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Persona insertar(Persona persona) throws IWDaoException {
		
		Session session = null;/**Sesion del usuario*/
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			session.save(persona);/**Se guarda la persona en la sesion*/
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		return persona;/**Se retorna la persona*/
	}
		
	/**
	 * Metodo que permite actualizar una persona en la BD
	 * @param persona que se va a actualizar en la BD
	 * @return una instancia de una persona
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Persona modificar(Persona persona) throws IWDaoException {
		
		Session session = null;/**Sesion del usuario*/
		try{
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			
			session.update(persona);/**Se actualiza la persona en la sesion*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return persona;/**Se retorna la persona*/
	}
		
	/**
	 * Metodo que permite obtener un listado de personas
	 * @return un listado de personas
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public List<Persona> obtener() throws IWDaoException {
		
		List<Persona> personas = new ArrayList<Persona>();/**Lista que almacenara las personas*/
		Session session = null;/**Sesion del usuario*/
		
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			Criteria criteria = session.createCriteria(Persona.class);/**se crea el criterio para la consulta*/
			personas = criteria.list();/**se llevan las personas a la lista*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return personas;/**se retorna la lista*/
	}
		
	/**
	 * Metodo que permite borrar una persona en la BD
	 * @param persona que se va a actualizar en la BD
	 * @return una instancia de una persona
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	
	@Override
	public void borrar(String cedula ) throws IWDaoException {
		Session session=null;
		Persona persona =null;
		
		try {
			persona=obtenerCedula(cedula);/**se obtine la persona con el metododo obtenercedula*/
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();
			session.delete(persona);/**se elimina la personaa selecionada*/
		} catch (HibernateException e) {
			throw new IWDaoException(e);
			}
		
	}
		
	/**
	 * Metodo que permite obtener una persona por su cedula
	 * @param cedyla que se va a buscar
	 * @return una instancia de una persona
	 * @throws IWDaoException ocurre un error con la base de datos
	 */
	@Override
	public Persona obtenerCedula(String cedula) throws IWDaoException {
		
		Persona persona = null;/**Persona que se retornara*/
		Session session = null;/**Sesion del usuario*/
		try{
			
			session = getHibernateTemplate().getSessionFactory().getCurrentSession();/** se obtiene la sesion*/
			persona = (Persona)session.get(Persona.class, cedula);/**se busca la persona y se guarda en el objeto persona*/
			
		}catch(HibernateException e){
			throw new IWDaoException(e);/**se captura la excepcion en caso de error*/
		}
		
		return persona;/**Se retorna la persona*/
	}

}
