package datos;

public class Caracteristica {
	
	private int idCaracteristica;
	private String codigo;
	private String descripcion;
	
	public Caracteristica() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCaracteristica() {
		return idCaracteristica;
	}

	public void setIdCaracteristica(int idCaracteristica) {
		this.idCaracteristica = idCaracteristica;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String presente(boolean estaPresente){
		return "(caracteristica (codigo "+getCodigo()+") (presente "+(estaPresente ? "si" : "no") + "))\n\t";
	}
	
	
	
}
