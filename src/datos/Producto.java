package datos;

import java.util.Set;

public class Producto extends MasterDato {
	private int idProducto;
	private String nombre;
	private Set<Actividad> entradaDeActividades;
	private Set<Actividad> salidaDeActividades;

	public Producto() {
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Actividad> getEntradaDeActividades() {
		return entradaDeActividades;
	}

	public void setEntradaDeActividades(Set<Actividad> entradaDeActividades) {
		this.entradaDeActividades = entradaDeActividades;
	}

	public Set<Actividad> getSalidaDeActividades() {
		return salidaDeActividades;
	}

	public void setSalidaDeActividades(Set<Actividad> salidaDeActividades) {
		this.salidaDeActividades = salidaDeActividades;
	}

	@Override
	public String toString() {
		return "Producto OK";
	}
}
