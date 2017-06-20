package negocio;

import dao.ActividadDao;
import datos.Actividad;

public class ActividadABM extends MasterABM<Actividad>{
	
	public ActividadABM() {
		super(new ActividadDao());
	}
}