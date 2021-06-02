package Razas;

public abstract class Unidad implements Comparable<Unidad>{

	//enum Aliado Enemigo
	protected Bando bando;
	//getSalud
	protected Double salud;

/**
 * Ataca a una unidad enemiga/ejercito dependiendo de su raza obtendra un efecto diferente
 * @param enemigos
 */
	protected abstract void atacar(Unidad enemigo);

/**
 * la unidad o ejercito descansa teniendo diferentes beneficios
 *
 */
	protected abstract void descansar();
	
	
	protected abstract int recibirDanio(int danio);
	
	@Override
	public int compareTo(Unidad o) {
		if(this.bando == Bando.PROPIO && o.bando == Bando.ALIADO) {
			return -1;
		}
		if(this.bando == Bando.ALIADO && o.bando == Bando.PROPIO) {
			return 1;
		}else {
			return this.getSalud().compareTo(o.getSalud())*(-1);
		}
			
	}

	protected abstract Double getSalud();
}
