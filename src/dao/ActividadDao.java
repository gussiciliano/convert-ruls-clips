package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import datos.Actividad;
import datos.Producto;

public class ActividadDao extends MasterDao<Actividad> {

	public List<Producto> traerProductosDeEntrada(int idActividad) throws HibernateException {
		Actividad objeto = null;
		try {
			iniciaOperacion();
	        String hql="from Actividad a where a.idActividad =" + idActividad;
	        objeto = (Actividad) session.createQuery(hql).uniqueResult();
	        Hibernate.initialize(objeto.getProductosDeEntrada());
	    } finally {
	        session.close();
	    }
		List<Producto> lstProducto = new ArrayList<Producto>();
		lstProducto.addAll(objeto.getProductosDeEntrada());
	    return lstProducto;
	}
	
	public List<Producto> traerProductosDeSalida(int idActividad) throws HibernateException {
		Actividad objeto = null;
		try {
			iniciaOperacion();
	        String hql="from Actividad a where a.idActividad =" + idActividad;
	        objeto = (Actividad) session.createQuery(hql).uniqueResult();
	        Hibernate.initialize(objeto.getProductosDeSalida());
	    } finally {
	        session.close();
	    }
		List<Producto> lstProducto = new ArrayList<Producto>();
		lstProducto.addAll(objeto.getProductosDeSalida());
	    return lstProducto;
	}

}
