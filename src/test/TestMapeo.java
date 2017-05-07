package test;

import datos.MasterDato;
import negocio.AdminAMB;

public class TestMapeo {

	public static void main(String[] args) {
		AdminAMB adminABM = new AdminAMB();
		for (MasterDato dato: adminABM.testTraerParaTodosLasClasesDeDato()) {
			System.out.println(dato);
		}
	}
}
