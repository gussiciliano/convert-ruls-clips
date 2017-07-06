package test;

import java.util.List;

import datos.Actividad;
import datos.Producto;
import negocio.ActividadABM;
import negocio.ProductoABM;

public class TestDefRules {

	public TestDefRules() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// generacion de reglas de producto
		
		ProductoABM pa = new ProductoABM();
		
		List<Producto> productos=pa.traerTodosConDependencias();
		
		System.out.println("; ========================= Reglas de producto =========================\n\n");
		
		for(Producto producto:productos){
			System.out.println(producto.defRules());
		}
		
		
		// generacion de reglas de actividad
		
		System.out.println("; ========================= Reglas de actividad =========================\n\n");
		
		ActividadABM aa = new ActividadABM();
		
		List<Actividad> actividades=aa.traerTodosConDependencias();
		
		for(Actividad actividad:actividades){
			System.out.println(actividad.defRules());
		}
		
		

	}
	
}
