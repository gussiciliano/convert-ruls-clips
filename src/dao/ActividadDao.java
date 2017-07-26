package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Actividad;
import datos.FaseHasActividad;
import datos.Producto;

public class ActividadDao extends MasterDao<Actividad> {

	@SuppressWarnings("unchecked")
	public List<Actividad> traerTodosConDependencias() throws HibernateException {
		List<Actividad> lista = null;
		try {
			iniciaOperacion();
			lista = session.createQuery("from Actividad a").list();
			for(Actividad a:lista){
				Hibernate.initialize(a.getCaracteristicas());
				Hibernate.initialize(a.getFaseHasActividades());
				for(FaseHasActividad fha:a.getFaseHasActividades()){
					Hibernate.initialize(fha.getActividad());
					Hibernate.initialize(fha.getFase());
				}
				Hibernate.initialize(a.getProceso());
				Hibernate.initialize(a.getGrupoActividad());
				Hibernate.initialize(a.getProductosDeEntrada());
				for(Producto p:a.getProductosDeEntrada()){
					Hibernate.initialize(p.getSalidaDeActividades());
					Hibernate.initialize(p.getEntradaDeActividades());
				}
				Hibernate.initialize(a.getProductosDeSalida());
				for(Producto p:a.getProductosDeSalida()){
					Hibernate.initialize(p.getSalidaDeActividades());
					Hibernate.initialize(p.getEntradaDeActividades());
				}
			}

		} finally {
			session.close();
		}
		return lista;
	}
	
}
