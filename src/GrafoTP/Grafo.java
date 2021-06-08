package GrafoTP;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Grafo {

	private HashMap<String, Vertice> grafo;

	public Grafo() {

		this.grafo = new HashMap<String, Vertice>();
	}
	
	public void agregarArista(String verticeOrigen, String verticeDestino, double peso) {

		Arista arista = new Arista(verticeDestino, peso);
		
		if (!grafo.containsKey(verticeOrigen))
			grafo.put(verticeOrigen, new Vertice());
		
		if (!grafo.containsKey(verticeDestino))
			grafo.put(verticeDestino, new Vertice());
		
		grafo.get(verticeOrigen).agregarArista(arista);
		
		grafo.get(verticeDestino).aumentarGrado();
	}

	public HashMap<String, String> dijkstra(String verticeInicial) {
		
		PriorityQueue<Distancia> colaDePrioridad = new PriorityQueue<>();
		HashMap<String, String> predecesores = new HashMap<>();
		HashMap<String, Double> distancias = new HashMap<>();
		HashMap<String, Boolean> estaVisitado = new HashMap<>();
		
		for (String vertice : grafo.keySet()) {
			
			distancias.put(vertice, Double.MAX_VALUE);
			predecesores.put(vertice, null);
			estaVisitado.put(vertice, false);
		}
		
		distancias.put(verticeInicial, 0.0);
		
		colaDePrioridad.add(new Distancia(verticeInicial, 0.0));
		
		while (!colaDePrioridad.isEmpty()) {
			
			Distancia unaDistancia = colaDePrioridad.poll();
			
			if (!estaVisitado.get(unaDistancia.obtenerVertice())) {
				
				estaVisitado.put(unaDistancia.obtenerVertice(), true);
				
				HashSet<Arista> aristas = grafo.get(unaDistancia.obtenerVertice()).obtenerAristasAdyacentes();
				
				for (Arista aristaAdyacente : aristas) {
					
					String verticeAdyacente = aristaAdyacente.destino;
					
					double nuevaDistancia = (unaDistancia.obtenerValor() + aristaAdyacente.peso);
					
					if (!estaVisitado.get(verticeAdyacente)
							&& nuevaDistancia < distancias.get(verticeAdyacente)) {
						
						distancias.put(verticeAdyacente, nuevaDistancia);
						predecesores.put(verticeAdyacente, unaDistancia.obtenerVertice());
						colaDePrioridad.add(new Distancia(verticeAdyacente, nuevaDistancia));
					}
				}
			}
		}
		
		return predecesores;
	}

	@Override
	public String toString() {

		String mensaje = grafo.keySet().toString() + "\n";

		for (String vertice : grafo.keySet())
			mensaje += vertice + ": " + grafo.get(vertice).obtenerAristasAdyacentes() + "\n";

		return mensaje;
	}

	public static void main(String[] args) {

		Grafo grafoConAristaPositivas = new Grafo();
		
		grafoConAristaPositivas.agregarArista("V0", "V1", 1);
		grafoConAristaPositivas.agregarArista("V0", "V2", 2);
		grafoConAristaPositivas.agregarArista("V1", "V3", 3);
		grafoConAristaPositivas.agregarArista("V2", "V4", 3);
		grafoConAristaPositivas.agregarArista("V3", "V5", 4);
		grafoConAristaPositivas.agregarArista("V4", "V5", 4);
		
		System.out.println(grafoConAristaPositivas);
		System.out.println(grafoConAristaPositivas.dijkstra("V0"));
	}
}
