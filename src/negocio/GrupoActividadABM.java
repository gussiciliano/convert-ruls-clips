package negocio;

import dao.GrupoActividadDao;
import datos.GrupoActividad;

public class GrupoActividadABM extends MasterABM<GrupoActividad>{
	
	protected GrupoActividadABM() {
		super(new GrupoActividadDao());
	}
}