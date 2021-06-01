package Razas;

import java.util.PriorityQueue;
import java.util.Queue;
import Razas.Poblado.Bando;
import Razas.Raza.Status;
//estp es una prueba sdadadasf

public class Ejercito extends Unidad {



	private PriorityQueue<Raza> army = new PriorityQueue<Raza>();
	private PriorityQueue<Raza> auxiliar = new PriorityQueue<Raza>();

	/**
	 * 
	 * @param raza
	 * @param cantidad
	 */
	//public Ejercito(Enum tipoDeEjercito, int cantidad)
	
	
	public Ejercito(String raza ,int cantidad) {

		aniadirPropios(raza,cantidad);
		//aniadirUnidad(unidad)
	}
	/**
	 * 
	 * @param raza
	 * @param cantidad
	 */
	
	//delegar al bufferReader (crear las unidades)
	private void aniadirPropios(String raza ,int cantidad) {
		Raza soldado;
		if(raza== "Nortaichian") {

			for(int i =0;i<cantidad;i++) {	
				soldado= new Nortaichian();
				army.add(soldado);
			}

		}if(raza== "Radaiteran") {

			for(int i =0;i<cantidad;i++) {
				soldado= new Radaiteran();
				army.add(soldado);
			}

		}if(raza== "Reralopes") {

			for(int i =0;i<cantidad;i++) {
				soldado= new Reralopes();
				army.add(soldado);
			}
		}if(raza== "Wrives") {

			for(int i =0;i<cantidad;i++) {
				soldado= new Wrives();
				army.add(soldado);
			}

		}
	}

	/**
	 * 
	 * @param pueblito
	 */
	public void comprobarPoblado(Poblado pueblito) {

		if(pueblito.getBando()== Bando.ENEMIGO) {
			batallar(pueblito);
		}else {
			descansar();
			aniadirAliados(pueblito.getPoblado());
		}
	}



	/**
	 * 
	 * @param poblado
	 */
	private void aniadirAliados(Queue<Raza> poblado) {
		while(!poblado.isEmpty()) {
			army.add(poblado.poll());
		}

	}
	/**
	 * 
	 * @param pueblito
	 */
	//atacar en ejercito devuelve el primer soldado de la cola
	//pasar a controlador de batalla, clase batallador que sea singleton
	//debemos pasarle 2 ejercitos 
	private void batallar(Poblado pueblito) {
		Queue <Raza> enemigos= pueblito.getPoblado();
		Raza enemigoActual= null;
		Raza aliadoActual= null;
		while(!enemigos.isEmpty() && !army.isEmpty()) {
			enemigoActual= enemigos.poll();
			aliadoActual =  army.poll();

			//pelea individual
			while(enemigoActual.getStatus()!= Status.DESMAYADO && aliadoActual.getStatus()!= Status.DESMAYADO){
				aliadoActual.atacar(enemigoActual);
				if(enemigoActual.getStatus()!= Status.DESMAYADO)
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
	/**
	 * 
	 */
	@Override
	protected void descansar() {
		while(!army.isEmpty()) {
			auxiliar.add(army.poll());
		}
		while(!auxiliar.isEmpty()) {
			Raza soldado= auxiliar.poll();
			soldado.descansar();
			army.add(soldado);
		}

	}


}
