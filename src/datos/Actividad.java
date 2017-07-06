package datos;

import java.util.Iterator;
import java.util.Set;

public class Actividad extends MasterDato {
	private int idActividad;
	private String nombre;
	private String codigo;
	private Proceso proceso;
	private GrupoActividad grupoActividad;
	private Set<Producto> productosDeEntrada;
	private Set<Producto> productosDeSalida;
	private Set<FaseHasActividad> faseHasActividades;
	private Set<Caracteristica> caracteristicas;
	
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	
	public Set<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(Set<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public Fase faseInicial(){
		return faseHelper(true);
	}
	
	public Fase faseFinal(){
		return faseHelper(false);
	}
			
	public Fase faseHelper(boolean inicial){
		Iterator<FaseHasActividad> i=faseHasActividades.iterator();
		FaseHasActividad fha=null;
		Fase f=null;
		while(i.hasNext() && f==null){
			fha=i.next();
			if((fha.isFaseInicial() && inicial) || (fha.isFaseFinal() && !inicial)){
				f=fha.getFase();
			}
		}
		
		return f;		
	}
	
	
	/*
	(deffacts hechos-iniciales
			  (trabajador (causa nacimiento) (nombre empleado1) (antiguedad 12) (acumulado-examen 0))
			  (trabajador (causa matrimonio) (nombre empleado2) (antiguedad 16) (acumulado-examen 0))
			  (trabajador (causa fallecimiento-conyuge) (nombre emplado3) (antiguedad 18) (acumulado-examen 0))
			  (trabajador (causa fallecimiento-hijos) (nombre empleado4) (antiguedad 5) (acumulado-examen 0))
			  (trabajador (causa fallecimiento-padres) (nombre empleado5) (antiguedad 20) (acumulado-examen 0))
			  (trabajador (causa fallecimiento-hermano) (nombre empleado6) (antiguedad 22) (acumulado-examen 0))
			  (trabajador (causa examen) (nombre empleado7) (antiguedad 1) (acumulado-examen 6))
			  (trabajador (causa examen) (nombre empleado8) (antiguedad 3) (acumulado-examen 10))
			  (trabajador (causa ordinaria) (nombre empleado9) (antiguedad 2) (acumulado-examen 0))
			  (trabajador (causa ordinaria) (nombre empleado10) (antiguedad 7) (acumulado-examen 0))
			  (trabajador (causa ordinaria) (nombre empleado11) (antiguedad 12) (acumulado-examen 0))
			  (trabajador (causa ordinaria) (nombre empleado12) (antiguedad 22) (acumulado-examen 0)))

	*/
	
	public String defFact(){
		// genera el deffact para la actividad
		// necesitamos el codigo para la actividad desde el grupo de actividad
		
		
		// cada fase pertenece a lo que llamamos un grupo_actividad (en el resumen procesos incluidos)
		// y cada uno de ellos a un proceso 
				
		//(trabajador (causa nacimiento) (nombre empleado1) (antiguedad 12) (acumulado-examen 0))
		
		StringBuffer fact=new StringBuffer(300);
			
		fact.append("("+grupoActividad.getCodigo()+"\n");
		fact.append("	(codigo "+codigo+")\n");
		fact.append("	(nombre '"+nombre+"')\n");
		fact.append("	(estado no-iniciada)\n");
		Fase fi=faseInicial();
		Fase ff=faseFinal();
		String code=(fi==null ? "na" : fi.getCodigo());
		fact.append("	(fase-inicial "+code+")\n");
		code=(ff==null ? "na" : ff.getCodigo());
		fact.append("	(fase-final "+code+"))\n");
		
		return fact.toString();
	}
	
	public String defRules(){
		
		return ";; Par de reglas de inicializacion y terminación para la actividad "+nombre+"\n\n"+
				defRuleIniciacion()+"\n\n"+defRuleFinalizacion();
	}
	
	public String defRuleIniciacion(){
//		controlar la sintaxis, que sea igual a la de clips
		
//		*************** TODAS ESTAS REGLAS SE ACTIVAN CUANDO HAY UN HECHO mcv.codigo=cascada *********************		
//		***************ADEMAS, HAY REGLAS QUE NECESITAN ALGUNA CARACTERISTICA PRESENTE PARA ACTIVARSE*************
//		(por ejemplo, para que la actividad Diseño de base de datos se active el proyecto debe tener base de datos, 
//		si no al pedo)
		 
	
//		Reglas:
//		La actividad pasa a en curso cuando se encuentra no iniciada, todos los productos de entrada están disponibles
//		y la fase en curso es la fase inicial de la actividad.
		
		StringBuffer regla=new StringBuffer(300);
		
		// Cuidado: Si no tiene fase inicial, no se emite regla de iniciacion (ni de finalización, para el caso)
		
		if(faseInicial()!=null){
			regla.append("(defrule iniciar-act-"+codigo+"\n");
			
			// estamos en MCV cascada?
			regla.append("    (mcv (codigo cascada))\n");
			
			// la regla está no iniciada?
			regla.append("    ?a <- ("+grupoActividad.getCodigo()+" (codigo "+getCodigo()+") (estado no-iniciada))\n");
			
			// estamos en la fase adecuada para iniciar?
			regla.append("    "+faseInicial().enCurso());
			
			// hay caracteristicas que deban estar presentes?
	//		for(Caracteristica caracteristica:caracteristicas){
	//			regla.append("    "+caracteristica.presente(true));
	//		}
			
			// están los productos necesarios?
			for(Producto producto:productosDeEntrada){
				regla.append("    "+producto.disponible(true));
			}
			
			regla.append("    "+"=>\n");
			
			// marcamos la actividad como iniciada 
			
			regla.append("    "+"(modify ?a (estado iniciada)))\n");
		}
		
		return regla.toString();
		
	}
	
	public String defRuleFinalizacion(){
//		*************** TODAS ESTAS REGLAS SE ACTIVAN CUANDO HAY UN HECHO mcv.codigo=cascada *********************		
//				
//		Para poder finalizar una actividad: 
//			el mcv debe ser cascada
//			todos sus productos de salida deben estar disponibles
//			debemos estar en la fase final de la actividad

			
		StringBuffer regla=new StringBuffer(300);
		
		// Cuidado: Si no tiene fase final, no se emite regla de finalización
		
		if(faseFinal()!=null){
			regla.append("(defrule finalizar-act-"+codigo+"\n");
			
			// estamos en MCV cascada?
			regla.append("    "+"(mcv (codigo cascada))\n");
			
			// la actividad está iniciada?
			regla.append("    "+"?a <- ("+grupoActividad.getCodigo()+" (codigo "+getCodigo()+") (estado iniciada))\n");
			
			// estamos en la fase adecuada para terminar?
			regla.append("    "+faseFinal().enCurso());
			
			// están los productos de salida disponibles?
			for(Producto producto:productosDeSalida){
				regla.append("    "+producto.disponible(true));
			}
			
			regla.append("    "+"=>\n");
			
			// marcamos la actividad como terminada 
			
			regla.append("    "+"(modify ?a (estado terminada)))\n");
		}
		
		return regla.toString();
		
	}
	
	public String tablasPER(){
		return tablaPERIniciacion()+tablaPERFinalizacion();
	}
	
	public String tablaPERFinalizacion(){
		// devolvemos el texto de la tabla per: 
		// un identificador de regla (texto)
		// las palabras del experto (ver si salen de acá o las sacamos del texto de la ieee)
		// la regla
		
		StringBuffer per=new StringBuffer(300);
		
		// Cuidado: Si no tiene fase final, no se emite regla de finalización
		
		if(faseFinal()!=null){
			per.append("=======================================================================================================\n");
			per.append("Identificador de la regla  | Finalización de actividad "+nombre+"\n");
			per.append("-------------------------------------------------------------------------------------------------------\n");
			per.append("Palabras del experto:\n");
			
			// armamos las palabras del experto: 
			// Para el MCV cascada, la actividad iniciada (nombre actividad) finaliza cuando se encuentra en la fase   
			// (nombre fase) y los productos:
			// (listamos productos)
			// se encuentran disponibles
			
			per.append("\"Para el mapa de actividades vigente (con MCV cascada), \n");
			per.append("la actividad iniciada "+nombre+"\n");
			per.append("finaliza cuando el proyecto se encuentra en la fase "+faseFinal().getNombre());
			
			per.append(productosPER(productosDeSalida));
			
//			if (productosDeSalida.size()==1)
//				per.append(" y el producto ");
//			else
//				per.append(" y los productos"+"\n");
//			
//			for(Producto producto:productosDeSalida){
//				per.append(producto.getNombre()+"\n");
//			}
//			
//			if (productosDeSalida.size()==1)
//				per.append("se encuentra disponible\"\n");
//			else
//				per.append("se encuentran disponibles\"\n");
			
			per.append("-------------------------------------------------------------------------------------------------------\n");

			//per.append("Regla:\n");
			
			// estamos en MCV cascada?
			per.append("SI mcv<-codigo=cascada\n");
			
			// la regla está no iniciada?
			per.append("Y actividad<-codigo="+getCodigo());
			per.append("\nY actividad<-estado=iniciada\n");		
			
			// estamos en la fase adecuada para terminar?
			per.append("Y "+faseFinal().enCursoPER());
			
			int numerador=1;
			for(Producto producto:productosDeSalida){
				per.append("Y "+producto.disponiblePER(true,numerador++));
			}
			
			per.append("ENTONCES\n");
			
			// marcamos la actividad como iniciada 
			
			per.append("actividad<-estado=terminada\n");

		}
		
		return per.toString();
		
	}
	
	public String tablaPERIniciacion(){
		StringBuffer per=new StringBuffer(300);
		
		// Cuidado: Si no tiene fase inicial, no se emite regla de iniciacion (ni de finalización, para el caso)
		
		if(faseInicial()!=null){
			per.append("=======================================================================================================\n");
			per.append("Identificador de la regla  | Iniciación de actividad "+nombre+"\n");
			per.append("-------------------------------------------------------------------------------------------------------\n");
			per.append("Palabras del experto:\n");
			
			per.append("\"Para el mapa de actividades vigente (con MCV cascada),\nla actividad no iniciada "+nombre+"\n");
			per.append("se inicia cuando el proyecto se encuentra en la fase "+faseInicial().getNombre());
			
			per.append(productosPER(productosDeEntrada));
			
//			
//			
//			Iterator<Producto> i=productosDeEntrada.iterator();
//			if(i.hasNext()){
//				if (productosDeEntrada.size()==1)
//					per.append(" y el producto ");
//				else
//					per.append(" y los productos"+"\n");
//				
//				String conector;
//					
//				if(productosDeEntrada.size()>2)
//					conector=", ";
//				else
//					conector="";
//				
//				Producto producto=i.next();
//				
//				do{
//					per.append(producto.getNombre());
//					if(i.hasNext())
//						producto=i.next();
//					else {
//						producto=null;
//						conector="";
//					}
//							
//					if(!i.hasNext() && producto!=null)
//						conector=" y ";
//					
//					per.append(conector+"\n");
//					
//				} while(producto!=null);
//			
//			
//				if (productosDeEntrada.size()==1)
//					per.append("se encuentra disponible\"\n");
//				else
//					per.append("se encuentran disponibles\"\n");
//			}else{
//				per.append("\"\n");
//			}
			
			per.append("-------------------------------------------------------------------------------------------------------\n");
			
			//per.append("Regla:\n");
			
			// estamos en MCV cascada?
			per.append("SI mcv<-codigo=cascada\n");
			
			// la regla está no iniciada?
			per.append("Y actividad<-codigo="+getCodigo());
			per.append("\nY actividad<-estado=no-iniciada\n");
			
			// estamos en la fase adecuada para iniciar?
			per.append("Y "+faseInicial().enCursoPER());
			
			// hay caracteristicas que deban estar presentes?
	//		for(Caracteristica caracteristica:caracteristicas){
	//			regla.append("    "+caracteristica.presente(true));
	//		}
			
			// están los productos necesarios?
			int numerador=1;
			for(Producto producto1:productosDeEntrada){
				per.append("Y "+producto1.disponiblePER(true,numerador++));
			}
			
			per.append("ENTONCES\n");
			
			// marcamos la actividad como iniciada 
			
			per.append("actividad<-estado=iniciada\n\n");
		}
		
		return per.toString();

	}
	
	
	public String productosPER(Set<Producto> productos){
		StringBuffer pPER=new StringBuffer(300);
		Iterator<Producto> i=productos.iterator();
		if(i.hasNext()){
			if (productos.size()==1)
				pPER.append(" y el producto ");
			else
				pPER.append(" y los productos"+"\n");
			
			String conector;
				
			if(productos.size()>2)
				conector=", ";
			else
				conector="";
			
			Producto producto=i.next();
			
			do{
				pPER.append(producto.getNombre());
				if(i.hasNext())
					producto=i.next();
				else {
					producto=null;
					conector="";
				}
						
				if(!i.hasNext() && producto!=null)
					conector=" y ";
				
				pPER.append(conector+"\n");
				
			} while(producto!=null);
		
		
			if (productos.size()==1)
				pPER.append("se encuentra disponible\"\n");
			else
				pPER.append("se encuentran disponibles\"\n");
		}else{
			pPER.append("\"\n");
		}
		
		return pPER.toString();
	}
	
	@Override
	public String toString() {
		return "Actividad OK";
	}
}
