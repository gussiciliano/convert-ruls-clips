package negocio;

import java.util.List;
import dao.MasterDao;
import java.lang.reflect.ParameterizedType;

public abstract class MasterABM<T> {

	@SuppressWarnings("unused")
	private Class<T> claseT;
	@SuppressWarnings("rawtypes")
	private MasterDao dao;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected MasterABM(MasterDao dao) {
		this.claseT = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.dao = dao;
	}

	@SuppressWarnings("rawtypes")
	public MasterDao getDao() {
		return dao;
	}

	@SuppressWarnings("unchecked")
	public T traer(int idMedicion){
		return (T) getDao().traer(idMedicion);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> traerTodos(){
		return (List<T>) getDao().traerTodos();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> traerPorHQL(String hql) {
		return (List<T>) getDao().traerPorHQL(hql);
	}

	@SuppressWarnings("unchecked")
	public void eliminar(T objeto) {
		getDao().eliminar(objeto);
	}

	@SuppressWarnings("unchecked")
	public int agregar(T objeto) {
		return getDao().agregar(objeto);
	}

	@SuppressWarnings("unchecked")
	public void actualizar(T objeto) {
		getDao().actualizar(objeto);
	}
}