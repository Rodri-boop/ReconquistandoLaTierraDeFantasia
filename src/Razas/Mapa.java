package Razas;

import java.util.List;

public class Mapa {
	private Mapa instancia;
	//TODO: Agregar lista de pueblos
	
	private Mapa() {
		//TODO:Crear mapa y levantar el archivo.
	}

	public Mapa getInstancia() {
		if(instancia == null)
			instancia = new Mapa();
			
		return instancia;
	}
	
	public void iniciarPrediccion() {
		//TODO: 
	}
	
	
}
