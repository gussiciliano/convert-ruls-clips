package negocio;

import dao.ActividadDao;
import datos.Actividad;

public class ActividadABM extends MasterABM<Actividad>{
	
	protected ActividadABM() {
		super(new ActividadDao());
	}
}