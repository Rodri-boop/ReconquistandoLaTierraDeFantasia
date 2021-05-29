package Razas;

public abstract class Raza extends Unidad{

	protected int salud;
	protected int rangoDe_Ataque;
	protected int danio_Basico;
	protected Status estado;


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
		VIVO,DESMAYADO//MUERTO
	}	


	/**
	 * se defiende de un ataque dependiendo si tiene una habilidada de defensa
	 * @param i
	 * @return
	 */
	protected abstract int recibirDanio(int i);
	
	
	protected abstract void descansar();

}
