package test;

import java.util.List;

import datos.Actividad;
import datos.Producto;
import negocio.ActividadABM;
import negocio.ProductoABM;

public class TestDefRulesProducto {

	public TestDefRulesProducto() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
				
		// generacion de reglas de producto
		
		ProductoABM pa = new ProductoABM();
		
		List<Producto> productos=pa.traerTodosConDependencias();
		
		System.out.println("; ========================= Reglas de producto =========================\n\n");
		
		for(Producto producto:productos){
			System.out.println(producto.defRules());
		}
		
	}
	
}
