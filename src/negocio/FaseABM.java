package negocio;

import dao.FaseDao;
import datos.Fase;

public class FaseABM extends MasterABM<Fase>{
	
	public FaseABM() {
		super(new FaseDao());
	}
}