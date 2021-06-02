package Razas;

public abstract class Unidad {

	//enum Aliado Enemigo
	protected Bando bando;
	//getSalud

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
	
}
