package datos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Fase extends MasterDato {
	private int idFase;
	private String nombre;
	private String codigo;
	private Set<FaseHasActividad> faseHasActividades;

	public Fase() {
	}

	public int getIdFase() {
		return idFase;
	}

	public void setIdFase(int idFase) {
		this.idFase = idFase;
	}

	public String getCodigo() {
		String code;
		if(codigo==null)
			code="na";
		else
			code=codigo;
					
		return code;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String enCurso(){
		return "(fase (codigo "+getCodigo()+") (estado en-curso))\n";
	}
	
	public String enCursoPER(){
		return "fase<-codigo="+getCodigo()+"\nY fase<-estado=en-curso\n";
	}
	
	
	public String defFact(){
		// genera el deffact para la fase
		// necesitamos el codigo para la actividad desde el grupo de actividad
				
		//(trabajador (causa nacimiento) (nombre empleado1) (antiguedad 12) (acumulado-examen 0))
		
		StringBuffer fact=new StringBuffer(300);
			
		fact.append("    (fase\n");
		fact.append("	    (codigo "+codigo+")\n");
		fact.append("	    (nombre \""+nombre+"\")\n");
		fact.append("	    (estado no-iniciada))\n");
		
		return fact.toString();
	}
	
	// Cambiamos de fase cuando todas las actividades que tienen que terminar en esa fase terminaron
	// y cuando las que tengan que iniciar hayan iniciado, de otra forma no se puede cambiar de fase.
	
	// Hay que buscar en faseHasActividades (el mapa de actividades) cuales son las actividades para
	// las cuales esta es la fase final y verificar que hayan terminado.
	// Lo mismo para las actividades de las cuales ésta sea fase inicial, hay que verificar que todas
	// hayan iniciado
	// Cuando finaliza una fase, inicia la siguiente. Cuando arranca el sistema hay que marcar la 
	// primera fase como iniciada
	
	public String defRuleFinalizacion(Fase faseSiguiente){
//		*************** TODAS ESTAS REGLAS SE ACTIVAN CUANDO HAY UN HECHO mcv.codigo=cascada *********************		
//				
//		Para poder finalizar una Fase: 
//			el mcv debe ser cascada
//		    La fase debe estar iniciada
//			Todas las actividades que inician deben estar iniciadas
//			Todas las que terminan deben haber terminado
//			Al finalizar la fase, se inicia la siguiente si existe. 
			
		StringBuffer regla=new StringBuffer(300);
		
		regla.append(";; Regla de terminación de fase "+nombre+"\n\n");
		
		regla.append("(defrule finalizar-fase-"+codigo+"\n");
		
		// estamos en MCV cascada?
		regla.append("    "+"(mcv (codigo cascada))\n");
		
		// la fase está iniciada?
		regla.append("    "+"?f <- (fase (codigo "+getCodigo()+") (estado en-curso))\n");
		
		// cargamos la fase siguiente si hay
		
		if(faseSiguiente!=null){
			regla.append("    "+"?fs <- (fase (codigo "+faseSiguiente.getCodigo()+"))\n");
		}
		
		// Todas las actividades que inician están iniciadas?
		for(FaseHasActividad fha:faseHasActividades){
			Actividad a=fha.getActividad();
			
			if(a.faseInicial().equals(this)){
				if(!a.faseInicial().equals(a.faseFinal())){
					regla.append("    "+"("+a.getGrupoActividad().getCodigo()+" (codigo "+fha.getActividad().getCodigo()+") (estado iniciada))\n");
				}
			}
		}
		
		// Todas las actividades que terminan están terminadas?
		for(FaseHasActividad fha:faseHasActividades){
			Actividad a=fha.getActividad();
			if(a.faseFinal().equals(this)){
				regla.append("    "+"("+a.getGrupoActividad().getCodigo()+" (codigo "+fha.getActividad().getCodigo()+") (estado terminada))\n");
			}
		}
		
		regla.append("    "+"=>\n");
		
		// marcamos la fase como terminada 
		
		regla.append("    "+"(modify ?f (estado terminada))");
		
		// iniciamos la siguiente si hay
		if(faseSiguiente!=null)
			regla.append("\n    "+"(modify ?fs (estado en-curso)))\n");
		else
			regla.append(")\n");
				
		
		return regla.toString();
	}
	
	public String tablaPERFinalizacion(){
		
		StringBuffer per=new StringBuffer(300);

		per.append("=======================================================================================================\n");
		per.append("Identificador de la regla  | Finalización de fase "+nombre+"\n");
		per.append("-------------------------------------------------------------------------------------------------------\n");
		per.append("Palabras del experto:\n");
		
		// armamos las palabras del experto: 
		// Para el MCV cascada, la fase en curso (nombre fase) finaliza cuando    
		// las actividades
		// (listamos actividades)
		// se encuentran iniciadas y las actividades
		// (listamos actividades)
		// Se encuentran terminadas
		
		per.append("\"Para el mapa de actividades vigente (con MCV cascada), \n");
		per.append("la Fase en curso "+nombre+"\n");
		per.append("finaliza cuando");
		String actividadesQueInician = actividadesPER(true);
		if (actividadesQueInician.length()>1){
			per.append(actividadesQueInician);
			//per.append("se encuentran iniciadas y las actividades \n");
			per.append(" y ");
		}
		per.append(actividadesPER(false)+"\"\n");
				
		per.append("-------------------------------------------------------------------------------------------------------\n");

		// estamos en MCV cascada?
		per.append("SI mcv<-codigo=cascada\n");
		
		// la fase está iniciada?
		per.append("Y fase<-codigo="+getCodigo()+"\n");
		per.append("Y fase<-estado=en-curso\n");
		
		// Todas las actividades que inician están iniciadas?
		int contador=1;
		for(FaseHasActividad fha:faseHasActividades){
			Actividad a=fha.getActividad();
			
			if(a.faseInicial().equals(this)){
				if(!a.faseInicial().equals(a.faseFinal())){
					per.append("Y actividad"+contador+"<-codigo="+fha.getActividad().getCodigo()+"\n");
					per.append("Y actividad"+contador+"<-estado=iniciada\n");
					contador++;
				}
			}
		}
		
		// Todas las actividades que terminan están terminadas?
		for(FaseHasActividad fha:faseHasActividades){
			Actividad a=fha.getActividad();
			if(a.faseFinal().equals(this)){
				per.append("Y actividad"+contador+"<-codigo="+fha.getActividad().getCodigo()+"\n");
				per.append("Y actividad"+contador+"<-estado=terminada\n");
				contador++;
			}
		}

		per.append("ENTONCES\n");
		
		// marcamos la actividad como iniciada 
		
		per.append("fase<-estado=terminada\n");


		
		return per.toString();
		
	}
	
	
	public String actividadesPER(boolean queInician){
		StringBuffer pPER=new StringBuffer(300);
		List<Actividad> actividades=new ArrayList<Actividad>();
		for(FaseHasActividad fha:faseHasActividades){
			Actividad a=fha.getActividad();
			if(queInician){
				if(!a.faseInicial().equals(a.faseFinal())){
					if(a.faseInicial().equals(this))
						actividades.add(a);
				}
			} else {
				if(a.faseFinal().equals(this))
					actividades.add(a);
			}
		}
		//System.out.println(queInician+" "+actividades.size());
		Iterator<Actividad> i=actividades.iterator();
		if(i.hasNext()){
			if (actividades.size()==1)
				pPER.append(" la actividad ");
			else
				pPER.append(" las actividades"+"\n");
			
			String conector;
				
			if(actividades.size()>2)
				conector=", ";
			else
				conector="";
			
			Actividad actividad=i.next();
			
			do{
				pPER.append(actividad.getNombre());
				if(i.hasNext())
					actividad=i.next();
				else {
					actividad=null;
					conector="";
				}
						
				if(!i.hasNext() && actividad!=null)
					conector=" y ";
				
				pPER.append(conector+"\n");
				
			} while(actividad!=null);
		
		
			if (actividades.size()==1)
				pPER.append("se encuentra "+(queInician ? "en curso" : "terminada"));
			else
				pPER.append("se encuentran "+(queInician ? "en curso" : "terminadas"));
		}else{
			//pPER.append("\"\n");
		}
		
		return pPER.toString();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFase;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fase other = (Fase) obj;
		if (idFase != other.idFase)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Fase OK";
	}
}
