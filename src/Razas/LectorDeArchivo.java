package Razas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import Razas.Raza.tipoDeRaza;

public class LectorDeArchivo {
	private HashMap<Integer, Integer> cantidadHabitantes;
	private HashMap<Integer, Bando> bandoMapa;
	private HashMap<Integer, tipoDeRaza> razaMapa;
	private int origen;
	private int destino;
	
	private int cantPueblos = 0;
	
	public void leerArchivo(File archivo) {
		
		cantidadHabitantes = new HashMap<Integer, Integer>();
		bandoMapa = new HashMap<Integer, Bando>();
		razaMapa = new HashMap<Integer, Raza.tipoDeRaza>();
		
		try {
			if (archivo.exists()) {
				BufferedReader leerArchivo = new BufferedReader(new FileReader(archivo));
				String lineaLeida;
				
				cantPueblos = Integer.parseInt(leerArchivo.readLine()); //Primer linea
				
				for (int i = 0; i < cantPueblos; i++) {
					lineaLeida = leerArchivo.readLine();
					String[] palabras = lineaLeida.split(" ");
					cantidadHabitantes.put(Integer.parseInt(palabras[0]),Integer.parseInt(palabras[1]));
					razaMapa.put(Integer.parseInt(palabras[0]), comprobarRaza(palabras[2]));
					bandoMapa.put(Integer.parseInt(palabras[0]), comprobarBando(palabras[3]));
				}
				
				lineaLeida = leerArchivo.readLine();
				String[] palabras = lineaLeida.split(" ");
				origen = Integer.parseInt(palabras[0]);
				destino = Integer.parseInt(palabras[2]);
				
				lineaLeida = leerArchivo.readLine();
				while (lineaLeida != null) {
					String[] linea = lineaLeida.split(" ");
					
					
					
					lineaLeida = leerArchivo.readLine();
				}
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	private Bando comprobarBando(String bando) {
		if(bando.equals("propio")){
			return Bando.PROPIO;}
		else if(bando.equals("aliado")){
			return Bando.ALIADO;}
		else {
			return Bando.ENEMIGO;}
	}

	private tipoDeRaza comprobarRaza(String raza) {
		if(raza.equals("Nortaichian")) {
			return tipoDeRaza.NORTAICHIAN;}
		else if (raza.equals("Wrives")) {
			return tipoDeRaza.WRIVES;}
		else if (raza.equals("Reralopes")) {
			return tipoDeRaza.RERALOPES;}
		else {
			return tipoDeRaza.RADAITERAN;}
	}
	
//	public static void main(String[] args) {
//		File file = new File("/D://Agustín//Escritorio/Camino.txt");
//		LectorDeArchivo lec = new LectorDeArchivo();
//		lec.leerArchivo(file);
//		
//		for (Map.Entry<Integer, Integer> pueblo : lec.cantidadHabitantes.entrySet()) {
//			System.out.println(pueblo.getValue());
//		}
//		
//		for (Map.Entry<Integer, Bando> pueblo1 : lec.bandoMapa.entrySet()) {
//			System.out.println(pueblo1.getValue());
//		}
//		
//		for (Map.Entry<Integer, tipoDeRaza> pueblo2 : lec.razaMapa.entrySet()) {
//			System.out.println(pueblo2.getValue());
//		}
//		
//	}

}
