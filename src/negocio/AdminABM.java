package negocio;

import java.util.ArrayList;
import java.util.List;

import datos.MasterDato;

@SuppressWarnings("rawtypes")
public class AdminABM {

	private ActividadABM actividadABM;
	private FaseABM faseABM;  
	private FaseHasActividadABM faseHasActividadABM;
	private GrupoActividadABM grupoActividadABM;
	private ProcesoABM procesoABM;
	private ProductoABM productoABM;
	private List<MasterABM> allABMs;
	
	public AdminABM() {
		this.actividadABM = new ActividadABM();
		this.faseABM = new FaseABM();
		this.faseHasActividadABM = new FaseHasActividadABM();
		this.grupoActividadABM = new GrupoActividadABM();
		this.procesoABM = new ProcesoABM();
		this.productoABM = new ProductoABM();
		this.allABMs = new ArrayList<MasterABM>();
		this.allABMs.add(this.actividadABM);
		this.allABMs.add(this.faseABM);
		this.allABMs.add(this.faseHasActividadABM);
		this.allABMs.add(this.grupoActividadABM);
		this.allABMs.add(this.procesoABM);
		this.allABMs.add(this.productoABM);
	}

	@SuppressWarnings("unchecked")
	public List<MasterDato> testTraerParaTodosLasClasesDeDato() {
		List<MasterDato> lst = new ArrayList<MasterDato>();
		for (MasterABM abm : this.getAllABMs()) {
			lst.addAll(abm.traerTodos());
		}
		return lst;
	}
	
	// SETs y GETs
	public List<MasterABM> getAllABMs() {
		return allABMs;
	}

	public void setAllABMs(List<MasterABM> allABMs) {
		this.allABMs = allABMs;
	}

	public ActividadABM getActividadABM() {
		return actividadABM;
	}

	public void setActividadABM(ActividadABM actividadABM) {
		this.actividadABM = actividadABM;
	}

	public FaseABM getFaseABM() {
		return faseABM;
	}

	public void setFaseABM(FaseABM faseABM) {
		this.faseABM = faseABM;
	}

	public FaseHasActividadABM getFaseHasActividadABM() {
		return faseHasActividadABM;
	}

	public void setFaseHasActividadABM(FaseHasActividadABM faseHasActividadABM) {
		this.faseHasActividadABM = faseHasActividadABM;
	}

	public GrupoActividadABM getGrupoActividadABM() {
		return grupoActividadABM;
	}

	public void setGrupoActividadABM(GrupoActividadABM grupoActividadABM) {
		this.grupoActividadABM = grupoActividadABM;
	}

	public ProcesoABM getProcesoABM() {
		return procesoABM;
	}

	public void setProcesoABM(ProcesoABM procesoABM) {
		this.procesoABM = procesoABM;
	}

	public ProductoABM getProductoABM() {
		return productoABM;
	}

	public void setProductoABM(ProductoABM productoABM) {
		this.productoABM = productoABM;
	}
}
