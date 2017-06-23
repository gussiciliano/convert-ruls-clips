package negocio;

import dao.FaseHasActividadDao;
import datos.FaseHasActividad;

public class FaseHasActividadABM extends MasterABM<FaseHasActividad>{
	
	public FaseHasActividadABM() {
		super(new FaseHasActividadDao());
	}
}