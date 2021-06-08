package Razas;

import java.util.PriorityQueue;
import java.util.Queue;
import Razas.Raza.Status;
import Razas.TipoDeRaza;


public class Ejercito extends Unidad {



	private Queue<Unidad> army = new PriorityQueue<Unidad>();
	private Queue<Unidad> auxiliar = new PriorityQueue<Unidad>();
	//TODO:Cambiar auxiliar en cada metodo
	private Bando bando;
	private Unidad soldadoListo;
	
	
	
	/**
	 * Constructor
	 * @param raza
	 * @param cantidad
	 * @param bando
	 */
	
	public Ejercito(TipoDeRaza raza, int cantidad, Bando bando) {
		for (int i = 0; i < cantidad; i++) {
			aniadirUnidad(raza);
		}
		this.bando = bando;
	}
	/**
	 * 
	 * @param raza
	 * @param cantidad
	 */
	
	//delegar al bufferReader (crear las unidades)

	private void aniadirUnidad(TipoDeRaza raza){
		if(raza == TipoDeRaza.NORTAICHIAN) {
			army.add(new Nortaichian());
		}
		if(raza == TipoDeRaza.WRIVES) {
			army.add(new Wrives());
		}
		if(raza == TipoDeRaza.RADAITERAN) {
			army.add(new Radaiteran());
		}
		if(raza == TipoDeRaza.RERALOPES) {
			army.add(new Reralopes());
		}
		
	}
	public void aniadirUnidad(Unidad unidad) {
		army.add(unidad);
	}

	


	//atacar en ejercito devuelve el primer soldado de la cola
	
	/**
	 * 
	 */
	@Override
	protected void descansar() {
		while(!army.isEmpty()) {
			auxiliar.add(army.poll());
		}
		while(!auxiliar.isEmpty()) {
			Unidad soldado = auxiliar.poll();
			soldado.descansar();
			army.add(soldado);
		}

	}
	
	@Override
	protected void atacar(Unidad enemigo) {
		army.peek().atacar(enemigo);
		
	}
	
	
	@Override
	protected int recibirDanio(int danio) {
		
		army.peek().recibirDanio(danio);
		return 0;
	}
	
	@Override
	protected Double getSalud() {
		Double total = 0.0;
		while(!army.isEmpty()) {
			auxiliar.add(army.poll());
		}
		while(!auxiliar.isEmpty()) {
			Unidad soldado = auxiliar.poll();
			total += soldado.getSalud();
			army.add(soldado);
		}
		return total;
	}
	
	
//	private void aniadirPropios(String raza, int cantidad) {
//	Raza soldado;
//	if(raza == "Nortaichian") {
//
//		for(int i = 0;i<cantidad;i++) {	
//			soldado= new Nortaichian();
//			army.add(soldado);
//		}
//
//	}if(raza == "Radaiteran") {
//
//		for(int i = 0; i < cantidad; i++) {
//			soldado= new Radaiteran();
//			army.add(soldado);
//		}
//
//	}if(raza == "Reralopes") {
//
//		for(int i = 0; i < cantidad; i++) {
//			soldado = new Reralopes();
//			army.add(soldado);
//		}
//	}if(raza == "Wrives") {
//
//		for(int i = 0; i < cantidad; i++) {
//			soldado = new Wrives();
//			army.add(soldado);
//		}
//
//	}
//}
	
	



}
