package negocio;

import dao.ProductoDao;
import datos.Producto;

public class ProductoABM extends MasterABM<Producto>{
	
	protected ProductoABM() {
		super(new ProductoDao());
	}
}