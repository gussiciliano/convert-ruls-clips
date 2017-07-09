package test;

import java.util.List;

import datos.Actividad;
import datos.Producto;
import negocio.ActividadABM;
import negocio.ProductoABM;

public class TestDefRulesActividad {

	public TestDefRulesActividad() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// generacion de reglas de actividad
		
		ActividadABM aa = new ActividadABM();
		
		List<Actividad> actividades=aa.traerTodosConDependencias();
		
		System.out.println("; ========================= Reglas de actividad =========================\n\n");
		
		for(Actividad actividad:actividades){
			System.out.println(actividad.defRules());
		}
		
		

	}
	
}
