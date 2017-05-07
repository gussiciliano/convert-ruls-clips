package datos;

import java.util.Set;

public class Fase extends MasterDato {
	private int idFase;
	private String nombre;
	private Set<FaseHasActividad> faseHasActividades;

	public Fase() {
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Set<FaseHasActividad> getFaseHasActividades() {
		return faseHasActividades;
	}

	public void setFaseHasActividades(Set<FaseHasActividad> faseHasActividades) {
		this.faseHasActividades = faseHasActividades;
	}

	@Override
	public String toString() {
		return "Fase OK";
	}
}
