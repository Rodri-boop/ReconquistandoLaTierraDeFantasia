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
		Queue <Raza> enemigos = pueblito.getPoblado();
		Raza enemigoActual = null;
		Raza aliadoActual = null;
		while(!enemigos.isEmpty() && !army.isEmpty()) {
			enemigoActual = enemigos.poll();
			aliadoActual =  army.poll();

			//pelea individual
			while(enemigoActual.getStatus() != Status.DESMAYADO && aliadoActual.getStatus()!= Status.DESMAYADO){
				aliadoActual.atacar(enemigoActual);
				if(enemigoActual.getStatus() != Status.DESMAYADO)
					enemigoActual.atacar(aliadoActual);

			}
			if(enemigoActual.getStatus()== Status.DESMAYADO&& !enemigos.isEmpty()) {
				enemigoActual = enemigos.poll();
			}
			if(aliadoActual.getStatus()== Status.DESMAYADO&& !army.isEmpty()) {
				aliadoActual = army.poll();
			}
		}
		if(enemigoActual.getStatus()== Status.DESMAYADO) {
			army.add(aliadoActual);
		}else {
			enemigos.add(enemigoActual);
		}
	}
}
