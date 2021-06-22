package Razas;

public abstract class Unidad implements Comparable<Unidad>{

	//enum Aliado Enemigo
	protected Bando bando;
	//getSalud
	protected Double salud;
	
	/**
	 * Ataca a una unidad enemiga/ejercito dependiendo de su raza obtendra un efecto diferente
	 * @param enemigo
	 */
	protected abstract void atacar(Unidad enemigo);
	
	/**
	 * la unidad o ejercito descansa teniendo diferentes beneficios

	 */
	protected abstract void descansar();
	
	/**
	 * 
	 * @param Recibe danio de una unidad enemiga con diferentes efectos.
	 */
	protected abstract void recibirDanio(int danio);
	
	/**
	 * Valida la vida de la unidad.
	 * @return
	 */
	protected abstract boolean validarVida();
	
	/**
	 * Devuelve la salud de una unidad.
	 * @return
	 */
	protected abstract Double getSalud();

	/**
	 * Obtiene los soldados listos para la batalla.
	 * @return
	 */
	protected abstract Unidad quitarSoldadosListos();
	
	/**
	 * Cuenta la cantidad de soldados de nuestro ejercito.
	 * @return
	 */
	protected abstract int contarCabezas();
	
	@Override
	public int compareTo(Unidad o) {
		if(this.bando.compareTo(o.bando) == 0) {
			return this.getSalud().compareTo(o.getSalud())*(-1);
		}
		return this.bando.compareTo(o.bando);
	}

}
