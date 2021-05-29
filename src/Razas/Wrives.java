package Razas;

public class Wrives extends Raza{
	private int golpesDados;

	public Wrives() {
		this.danio_Basico=113;
		this.salud=108;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void atacar(Raza enemigo) {
		if(golpesDados==1) {
			enemigo.recibirDanio(this.danio_Basico*2);
			golpesDados=0;
		}
		enemigo.salud -= enemigo.recibirDanio(this.danio_Basico);
		golpesDados++;
		
		
	}

	@Override
	protected int recibirDanio(int danioRecibido) {
		
		int danio = danioRecibido*2;
		this.salud-=danio;
		return danio;
	}

	@Override
	protected void descansar() {
		
		this.salud +=50;
		// TODO 
		
	}
	
	protected void setDesmayado() {
		if(this.salud<=0) {
			this.estado = Status.DESMAYADO;
		}
	}

}
