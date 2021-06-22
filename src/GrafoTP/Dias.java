package GrafoTP;

import java.util.HashMap;

public class Dias {
	private HashMap<String,String> predecesores;
	private HashMap<String,Double> distancias;

	public Dias(HashMap<String, String> predecesores, HashMap<String, Double> distancias) {
		
		this.predecesores = predecesores;
		this.distancias = distancias;
	}

	public HashMap<String,String> getPredecesores() {
		return predecesores;
	}

	public HashMap<String,Double> getDistancias() {
		return distancias;
	}
	
	
}
