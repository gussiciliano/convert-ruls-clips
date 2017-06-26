package test;

import java.util.List;

import datos.Actividad;
import datos.GrupoActividad;
import negocio.ActividadABM;
import negocio.GrupoActividadABM;

public class TestDefTemplate {

	public TestDefTemplate() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// probamos generación de deftemplates
		
		GrupoActividadABM ga = new GrupoActividadABM();
		
		List<GrupoActividad> grupos=ga.traerTodosConDependencias();
		
		for(GrupoActividad grupo:grupos){
			System.out.println(grupo.defTemplateActividad());
		}
		
	}

}
