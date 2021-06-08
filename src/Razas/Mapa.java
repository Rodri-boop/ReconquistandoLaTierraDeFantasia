package Razas;

import java.util.HashMap;
import GrafoTP.Grafo;

public class Mapa {
	private Mapa instancia;
	private HashMap<Integer, Poblado> mapa;
	HashMap<String, String> caminoMinimo;
	
	private Mapa() {
	}

	public Mapa getInstancia() {
		if(instancia == null)
			instancia = new Mapa();
			
		return instancia;
	}
	
	public void setMapa(HashMap<Integer, Integer> cantidadHabitantes, HashMap<Integer, Bando> bando, HashMap<Integer, TipoDeRaza> raza, String origen) {
		mapa = new HashMap<Integer, Poblado>();
		Poblado pueblo;
		for (int i = 1; i <= Integer.parseInt(origen); i++) {
			pueblo = new Poblado(raza.get(i), cantidadHabitantes.get(i),bando.get(i));
			mapa.put(i, pueblo);
		}
	}
	
	public Ejercito getNuestroEjercito() {
		return this.mapa.get(1).getEjercito();
	}
	
	public void calcularCaminoMinimo(Grafo grafo, String origen) {
		caminoMinimo = new HashMap<String,String>();
		caminoMinimo = grafo.dijkstra(origen);
	}
	
	public HashMap<String, String> getCaminoMinimo() {
		return caminoMinimo;
	}	
}
