package Razas;

import java.util.HashMap;

import GrafoTP.Dias;
import GrafoTP.Grafo;

public class Mapa {
	private static Mapa instancia;
	private Double dias;
	private HashMap<Integer, Poblado> mapa;
	private HashMap<String, String> caminoMinimo;
	
	private Mapa() {
	}

	/**
	 * iniciamos nuestro singleton.
	 * @return
	 */
	public static Mapa getInstancia() {
		if(instancia == null)
			instancia = new Mapa();
			
		return instancia;
	}
	
	public void setMapa(HashMap<Integer, Integer> cantidadHabitantes, HashMap<Integer, Bando> bando,
		HashMap<Integer, TipoDeRaza> raza, String destino) {
		mapa = new HashMap<Integer, Poblado>();
		Poblado pueblo;
		for (int i = 1; i <= Integer.parseInt(destino); i++) {
			pueblo = new Poblado(raza.get(i), cantidadHabitantes.get(i),bando.get(i));
			mapa.put(i, pueblo);
		}
	}
	
	public HashMap<Integer, Poblado> getMapa() {
		return mapa;
	}

	/**
	 * Obtenemos nuestro ejercito.
	 * @return
	 */
	public Ejercito getNuestroEjercito() {
		return this.mapa.get(1).getEjercito();
	}
	
	/**
	 * Calculamos el camino minimo.
	 * @param grafo
	 * @param origen
	 * @param destino
	 */
	public void calcularCaminoMinimo(Grafo grafo, String origen,String destino) {
		
		Dias d = grafo.dijkstraPesos(origen);
		caminoMinimo = d.getPredecesores();
		dias = d.getDistancias().get(destino);
	}
	
	
	public HashMap<String, String> getCaminoMinimo() {
		return caminoMinimo;
	}	
	
	public Double getDias() {
		return this.dias;
	}
}
