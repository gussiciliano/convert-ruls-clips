package datos;

import java.util.Set;

public class Proceso extends MasterDato {
	private int idProceso;
	private String nombre;
	private Set<Actividad> actividades;
	private Set<GrupoActividad> grupoActividades;

	public Proceso() {
	}

	public int getIdProceso() {
		return idProceso;
	}

	public void setIdProceso(int idProceso) {
		this.idProceso = idProceso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

	public Set<GrupoActividad> getGrupoActividades() {
		return grupoActividades;
	}

	public void setGrupoActividades(Set<GrupoActividad> grupoActividades) {
		this.grupoActividades = grupoActividades;
	}

	@Override
	public String toString() {
		return "Proceso OK";
	}
}
