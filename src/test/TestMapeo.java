package test;

import datos.MasterDato;
import negocio.AdminABM;

public class TestMapeo {

	public static void main(String[] args) {
		AdminABM adminABM = new AdminABM();
		for (MasterDato dato: adminABM.testTraerParaTodosLasClasesDeDato()) {
			System.out.println(dato);
		}
	}
}
