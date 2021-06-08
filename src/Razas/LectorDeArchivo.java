package Razas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
//import java.util.Map;
//import java.util.Map.Entry;
import GrafoTP.Grafo;

public class LectorDeArchivo {
	private HashMap<Integer, Integer> cantidadHabitantes;
	private HashMap<Integer, Bando> bandoMapa;
	private HashMap<Integer, TipoDeRaza> razaMapa;
	private String origen;
	private String destino;
	private Grafo ruta;
	
	private int cantPueblos = 0;
	
	public void leerArchivo(File archivo) {
		
		cantidadHabitantes = new HashMap<Integer, Integer>();
		bandoMapa = new HashMap<Integer, Bando>();
		razaMapa = new HashMap<Integer, TipoDeRaza>();
		ruta = new Grafo();
		
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
				origen = palabras[0];
				destino = palabras[2];
				
				lineaLeida = leerArchivo.readLine();
				while (lineaLeida != null) {
					String[] linea = lineaLeida.split(" ");
					ruta.agregarArista(linea[0], linea[1], Integer.parseInt(linea[2]));
					lineaLeida = leerArchivo.readLine();
				}
			}
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	
	public Grafo getRuta() {
		return this.ruta;
	}
	
	private Bando comprobarBando(String bando) {
		if(bando.equals("propio")){
			return Bando.PROPIO;}
		else if(bando.equals("aliado")){
			return Bando.ALIADO;}
		else {
			return Bando.ENEMIGO;}
	}

	private TipoDeRaza comprobarRaza(String raza) {
		if(raza.equals("Nortaichian")) {
			return TipoDeRaza.NORTAICHIAN;}
		else if (raza.equals("Wrives")) {
			return TipoDeRaza.WRIVES;}
		else if (raza.equals("Reralopes")) {
			return TipoDeRaza.RERALOPES;}
		else {
			return TipoDeRaza.RADAITERAN;}
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
//		for (Map.Entry<Integer, TipoDeRaza> pueblo2 : lec.razaMapa.entrySet()) {
//			System.out.println(pueblo2.getValue());
//		}
//		
//	}

}
