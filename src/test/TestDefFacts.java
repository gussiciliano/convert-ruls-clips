package test;

import java.util.List;

import datos.Actividad;
import negocio.ActividadABM;

public class TestDefFacts {

	public TestDefFacts() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActividadABM aa = new ActividadABM();
		
		List<Actividad> actividades=aa.traerTodosConDependencias();
		
		for(Actividad actividad:actividades){
			System.out.println(actividad.defFact());
		}
	}

}
