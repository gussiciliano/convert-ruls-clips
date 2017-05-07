package negocio;

import dao.FaseDao;
import datos.Fase;

public class FaseABM extends MasterABM<Fase>{
	
	protected FaseABM() {
		super(new FaseDao());
	}
}