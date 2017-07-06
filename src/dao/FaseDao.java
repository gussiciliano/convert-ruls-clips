package dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Actividad;
import datos.Fase;
import datos.FaseHasActividad;

public class FaseDao extends MasterDao<Fase> {
	
//	private int idFase;
//	private String nombre;
//	private String codigo;
//	private Set<FaseHasActividad> faseHasActividades;
	
	
	public List<Fase> traerTodosConDependencias() throws HibernateException {
		List<Fase> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Fase f order by f.idFase").list();
			for(Fase f:lista){
				for(FaseHasActividad fha:f.getFaseHasActividades()){
					Hibernate.initialize(fha.getActividad());
					Hibernate.initialize(fha.getActividad().getGrupoActividad());
					fha.getActividad().faseFinal();
					fha.getActividad().faseInicial();
					Hibernate.initialize(fha.getFase());
				}
			}

		} finally {
			session.close();
		}
		return lista;
	}

}
