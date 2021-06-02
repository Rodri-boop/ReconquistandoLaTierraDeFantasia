package Razas;

public abstract class Raza extends Unidad{

	protected int rangoDe_Ataque;
	protected int danio_Basico;
	protected Status estado;


	public enum tipoDeRaza{
		NORTAICHIAN,
		WRIVES,
		RADAITERAN,
		RERALOPES
	}
	/**
	 * Constructor inicial de cada raza en base a sus valores puede ser cambiado.
	 * @param saludInicial
	 * @param rangoDeataque
	 * @param danioBasico
	 */
	Raza() {
		this.estado = Status.VIVO;
	}

	/**
	 * Estado de la unidad del ejercito.
	 * @author rolin
	 *
	 */
	public enum Status{
		VIVO,DESMAYADO,HERIDO//MUERTO
	}	


	/**
	 * se defiende de un ataque dependiendo si tiene una habilidada de defensa
	 * @param i
	 * @return
	 */
	protected abstract int recibirDanio(int i);
	
	protected abstract void descansar();

	/**
	 * Cuando lso puntos de salud de una unidad llegan a 0 se desmayan y quedan
	 * fuera de la batalla.
	 */
	protected void setDesmayado() {
		if(salud<=0) {
			estado = Status.DESMAYADO;
		}
	}
	
	//setear herido para todas las clases y agregarlo a recibir daño
	
	public Status getStatus() {
		return this.estado;
	}
	public Double getSalud() {
		return this.salud;
	}
}
