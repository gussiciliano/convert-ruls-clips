package negocio;

import dao.FaseHasActividadDao;
import datos.FaseHasActividad;

public class FaseHasActividadABM extends MasterABM<FaseHasActividad>{
	
	protected FaseHasActividadABM() {
		super(new FaseHasActividadDao());
	}
}