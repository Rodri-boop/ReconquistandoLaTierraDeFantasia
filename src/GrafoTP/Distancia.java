package GrafoTP;

public class Distancia implements Comparable<Distancia> {

	private String nombre;
	private Double distancia;
	
	public Distancia(String nombre, Double distancia) {
		
		this.nombre = nombre;
		this.distancia = distancia;
	}

	public String obtenerVertice() {
		
		return this.nombre;
	}
	
	public Double obtenerValor() {
		
		return this.distancia;
	}
	
	@Override
	public int compareTo(Distancia otra) {
		
		return this.distancia.compareTo(otra.distancia);
	}
}
