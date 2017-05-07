package datos;

import java.util.Set;

public class Actividad extends MasterDato {
	private int idActividad;
	private String nombre;
	private Proceso proceso;
	private GrupoActividad grupoActividad;
	private Set<Producto> productosDeEntrada;
	private Set<Producto> productosDeSalida;
	private Set<FaseHasActividad> faseHasActividades;

	public Actividad() {
	}

	public int getIdActividad() {
		return idActividad;
	}

	public void setIdActividad(int idActividad) {
		this.idActividad = idActividad;
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

	public GrupoActividad getGrupoActividad() {
		return grupoActividad;
	}

	public void setGrupoActividad(GrupoActividad grupoActividad) {
		this.grupoActividad = grupoActividad;
	}

	public Set<Producto> getProductosDeEntrada() {
		return productosDeEntrada;
	}

	public void setProductosDeEntrada(Set<Producto> productosDeEntrada) {
		this.productosDeEntrada = productosDeEntrada;
	}

	public Set<Producto> getProductosDeSalida() {
		return productosDeSalida;
	}

	public void setProductosDeSalida(Set<Producto> productosDeSalida) {
		this.productosDeSalida = productosDeSalida;
	}
	
	public Set<FaseHasActividad> getFaseHasActividades() {
		return faseHasActividades;
	}

	public void setFaseHasActividades(Set<FaseHasActividad> faseHasActividades) {
		this.faseHasActividades = faseHasActividades;
	}
	
	@Override
	public String toString() {
		return "Actividad OK";
	}
}
