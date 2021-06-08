package Razas;

public class Poblado {
	private Bando bando;
	private Ejercito armyPoblado;
	
	public Poblado(TipoDeRaza raza, int cantidad, Bando bando){
		this.bando = bando;
		armyPoblado = new Ejercito(raza, cantidad, bando);
	}
	
	public Ejercito getEjercito(){
		return this.armyPoblado;
	}
	public Bando getBando() {
		return this.bando;
	}
	
	public void atacar(Ejercito armyPropio) {
		ControladorDeBatalla.getControlador().batallar(armyPropio, this.armyPoblado);;
	}
}
	

