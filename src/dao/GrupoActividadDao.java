package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.GrupoActividad;

public class GrupoActividadDao extends MasterDao<GrupoActividad> {
	@SuppressWarnings("unchecked")
	public List<GrupoActividad> traerTodosConDependencias() throws HibernateException {
		List<GrupoActividad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from GrupoActividad g").list();
			for(GrupoActividad g:lista){
				Hibernate.initialize(g.getActividades());
				Hibernate.initialize(g.getProceso());
			}

		} finally {
			session.close();
		}
		return lista;
	}

}
