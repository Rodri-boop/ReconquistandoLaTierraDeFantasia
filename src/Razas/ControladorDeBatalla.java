package Razas;

import java.util.Queue;

import Razas.Raza.Status;

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

	//atacar en ejercito devuelve el primer soldado de la cola
	//pasar a controlador de batalla, clase batallador que sea singleton
	//debemos pasarle 2 ejercitos
	public void batallar(Ejercito propio, Ejercito enemigo) {
		
		while(enemigo.getSalud() > 0 && propio.getSalud() > 0) {
			//TODO: Verificar antes de atacar
			propio.atacar(enemigo);
			enemigo.atacar(propio);
	}
}
}