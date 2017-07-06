package test;

import java.util.List;

import datos.Actividad;
import negocio.ActividadABM;

public class TestTablasPERActividad {

	public TestTablasPERActividad() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// probamos generacion de tablas PER
		ActividadABM aa = new ActividadABM();
		
		List<Actividad> actividades=aa.traerTodosConDependencias();
		
		for(Actividad actividad:actividades){
			System.out.println(actividad.tablasPER());
		}

	}

}
