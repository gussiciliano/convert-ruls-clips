package negocio;

import dao.GrupoActividadDao;
import datos.GrupoActividad;

public class GrupoActividadABM extends MasterABM<GrupoActividad>{
	
	public GrupoActividadABM() {
		super(new GrupoActividadDao());
	}
}