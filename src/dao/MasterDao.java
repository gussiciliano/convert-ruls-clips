package dao;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.lang.reflect.ParameterizedType;

public abstract class MasterDao<T> {

	private Class<T> clasePersistente;
	protected static Session session;
	protected Transaction tx;

	@SuppressWarnings("unchecked")
	protected MasterDao() {
		this.clasePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Class<T> getClasePersistente() {
		return clasePersistente;
	}

	protected void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	protected void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	@SuppressWarnings("unchecked")
	public T traer(int idObjeto) throws HibernateException {
		T objeto = null;
		try {
			iniciaOperacion();
			objeto = (T) session.get(clasePersistente, idObjeto);
		} finally {
			session.close();
		}
		return objeto;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> traerTodos() throws HibernateException {
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from " + clasePersistente.getName()).list();

		} finally {
			session.close();
		}
		return lista;
	}

	// este debería ser abstracto, pero lo dejo así para no tener que estar obligado a implementarlo en todas 
	// las subclases de MasterDao
	public List<T> traerTodosConDependencias() throws HibernateException{
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> traerPorHQL(String hql) throws HibernateException {
		List<T> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from " + clasePersistente.getName() + " masterClass " + hql).list();
		} finally {
			session.close();
		}
		return lista;
	}

	public void eliminar(T objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}

	public int agregar(T objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = (int) session.save(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(T objeto) throws HibernateException {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;
		} finally {
			session.close();
		}
	}
}