package Razas;

import java.util.Map;
import java.util.Stack;

public class Desarrollador {
	
	private LectorDeArchivo lector;
	private Ejercito myArmy;
	private String origen;
	private String destino;
	private Stack<String> pila;
	
	public Desarrollador(String archivo) {
		lector = new LectorDeArchivo();
		lector.leerArchivo(archivo);
		Mapa.getInstancia().setMapa(lector.getCantidadHabitantes(), lector.getBandoMapa(), lector.getRazaMapa(), lector.getDestino());
		Mapa.getInstancia().calcularCaminoMinimo(lector.getRuta(), lector.getOrigen()); //Mmmmm 
		myArmy = Mapa.getInstancia().getNuestroEjercito();
		origen = lector.getOrigen();
		destino = lector.getDestino();
		pila = new Stack<String>();
	}
	
	public void prediccion() {
		
	}
	
	
	private void deRegresoACasa() {
		String ultimoPueblo = destino;
		pila.add(ultimoPueblo);
		
		while (!ultimoPueblo.equals(origen)) { //Recorremos el camino minimo desde el destino hacia el origen.
			pila.add(Mapa.getInstancia().getCaminoMinimo().get(ultimoPueblo));
			ultimoPueblo = Mapa.getInstancia().getCaminoMinimo().get(ultimoPueblo);
		}
	}
	
	
	public static void main(String[] args) {
		Desarrollador d = new Desarrollador("/D://Agustín//Escritorio/Camino.txt");
		System.out.println(Mapa.getInstancia().getCaminoMinimo());
		System.out.println(d.pila);
	}
	
	//TODO: iniciar prediccion, pensar nuestro ejercito

}
