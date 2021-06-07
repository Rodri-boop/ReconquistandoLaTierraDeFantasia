package Razas;

import Razas.Raza.tipoDeRaza;

public class Poblado {
	private Bando bando;
	private Ejercito army;
	
	
	//ejercito no cola
	public Poblado(tipoDeRaza raza, int cantidad, Bando bando){
		this.bando = bando;
		army = new Ejercito(raza, cantidad, bando);
	}
	
	public Ejercito getEjercito(){
		return this.army;
	}
	public Bando getBando() {
		return this.bando;
	}
}
	
