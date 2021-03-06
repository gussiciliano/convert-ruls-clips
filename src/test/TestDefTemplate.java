package test;

import java.util.List;

import datos.Actividad;
import datos.GrupoActividad;
import negocio.ActividadABM;
import negocio.GrupoActividadABM;
import negocio.ProductoABM;

public class TestDefTemplate {

	public TestDefTemplate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// lo pongo aqui porque así salen antes los mensajes de hibernate
		GrupoActividadABM ga = new GrupoActividadABM();
		List<GrupoActividad> grupos=ga.traerTodosConDependencias();
		
		// generación de deftemplate de MCV
		System.out.println("(deftemplate mcv");
		System.out.println("    (slot codigo");
		System.out.println("        (type SYMBOL)");
		System.out.println("        (allowed-symbols nil cascada prot-evolutivo prot-desechable espiral))");
		System.out.println("    (slot nombre");
		System.out.println("        (type STRING)))\n");
		
		
		// generación de deftemplate de fase
		
		System.out.println("(deftemplate fase");
		System.out.println("    (slot codigo");
		System.out.println("        (type SYMBOL)");
		System.out.println("        (allowed-symbols preparacion req-analisis disenio codificacion integracion implementacion operacion retiro))");
		System.out.println("    (slot nombre");
		System.out.println("        (type STRING))");
		System.out.println("    (slot estado"); 
		System.out.println("        (type SYMBOL)");
		System.out.println("        (allowed-symbols no-iniciada en-curso terminada)))\n");
		
		
		
		// generación de deftemplates de producto
		ProductoABM pa=new ProductoABM();
		System.out.println(pa.defTemplateProducto());
		
		// generación de deftemplates de actividad
		
		for(GrupoActividad grupo:grupos){
			System.out.println(grupo.defTemplateActividad());
		}
		
		
		
	}

}


//Ojo, estas deben ir siempre:
//	
//	(deftemplate mcv
//			  (slot codigo
//				(type SYMBOL)
//				(allowed-symbols nil cascada prot-evolutivo prot-desechable espiral))
//			  (slot descripcion
//				(type STRING)))
//
//			(deftemplate caracteristica
//			  (slot codigo
//				(type SYMBOL)
//				(allowed-symbols DB IU HW com-SW transicion mant-corr mant-perf operac asistencia formacion))
//			  (slot descripcion
//				(type STRING))
//			  (slot presente
//				(type SYMBOL)
//				(allowed-symbols si no)))
//
//			(deftemplate fase
//			  (slot codigo
//				(type SYMBOL)
//				(allowed-symbols preparacion req-analisis disenio codificacion integracion implementacion operacion retiro))
//			  (slot descripcion
//				(type STRING))
//			  (slot estado 
//				(type SYMBOL)
//				(allowed-symbols no-iniciada en-curso terminada)))

	
	
