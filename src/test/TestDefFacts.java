package test;

import java.util.List;

import datos.Actividad;
import datos.Fase;
import datos.Producto;
import negocio.ActividadABM;
import negocio.FaseABM;
import negocio.ProductoABM;

public class TestDefFacts {

	public TestDefFacts() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActividadABM aa = new ActividadABM();
		FaseABM fa = new FaseABM();
		ProductoABM pa = new ProductoABM();
		
		List<Fase> fases=fa.traerTodosConDependencias();
		
		System.out.println("; ========================= Hechos iniciales del sistema =========================\n\n");
		
		System.out.println("(deffacts hechos-iniciales\n"); 
		
		System.out.println(";    ========================= Hechos de fase =========================\n\n");
		
		for(Fase fase:fases){
			System.out.println(fase.defFact());
		}
		
		List<Actividad> actividades=aa.traerTodosConDependencias();
		System.out.println("\n;    ========================= Hechos de actividad =========================\n\n");
		
		for(Actividad actividad:actividades){
			System.out.println(actividad.defFact());
		}
		
		List<Producto> productos=pa.traerTodosConDependencias();
		System.out.println("\n;    ========================= Hechos de producto =========================\n\n");
		
		for(Producto producto:productos){
			System.out.println(producto.defFact());
		}
		
		System.out.println("\b\b)\n"); 
			
	}

}
