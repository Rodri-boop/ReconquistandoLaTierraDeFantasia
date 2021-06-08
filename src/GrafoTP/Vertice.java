package GrafoTP;

import java.util.HashSet;

public class Vertice {

	private HashSet<Arista> aristasAdyacentes;
	private int grado;
	
	public Vertice() {
		
		this.aristasAdyacentes = new HashSet<>();
		this.grado = 0;
	}
	
	public HashSet<Arista> obtenerAristasAdyacentes() {
		
		return this.aristasAdyacentes;
	}
	
	public void agregarArista(Arista arista) {
		
		this.aristasAdyacentes.add(arista);
	}
	
	public void aumentarGrado() {
		
		this.grado += 1;
	}
	
	public int obtenerGrado() {
		
		return this.grado;
	}
	
	@Override
	public String toString() {
		
		return this.aristasAdyacentes.toString();
	}
}
