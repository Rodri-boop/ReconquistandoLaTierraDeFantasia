package Razas;

public class ControladorDeBatalla {
	private static ControladorDeBatalla controlador;
	
	private ControladorDeBatalla() {
	}
	
	public static ControladorDeBatalla getControlador(){
		if(controlador == null) {
			controlador = new ControladorDeBatalla();
		}
		return controlador;
	}

	public void batallar(Ejercito propio, Ejercito enemigo) {
		while(enemigo.getSalud() > 0 && propio.getSalud() > 0) {
			propio.atacar(enemigo);
			if(enemigo.army.peek().getSalud() > 0)
				enemigo.atacar(propio);
		}
	}
	
	
}