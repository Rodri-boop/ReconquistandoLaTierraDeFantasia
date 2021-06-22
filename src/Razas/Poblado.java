package Razas;

public class Poblado {
	private Bando bando;
	private Ejercito armyPoblado;
	
	/**
	 * Inicializa los poblados Aliados o enemigos.
	 * @param raza
	 * @param cantidad
	 * @param bando
	 */
	public Poblado(TipoDeRaza raza, int cantidad, Bando bando){
		this.bando = bando;
		armyPoblado = new Ejercito(raza, cantidad, bando);
	}
	
	/**
	 * Devuelve un ejercito.
	 * @return
	 */
	public Ejercito getEjercito(){
		return this.armyPoblado;
	}
	
	/**
	 * Devuelve el bando de este ejercito.
	 * @return
	 */
	public Bando getBando() {
		return this.bando;
	}
	
//	public void atacar(Ejercito armyPropio) {
//		ControladorDeBatalla.getControlador().batallar(armyPropio, this.armyPoblado);
//	}
}
	

