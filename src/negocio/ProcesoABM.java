package negocio;

import dao.ProcesoDao;
import datos.Proceso;

public class ProcesoABM extends MasterABM<Proceso>{
	
	protected ProcesoABM() {
		super(new ProcesoDao());
	}
}