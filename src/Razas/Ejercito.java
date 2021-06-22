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
	 * Aniade la unidad y la compara para ver que tipo de raza es.
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
	/**
	 * Metodo recursivo para poder aniadir unidades en el composite.
	 * @param unidad
	 */
	public void aniadirUnidad(Unidad unidad) {
		army.add(unidad);
	}

	/**
	 * Descansa a todos las unidades del ejercito.
	 * Dependiendo su raza el metodo es diferente.
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
	
	/**
	 * Metodo de ataque para las unidades del Ejercito
	 * Dependiendo su raza el metodo es diferente.
	 */
	@Override
	protected void atacar(Unidad enemigo) {
		army.peek().atacar(enemigo);
	}
	
	/**
	 * Metod de Recibir danio para las unidades del ejercito.
	 * Dependiendo su raza el metodo es diferente.
	 */
	@Override
	protected void recibirDanio(int danio) {
		army.peek().recibirDanio(danio);	
	}
	
	/**
	 * Metodo getSalud donde devuelve la suma de la salud total de todas las unidades
	 * en una sola.
	 */
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

	/**
	 * Metodo donde devuelve la suma de las unidades en nuestro ejercito.
	 */
	@Override
	protected int contarCabezas() {
		int suma=0;
		for (Unidad unidad : army) {
			
			suma+=unidad.contarCabezas();
		}
		return suma;
	}

	/**
	 * Quita los soldados listos para el compate de la cola.
	 */
	public Unidad quitarSoldadosListos() {
		
		return army.poll();	
		}
	
	/**
	 * Valida la vida de nuestra unidad si esta viva o no.
	 */
	@Override
	protected boolean validarVida() {
		
		return army.peek().validarVida();
	}
}
