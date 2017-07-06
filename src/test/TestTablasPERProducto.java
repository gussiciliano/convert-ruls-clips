package test;

import java.util.List;

import datos.Actividad;
import datos.Producto;
import negocio.ActividadABM;
import negocio.ProductoABM;

public class TestTablasPERProducto {

	public TestTablasPERProducto() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// probamos generacion de tablas PER
		
		ProductoABM aa = new ProductoABM();
		
		List<Producto> productoes=aa.traerTodosConDependencias();
		
		for(Producto producto:productoes){
			System.out.println(producto.tablasPER());
		}

	}

}
