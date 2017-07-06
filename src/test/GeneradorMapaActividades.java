package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import datos.Actividad;
import datos.Fase;
import datos.FaseHasActividad;
import negocio.ActividadABM;
import negocio.AdminABM;
import negocio.FaseABM;
import negocio.FaseHasActividadABM;

public class GeneradorMapaActividades {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		crearMapaActividades();

	}
	
	public static void crearMapaActividades(){

		// Para crear el mapa de actividades levantamos "mapa de actividades.csv" y donde hay una x creamos una relacion muchos a muchos entre actividad y fase. 
		// Si es la primera fase en la que apacece la actividad, la marcamos como fase inicial, si aparece como final idem. 
		// el csv tiene que estar separado por coma y los textos encerrados con comillas
		
		System.out.println("********************************* crearMapaActividades ********************************\n\n");
		
		// eliminamos el mapa anterior
		limpiarMapaActividades();
		
		BufferedReader br = null;
		String linea = "";
		String separador=",";
		String archivoCSV = System.getProperty("user.dir")+"/src/test/MapaActividades.csv";
		
		try {
	 
			br = new BufferedReader(new FileReader(archivoCSV));
			// salteamos los encabezados. Son 2, uno con el id y otro con el nombre
			linea = br.readLine();
			linea = br.readLine();
			
			AdminABM aABM=new AdminABM();
			FaseHasActividadABM fhaABM=aABM.getFaseHasActividadABM();
 			ActividadABM actABM=aABM.getActividadABM();
 			FaseABM fABM=aABM.getFaseABM();
			
			while ((linea = br.readLine()) != null) {
	 			String[] fases = linea.split(separador);
	 			int idActividad=Integer.parseInt(fases[0]);
	 				 			
	 			// salvamos solo cuando se encuentra otra fase o se terminan las fases, para poder marcar la fase final
	 			
	 			FaseHasActividad fha=null;
	 			boolean faseInicialEncontrada=false;
	 			
	 			System.out.println(Arrays.toString(fases));
	 			
	 			for(int contFase=2;contFase<fases.length; contFase++){
	 				int idFase=contFase-1; // por la posicion en el csv  
	 				// Si hay una x en el lugar, creamos FaseHasActividad (debería llamarse ItemMapaActividades)
	 				if ("x".compareTo(fases[contFase].toLowerCase())==0){
	 					if (fha!=null) // salvamos la anterior que no es la ultima  
	 						fhaABM.agregar(fha);
	 					 						 					
	 					// traemos la fase
	 					Fase fase=fABM.traer(idFase);
	 					// traemos la actividad
	 					Actividad actividad=actABM.traer(idActividad);
	 					// armamos el item
	 					fha=new FaseHasActividad(fase,actividad);
	 					
	 					if(!faseInicialEncontrada)
	 						fha.setFaseInicial(faseInicialEncontrada=true);
	 				}
	 			}
	 			
	 			if(fha!=null){ // marcamos como ultima y salvamos porque no se encontraron más fases
	 				// ojo que cuando hay una sola ésa es la inicial y final
	 				fha.setFaseFinal(true);
	 				fhaABM.agregar(fha);
	 			}
				
	 		}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private static void limpiarMapaActividades(){
		
		// traemos todos los fha y los eliminamos
		AdminABM aABM=new AdminABM();
		FaseHasActividadABM fhaABM=aABM.getFaseHasActividadABM();
		List<FaseHasActividad> fhas=fhaABM.traerTodos();
		for(FaseHasActividad fha:fhas){
			fhaABM.eliminar(fha);
		}
	}
}
