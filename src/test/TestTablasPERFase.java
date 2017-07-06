package test;

import java.util.List;

import datos.Actividad;
import datos.Fase;
import datos.Producto;
import negocio.ActividadABM;
import negocio.FaseABM;
import negocio.ProductoABM;

public class TestTablasPERFase {

	public TestTablasPERFase() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// probamos generacion de tablas PER
		
		FaseABM fa = new FaseABM();
		
		List<Fase> fases=fa.traerTodosConDependencias();
		
		for(Fase fase:fases){
			System.out.println(fase.tablaPERFinalizacion());
		}

	}

}
