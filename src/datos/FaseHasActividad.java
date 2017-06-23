package datos;

public class FaseHasActividad extends MasterDato {
	private int idFaseHasActividad;
	private Fase fase;
	private Actividad actividad;
	private boolean faseInicial;
	private boolean faseFinal;

	public FaseHasActividad() {
	}
	
	public FaseHasActividad(Fase fase, Actividad actividad) {
		super();
		this.fase = fase;
		this.actividad = actividad;
	}

	public int getIdFaseHasActividad() {
		return idFaseHasActividad;
	}

	public void setIdFaseHasActividad(int idFaseHasActividad) {
		this.idFaseHasActividad = idFaseHasActividad;
	}

	public Fase getFase() {
		return fase;
	}

	public void setFase(Fase fase) {
		this.fase = fase;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public boolean isFaseInicial() {
		return faseInicial;
	}

	public void setFaseInicial(boolean faseInicial) {
		this.faseInicial = faseInicial;
	}

	public boolean isFaseFinal() {
		return faseFinal;
	}

	public void setFaseFinal(boolean faseFinal) {
		this.faseFinal = faseFinal;
	}
	
	@Override
	public String toString() {
		return "FaseHasActividad OK";
	}
}
