package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Actividad;
import datos.Producto;

public class ProductoDao extends MasterDao<Producto> {
	public List<Producto> traerTodosConDependencias() throws HibernateException {
		List<Producto> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Producto p").list();
			for(Producto p:lista){
				for(Actividad a:p.getEntradaDeActividades()){
					Hibernate.initialize(a.getGrupoActividad());
				}
				for(Actividad a:p.getSalidaDeActividades()){
					Hibernate.initialize(a.getGrupoActividad());
				}
				Hibernate.initialize(p.getSalidaDeActividades());
				Hibernate.initialize(p.getEntradaDeActividades());
			}

		} finally {
			session.close();
		}
		return lista;
	}
}
