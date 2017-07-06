package test;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import datos.Actividad;
import datos.Fase;
import datos.Producto;
import negocio.ActividadABM;
import negocio.FaseABM;
import negocio.ProductoABM;

public class TestDefRulesFase {

	public TestDefRulesFase() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// generacion de reglas de fase
		
		FaseABM fa = new FaseABM();
		
		List<Fase> fases=fa.traerTodosConDependencias();
		
		System.out.println("; ========================= Reglas de fase =========================\n\n");
		
		Fase fase;
		Fase faseSiguiente;
		
		ListIterator<Fase> i= fases.listIterator();
		while(i.hasNext()){
			fase=i.next();
			if (i.hasNext()){
				faseSiguiente=i.next();
				i.previous();
			} else {
				faseSiguiente=null;
			}
			System.out.println(fase.defRuleFinalizacion(faseSiguiente));
		}

	}
	
}
