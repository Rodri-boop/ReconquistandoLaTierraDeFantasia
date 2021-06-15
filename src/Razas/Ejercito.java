package Razas;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ejercito extends Unidad {

	protected Queue<Unidad> army = new PriorityQueue<Unidad>();
	private Queue<Unidad> auxiliar = new PriorityQueue<Unidad>();
	
	
	/**
	 * Constructor
	 * @param raza
	 * @param cantidad
	 * @param bando
	 */
	public Ejercito(TipoDeRaza raza, int cantidad, Bando bando) {
		super.bando = bando;
		for (int i = 0; i < cantidad; i++) {
			aniadirUnidad(raza);
		}
	}
	
	/**
	 * 
	 * @param raza
	 * @param cantidad
	 */
	private void aniadirUnidad(TipoDeRaza raza){
		if(raza == TipoDeRaza.NORTAICHIAN) {
			Nortaichian soldier = new Nortaichian();
			soldier.setBando(bando);
			army.add(soldier);
		}
		if(raza == TipoDeRaza.WRIVES) {
			Wrives soldier = new Wrives();
			soldier.setBando(bando);
			army.add(soldier);
		}
		if(raza == TipoDeRaza.RADAITERAN) {
			Radaiteran soldier = new Radaiteran();
			soldier.setBando(bando);
			army.add(soldier);
		}
		if(raza == TipoDeRaza.RERALOPES) {
			Reralopes soldier = new Reralopes();
			soldier.setBando(bando);
			army.add(soldier);
		}
		
	}
	public void aniadirUnidad(Unidad unidad) {
		army.add(unidad);
	}

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
	protected void recibirDanio(int danio) {
		army.peek().recibirDanio(danio);
		
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
