package Razas;

public abstract class Unidad {


/**
 * Ataca a una unidad enemiga/ejercito dependiendo de su raza obtendra un efecto diferente
 * @param enemigos
 */
protected abstract void atacar(Raza enemigos);

/**
 * la unidad o ejercito descansa teniendo diferentes beneficios
 *
 */
protected abstract void descansar();
	
}
