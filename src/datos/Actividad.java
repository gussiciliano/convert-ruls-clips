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
			if((fha.isFaseInicial() && inicial) || (fha.isFaseFinal() && !inicial)){
				f=fha.getFase();
			}
		}
		
		return f;		
	}
	
	public String defFact(){
		// genera el deffact para la actividad
		
	}
	
	public String defRules(){
		
		return ";; Par de reglas Inicializacion-Terminación para la actividad "+nombre+"\n\n"+
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
		
		
		regla.append("(defrule iniciar-"+codigo+"\n\t ");
		
		// estamos en MCV cascada?
		regla.append("(mcv (codigo cascada))\n");
		
		// la regla está no iniciada?
		regla.append("?a <- (actividad (codigo "+getCodigo()+") (estado no-iniciada))\n");
		
		// estamos en la fase adecuada para iniciar?
		regla.append(faseInicial().enCurso());
		
		// hay caracteristicas que deban estar presentes?
		for(Caracteristica caracteristica:caracteristicas){
			regla.append(caracteristica.presente(true));
		}
		
		// están los productos necesarios?
		for(Producto producto:productosDeEntrada){
			regla.append(producto.disponible(true));
		}
		
		regla.append("=>\n\t");
		
		// marcamos la actividad como iniciada 
		
		regla.append("(modify ?a (estado iniciada))\n");
		
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
		
		regla.append("(defrule finalizar-"+codigo+"\n\t ");
		
		// estamos en MCV cascada?
		regla.append("(mcv (codigo cascada))\n");
		
		// la regla está iniciada?
		regla.append("?a <- (actividad (codigo "+getCodigo()+") (estado iniciada))\n");
		
		// estamos en la fase adecuada para terminar?
		regla.append(faseFinal().enCurso());
		
		// están los productos de salida disponibles?
		for(Producto producto:productosDeSalida){
			regla.append(producto.disponible(true));
		}
		
		regla.append("=>\n\t");
		
		// marcamos la actividad como terminada 
		
		regla.append("(modify ?a (estado terminada))\n");
		
		return regla.toString();
		
	}
	
	public String defPER(){
		
	}
	
	@Override
	public String toString() {
		return "Actividad OK";
	}
}
