package GrafoTP;

public class Arista {

	public final String destino;
	public final double peso;
	
	public Arista(String destino, double peso) {
		
		this.destino = destino;
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		return result;
	}
	
	@Override
	public String toString() {
		
		return destino + " (" + (int) peso + ")";
	}
}
