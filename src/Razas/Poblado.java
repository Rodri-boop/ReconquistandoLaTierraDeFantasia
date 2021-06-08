package Razas;

import Razas.TipoDeRaza;

public class Poblado {
	private Bando bando;
	private Ejercito army;
	
	
	//ejercito no cola
	public Poblado(TipoDeRaza raza, int cantidad, Bando bando){
		this.bando = bando;
		army = new Ejercito(raza, cantidad, bando);
	}
	
	public Ejercito getEjercito(){
		return this.army;
	}
	public Bando getBando() {
		return this.bando;
	}
	
	public void atacar(Ejercito ejPropio) {
		ControladorDeBatalla.getControlador().batallar(ejPropio, this.army);;
	}
}
	
