package Razas;

public abstract class Raza extends Unidad{

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
		this.estado = Status.SANO;
	}

	/**
	 * Estado de la unidad del ejercito.
	 * @author rolin
	 *
	 */
	public enum Status{
		SANO,HERIDO//MUERTO
	}	


	/**
	 * se defiende de un ataque dependiendo si tiene una habilidada de defensa
	 * @param i
	 * @return
	 */
	protected abstract void recibirDanio(int i);
	
	protected abstract void descansar();
	
	//setear herido para todas las clases y agregarlo a recibir daño
	
	public Status getStatus() {
		return this.estado;
	}
	public Double getSalud() {
		return this.salud;
	}
	
	protected void setStatus(Double salud1) {
        if(this.salud == salud1) {
            estado = Status.SANO;
        }else{
            estado = Status.HERIDO;
        }
    }
}
