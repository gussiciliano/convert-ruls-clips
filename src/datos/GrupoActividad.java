package datos;

import java.util.Set;

public class GrupoActividad extends MasterDato {
	private int idGrupoActividad;
	private String nombre;
	private Proceso proceso;
	private Set<Actividad> actividades;

	public GrupoActividad() {
	}

	public int getIdGrupoActividad() {
		return idGrupoActividad;
	}

	public void setIdGrupoActividad(int idGrupoActividad) {
		this.idGrupoActividad = idGrupoActividad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Proceso getProceso() {
		return proceso;
	}

	public void setProceso(Proceso proceso) {
		this.proceso = proceso;
	}
	
	public Set<Actividad> getActividades() {
		return actividades;
	}

	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}
	
	@Override
	public String toString() {
		return "GrupoActividad OK";
	}
}
