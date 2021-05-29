package Razas;

public class Nortaichian extends Raza {
	
	private int potenciador;
	private int turnosDePiedra;
	
	public Nortaichian() {
		this.salud = 66;
		this.danio_Basico = 18;
	}
	
	@Override
	protected int recibirDanio(int i) {
		potenciador = 2;
		if(this.turnosDePiedra != 0 ) {
			return i/2;
		}
		return i;
	}

	@Override
	protected void descansar() {
		this.salud = 66;
		this.turnosDePiedra = 2;
		
	}

	@Override
	protected void atacar(Raza enemigo) {
		if(turnosDePiedra == 0) {
			if(potenciador != 0) {
				enemigo.salud -= enemigo.recibirDanio(danio_Basico*2);
				this.salud += this.salud*0.04;
				potenciador--;
			}else {
				enemigo.salud -= enemigo.recibirDanio(danio_Basico);
				this.salud += this.salud*0.04;
			}
		}
		turnosDePiedra--;
	}
	

}
