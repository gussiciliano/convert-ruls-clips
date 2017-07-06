package datos;

import java.util.Set;

import negocio.FaseABM;

public class GrupoActividad extends MasterDato {
	
//	static String fases="";
//	{
//		FaseABM fa=new FaseABM();
//		for(Fase f:fa.traerTodos()){
//			fases=fases+f.getCodigo()+" ";
//		}
//	}
	
	private int idGrupoActividad;
	private String nombre;
	private Proceso proceso;
	private String codigo;
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
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "GrupoActividad OK";
	}
	
	public String defTemplateActividad(){

		String fases="";
		FaseABM fa=new FaseABM();
		for(Fase f:fa.traerTodos()){
			fases=fases+f.getCodigo()+" ";
		}
		
		StringBuffer template=new StringBuffer(300);
		template.append("(deftemplate "+codigo+"\n");
		template.append("   (slot codigo\n");
		template.append("       (type SYMBOL)\n");
		template.append("       (allowed-symbols ");
		for(Actividad a:actividades){
			template.append(" "+a.getCodigo());
		}
		template.append("))\n");
		template.append("   (slot nombre\n");
		template.append("		(type STRING))\n");
		template.append("   (slot estado\n");
		template.append("		(type SYMBOL)\n");
		template.append("		(allowed-symbols no-iniciada iniciada terminada))\n");
		template.append("   (slot fase-inicial \n");
		template.append("		(type SYMBOL)\n");
		template.append("		(allowed-symbols "+fases+"))\n"); //prep req dis codif test oper fin))\n");
		template.append("   (slot fase-final\n");
		template.append("		(type SYMBOL)\n");
		template.append("		(allowed-symbols "+fases+")))\n");
		return template.toString();
	}
}
