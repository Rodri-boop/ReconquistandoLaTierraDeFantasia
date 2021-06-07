package Razas;

public class Inicializador {
	private Inicializador instancia;
	
	private Inicializador() {
		
	}

	public Inicializador getInstancia() {
		if(instancia == null)
			instancia = new Inicializador();
			
		return instancia;
	}
	
	public void iniciarPrediccion() {
		
	}
}
