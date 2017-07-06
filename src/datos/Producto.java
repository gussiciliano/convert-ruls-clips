package datos;

import java.util.Set;

public class Producto extends MasterDato {
	private int idProducto;
	private String nombre;
	private String codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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

	public String disponible(boolean estaDisponible){
		return "(producto (codigo "+getCodigo()+") (estado "+(estaDisponible ? "disponible" : "no-disponible") + "))\n";
	}
	
	public String disponiblePER(boolean estaDisponible, int numerador){
		return "producto"+numerador+"<-codigo="+getCodigo()+"\nY producto"+numerador+"<-estado="+(estaDisponible ? "disponible" : "no-disponible") + "\n";
	}
	
	// reglas de iniciacion y finalizacion de producto
	// Para que un producto pueda iniciarse, la actividad de la que es salida debe estar iniciada
	// para que pueda terminarse, también, así que basta con que el producto esté en curso
	// estados: no-disponible en-curso disponible
	
	public String defRules(){
		
		return ";; Par de reglas de inicializacion y terminación para el producto "+nombre+"\n\n"+
				defRuleIniciacion()+"\n\n"+defRuleFinalizacion();
	}
	
	public String defRuleIniciacion(){
		
		StringBuffer regla=new StringBuffer(300);
		
		regla.append("(defrule iniciar-prod-"+codigo+"\n");
		
		// Tenemos el token de iniciación?
		regla.append("    ?f <- (modificar-estado "+getCodigo()+" iniciar)\n");
		regla.append("    ?p <- (producto (codigo "+getCodigo()+") (estado no-disponible))\n");
		// la actividad de la que es salida, está iniciada?
		for(Actividad a:salidaDeActividades){
			regla.append("    ("+a.getGrupoActividad().getCodigo()+" (codigo "+a.getCodigo()+") (estado iniciada))\n");	
		}
		
		regla.append("    "+"=>\n");
		
		// marcamos el producto como en curso 
		
		regla.append("    "+"(modify ?p (estado en-curso))\n");
		regla.append("    "+"(retract ?f))\n");
		
		return regla.toString();
		
	}
	
	public String defRuleFinalizacion(){
		
		StringBuffer regla=new StringBuffer(300);
		
		regla.append("(defrule finalizar-prod-"+codigo+"\n");
		regla.append("    ?f <- (modificar "+getCodigo()+" terminar)\n");
		regla.append("    ?p <- (producto (codigo "+getCodigo()+") (estado en-curso))\n");
		
		regla.append("    "+"=>\n");
		
		// marcamos el producto como en curso 
		
		regla.append("    "+"(modify ?p (estado disponible))\n");
		regla.append("    "+"(retract ?f))\n");
		
		return regla.toString();
		
	}
	
	// Tablas PER
	
	public String tablasPER(){
		return tablaPERIniciacion()+tablaPERFinalizacion();
	}
	
	public String tablaPERFinalizacion(){
		// devolvemos el texto de la tabla per: 
		// un identificador de regla (texto)
		// las palabras del experto (ver si salen de acá o las sacamos del texto de la ieee)
		// la regla
		
		StringBuffer per=new StringBuffer(300);
		
	
		per.append("=======================================================================================================\n");
		per.append("Identificador de la regla  | Finalización del producto "+nombre+"\n");
		per.append("-------------------------------------------------------------------------------------------------------\n");
		per.append("Palabras del experto:\n");
		
		// armamos las palabras del experto: 
		// Para el MCV cascada, la actividad iniciada (nombre actividad) finaliza cuando se encuentra en la fase   
		// (nombre fase) y los productos:
		// (listamos productos)
		// se encuentran disponibles
		
		
		per.append("\"Para que el producto "+nombre+" pueda declararse disponible,\n");
		per.append("debe encontrarse en curso previamente.\"\n");
		
		per.append("-------------------------------------------------------------------------------------------------------\n");

		//per.append("Regla:\n");
		
		// El producto está en curso?
		per.append("SI producto<-codigo="+codigo+"\n");
		per.append("Y producto<-estado=en-curso\n");		
		
		per.append("ENTONCES\n");
		
		// marcamos el producto como disponible 
		
		per.append("producto<-estado=disponible\n");
		
		return per.toString();
		
	}
	
	public String tablaPERIniciacion(){
		StringBuffer per=new StringBuffer(300);
		
		// Cuidado: Si no tiene fase inicial, no se emite regla de iniciacion (ni de finalización, para el caso)
		
		per.append("=======================================================================================================\n");
		per.append("Identificador de la regla  | Iniciación del producto "+nombre+"\n");
		per.append("-------------------------------------------------------------------------------------------------------\n");
		per.append("Palabras del experto:\n");
		
		per.append("\"Para que el producto "+nombre+" pueda declararse disponible,\n");
		per.append("debe encontrarse no disponible previamente y la actividad "+((Actividad) salidaDeActividades.toArray()[0]).getNombre() +"\n"); 
		per.append("debe encontrarse iniciada.\"\n");
		
		per.append("-------------------------------------------------------------------------------------------------------\n");
		
		per.append("SI producto<-codigo="+codigo+"\n");
		per.append("Y producto<-estado=no-disponible\n");		
		per.append("Y actividad<-codigo="+((Actividad) salidaDeActividades.toArray()[0]).getCodigo()+"\n");
		per.append("Y actividad<-estado=iniciada\n");
		
		per.append("ENTONCES\n");
		
		// marcamos el producto como disponible 
		
		per.append("producto<-estado=en-curso\n");
		
		return per.toString();

	}

	
	
	@Override
	public String toString() {
		return "Producto OK";
	}
}
