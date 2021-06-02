package Razas;

public class Wrives extends Raza{
	private Double SALUD_BASE = 108.0;
	private int golpesDados;
	private boolean zen;

	public Wrives() {
		this.danio_Basico=113;
		this.salud=SALUD_BASE;
		this.zen=false;
		// TODO Auto-generated constructor stub
	}

	/**
	 * Ataque de un wrives: Ocasiona un daño básico de 113 puntos.
	 * Cuando ataca, lo hace con 2 veces su daño, cada 2 ataques.
	 */
	@Override
	protected void atacar(Unidad enemigo) {
		if(!this.zen) {
		if(golpesDados==1) {
			enemigo.recibirDanio(this.danio_Basico*2);
			golpesDados=0;
		}else {
		enemigo.recibirDanio(this.danio_Basico);
		golpesDados++;
		}
		}
	}

	
	/**
	 * Toda raza al recibir un ataque consecuentemente tiene un efecto
	 * en este caso los wrives reciben el doble de sus daño al no poseer armaduras.
	 */
	@Override
	protected int recibirDanio(int danioRecibido) {
		//que reciba el set de super
		if(this.zen) {
			this.zen=false;
		}
		int danio = danioRecibido*2;
		this.salud-=danio;
		super.setDesmayado();
		return danio;
	}

	/**
	 * Cuando los Wrives descansan aumentan 50 puntos su salud base y su salud
	 * actual. Y como consideran la violencia algo negativo no atacan hasta que
	 * sean atacados.
	 */
	@Override
	protected void descansar() {
		this.zen=true;
		this.SALUD_BASE+=50;
		this.salud +=50;
		// TODO que entre en modo zen hasta ser atacado

		
	}




	

}
